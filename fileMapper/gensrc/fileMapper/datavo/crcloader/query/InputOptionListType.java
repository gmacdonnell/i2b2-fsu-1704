//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.01.27 at 07:53:28 AM EST 
//


package fileMapper.datavo.crcloader.query;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for input_option_listType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="input_option_listType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="data_file" type="{http://www.i2b2.org/xsd/cell/crc/loader/1.1/}data_listType"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "input_option_listType", propOrder = {

})
public class InputOptionListType {

    @XmlElement(name = "data_file", required = true)
    protected DataListType dataFile;

    /**
     * Gets the value of the dataFile property.
     * 
     * @return
     *     possible object is
     *     {@link DataListType }
     *     
     */
    public DataListType getDataFile() {
        return dataFile;
    }

    /**
     * Sets the value of the dataFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataListType }
     *     
     */
    public void setDataFile(DataListType value) {
        this.dataFile = value;
    }

}
