//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.02.04 at 09:38:52 AM EST 
//


package edu.harvard.i2b2.im.datavo.i2b2message;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for message_headerType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="message_headerType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="i2b2_version_compatible" type="{http://www.i2b2.org/xsd/hive/msg/1.1/}decimal"/>
 *         &lt;element name="hl7_version_compatible" type="{http://www.i2b2.org/xsd/hive/msg/1.1/}decimal"/>
 *         &lt;element name="sending_application" type="{http://www.i2b2.org/xsd/hive/msg/1.1/}applicationType"/>
 *         &lt;element name="sending_facility" type="{http://www.i2b2.org/xsd/hive/msg/1.1/}facilityType"/>
 *         &lt;element name="receiving_application" type="{http://www.i2b2.org/xsd/hive/msg/1.1/}applicationType"/>
 *         &lt;element name="receiving_facility" type="{http://www.i2b2.org/xsd/hive/msg/1.1/}facilityType"/>
 *         &lt;element name="datetime_of_message" type="{http://www.i2b2.org/xsd/hive/msg/1.1/}dateTime"/>
 *         &lt;element name="security" type="{http://www.i2b2.org/xsd/hive/msg/1.1/}securityType"/>
 *         &lt;element name="message_type" type="{http://www.i2b2.org/xsd/hive/msg/1.1/}message_typeType"/>
 *         &lt;element name="message_control_id" type="{http://www.i2b2.org/xsd/hive/msg/1.1/}message_control_idType"/>
 *         &lt;element name="processing_id" type="{http://www.i2b2.org/xsd/hive/msg/1.1/}processing_idType"/>
 *         &lt;element name="accept_acknowledgement_type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="application_acknowledgement_type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="country_code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="project_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "message_headerType", propOrder = {
    "i2B2VersionCompatible",
    "hl7VersionCompatible",
    "sendingApplication",
    "sendingFacility",
    "receivingApplication",
    "receivingFacility",
    "datetimeOfMessage",
    "security",
    "messageType",
    "messageControlId",
    "processingId",
    "acceptAcknowledgementType",
    "applicationAcknowledgementType",
    "countryCode",
    "projectId"
})
public class MessageHeaderType {

    @XmlElement(name = "i2b2_version_compatible", required = true)
    protected BigDecimal i2B2VersionCompatible;
    @XmlElement(name = "hl7_version_compatible", required = true)
    protected BigDecimal hl7VersionCompatible;
    @XmlElement(name = "sending_application", required = true)
    protected ApplicationType sendingApplication;
    @XmlElement(name = "sending_facility", required = true)
    protected FacilityType sendingFacility;
    @XmlElement(name = "receiving_application", required = true)
    protected ApplicationType receivingApplication;
    @XmlElement(name = "receiving_facility", required = true)
    protected FacilityType receivingFacility;
    @XmlElement(name = "datetime_of_message", required = true)
    protected XMLGregorianCalendar datetimeOfMessage;
    @XmlElement(required = true)
    protected SecurityType security;
    @XmlElement(name = "message_type", required = true)
    protected MessageTypeType messageType;
    @XmlElement(name = "message_control_id", required = true)
    protected MessageControlIdType messageControlId;
    @XmlElement(name = "processing_id", required = true)
    protected ProcessingIdType processingId;
    @XmlElement(name = "accept_acknowledgement_type", required = true)
    protected String acceptAcknowledgementType;
    @XmlElement(name = "application_acknowledgement_type", required = true)
    protected String applicationAcknowledgementType;
    @XmlElement(name = "country_code", required = true)
    protected String countryCode;
    @XmlElement(name = "project_id", required = true, nillable = true)
    protected String projectId;

    /**
     * Gets the value of the i2B2VersionCompatible property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getI2B2VersionCompatible() {
        return i2B2VersionCompatible;
    }

    /**
     * Sets the value of the i2B2VersionCompatible property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setI2B2VersionCompatible(BigDecimal value) {
        this.i2B2VersionCompatible = value;
    }

    /**
     * Gets the value of the hl7VersionCompatible property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getHl7VersionCompatible() {
        return hl7VersionCompatible;
    }

    /**
     * Sets the value of the hl7VersionCompatible property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setHl7VersionCompatible(BigDecimal value) {
        this.hl7VersionCompatible = value;
    }

    /**
     * Gets the value of the sendingApplication property.
     * 
     * @return
     *     possible object is
     *     {@link ApplicationType }
     *     
     */
    public ApplicationType getSendingApplication() {
        return sendingApplication;
    }

