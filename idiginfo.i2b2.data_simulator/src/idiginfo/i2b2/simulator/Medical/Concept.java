package idiginfo.i2b2.simulator.Medical;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import idiginfo.i2b2.stats.dao.PriorDAO;
import idiginfo.i2b2.stats.dao.iProcessProcedure;
import edu.harvard.i2b2.common.exception.I2B2Exception;
import idiginfo.i2b2.data_simulator.Generators.Util;


public class Concept extends History_Item {
	protected String Concept_ID;
	protected String ValType_CD;
	public static String DEFAULT_STRING = "@";
	public static String DATE = "D";
	public static String TEXT = "T";
	public static String BOOL = "B";
	public static String NUMBER = "N";
	public static String DATE_FORMAT="yyyy-MM-dd";
	public static int ENCOUNTER_NUM=0;
	public static int  PATIENT_NUM=1;
	public static int  CONCEPT_CD=2;
	public static int PROVIDER_ID=3;
	public static int START_DATE=4;
	public static int MODIFIER_CD=5;
	public static int INSTANCE_NUM=6;
	public static int VALTYPE_CD=7;
	public static int TVAL_CHAR=8;
	public static int NVAL_NUM=9;
	public static int VALUEFLAG_CD=10;
	public static int QUANTITY_NUM=11;
	public static int UNITS_CD=12;
	public static int END_DATE=13;
	public static int LOCATION_CD=14;
	public static int OBSERVATION_BLOB=15;
	public static int CONFIDENCE_NUM=16;
	public static int UPDATE_DATE=17;
	public static int DOWNLOAD_DATE=18;
	public static int IMPORT_DATE=19;
	public static int SOURCESYSTEM_CD=20;
	public static int UPLOAD_ID=21;
	public static String INSERT_PROCEDURE ="I2B2BAYES.INSERTFACT";
	public static int FIELD_COUNT = 22;

	protected double NVAL_Num;
	protected String TVAL_Char;
	protected Boolean	BVAL_Bool;
	protected Calendar DVAL_Date;
	//MODIFIER_CD,
	protected String Modifier;
	//INSTANCE_NUM,
	protected int Instance;
	//VALUEFLAG_CD,
	protected String ValueFlag;
	// QUANTITY_NUM,
	protected int Quantity;
	// UNITS_CD,
	protected String Units;

	//LOCATION_CD,
	protected int Location;
	//OBSERVATION_BLOB,
	protected String Blob;
	//CONFIDENCE_NUM,
	protected int Confidence;
	//UPDATE_DATE,
	protected Calendar UpdateDate;
	//DOWNLOAD_DATE,
	protected Calendar DownLoadDate;
	//IMPORT_DATE,
	protected Calendar ImportDate;
	//SOURCESYSTEM_CD,
	protected String Source;
	//UPLOAD_ID
	protected String UploadID;
	
	
	public Concept(History_Item Parent, String Concept_CD, String Mod_CD, int InstanceNum, String ValType_CD, int Location)
	{
		super(Parent);
		init();
		this.setConcept_ID(Concept_CD);
		if(Mod_CD == null)
		{
			this.Modifier = DEFAULT_STRING;
		}
		else{
		this.Modifier = Mod_CD;
		}
		this.Instance = InstanceNum;
		this.ValType_CD = ValType_CD;
		this.Location = Location;
	
		
	}
	public Concept(Concept other)
	{
		copy(other);
	}
	protected void init()
	{
		 DVAL_Date = Calendar.getInstance();
		Modifier = DEFAULT_STRING;
		Instance = 0;
		Quantity = 1;
		Location= 0;;
		Confidence =0;
		UpdateDate=Calendar.getInstance();
		DownLoadDate =Calendar.getInstance();;
		ImportDate =Calendar.getInstance();;
		
	}

