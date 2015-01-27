//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.01.26 at 12:47:09 PM EST 
//


package edu.harvard.i2b2.ontology.datavo.crc.setfinder.query;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for psmRequest_typeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="psmRequest_typeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CRC_QRY_getQueryMasterList_fromUserId"/>
 *     &lt;enumeration value="CRC_QRY_getQueryMasterList_fromGroupId"/>
 *     &lt;enumeration value="CRC_QRY_getQueryMaster_fromQueryMasterId"/>
 *     &lt;enumeration value="CRC_QRY_getQueryMaster_fromQueryInstanceId"/>
 *     &lt;enumeration value="CRC_QRY_getQueryMaster_fromResultInstanceId"/>
 *     &lt;enumeration value="CRC_QRY_saveQueryMaster_fromQueryDefinition"/>
 *     &lt;enumeration value="CRC_QRY_getQueryInstanceList_fromQueryMasterId"/>
 *     &lt;enumeration value="CRC_QRY_getQueryInstance_fromQueryInstanceId"/>
 *     &lt;enumeration value="CRC_QRY_getQueryInstance_fromResultInstanceId"/>
 *     &lt;enumeration value="CRC_QRY_runQueryInstance_fromQueryMasterId"/>
 *     &lt;enumeration value="CRC_QRY_runQueryInstance_fromQueryDefinition"/>
 *     &lt;enumeration value="CRC_QRY_getQueryResultInstanceList_fromQueryInstanceId"/>
 *     &lt;enumeration value="CRC_QRY_getQueryResultInstance_fromResultInstanceId"/>
 *     &lt;enumeration value="CRC_QRY_getRequestXml_fromQueryMasterId"/>
 *     &lt;enumeration value="CRC_QRY_getPatientSet_fromResultInstanceId"/>
 *     &lt;enumeration value="CRC_QRY_deleteQueryMaster"/>
 *     &lt;enumeration value="CRC_QRY_renameQueryMaster"/>
 *     &lt;enumeration value="CRC_QRY_updateResultInstanceDescription"/>
 *     &lt;enumeration value="CRC_QRY_getResultDocument_fromResultInstanceId"/>
 *     &lt;enumeration value="CRC_QRY_getResultType"/>
 *     &lt;enumeration value="CRC_QRY_runQueryInstance_fromAnalysisDefinition"/>
 *     &lt;enumeration value="CRC_QRY_cancelQuery"/>
 *     &lt;enumeration value="CRC_QRY_getAnalysisPluginMetadata"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "psmRequest_typeType")
@XmlEnum
public enum PsmRequestTypeType {


    /**
     * [getquerylist]
     * 
     */
    @XmlEnumValue("CRC_QRY_getQueryMasterList_fromUserId")
    CRC_QRY_GET_QUERY_MASTER_LIST_FROM_USER_ID("CRC_QRY_getQueryMasterList_fromUserId"),

    /**
     * [getquerylist]
     * 
     */
    @XmlEnumValue("CRC_QRY_getQueryMasterList_fromGroupId")
    CRC_QRY_GET_QUERY_MASTER_LIST_FROM_GROUP_ID("CRC_QRY_getQueryMasterList_fromGroupId"),
    @XmlEnumValue("CRC_QRY_getQueryMaster_fromQueryMasterId")
    CRC_QRY_GET_QUERY_MASTER_FROM_QUERY_MASTER_ID("CRC_QRY_getQueryMaster_fromQueryMasterId"),
    @XmlEnumValue("CRC_QRY_getQueryMaster_fromQueryInstanceId")
    CRC_QRY_GET_QUERY_MASTER_FROM_QUERY_INSTANCE_ID("CRC_QRY_getQueryMaster_fromQueryInstanceId"),
    @XmlEnumValue("CRC_QRY_getQueryMaster_fromResultInstanceId")
    CRC_QRY_GET_QUERY_MASTER_FROM_RESULT_INSTANCE_ID("CRC_QRY_getQueryMaster_fromResultInstanceId"),
    @XmlEnumValue("CRC_QRY_saveQueryMaster_fromQueryDefinition")
    CRC_QRY_SAVE_QUERY_MASTER_FROM_QUERY_DEFINITION("CRC_QRY_saveQueryMaster_fromQueryDefinition"),

