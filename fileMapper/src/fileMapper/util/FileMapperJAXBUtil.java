package fileMapper.util;

/*
 * Copyright (c) 2006-2007 Massachusetts General Hospital 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the i2b2 Software License v1.0 
 * which accompanies this distribution. 
 * 
 * Contributors: 
 *     Rajesh Kuttan
 */


import java.util.List;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import edu.harvard.i2b2.common.exception.I2B2Exception;
import edu.harvard.i2b2.common.util.ServiceLocator;
import edu.harvard.i2b2.common.util.jaxb.JAXBUtil;
//import edu.harvard.i2b2.crc.util.QueryProcessorUtil;



/**
 * Factory class to create jaxb context Since jaxb context is tread safe, only
 * one instance is created for this cell. The package used for jaxb context is
 * read from spring config file $Id: CRCJAXBUtil.java,v 1.6 2007/09/11 20:05:40
 * rk903 Exp $
 * 
 * @author rkuttan
 */
public class FileMapperJAXBUtil  {
	private static JAXBUtil jaxbUtil = null;
	
	private BeanFactory beanFactory = null;
	/** property file name which holds application directory name **/
	public static final String APPLICATION_DIRECTORY_PROPERTIES_FILENAME = "fileMapper_application_directory.properties";

	/** application directory property name in fileMapper_application_directory.properties **/
	public static final String APPLICATIONDIR_PROPERTIES = "fileMapper.applicationdir";
	private static Properties loadProperties = null;
	/** class instance field* */
	private static FileMapperJAXBUtil thisInstance = null;
	/** log **/
	protected final static Log log = LogFactory
			.getLog(FileMapperJAXBUtil.class);

	//@SuppressWarnings("unchecked")
	public static JAXBUtil getJAXBUtil() {
		if (jaxbUtil == null) {
			BeanFactory springBean = getInstance().getSpringBeanFactory();
			List jaxbPackageName = (List) springBean.getBean("jaxbPackage");
			String[] jaxbPackageNameArray = (String[]) jaxbPackageName.toArray(new String[] {});
			jaxbUtil = new JAXBUtil(jaxbPackageNameArray);
		}

		return jaxbUtil;
	}
	public static FileMapperJAXBUtil getInstance() {
		if (thisInstance == null) {
			thisInstance = new FileMapperJAXBUtil();
			


		}

		// start cron job
		// startCronJob();

		return thisInstance;
	}
	/**
	 * Function to create spring bean factory
	 * 
	 * @return BeanFactory
	 */
	public BeanFactory getSpringBeanFactory() {
		if (beanFactory == null) {
			String appDir = null;
			try {
				// read application directory property file via classpath
				loadProperties = ServiceLocator
						.getProperties(APPLICATION_DIRECTORY_PROPERTIES_FILENAME);
				// read directory property
				appDir = loadProperties.getProperty(APPLICATIONDIR_PROPERTIES);

			} catch (I2B2Exception e) {
				log.error(APPLICATION_DIRECTORY_PROPERTIES_FILENAME
						+ "could not be located from classpath ");
			}

			if (appDir != null) {
				FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext(
						"file:" + appDir + "/" + "CRCApplicationContext.xml");
				beanFactory = ctx.getBeanFactory();
			} else {
				FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext(
						"classpath:" + "CRCApplicationContext.xml");
				beanFactory = ctx.getBeanFactory();
			}

		}
		return beanFactory;
	}

	
	
}

