package fileMapper.delegate;

import java.io.StringWriter;

import javax.xml.bind.JAXBElement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.harvard.i2b2.common.exception.I2B2Exception;
import edu.harvard.i2b2.common.util.jaxb.JAXBUnWrapHelper;
import edu.harvard.i2b2.common.util.jaxb.JAXBUtil;
import edu.harvard.i2b2.common.util.jaxb.JAXBUtilException;
import fileMapper.data.datavo.i2b2message.ApplicationType;
import fileMapper.data.datavo.i2b2message.StatusType;
import fileMapper.data.datavo.i2b2message.BodyType;
import fileMapper.data.datavo.i2b2message.InfoType;
import fileMapper.data.datavo.i2b2message.MessageControlIdType;
import fileMapper.data.datavo.i2b2message.MessageHeaderType;
import fileMapper.data.datavo.i2b2message.PollingUrlType;
import fileMapper.data.datavo.i2b2message.RequestMessageType;
import fileMapper.data.datavo.i2b2message.ResponseHeaderType;
import fileMapper.data.datavo.i2b2message.ResponseMessageType;
import fileMapper.data.datavo.i2b2message.ResultStatusType;
import fileMapper.data.datavo.i2b2message.StatusType;
import fileMapper.davato.db.DataSourceLookup;
import fileMapper.util.FileMapperJAXBUtil;

public abstract class Handler {

	public abstract String handleRequest(String message) throws I2B2Exception;

	/** log **/
	protected final Log log = LogFactory.getLog(getClass());
	protected DataSourceLookup dataSourceLookup = null;

	/**
	 * Function to perform operation on the given request
	 * 
	 * @return response xml message
	 */
	public abstract BodyType execute() throws I2B2Exception;

	/**
	 * Class to fetch specific request message from i2b2 message xml
	 * 
	 * @param requestXml
	 * @param classname
	 * @return object which is of type classname
	 * @throws JAXBUtilException
	 */
	protected Object getRequestType(String requestXml, Class classname)
			throws JAXBUtilException {
		Object returnObject = null;

		JAXBUtil jaxbUtil = FileMapperJAXBUtil.getJAXBUtil();
		JAXBElement jaxbElement = jaxbUtil.unMashallFromString(requestXml);
		RequestMessageType requestMessageType = (RequestMessageType) jaxbElement
				.getValue();
		BodyType bodyType = requestMessageType.getMessageBody();
		JAXBUnWrapHelper unWrapHelper = new JAXBUnWrapHelper();
		// get request header type
		returnObject = unWrapHelper.getObjectByClass(bodyType.getAny(),
				classname);

		return returnObject;
	}

	/**
	 * Function to build response message type using given bodytype and request
	 * xml
	 * 
	 * @param requestXml
	 * @param bodyType
	 * @return i2b2 response message xml
	 * @throws JAXBUtilException
	 */
	protected String buildResponseMessage(String requestXml, BodyType bodyType)
			throws JAXBUtilException {
		JAXBUtil util = FileMapperJAXBUtil.getJAXBUtil();
		RequestMessageType requestMsgType = getI2B2RequestMessageType(requestXml);
		MessageHeaderType messageHeader = requestMsgType.getMessageHeader();

		// reverse sending and receiving app
		ApplicationType sendingApp = messageHeader.getSendingApplication();
		ApplicationType receiveApp = messageHeader.getReceivingApplication();
		messageHeader.setSendingApplication(receiveApp);
		messageHeader.setReceivingApplication(sendingApp);

		// set instance num
		MessageControlIdType messageControlIdType = messageHeader
				.getMessageControlId();

		if (messageControlIdType != null) {
			messageControlIdType.setInstanceNum(1);
		}

		StatusType statusType = new StatusType();
		statusType.setType("DONE");

		// :TODO statusType.setValue(sessionId);
		PollingUrlType pollingType = new PollingUrlType();
		pollingType.setIntervalMs(100);

		// :TODO value come from property file
		// pollingType.setValue(
		// "http://phsi2b2appdev:8080/QueryProcessor/getResult");
		ResultStatusType resultStatusType = new ResultStatusType();
		resultStatusType.setStatus(statusType);
		resultStatusType.setPollingUrl(pollingType);

		InfoType infoType = new InfoType();
		// :TODO value come from property file
		// infoType.setUrl("http://phsi2b2appdev:8080/QueryProcessor/getStatus");
		infoType.setValue("Log information");

		ResponseHeaderType responseHeader = new ResponseHeaderType();
		responseHeader.setResultStatus(resultStatusType);
		responseHeader.setInfo(infoType);

		ResponseMessageType responseMessageType = new ResponseMessageType();
		responseMessageType.setMessageHeader(messageHeader);
		responseMessageType.setResponseHeader(responseHeader);
		responseMessageType.setMessageBody(bodyType);

		fileMapper.data.datavo.i2b2message.ObjectFactory of = new fileMapper.data.datavo.i2b2message.ObjectFactory();
		StringWriter strWriter = new StringWriter();
		util.marshaller(of.createResponse(responseMessageType), strWriter);

		return strWriter.toString();
	}

	/**
	 * Function to unmarshall i2b2 request message type
	 * 
	 * @param requestXml
	 * @return RequestMessageType
	 * @throws JAXBUtilException
	 */
	protected RequestMessageType getI2B2RequestMessageType(String requestXml)
			throws JAXBUtilException {
		JAXBUtil jaxbUtil = FileMapperJAXBUtil.getJAXBUtil();
		JAXBElement jaxbElement = jaxbUtil.unMashallFromString(requestXml);
		RequestMessageType requestMessageType = (RequestMessageType) jaxbElement
				.getValue();

		return requestMessageType;
	}

	/**
	 * Function marshall i2b2 response message type
	 * 
	 * @param responseMessageType
	 * @return
	 */
	protected String getResponseString(ResponseMessageType responseMessageType) {
		StringWriter strWriter = new StringWriter();

		try {
			fileMapper.data.datavo.i2b2message.ObjectFactory of = new fileMapper.data.datavo.i2b2message.ObjectFactory();
			JAXBUtil jaxbUtil = FileMapperJAXBUtil.getJAXBUtil();
			jaxbUtil.marshaller(of.createResponse(responseMessageType),
					strWriter);
		} catch (JAXBUtilException e) {
			log.error("Error while generating response message"
					+ e.getMessage());
		}

		return strWriter.toString();
	}

	protected void setDataSourceLookup(String requestXml)
			throws JAXBUtilException {
		RequestMessageType reqMessage = getI2B2RequestMessageType(requestXml);
		String projectId = reqMessage.getMessageHeader().getProjectId();
		String domainId = reqMessage.getMessageHeader().getSecurity()
				.getDomain();
		String userId = reqMessage.getMessageHeader().getSecurity()
				.getUsername();
		dataSourceLookup = new DataSourceLookup();
		dataSourceLookup.setProjectPath(projectId);
		dataSourceLookup.setDomainId(domainId);
		dataSourceLookup.setOwnerId(userId);

	}

	protected DataSourceLookup getDataSourceLookup() {
		return dataSourceLookup;
	}

}
