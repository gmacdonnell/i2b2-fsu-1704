//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.02.03 at 11:42:52 AM EST 
//


package edu.harvard.i2b2.workplace.datavo.crc.setfinder.query;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for psm_qry_headerType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="psm_qry_headerType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.i2b2.org/xsd/cell/crc/psm/1.1/}headerType">
 *       &lt;sequence>
 *         &lt;element name="request_type" type="{http://www.i2b2.org/xsd/cell/crc/psm/1.1/}psmRequest_typeType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "psm_qry_headerType", propOrder = {
    "requestType"
})
public class PsmQryHeaderType
    extends HeaderType
{

    @XmlElement(name = "request_type", required = true)
    protected PsmRequestTypeType requestType;

    /**
     * Gets the value of the requestType property.
     * 
     * @return
     *     possible object is
     *     {@link PsmRequestTypeType }
     *     
     */
    public PsmRequestTypeType getRequestType() {
        return requestType;
    }

    /**
     * Sets the value of the requestType property.
     * 
     * @param value
     *     allowed object is
     *     {@link PsmRequestTypeType }
     *     
     */
    public void setRequestType(PsmRequestTypeType value) {
        this.requestType = value;
    }

}
