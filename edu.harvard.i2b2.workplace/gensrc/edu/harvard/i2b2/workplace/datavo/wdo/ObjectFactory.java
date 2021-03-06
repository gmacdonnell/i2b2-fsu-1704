//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.01.26 at 09:47:49 AM EST 
//


package edu.harvard.i2b2.workplace.datavo.wdo;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the edu.harvard.i2b2.workplace.datavo.wdo package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Folders_QNAME = new QName("http://www.i2b2.org/xsd/cell/work/1.1/", "folders");
    private final static QName _RequestXML_QNAME = new QName("http://www.i2b2.org/xsd/cell/work/1.1/", "requestXML");
    private final static QName _SetProtectedAccess_QNAME = new QName("http://www.i2b2.org/xsd/cell/work/1.1/", "set_protected_access");
    private final static QName _MoveChild_QNAME = new QName("http://www.i2b2.org/xsd/cell/work/1.1/", "move_child");
    private final static QName _GetFoldersByUserId_QNAME = new QName("http://www.i2b2.org/xsd/cell/work/1.1/", "get_folders_by_userId");
    private final static QName _DeleteChild_QNAME = new QName("http://www.i2b2.org/xsd/cell/work/1.1/", "delete_child");
    private final static QName _AddChild_QNAME = new QName("http://www.i2b2.org/xsd/cell/work/1.1/", "add_child");
    private final static QName _GetChildren_QNAME = new QName("http://www.i2b2.org/xsd/cell/work/1.1/", "get_children");
    private final static QName _GetFoldersByProject_QNAME = new QName("http://www.i2b2.org/xsd/cell/work/1.1/", "get_folders_by_project");
    private final static QName _AnnotateChild_QNAME = new QName("http://www.i2b2.org/xsd/cell/work/1.1/", "annotate_child");
    private final static QName _GetNameInfo_QNAME = new QName("http://www.i2b2.org/xsd/cell/work/1.1/", "get_name_info");
    private final static QName _RenameChild_QNAME = new QName("http://www.i2b2.org/xsd/cell/work/1.1/", "rename_child");
    private final static QName _ExportChild_QNAME = new QName("http://www.i2b2.org/xsd/cell/work/1.1/", "export_child");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.harvard.i2b2.workplace.datavo.wdo
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FolderType }
     * 
     */
    public FolderType createFolderType() {
        return new FolderType();
    }

    /**
     * Create an instance of {@link AnnotateChildType }
     * 
     */
    public AnnotateChildType createAnnotateChildType() {
        return new AnnotateChildType();
    }

    /**
     * Create an instance of {@link ChildType }
     * 
     */
    public ChildType createChildType() {
        return new ChildType();
    }

    /**
     * Create an instance of {@link XmlValueType }
     * 
     */
    public XmlValueType createXmlValueType() {
        return new XmlValueType();
    }

    /**
     * Create an instance of {@link MatchStrType }
     * 
     */
    public MatchStrType createMatchStrType() {
        return new MatchStrType();
    }

    /**
     * Create an instance of {@link GetReturnType }
     * 
     */
    public GetReturnType createGetReturnType() {
        return new GetReturnType();
    }

    /**
     * Create an instance of {@link ProtectedType }
     * 
     */
    public ProtectedType createProtectedType() {
        return new ProtectedType();
    }

    /**
     * Create an instance of {@link FoldersType }
     * 
     */
    public FoldersType createFoldersType() {
        return new FoldersType();
    }

    /**
     * Create an instance of {@link ExportChildType }
     * 
     */
    public ExportChildType createExportChildType() {
        return new ExportChildType();
    }

    /**
     * Create an instance of {@link GetChildrenType }
     * 
     */
    public GetChildrenType createGetChildrenType() {
        return new GetChildrenType();
    }

    /**
     * Create an instance of {@link DeleteChildType }
     * 
     */
    public DeleteChildType createDeleteChildType() {
        return new DeleteChildType();
    }

    /**
     * Create an instance of {@link FindByChildType }
     * 
     */
    public FindByChildType createFindByChildType() {
        return new FindByChildType();
    }

    /**
     * Create an instance of {@link RenameChildType }
     * 
     */
    public RenameChildType createRenameChildType() {
        return new RenameChildType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FoldersType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.i2b2.org/xsd/cell/work/1.1/", name = "folders")
    public JAXBElement<FoldersType> createFolders(FoldersType value) {
        return new JAXBElement<FoldersType>(_Folders_QNAME, FoldersType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.i2b2.org/xsd/cell/work/1.1/", name = "requestXML")
    public JAXBElement<String> createRequestXML(String value) {
        return new JAXBElement<String>(_RequestXML_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProtectedType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.i2b2.org/xsd/cell/work/1.1/", name = "set_protected_access")
    public JAXBElement<ProtectedType> createSetProtectedAccess(ProtectedType value) {
        return new JAXBElement<ProtectedType>(_SetProtectedAccess_QNAME, ProtectedType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChildType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.i2b2.org/xsd/cell/work/1.1/", name = "move_child")
    public JAXBElement<ChildType> createMoveChild(ChildType value) {
        return new JAXBElement<ChildType>(_MoveChild_QNAME, ChildType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetReturnType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.i2b2.org/xsd/cell/work/1.1/", name = "get_folders_by_userId")
    public JAXBElement<GetReturnType> createGetFoldersByUserId(GetReturnType value) {
        return new JAXBElement<GetReturnType>(_GetFoldersByUserId_QNAME, GetReturnType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteChildType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.i2b2.org/xsd/cell/work/1.1/", name = "delete_child")
    public JAXBElement<DeleteChildType> createDeleteChild(DeleteChildType value) {
        return new JAXBElement<DeleteChildType>(_DeleteChild_QNAME, DeleteChildType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FolderType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.i2b2.org/xsd/cell/work/1.1/", name = "add_child")
    public JAXBElement<FolderType> createAddChild(FolderType value) {
        return new JAXBElement<FolderType>(_AddChild_QNAME, FolderType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetChildrenType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.i2b2.org/xsd/cell/work/1.1/", name = "get_children")
    public JAXBElement<GetChildrenType> createGetChildren(GetChildrenType value) {
        return new JAXBElement<GetChildrenType>(_GetChildren_QNAME, GetChildrenType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetReturnType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.i2b2.org/xsd/cell/work/1.1/", name = "get_folders_by_project")
    public JAXBElement<GetReturnType> createGetFoldersByProject(GetReturnType value) {
        return new JAXBElement<GetReturnType>(_GetFoldersByProject_QNAME, GetReturnType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnnotateChildType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.i2b2.org/xsd/cell/work/1.1/", name = "annotate_child")
    public JAXBElement<AnnotateChildType> createAnnotateChild(AnnotateChildType value) {
        return new JAXBElement<AnnotateChildType>(_AnnotateChild_QNAME, AnnotateChildType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByChildType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.i2b2.org/xsd/cell/work/1.1/", name = "get_name_info")
    public JAXBElement<FindByChildType> createGetNameInfo(FindByChildType value) {
        return new JAXBElement<FindByChildType>(_GetNameInfo_QNAME, FindByChildType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RenameChildType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.i2b2.org/xsd/cell/work/1.1/", name = "rename_child")
    public JAXBElement<RenameChildType> createRenameChild(RenameChildType value) {
        return new JAXBElement<RenameChildType>(_RenameChild_QNAME, RenameChildType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExportChildType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.i2b2.org/xsd/cell/work/1.1/", name = "export_child")
    public JAXBElement<ExportChildType> createExportChild(ExportChildType value) {
        return new JAXBElement<ExportChildType>(_ExportChild_QNAME, ExportChildType.class, null, value);
    }

}
