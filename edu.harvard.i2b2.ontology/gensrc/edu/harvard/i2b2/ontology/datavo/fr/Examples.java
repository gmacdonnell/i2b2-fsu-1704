//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.02.03 at 11:42:26 AM EST 
//


package edu.harvard.i2b2.ontology.datavo.fr;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="message_body" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://www.i2b2.org/xsd/cell/fr/1.0/}sendfile_request"/>
 *                   &lt;element ref="{http://www.i2b2.org/xsd/cell/fr/1.0/}recvfile_response"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "messageBody"
})
@XmlRootElement(name = "examples")
public class Examples {

    @XmlElement(name = "message_body", required = true)
    protected List<Examples.MessageBody> messageBody;

    /**
     * Gets the value of the messageBody property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the messageBody property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMessageBody().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Examples.MessageBody }
     * 
     * 
     */
    public List<Examples.MessageBody> getMessageBody() {
        if (messageBody == null) {
            messageBody = new ArrayList<Examples.MessageBody>();
        }
        return this.messageBody;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element ref="{http://www.i2b2.org/xsd/cell/fr/1.0/}sendfile_request"/>
     *         &lt;element ref="{http://www.i2b2.org/xsd/cell/fr/1.0/}recvfile_response"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "sendfileRequest",
        "recvfileResponse"
    })
    public static class MessageBody {

        @XmlElement(name = "sendfile_request", namespace = "http://www.i2b2.org/xsd/cell/fr/1.0/", required = true)
        protected SendfileRequestType sendfileRequest;
        @XmlElement(name = "recvfile_response", namespace = "http://www.i2b2.org/xsd/cell/fr/1.0/", required = true)
        protected RecvfileResponseType recvfileResponse;

        /**
         * Gets the value of the sendfileRequest property.
         * 
         * @return
         *     possible object is
         *     {@link SendfileRequestType }
         *     
         */
        public SendfileRequestType getSendfileRequest() {
            return sendfileRequest;
        }

        /**
         * Sets the value of the sendfileRequest property.
         * 
         * @param value
         *     allowed object is
         *     {@link SendfileRequestType }
         *     
         */
        public void setSendfileRequest(SendfileRequestType value) {
            this.sendfileRequest = value;
        }

        /**
         * Gets the value of the recvfileResponse property.
         * 
         * @return
         *     possible object is
         *     {@link RecvfileResponseType }
         *     
         */
        public RecvfileResponseType getRecvfileResponse() {
            return recvfileResponse;
        }

        /**
         * Sets the value of the recvfileResponse property.
         * 
         * @param value
         *     allowed object is
         *     {@link RecvfileResponseType }
         *     
         */
        public void setRecvfileResponse(RecvfileResponseType value) {
            this.recvfileResponse = value;
        }

    }

}