    /**
     * Sets the value of the sendingApplication property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApplicationType }
     *     
     */
    public void setSendingApplication(ApplicationType value) {
        this.sendingApplication = value;
    }

    /**
     * Gets the value of the sendingFacility property.
     * 
     * @return
     *     possible object is
     *     {@link FacilityType }
     *     
     */
    public FacilityType getSendingFacility() {
        return sendingFacility;
    }

    /**
     * Sets the value of the sendingFacility property.
     * 
     * @param value
     *     allowed object is
     *     {@link FacilityType }
     *     
     */
    public void setSendingFacility(FacilityType value) {
        this.sendingFacility = value;
    }

    /**
     * Gets the value of the receivingApplication property.
     * 
     * @return
     *     possible object is
     *     {@link ApplicationType }
     *     
     */
    public ApplicationType getReceivingApplication() {
        return receivingApplication;
    }

    /**
     * Sets the value of the receivingApplication property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApplicationType }
     *     
     */
    public void setReceivingApplication(ApplicationType value) {
        this.receivingApplication = value;
    }

    /**
     * Gets the value of the receivingFacility property.
     * 
     * @return
     *     possible object is
     *     {@link FacilityType }
     *     
     */
    public FacilityType getReceivingFacility() {
        return receivingFacility;
    }

    /**
     * Sets the value of the receivingFacility property.
     * 
     * @param value
     *     allowed object is
     *     {@link FacilityType }
     *     
     */
    public void setReceivingFacility(FacilityType value) {
        this.receivingFacility = value;
    }

    /**
     * Gets the value of the datetimeOfMessage property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatetimeOfMessage() {
        return datetimeOfMessage;
    }

    /**
     * Sets the value of the datetimeOfMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatetimeOfMessage(XMLGregorianCalendar value) {
        this.datetimeOfMessage = value;
    }

    /**
     * Gets the value of the security property.
     * 
     * @return
     *     possible object is
     *     {@link SecurityType }
     *     
     */
    public SecurityType getSecurity() {
        return security;
    }

    /**
     * Sets the value of the security property.
     * 
     * @param value
     *     allowed object is
     *     {@link SecurityType }
     *     
     */
    public void setSecurity(SecurityType value) {
        this.security = value;
    }

    /**
     * Gets the value of the messageType property.
     * 
     * @return
     *     possible object is
     *     {@link MessageTypeType }
     *     
     */
    public MessageTypeType getMessageType() {
        return messageType;
    }

    /**
     * Sets the value of the messageType property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageTypeType }
     *     
     */
    public void setMessageType(MessageTypeType value) {
        this.messageType = value;
    }

    /**
     * Gets the value of the messageControlId property.
     * 
     * @return
     *     possible object is
     *     {@link MessageControlIdType }
     *     
     */
    public MessageControlIdType getMessageControlId() {
        return messageControlId;
    }

    /**
     * Sets the value of the messageControlId property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageControlIdType }
     *     
     */
    public void setMessageControlId(MessageControlIdType value) {
        this.messageControlId = value;
    }

    /**
     * Gets the value of the processingId property.
     * 
     * @return
     *     possible object is
     *     {@link ProcessingIdType }
     *     
     */
    public ProcessingIdType getProcessingId() {
        return processingId;
    }

    /**
     * Sets the value of the processingId property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcessingIdType }
     *     
     */
    public void setProcessingId(ProcessingIdType value) {
        this.processingId = value;
    }

    /**
     * Gets the value of the acceptAcknowledgementType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcceptAcknowledgementType() {
        return acceptAcknowledgementType;
    }

    /**
     * Sets the value of the acceptAcknowledgementType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcceptAcknowledgementType(String value) {
        this.acceptAcknowledgementType = value;
    }

    /**
     * Gets the value of the applicationAcknowledgementType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicationAcknowledgementType() {
        return applicationAcknowledgementType;
    }

    /**
     * Sets the value of the applicationAcknowledgementType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicationAcknowledgementType(String value) {
        this.applicationAcknowledgementType = value;
    }

    /**
     * Gets the value of the countryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the value of the countryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryCode(String value) {
        this.countryCode = value;
    }

    /**
     * Gets the value of the projectId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * Sets the value of the projectId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProjectId(String value) {
        this.projectId = value;
    }

}
