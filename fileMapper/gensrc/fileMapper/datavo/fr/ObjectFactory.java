//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.02.02 at 01:24:08 PM EST 
//


package fileMapper.datavo.fr;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fileMapper.datavo.fr package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RecvfileResponse_QNAME = new QName("http://www.i2b2.org/xsd/cell/fr/1.0/", "recvfile_response");
    private final static QName _RecvfileRequest_QNAME = new QName("http://www.i2b2.org/xsd/cell/fr/1.0/", "recvfile_request");
    private final static QName _SendfileResponse_QNAME = new QName("http://www.i2b2.org/xsd/cell/fr/1.0/", "sendfile_response");
    private final static QName _SendfileRequest_QNAME = new QName("http://www.i2b2.org/xsd/cell/fr/1.0/", "sendfile_request");
    private final static QName _SendfileResponseTypeStatus_QNAME = new QName("", "status");
    private final static QName _SendfileResponseTypeStatusId_QNAME = new QName("", "status_id");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fileMapper.datavo.fr
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Examples }
     * 
     */
    public Examples createExamples() {
        return new Examples();
    }

    /**
     * Create an instance of {@link StatusType }
     * 
     */
    public StatusType createStatusType() {
        return new StatusType();
    }

    /**
     * Create an instance of {@link Examples.MessageBody }
     * 
     */
    public Examples.MessageBody createExamplesMessageBody() {
        return new Examples.MessageBody();
    }

    /**
     * Create an instance of {@link SendfileRequestType }
     * 
     */
    public SendfileRequestType createSendfileRequestType() {
        return new SendfileRequestType();
    }

    /**
     * Create an instance of {@link File }
     * 
     */
    public File createFile() {
        return new File();
    }

    /**
     * Create an instance of {@link StatusType.Condition }
     * 
     */
    public StatusType.Condition createStatusTypeCondition() {
        return new StatusType.Condition();
    }

    /**
     * Create an instance of {@link RecvfileRequestType }
     * 
     */
    public RecvfileRequestType createRecvfileRequestType() {
        return new RecvfileRequestType();
    }

    /**
     * Create an instance of {@link RecvfileResponseType }
     * 
     */
    public RecvfileResponseType createRecvfileResponseType() {
        return new RecvfileResponseType();
    }

    /**
     * Create an instance of {@link SendfileResponseType }
     * 
     */
    public SendfileResponseType createSendfileResponseType() {
        return new SendfileResponseType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RecvfileResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.i2b2.org/xsd/cell/fr/1.0/", name = "recvfile_response")
    public JAXBElement<RecvfileResponseType> createRecvfileResponse(RecvfileResponseType value) {
        return new JAXBElement<RecvfileResponseType>(_RecvfileResponse_QNAME, RecvfileResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RecvfileRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.i2b2.org/xsd/cell/fr/1.0/", name = "recvfile_request")
    public JAXBElement<RecvfileRequestType> createRecvfileRequest(RecvfileRequestType value) {
        return new JAXBElement<RecvfileRequestType>(_RecvfileRequest_QNAME, RecvfileRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendfileResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.i2b2.org/xsd/cell/fr/1.0/", name = "sendfile_response")
    public JAXBElement<SendfileResponseType> createSendfileResponse(SendfileResponseType value) {
        return new JAXBElement<SendfileResponseType>(_SendfileResponse_QNAME, SendfileResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendfileRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.i2b2.org/xsd/cell/fr/1.0/", name = "sendfile_request")
    public JAXBElement<SendfileRequestType> createSendfileRequest(SendfileRequestType value) {
        return new JAXBElement<SendfileRequestType>(_SendfileRequest_QNAME, SendfileRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatusType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "status", scope = SendfileResponseType.class)
    public JAXBElement<StatusType> createSendfileResponseTypeStatus(StatusType value) {
        return new JAXBElement<StatusType>(_SendfileResponseTypeStatus_QNAME, StatusType.class, SendfileResponseType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "status_id", scope = SendfileResponseType.class)
    public JAXBElement<String> createSendfileResponseTypeStatusId(String value) {
        return new JAXBElement<String>(_SendfileResponseTypeStatusId_QNAME, String.class, SendfileResponseType.class, value);
    }

}