    /**
     * [getrunlist]
     * 
     */
    @XmlEnumValue("CRC_QRY_getQueryInstanceList_fromQueryMasterId")
    CRC_QRY_GET_QUERY_INSTANCE_LIST_FROM_QUERY_MASTER_ID("CRC_QRY_getQueryInstanceList_fromQueryMasterId"),
    @XmlEnumValue("CRC_QRY_getQueryInstance_fromQueryInstanceId")
    CRC_QRY_GET_QUERY_INSTANCE_FROM_QUERY_INSTANCE_ID("CRC_QRY_getQueryInstance_fromQueryInstanceId"),
    @XmlEnumValue("CRC_QRY_getQueryInstance_fromResultInstanceId")
    CRC_QRY_GET_QUERY_INSTANCE_FROM_RESULT_INSTANCE_ID("CRC_QRY_getQueryInstance_fromResultInstanceId"),
    @XmlEnumValue("CRC_QRY_runQueryInstance_fromQueryMasterId")
    CRC_QRY_RUN_QUERY_INSTANCE_FROM_QUERY_MASTER_ID("CRC_QRY_runQueryInstance_fromQueryMasterId"),

    /**
     * [runquery]
     * 
     */
    @XmlEnumValue("CRC_QRY_runQueryInstance_fromQueryDefinition")
    CRC_QRY_RUN_QUERY_INSTANCE_FROM_QUERY_DEFINITION("CRC_QRY_runQueryInstance_fromQueryDefinition"),

    /**
     * [getpatientlist, but really resultlist]
     * 
     */
    @XmlEnumValue("CRC_QRY_getQueryResultInstanceList_fromQueryInstanceId")
    CRC_QRY_GET_QUERY_RESULT_INSTANCE_LIST_FROM_QUERY_INSTANCE_ID("CRC_QRY_getQueryResultInstanceList_fromQueryInstanceId"),
    @XmlEnumValue("CRC_QRY_getQueryResultInstance_fromResultInstanceId")
    CRC_QRY_GET_QUERY_RESULT_INSTANCE_FROM_RESULT_INSTANCE_ID("CRC_QRY_getQueryResultInstance_fromResultInstanceId"),

    /**
     * [getquerydef]
     * 
     */
    @XmlEnumValue("CRC_QRY_getRequestXml_fromQueryMasterId")
    CRC_QRY_GET_REQUEST_XML_FROM_QUERY_MASTER_ID("CRC_QRY_getRequestXml_fromQueryMasterId"),
    @XmlEnumValue("CRC_QRY_getPatientSet_fromResultInstanceId")
    CRC_QRY_GET_PATIENT_SET_FROM_RESULT_INSTANCE_ID("CRC_QRY_getPatientSet_fromResultInstanceId"),
    @XmlEnumValue("CRC_QRY_deleteQueryMaster")
    CRC_QRY_DELETE_QUERY_MASTER("CRC_QRY_deleteQueryMaster"),
    @XmlEnumValue("CRC_QRY_renameQueryMaster")
    CRC_QRY_RENAME_QUERY_MASTER("CRC_QRY_renameQueryMaster"),
    @XmlEnumValue("CRC_QRY_updateResultInstanceDescription")
    CRC_QRY_UPDATE_RESULT_INSTANCE_DESCRIPTION("CRC_QRY_updateResultInstanceDescription"),
    @XmlEnumValue("CRC_QRY_getResultDocument_fromResultInstanceId")
    CRC_QRY_GET_RESULT_DOCUMENT_FROM_RESULT_INSTANCE_ID("CRC_QRY_getResultDocument_fromResultInstanceId"),
    @XmlEnumValue("CRC_QRY_getResultType")
    CRC_QRY_GET_RESULT_TYPE("CRC_QRY_getResultType"),
    @XmlEnumValue("CRC_QRY_runQueryInstance_fromAnalysisDefinition")
    CRC_QRY_RUN_QUERY_INSTANCE_FROM_ANALYSIS_DEFINITION("CRC_QRY_runQueryInstance_fromAnalysisDefinition"),
    @XmlEnumValue("CRC_QRY_cancelQuery")
    CRC_QRY_CANCEL_QUERY("CRC_QRY_cancelQuery"),
    @XmlEnumValue("CRC_QRY_getAnalysisPluginMetadata")
    CRC_QRY_GET_ANALYSIS_PLUGIN_METADATA("CRC_QRY_getAnalysisPluginMetadata");
    private final String value;

    PsmRequestTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PsmRequestTypeType fromValue(String v) {
        for (PsmRequestTypeType c: PsmRequestTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
