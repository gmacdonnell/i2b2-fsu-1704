//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.02.05 at 03:41:33 PM EST 
//


package edu.harvard.i2b2.fr.datavo.fr.query;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sendfile_request_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sendfile_request_type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="upload_file" type="{http://www.i2b2.org/xsd/cell/fr/1.0/}file"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sendfile_request_type", propOrder = {

})
public class SendfileRequestType {

    @XmlElement(name = "upload_file", required = true)
    protected File uploadFile;

    /**
     * Gets the value of the uploadFile property.
     * 
     * @return
     *     possible object is
     *     {@link File }
     *     
     */
    public File getUploadFile() {
        return uploadFile;
    }

    /**
     * Sets the value of the uploadFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link File }
     *     
     */
    public void setUploadFile(File value) {
        this.uploadFile = value;
    }

}