	public int getInstance() {
		return Instance;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public void setUnits(String units) {
		Units = units;
	}
	public String getConcept_ID() {
		return Concept_ID;
	}
	public void setConcept_ID(String concept_ID) {
		this.setType(concept_ID);
		Concept_ID = concept_ID;
	}
	public String getValType_CD() {
		return ValType_CD;
	}
	public void setValType_CD(String valType_CD) {
		ValType_CD = valType_CD;
	}
	public double getNVAL_Num() {
		return NVAL_Num;
	}
	public void setNVAL_Num(double nVAL_Num) {
		NVAL_Num = nVAL_Num;
	}
	public String getTVAL_Char() {
		return TVAL_Char;
	}
	public void setTVAL_Char(String tVAL_Char) {
		TVAL_Char = tVAL_Char;
	}
	public Boolean getBVAL_Bool() {
		return BVAL_Bool;
	}
	public void setBVAL_Bool(Boolean bVAL_Bool) {
		BVAL_Bool = bVAL_Bool;
	}
	public Calendar getDVAL_Date() {
		return DVAL_Date;
	}
	public void setDVAL_Date(Calendar dVAL_Date) {
		DVAL_Date = dVAL_Date;
	}
	public Concept() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Concept(History_Item other) {
		super(other);
		// TODO Auto-generated constructor stub
	}
	
	public String getValue()
	{
		
		
		if(ValType_CD == DATE) return DVAL_Date.toString();
		if(ValType_CD == BOOL) return  BVAL_Bool.toString();
		if(ValType_CD == TEXT) return TVAL_Char;
		
		if(ValType_CD == NUMBER) 
			{
				int Value = (int)NVAL_Num * 1000;
			
				return new Double((double)Value/1000).toString();
			}
		return null;
	}
	@Override
	public String toString() {
		return "Concept ["//Concept_ID="
	+ Concept_ID 
	+ " = "
			//	+ ", CD="+ ValType_CD 
			//	+ ", Value=" 
			+ getValue() + "]";
	}

	public String[] getRecord()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		String[] Values = new String[FIELD_COUNT];
		//ConceptFields 
		//ENCOUNTER_NUM,
		Values[ENCOUNTER_NUM] = this.getEncounterID();
		//PATIENT_NUM,
		Values[PATIENT_NUM]= this.getPatientIDString() ;
		//CONCEPT_CD,
		Values[CONCEPT_CD]= this.getConcept_ID() ;
		//PROVIDER_ID,
		Values[PROVIDER_ID]= new  Integer(this.getProviderID()).toString() ;
		//START_DATE,
		Calendar SDate = this.getStartDate();
		if(SDate != null){
		
		Values[START_DATE]= dateFormat.format(SDate.getTime());//  new Long(SDate.getTimeInMillis()).toString() ;
		}else
			Values[START_DATE]= null;
		//MODIFIER_CD,
		Values[MODIFIER_CD]= this.getModifer() ;
		//INSTANCE_NUM,
		Values[INSTANCE_NUM]= new Integer(this.getInstanceNum()).toString() ;
		//VALTYPE_CD,
		Values[VALTYPE_CD]= this.getValType_CD() ;
		//TVAL_CHAR,
		Values[TVAL_CHAR]= this.getTVAL_Char() ;
		//NVAL_NUM,
		Values[NVAL_NUM]= new Double(this.getNVAL_Num()).toString() ;
		//VALUEFLAG_CD,
		Values[VALUEFLAG_CD]= this.getValueFlag() ;
		// QUANTITY_NUM,
		Values[QUANTITY_NUM]= new Integer(this.getQuantity()).toString() ;
		// UNITS_CD,
		Values[UNITS_CD]= this.getUnits() ;
		//END_DATE,
		Values[END_DATE]= dateFormat.format(this.getEndDate().getTime()) ;
		//LOCATION_CD,
		Values[LOCATION_CD]= new Integer(this.getLocation()).toString() ;
		//OBSERVATION_BLOB,
		Values[OBSERVATION_BLOB]= this.getBlob() ;
		//CONFIDENCE_NUM,
		Values[CONFIDENCE_NUM]= new Integer(this.getConfidence()).toString() ;
		//UPDATE_DATE,
		Values[UPDATE_DATE]= dateFormat.format(this.getUpdateDate().getTime()) ;
		//DOWNLOAD_DATE,
		Values[DOWNLOAD_DATE]=  dateFormat.format(this.getDownLoadDate().getTime()) ;
		//IMPORT_DATE,
		Values[IMPORT_DATE]=  dateFormat.format(this.getImportDate().getTime())  ;
		//SOURCESYSTEM_CD,
		Values[SOURCESYSTEM_CD]= this.getSource() ;
		//UPLOAD_ID
		Values[UPLOAD_ID]= this.getUploadID() ;
		
		return Values;
	}
	

