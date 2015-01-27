/*
 * Copyright (c) 2006-2007 Massachusetts General Hospital 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the i2b2 Software License v1.0 
 * which accompanies this distribution. 
 * 
 * Contributors: 
 *     Rajesh Kuttan
 */
package edu.harvard.i2b2.crc.delegate.pm;

import java.io.StringReader;
import java.util.Arrays;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.axis2.AxisFault;
import org.apache.axis2.Constants;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.corba.idl.types.CompositeDataType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.harvard.i2b2.common.exception.I2B2Exception;
import edu.harvard.i2b2.common.util.jaxb.JAXBUtilException;
import edu.harvard.i2b2.crc.datavo.i2b2message.SecurityType;
import edu.harvard.i2b2.crc.datavo.pm.ConfigureType;
import edu.harvard.i2b2.crc.datavo.pm.ParamType;
import edu.harvard.i2b2.crc.datavo.pm.ProjectType;
import edu.harvard.i2b2.crc.loader.util.CRCLoaderUtil;
import edu.harvard.i2b2.crc.util.QueryProcessorUtil;

public class PMServiceDriver {
	private static Log log = LogFactory.getLog(PMServiceDriver.class);

	public ProjectType checkValidUser(SecurityType security, String projectId)
			throws I2B2Exception, AxisFault, JAXBUtilException {
		ProjectType projectType = null;

		// Are we bypassing the PM cell? Look in properties file.
		Boolean pmBypass = false;
		String pmBypassRole = null, pmBypassProject = null, response = null;
		try {
			pmBypass = QueryProcessorUtil.getInstance()
					.getProjectManagementByPassFlag();
			pmBypassRole = QueryProcessorUtil.getInstance()
					.getProjectManagementByPassRole();
			pmBypassProject = QueryProcessorUtil.getInstance()
					.getProjectManagementByPassProject();
			log.debug("Project Management bypass flag  from property file :["
					+ pmBypass + "] bypass role [" + pmBypassRole
					+ "] project [" + pmBypassProject + "]");
		} catch (I2B2Exception e1) {
			e1.printStackTrace();
			log
					.info("Could not read Project Management bypass setting, trying PM without bypass option");
		}

		if (pmBypass == true) {
			log.info("Using Project Management by pass option ");
			log
					.info("Using project Management bypass flag  from property file :["
							+ pmBypass
							+ "] bypass role ["
							+ pmBypassRole
							+ "] project [" + pmBypassProject + "]");
			projectType = new ProjectType();
			if (pmBypassRole != null) {
				String[] roles = pmBypassRole.split(",");
				projectType.getRole().addAll(Arrays.asList(roles));

			}
			projectType.setId(pmBypassProject);

		} else {
		//	CallPMUtil callPMUtil = new CallPMUtil(security, projectId);
			projectType = CallPMUtil.callUserProject(security, projectId);
			
					
		}
		return projectType;
	}
	
	//gnm
	
	public ConfigureType  getConfig(SecurityType security)throws I2B2Exception
	{
		String response = null;
		ConfigureType  pmResponseUserInfo = null;
		try {
			edu.harvard.i2b2.crc.loader.delegate.pm.PMResponseMessage msg = new edu.harvard.i2b2.crc.loader.delegate.pm.PMResponseMessage();
			log.debug("calling PM service!!!!!!!!!!!!!!");
			response = new PMServiceDriver().getRoles1( security);
			//log.debug("PM response" + response);

			edu.harvard.i2b2.crc.datavo.i2b2message.StatusType procStatus = msg.processResult(response);
			if (!procStatus.getType().equalsIgnoreCase("ERROR")) { 
				pmResponseUserInfo = msg.readUserInfo();
				//projectType = pmResponseUserInfo.getUser().getProject().get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("Error in checkValidUser: " + e.getMessage());
			throw new I2B2Exception(e.getMessage());
			//pmResponseUserInfo = null;
		}
		return pmResponseUserInfo;
	}
	public  String getRoles1( SecurityType userSec) throws AxisFault,I2B2Exception {
		String response = null;	
		try {
			edu.harvard.i2b2.crc.loader.delegate.pm.GetUserConfigurationRequestMessage reqMsg = new edu.harvard.i2b2.crc.loader.delegate.pm.GetUserConfigurationRequestMessage();
			String getRolesRequestString = reqMsg.doBuildXML(new edu.harvard.i2b2.crc.datavo.pm.GetUserConfigurationType(), userSec);
			OMElement getPm = getPmPayLoad(getRolesRequestString);
			String pmEPR = "";
			try {
				pmEPR = CRCLoaderUtil.getInstance().getProjectManagementCellUrl();
				log.debug("project management cell URL " + pmEPR);
			} catch (I2B2Exception e1) {
				e1.printStackTrace();
				log.error("Error getting project management cell URL " + e1.getMessage());
			}
			Options options = new Options();
			options.setTo( new EndpointReference(pmEPR));
			options.setTransportInProtocol(Constants.TRANSPORT_HTTP);
			options.setProperty(Constants.Configuration.ENABLE_REST,
					Constants.VALUE_TRUE);
			options.setTimeOutInMilliSeconds(50000);
			ServiceClient sender = edu.harvard.i2b2.crc.loader.delegate.pm.PMServiceClient.getServiceClient();
			sender.setOptions(options);
			OMElement result = sender.sendReceive(getPm);
			if (result != null) {
				response = result.toString();
				//log.debug(response);

			}
			sender.cleanup();
		} catch (AxisFault e) {
			log.error(e);
			throw new I2B2Exception (e.getMessage(), e);
			//	} catch (Exception e) {
			//		log.error(e);
			//		throw e;
		}
		return response;
	}
	
	public  OMElement getPmPayLoad(String requestPm) throws I2B2Exception {
		OMElement method  = null;
		try {
			OMFactory fac = OMAbstractFactory.getOMFactory();
			//OMNamespace omNs = fac.createOMNamespace("http://www.i2b2.org/xsd/hive/msg",
			//"i2b2");
			//method = fac.createOMElement("request", omNs);
			StringReader strReader = new StringReader(requestPm);
			XMLInputFactory xif = XMLInputFactory.newInstance();
			XMLStreamReader reader = xif.createXMLStreamReader(strReader);
			StAXOMBuilder builder = new StAXOMBuilder(reader);
			method = builder.getDocumentElement();

		} catch (FactoryConfigurationError e) {
			log.error(e.getMessage());
			throw new I2B2Exception("",e.getException());
		} catch (XMLStreamException e) {
			log.error(e.getMessage());
			throw new I2B2Exception("",e);
		}
		return method;
	}//gnm
}