//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.02.05 at 03:41:56 PM EST 
//


package edu.harvard.i2b2.im.datavo.pdo.query;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for pageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="pageType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="paging_by_patients" type="{http://www.i2b2.org/xsd/cell/crc/pdo/1.1/}pageByPatient_Type"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pageType", propOrder = {
    "pagingByPatients"
})
public class PageType {

    @XmlElement(name = "paging_by_patients", required = true)
    protected PageByPatientType pagingByPatients;

    /**
     * Gets the value of the pagingByPatients property.
     * 
     * @return
     *     possible object is
     *     {@link PageByPatientType }
     *     
     */
    public PageByPatientType getPagingByPatients() {
        return pagingByPatients;
    }

    /**
     * Sets the value of the pagingByPatients property.
     * 
     * @param value
     *     allowed object is
     *     {@link PageByPatientType }
     *     
     */
    public void setPagingByPatients(PageByPatientType value) {
        this.pagingByPatients = value;
    }

}
