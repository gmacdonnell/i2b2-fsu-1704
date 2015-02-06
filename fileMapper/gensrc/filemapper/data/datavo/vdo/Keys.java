//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.02.06 at 03:42:34 PM EST 
//


package filemapper.data.datavo.vdo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Keys complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Keys">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Table" type="{http://fileMapper/data/datavo/vdo/}DataType"/>
 *         &lt;element name="Keys" type="{http://fileMapper/data/datavo/vdo/}DataTypeField" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Keys", propOrder = {
    "table",
    "keys"
})
public class Keys {

    @XmlElement(name = "Table", required = true)
    protected DataType table;
    @XmlElement(name = "Keys")
    protected List<DataTypeField> keys;

    /**
     * Gets the value of the table property.
     * 
     * @return
     *     possible object is
     *     {@link DataType }
     *     
     */
    public DataType getTable() {
        return table;
    }

    /**
     * Sets the value of the table property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataType }
     *     
     */
    public void setTable(DataType value) {
        this.table = value;
    }

    /**
     * Gets the value of the keys property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the keys property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKeys().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataTypeField }
     * 
     * 
     */
    public List<DataTypeField> getKeys() {
        if (keys == null) {
            keys = new ArrayList<DataTypeField>();
        }
        return this.keys;
    }

}
