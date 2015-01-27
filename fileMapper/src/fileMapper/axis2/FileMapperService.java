package fileMapper.axis2;
/* To add a service to this class you must also update etc/axis2/services.xml
 * Service URL stored in PM_CELL_DATA for clients 
 * 
 */

import java.io.StringReader;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

import edu.harvard.i2b2.common.exception.I2B2Exception;

public class FileMapperService {
	
	public static String DATATYPE_REQUEST="dataTypeRequest";
	/** log **/
	protected final Log log = LogFactory.getLog(getClass());
	
/* Request template	
 *  public OMElement request(OMElement omElement) {
		Assert.notNull(omElement,
				"Setfinder request OMElement must not be null");
		log.debug("Inside setfinder request " + omElement);
		return handleRequest(REQUEST_TYPE, omElement);
	}
	*/
	public OMElement getDataTypes(OMElement omElement) {
		Assert.notNull(omElement,
				"Setfinder request OMElement must not be null");
		log.debug("Inside getDataTypes request " + omElement);
		return handleRequest(DATATYPE_REQUEST, omElement);
	}
	public OMElement getKeys(OMElement omElement) {
		Assert.notNull(omElement,
				"Setfinder request OMElement must not be null");
		log.debug("Inside getKeys request " + omElement);
		return handleRequest(DATATYPE_REQUEST, omElement);
	}
	public OMElement getDimensions(OMElement omElement) {
		Assert.notNull(omElement,
				"Setfinder request OMElement must not be null");
		log.debug("Inside getDimensions " + omElement);
		return handleRequest(DATATYPE_REQUEST, omElement);
	}
	private OMElement handleRequest(String requestType, OMElement request)
	{
		// todo write code
		return null;
	}

}
