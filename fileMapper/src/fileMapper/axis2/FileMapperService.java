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
import fileMapper.delegate.DataTypeHandler;
import fileMapper.delegate.DimensionHandler;
import fileMapper.delegate.Handler;
import fileMapper.delegate.KeyHandler;
import fileMapper.delegate.MapHandler;

public class FileMapperService {
	
	public static final String DATATYPE_REQUEST="dataTypeRequest";
	public static final String KEY_REQUEST="keyRequest";
	public static final String DIM_REQUEST="dimensionRequest";
	public static final String MAPS_REQUEST="mapRequest";
	public static final String MAP_ELEMENTS_REQUEST="mapElementRequest";
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
		return handleRequest(KEY_REQUEST, omElement);
	}
	public OMElement getDimensions(OMElement omElement) {
		Assert.notNull(omElement,
				"Setfinder request OMElement must not be null");
		log.debug("Inside getDimensions " + omElement);
		return handleRequest(DIM_REQUEST, omElement);
	}
	public OMElement getMaps(OMElement omElement) {
		Assert.notNull(omElement,
				"Setfinder request OMElement must not be null");
		log.debug("Inside getDimensions " + omElement);
		return handleRequest(MAPS_REQUEST, omElement);
	}
	public OMElement getMapElements(OMElement omElement) {
		Assert.notNull(omElement,
				"Setfinder request OMElement must not be null");
		log.debug("Inside getDimensions " + omElement);
		return handleRequest(MAP_ELEMENTS_REQUEST, omElement);
	}
	private OMElement handleRequest(String requestType, OMElement request)
	{
		Handler handler = null;
		switch(requestType)
		{
		case DATATYPE_REQUEST:
			handler = new DataTypeHandler(); 
			break;
		case KEY_REQUEST:
			handler = new KeyHandler(); 
			break;
		case DIM_REQUEST:
			handler = new DimensionHandler();
			break;
		case MAPS_REQUEST:
			handler = new MapHandler();
			break;
		case MAP_ELEMENTS_REQUEST:
			handler = new MapHandler();
			((MapHandler)handler).setLoadElements(true);
			break;
		default:
			break;
			
		}
		
		
		OMElement returnElement = null;
		try {
			// call delegate's handleRequest function
			String response = handler.handleRequest(request
					.toString());
			log.debug("Response in service" + response);
			returnElement = buildOMElementFromString(response);
		} catch (XMLStreamException e) {
			log.error("xml stream exception", e);
		} catch (I2B2Exception e) {
			log.error("i2b2 exception", e);
		} catch (Throwable e) {
			log.error("Throwable", e);
		}
		return returnElement;
	}
	
	private OMElement buildOMElementFromString(String xmlString)
			throws XMLStreamException {
		XMLInputFactory xif = XMLInputFactory.newInstance();
		StringReader strReader = new StringReader(xmlString);
		XMLStreamReader reader = xif.createXMLStreamReader(strReader);
		StAXOMBuilder builder = new StAXOMBuilder(reader);
		OMElement element = builder.getDocumentElement();
		return element;
	}

}
