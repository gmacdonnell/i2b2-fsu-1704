package idiginfo.i2b2.stats.tests;

public class P_VALUE {
	String concept_cd   ;
	protected double n1 ;
	protected double m1 ;
	protected double v1 ;
	protected double n2 ;
	protected double m2 ;
	protected double v2 ;
	protected String Table_1;
	protected String Table_2;
	protected double P_Value;
	protected boolean Initialized;
	
	
	
	public P_VALUE(String concept_cd, double n1, double m1, double v1, double n2, double m2,
			double v2, String table_1, String table_2, double p_Value) {
		super();
		this.concept_cd = concept_cd;
		this.n1 = n1;
		this.m1 = m1;
		this.v1 = v1;
		this.n2 = n2;
		this.m2 = m2;
		this.v2 = v2;
		Table_1 = table_1;
		Table_2 = table_2;
		P_Value = p_Value;
		Initialized = true;
	}
	
	public P_VALUE()
	{
		init();
	}
	
	protected void init()
	{
		  concept_cd = null;
		  n1 =0.0;
		  m1 =0.0;
		  v1 =0.0;
		  n2 =0.0;
		  m2 =0.0;
		  v2 =0.0;
		  Table_1 = null;
		  Table_2 = null;
		  P_Value =0.0;
		  Initialized = false;
	}
	
	public String getConcept_Cd()
	{
		return concept_cd;
	}
	public void setConcept_Cd(String concept_cd)
	{
		this.concept_cd = concept_cd;
	}
	public double getN1() {
		return n1;
	}
	public void setN1(double n1) {
		this.n1 = n1;
	}
	public double getM1() {
		return m1;
	}
	public void setM1(double m1) {
		this.m1 = m1;
	}
	public double getV1() {
		return v1;
	}
	public void setV1(double v1) {
		this.v1 = v1;
	}
	public double getN2() {
		return n2;
	}
	public void setN2(double n2) {
		this.n2 = n2;
	}
	public double getM2() {
		return m2;
	}
	public void setM2(double m2) {
		this.m2 = m2;
	}
	public double getV2() {
		return v2;
	}
	public void setV2(double v2) {
		this.v2 = v2;
	}
	public String getTable_1() {
		return Table_1;
	}
	public void setTable_1(String table_1) {
		Table_1 = table_1;
	}
	public String getTable_2() {
		return Table_2;
	}
	public void setTable_2(String table_2) {
		Table_2 = table_2;
	}
	public void setP_VALUE(double value)
	{
		P_Value = value;
		Initialized = true;
	}
	public double getP_Value() {
		return P_Value;
	}
	public boolean isInitialized() {
		return Initialized;
	}
	
	


}