		public void setModifier (String Value ){
			this.Modifier = Value;
		}
		public String getModifer() {
			return this.Modifier;
		}
		//INSTANCE_NUM,
		public int getInstanceNum()  {
			
			return this.Instance;
		}
		public void setInstance (int Value ){
			this.Instance = Value;
		}
	
		//VALUEFLAG_CD,
		public String getValueFlag()  {
			return this.ValueFlag;
		}
		public void setValueFlag (String Value ){
			this.ValueFlag = Value;
		}
		// QUANTITY_NUM,
		public int getQuantity()  {
			return this.Quantity;
		}
		public void set (int Value ){
			this.Quantity = Value;
		}
		// UNITS_CD,
		public String getUnits()  {
			return this.Units;
		}
		public void seUnits (String Value ){
			this.Units = Value;
		}

		//LOCATION_CD,
		public int getLocation()  {
			return this.Location;
		}
		public void setLocation (int Value ){
			this.Location = Value;
		}
		//OBSERVATION_BLOB,
		public String getBlob()  {
			return this.Blob;
		}
		public void setBlob (String Value ){
			this.Blob = Value;
		}
		//CONFIDENCE_NUM,
		public int getConfidence()  {
			return this.Confidence;
		}
		public void setConfidence (int Value ){
			this.Confidence = Value;
		}
		//UPDATE_DATE,
		public Calendar getUpdateDate()  {
			return this.UpdateDate;
		}
		public void setUpdateDate (Calendar Value ){
			this.UpdateDate = Value;
		}
		//DOWNLOAD_DATE,
		public Calendar getDownLoadDate()  {
			return this.DownLoadDate;
		}
		public void setDownLoadDate (Calendar Value ){
			this.DownLoadDate = Value;
		}
		//IMPORT_DATE,
		public Calendar getImportDate()  {
			return this.ImportDate;
		}
		public void setImportDate (Calendar Value ){
			this.ImportDate = Value;
		}
		//SOURCESYSTEM_CD,
		public String getSource()  {
			return this.Source;
		}
		public void setSource (String Value ){
			this.Source = Value;
		}
		//UPLOAD_ID
		public String getUploadID()  {
			return this.UploadID;
		}
		public void setUploadID (String Value ){
			this.UploadID = Value;
		}
		
		public int getConceptCount()
		{
			return 1;
		}
		public Concept getConcept(int index)
		{
			if(index > getConceptCount() )
				return null;
			else
				return this;
		}
		
		public void InsertRecord(String procedure, String targetTable) throws I2B2Exception
		{
			String[] target= { procedure, targetTable };
			PriorDAO DAO = new PriorDAO();
			String[] inArgs =Util.combineArrays(target, this.getRecord());
			int [] outArgs = null;
			iProcessProcedure Processor = null;
			DAO.RunProcedure(inArgs, outArgs, Processor);
		}
		
		public void copy(Concept other)
		{
			super.copy(other);
			this.setNVAL_Num(other.getNVAL_Num());
			this.setTVAL_Char(other.getTVAL_Char());
			this.setBVAL_Bool(other.getBVAL_Bool());
			this.setDVAL_Date(other.getDVAL_Date());
			
			this.setModifier(other.getModifer());
			//INSTANCE_NUM,
			this.setInstance(other.getInstance());
			//VALUEFLAG_CD,
			this.setValueFlag(other.getValueFlag());
			// QUANTITY_NUM,
			this.setQuantity(other.getQuantity());
			// UNITS_CD,
			this.setUnits(other.getUnits());

			//LOCATION_CD,
			this.setLocation(other.getLocation());
			//OBSERVATION_BLOB,
			this.setBlob(other.getBlob());
			//CONFIDENCE_NUM,
			this.setConfidence(other.getConfidence());
			//UPDATE_DATE,
			this.setUpdateDate((Calendar)other.getUpdateDate().clone());
			//DOWNLOAD_DATE,
			this.setDownLoadDate((Calendar)other.getDownLoadDate().clone());
			//IMPORT_DATE,
			this.setImportDate((Calendar)other.getImportDate().clone());
			//SOURCESYSTEM_CD,
			this.setSource(other.getSource());
			//UPLOAD_ID
			this.setUploadID(other.getUploadID());
			
		}
		
}




