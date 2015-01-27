//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.01.27 at 07:53:28 AM EST 
//


package fileMapper.datavo.crc.setfinder.query;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for panelType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="panelType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="panel_number" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="panel_timing" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="panel_date_from" type="{http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/}constrainDateType"/>
 *         &lt;element name="panel_date_to" type="{http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/}constrainDateType"/>
 *         &lt;element name="panel_accuracy_scale" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="invert" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="total_item_occurrences">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>int">
 *                 &lt;attribute name="operator" type="{http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/}totOccuranceOperatorType" default="GE" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="item" type="{http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/}itemType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "panelType", namespace = "http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/", propOrder = {
    "panelNumber",
    "panelTiming",
    "panelDateFrom",
    "panelDateTo",
    "panelAccuracyScale",
    "invert",
    "totalItemOccurrences",
    "item"
})
public class PanelType {

    @XmlElement(name = "panel_number")
    protected int panelNumber;
    @XmlElement(name = "panel_timing", required = true, defaultValue = "ANY")
    protected String panelTiming;
    @XmlElement(name = "panel_date_from", required = true)
    protected ConstrainDateType panelDateFrom;
    @XmlElement(name = "panel_date_to", required = true)
    protected ConstrainDateType panelDateTo;
    @XmlElement(name = "panel_accuracy_scale")
    protected int panelAccuracyScale;
    @XmlElement(defaultValue = "0")
    protected int invert;
    @XmlElement(name = "total_item_occurrences", required = true, defaultValue = "1")
    protected PanelType.TotalItemOccurrences totalItemOccurrences;
    @XmlElement(required = true)
    protected List<ItemType> item;
    @XmlAttribute(required = true)
    protected String name;

    /**
     * Gets the value of the panelNumber property.
     * 
     */
    public int getPanelNumber() {
        return panelNumber;
    }

    /**
     * Sets the value of the panelNumber property.
     * 
     */
    public void setPanelNumber(int value) {
        this.panelNumber = value;
    }

    /**
     * Gets the value of the panelTiming property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPanelTiming() {
        return panelTiming;
    }

    /**
     * Sets the value of the panelTiming property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPanelTiming(String value) {
        this.panelTiming = value;
    }

    /**
     * Gets the value of the panelDateFrom property.
     * 
     * @return
     *     possible object is
     *     {@link ConstrainDateType }
     *     
     */
    public ConstrainDateType getPanelDateFrom() {
        return panelDateFrom;
    }

    /**
     * Sets the value of the panelDateFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConstrainDateType }
     *     
     */
    public void setPanelDateFrom(ConstrainDateType value) {
        this.panelDateFrom = value;
    }

    /**
     * Gets the value of the panelDateTo property.
     * 
     * @return
     *     possible object is
     *     {@link ConstrainDateType }
     *     
     */
    public ConstrainDateType getPanelDateTo() {
        return panelDateTo;
    }

    /**
     * Sets the value of the panelDateTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConstrainDateType }
     *     
     */
    public void setPanelDateTo(ConstrainDateType value) {
        this.panelDateTo = value;
    }

    /**
     * Gets the value of the panelAccuracyScale property.
     * 
     */
    public int getPanelAccuracyScale() {
        return panelAccuracyScale;
    }

    /**
     * Sets the value of the panelAccuracyScale property.
     * 
     */
    public void setPanelAccuracyScale(int value) {
        this.panelAccuracyScale = value;
    }

    /**
     * Gets the value of the invert property.
     * 
     */
    public int getInvert() {
        return invert;
    }

    /**
     * Sets the value of the invert property.
     * 
     */
    public void setInvert(int value) {
        this.invert = value;
    }

    /**
     * Gets the value of the totalItemOccurrences property.
     * 
     * @return
     *     possible object is
     *     {@link PanelType.TotalItemOccurrences }
     *     
     */
    public PanelType.TotalItemOccurrences getTotalItemOccurrences() {
        return totalItemOccurrences;
    }

    /**
     * Sets the value of the totalItemOccurrences property.
     * 
     * @param value
     *     allowed object is
     *     {@link PanelType.TotalItemOccurrences }
     *     
     */
    public void setTotalItemOccurrences(PanelType.TotalItemOccurrences value) {
        this.totalItemOccurrences = value;
    }

    /**
     * Gets the value of the item property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the item property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemType }
     * 
     * 
     */
    public List<ItemType> getItem() {
        if (item == null) {
            item = new ArrayList<ItemType>();
        }
        return this.item;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>int">
     *       &lt;attribute name="operator" type="{http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/}totOccuranceOperatorType" default="GE" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class TotalItemOccurrences {

        @XmlValue
        protected int value;
        @XmlAttribute
        protected TotOccuranceOperatorType operator;

        /**
         * Gets the value of the value property.
         * 
         */
        public int getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         */
        public void setValue(int value) {
            this.value = value;
        }

        /**
         * Gets the value of the operator property.
         * 
         * @return
         *     possible object is
         *     {@link TotOccuranceOperatorType }
         *     
         */
        public TotOccuranceOperatorType getOperator() {
            if (operator == null) {
                return TotOccuranceOperatorType.GE;
            } else {
                return operator;
            }
        }

        /**
         * Sets the value of the operator property.
         * 
         * @param value
         *     allowed object is
         *     {@link TotOccuranceOperatorType }
         *     
         */
        public void setOperator(TotOccuranceOperatorType value) {
            this.operator = value;
        }

    }

}
