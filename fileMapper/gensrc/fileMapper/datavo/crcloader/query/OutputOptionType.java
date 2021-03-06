//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.01.27 at 07:53:28 AM EST 
//


package fileMapper.datavo.crcloader.query;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for output_optionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="output_optionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="onlykeys" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *       &lt;attribute name="blob" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="techdata" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "output_optionType")
@XmlSeeAlso({
    FactOutputOptionType.class
})
public class OutputOptionType {

    @XmlAttribute
    protected Boolean onlykeys;
    @XmlAttribute
    protected Boolean blob;
    @XmlAttribute
    protected Boolean techdata;

    /**
     * Gets the value of the onlykeys property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isOnlykeys() {
        if (onlykeys == null) {
            return true;
        } else {
            return onlykeys;
        }
    }

    /**
     * Sets the value of the onlykeys property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOnlykeys(Boolean value) {
        this.onlykeys = value;
    }

    /**
     * Gets the value of the blob property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isBlob() {
        if (blob == null) {
            return false;
        } else {
            return blob;
        }
    }

    /**
     * Sets the value of the blob property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBlob(Boolean value) {
        this.blob = value;
    }

    /**
     * Gets the value of the techdata property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isTechdata() {
        if (techdata == null) {
            return false;
        } else {
            return techdata;
        }
    }

    /**
     * Sets the value of the techdata property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTechdata(Boolean value) {
        this.techdata = value;
    }

}
