package idiginfo.i2b2.simulator.Medical;

import idiginfo.i2b2.data_simulator.Human.Human;

import java.util.Arrays;
import java.util.Calendar;

/*
 Weight//lbs
 BP_SYS=1; //mm hg
 BP_DIA=2; //mm hg
 HR=3; // / min
 RESP_Rate=4; // / min 
 Temp=5; // deg F
 * 
 * */

public class Physical extends History_Item {
	// Physical
	protected static long count = (long) 0;
	public static int C_Weight = 0; // lbs
	public static int C_BP_SYS = 1; // mm hg
	public static int C_BP_DIA = 2; // mm hg
	public static int C_HR = 3; // / min
	public static int C_RESP_Rate = 4; // / min
	public static int C_Temp = 5; // deg F
	public static int C_DOB = 6;
	public static int C_GENDER = 7;
	public static int C_RACE =8;
	public static String TYPE = "PHYSICAL";
	public static String S_Weight = "WEIGHT"; // lbs
	public static String S_BP_SYS = "BP_SYS"; // mm hg
	public static String S_BP_DIA = "BP_DIA"; // mm hg
	public static String S_HR = "HR"; // / min
	public static String S_RESP_Rate = "RESP_RATE"; // / min
	public static String S_Temp = "TEMP"; // deg F
	public static String S_DOB = "DOB";
	public static String S_GENDER = "GENDER";
	public static String S_RACE ="RACE";
	protected Concept[] Vitals;
	protected int VITALS_COUNT ;
	protected static Human Owner;

	protected int Location;

	public Physical(History_Item Parent) {
		super(Parent);
		init();
	}

	public Physical(Human owner, Calendar startDate) {
		super(owner);
		Owner = owner;
		init(startDate);
	}

	public Physical(Human owner, Calendar startDate, Calendar endDate) {
		super(owner);
		Owner = owner;
		init(startDate, endDate);
	}
	public Physical(Physical other)
	{
		super(other);
		copy(other);
	}
public void copy(Physical other)
{
	for(int index = 0; index < VITALS_COUNT; index++){
		this.Vitals[index]= other.Vitals[index];
	}
}
	protected void init(Calendar startDate) {
		init(startDate, startDate);
	}
 
	protected void init(Calendar startDate, Calendar endDate) {

		setStartDate(startDate);
		setEndDate(endDate);
		init();
	}

	protected void init() {
		VITALS_COUNT = 9;
		this.EncounterID = Physical.count++;
		Concept temp;
		this.setType(Physical.TYPE);
		Vitals = new Concept[VITALS_COUNT];
		temp = new Concept(this, S_Weight, null, 0, Concept.NUMBER,
				getLocation());
		temp.setUnits(Units.lb.Code());
		temp.setProviderID(getProviderID());
		Vitals[C_Weight] = temp;
		temp = new Concept(this, S_BP_SYS, null, 0, Concept.NUMBER,
				getLocation());
		temp.setUnits(Units.mmhg.Code());
		temp.setProviderID(getProviderID());
		Vitals[C_BP_SYS] = temp;
		temp = new Concept(this, S_BP_DIA, null, 0, Concept.NUMBER,
				getLocation());
		temp.setUnits(Units.mmhg.Code());
		temp.setProviderID(getProviderID());
		temp.setProviderID(getProviderID());
		Vitals[C_BP_DIA] = temp;
		temp = new Concept(this, S_HR, null, 0, Concept.NUMBER, getLocation());
		temp.setUnits(Units.beats_Per_minute.Code());
		temp.setProviderID(getProviderID());
		Vitals[C_HR] = temp;
		temp = new Concept(this, S_RESP_Rate, null, 0, Concept.NUMBER,
				getLocation());
		temp.setUnits(Units.breaths_Per_minute.Code());
		temp.setProviderID(getProviderID());
		Vitals[C_RESP_Rate] = temp;
		//TEMP
		temp = new Concept(this, S_Temp, null, 0, Concept.NUMBER, getLocation());
		temp.setUnits(Units.DegC.Code());
		temp.setProviderID(getProviderID());
		Vitals[C_Temp] = temp;
		//human 
		
		if (Owner != null)
		{
			temp = new Concept(this, S_DOB, null, 0, Concept.DATE, getLocation());
			//temp.setUnits(Units.DegC.Code());
			temp.setProviderID(getProviderID());
			temp.setDVAL_Date(Owner.getDOB());
			Vitals[C_DOB] = temp;
			//dob
			temp = new Concept(this, S_GENDER, null, 0, Concept.TEXT, getLocation());
			temp.setTVAL_Char(Owner.getGender());
			temp.setProviderID(getProviderID());
			Vitals[C_GENDER] = temp;
			//Gendar
			temp = new Concept(this, S_RACE, null, 0, Concept.TEXT, getLocation());
			temp.setTVAL_Char(Owner.getRace());
			temp.setProviderID(getProviderID());
			Vitals[C_RACE] = temp;
			//race
		}

	}

	public double getWeight() {
		return Vitals[C_Weight].getNVAL_Num();
	}

	public void setWeight(double value) {
		Vitals[C_Weight].setNVAL_Num(value);
	}

	public double getBP_SYS() {
		return Vitals[C_BP_SYS].getNVAL_Num();
	}

	public void setBP_SYS(double value) {
		Vitals[C_BP_SYS].setNVAL_Num(value);
	}

	public double getBP_DIA() {
		return Vitals[C_BP_DIA].getNVAL_Num();
	}

	public void setBP_DIA(double value) {
		Vitals[C_BP_DIA].setNVAL_Num(value);
	}

	public double getHR() {
		return Vitals[C_HR].getNVAL_Num();
	}

	public void setHR(double value) {
		Vitals[C_HR].setNVAL_Num(value);
	}

	public double getRESP_Rate() {
		return Vitals[C_RESP_Rate].getNVAL_Num();
	}

	public void setRESP_Rate(double value) {
		Vitals[C_RESP_Rate].setNVAL_Num(value);
	}

	public double getTemp() {
		return Vitals[C_Temp].getNVAL_Num();
	}

	public void setTemp(double value) {
		Vitals[C_Temp].setNVAL_Num(value);
	}

	@Override
	public String toString() {
		return "Physical [Vitals=" + Arrays.toString(Vitals) + ", HistID="
				+ HistID + ", Type=" + Type + ", EncounterID="
				+ getEncounterID() + ", ProviderID=" + ProviderID
				+ ", StartDate=" + StartDate.get(Calendar.YEAR) + ", EndDate="
				+ EndDate.get(Calendar.YEAR) + "]";
	}

	/*
	 * Template public double get () { return Vitals[C_].getNVAL_Num(); } public
	 * void set (double value) { Vitals[C_].setNVAL_Num(value); }
	 */
	// @Overide
	public void setProviderID(int ID) {
		super.setProviderID(ID);
		Location = Provider.getProvider(ID).getLocation();
	}

	public void SetLocation(int location) {
		Location = location;
	}

	public int getLocation() {
		return Location;
	}

	public Concept getConcept(int index) {
		if (index < VITALS_COUNT) {
			return Vitals[index];
		}
		return null;
	}

	public int getConceptCount() {
		return VITALS_COUNT;
	}

	public static Human getOwner() {
		return Owner;
	}

	public  void setOwner(Human owner) {
		Owner = owner;
	}

	
}
