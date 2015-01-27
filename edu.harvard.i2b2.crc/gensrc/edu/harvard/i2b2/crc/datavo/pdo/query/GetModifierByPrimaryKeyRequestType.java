//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.01.26 at 12:45:17 PM EST 
//


package edu.harvard.i2b2.crc.datavo.pdo.query;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetModifierByPrimaryKey_requestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetModifierByPrimaryKey_requestType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.i2b2.org/xsd/cell/crc/pdo/1.1/}requestType">
 *       &lt;sequence>
 *         &lt;element name="modifier_primary_key" type="{http://www.i2b2.org/xsd/cell/crc/pdo/1.1/}modifier_primary_key_Type"/>
 *         &lt;element name="modifier_output_option" type="{http://www.i2b2.org/xsd/cell/crc/pdo/1.1/}output_optionType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetModifierByPrimaryKey_requestType", propOrder = {
    "modifierPrimaryKey",
    "modifierOutputOption"
})
public class GetModifierByPrimaryKeyRequestType
    extends RequestType
{

    @XmlElement(name = "modifier_primary_key", required = true)
    protected ModifierPrimaryKeyType modifierPrimaryKey;
    @XmlElement(name = "modifier_output_option", required = true)
    protected OutputOptionType modifierOutputOption;

    /**
     * Gets the value of the modifierPrimaryKey property.
     * 
     * @return
     *     possible object is
     *     {@link ModifierPrimaryKeyType }
     *     
     */
    public ModifierPrimaryKeyType getModifierPrimaryKey() {
        return modifierPrimaryKey;
    }

    /**
     * Sets the value of the modifierPrimaryKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link ModifierPrimaryKeyType }
     *     
     */
    public void setModifierPrimaryKey(ModifierPrimaryKeyType value) {
        this.modifierPrimaryKey = value;
    }

    /**
     * Gets the value of the modifierOutputOption property.
     * 
     * @return
     *     possible object is
     *     {@link OutputOptionType }
     *     
     */
    public OutputOptionType getModifierOutputOption() {
        return modifierOutputOption;
    }

    /**
     * Sets the value of the modifierOutputOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link OutputOptionType }
     *     
     */
    public void setModifierOutputOption(OutputOptionType value) {
        this.modifierOutputOption = value;
    }

}