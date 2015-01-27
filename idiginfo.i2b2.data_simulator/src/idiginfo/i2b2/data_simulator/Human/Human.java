package idiginfo.i2b2.data_simulator.Human;

import idiginfo.i2b2.simulator.Medical.Concept;
import idiginfo.i2b2.simulator.Medical.History;
import idiginfo.i2b2.simulator.Medical.History_Item;
import idiginfo.i2b2.simulator.Medical.Medication;
import idiginfo.i2b2.simulator.Medical.Physical;

import java.util.Calendar;
import java.util.LinkedList;


public class Human {
	
	//Demographic
	static long HumanCounter=1;

	

	protected Calendar DOB;
	protected String Gender;
	protected long PatientID;
	protected String Race;
	
	protected LinkedList<Address> Addresses;
	
	protected int LifeSpan;
	protected int Primarary;
	
	
	//Medical History
	
	public int getPrimarary() {
		return Primarary;
	}
	public void setPrimarary(int primarary) {
		Primarary = primarary;
	}

	protected LinkedList<Medication> Medications;
	protected History c_History;
	
	public Human( long patientID, Calendar dOB2,
			String gender, String race) {
		PatientID=patientID;
		DOB = dOB2;
		Gender = gender;
		Race = race;
		init();
		
	}
	public Human()
	{
		init();
		PatientID = HumanCounter++;
	}
	protected void init()
	{
		Addresses = new LinkedList<Address>();
		Medications = new LinkedList<Medication>();
		c_History = new History(this);
		Concept temp = new Concept();
		
	}
	
	
	public static long getHumanCounter() {
		return HumanCounter;
	}
	public static void setHumanCounter(long humanCounter) {
		HumanCounter = humanCounter;
	}
	/**
	 * @return the dOB
	 */
	public Calendar getDOB() {
		return DOB;
	}
	/**
	 * @param dOB the dOB to set
	 */
	public void setDOB(Calendar dOB) {
		DOB = dOB;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return Gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		Gender = gender;
	}
	/**
	 * @return the race
	 */
	public String getRace() {
		return Race;
	}
	/**
	 * @param race the race to set
	 */
	public void setRace(String race) {
		Race = race;
	}
	/**
	 * @return the addresses
	 */
	public LinkedList<Address> getAddresses() {
		return Addresses;
	}
	/**
	 * @param addresses the addresses to set
	 */
	public void setAddresses(LinkedList<Address> addresses) {
		Addresses = addresses;
	}


	/**
	 * @return the c_Medications
	 */
	public LinkedList<Medication> getC_Medications() {
		return Medications;
	}
	/**
	 * @param c_Medications the c_Medications to set
	 */
	@SuppressWarnings("unchecked")
	public void setC_Medications(LinkedList<Medication> medications) {
		this.Medications =(LinkedList<Medication>) Medications.clone();
	}
	/**
	 * @return the c_History
	 */
	public History getHistory() {
		return c_History;
	}
	/**
	 * @param c_History the c_History to set
	 */
	public void setHistory(History c_History) {
		this.c_History = c_History;
	}
	
	public void setLifeSpan(int LifeSpan)
	{
		this.LifeSpan = LifeSpan;
	}
	public int getLifeSpan()
	{
		return LifeSpan;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Human [DOB=" + DOB.get(Calendar.YEAR) + " LifeSpan="+getLifeSpan()+ ", Gender=" + Gender + ", Race=" + Race
			//	+ ", Addresses=" + Addresses  
				+  ", ID=" + getPatientIDString() + ", "
				 + c_History.toString()+ "]"
				;
	}
	
	public long getPatientID() {
		return PatientID;
	}
	public String getPatientIDString()
	{
		return new Long(getPatientID()).toString();
	}
	public void setPatientID(long patientID) {
		PatientID = patientID;
	}
	public void setPatientID(String patientID)
	{
		setPatientID(Long.valueOf(patientID));
	}
	public LinkedList<Medication> getMedications() {
		return Medications;
	}
	public void setMedications(LinkedList<Medication> medications) {
		Medications = medications;
	}
	public double getCurrentWeight()
	{
		Physical Last = getLastPhysical();
		if(Last != null)
		{
			return Last.getWeight();
		}
		return 0.0;
	}
	
	public int getAge()
	{
		Calendar cal =  Calendar.getInstance();
		//cal.setTime(getDOB());
		return cal.get(Calendar.YEAR)- getDOB().get(Calendar.YEAR);
	}
	
	
	public Physical getLastPhysical(){
		Physical OutVal = null;
		if(c_History != null)
		{
			int index = 0;
			
			while(index < c_History.size())
			{
				History_Item temp = c_History.getItem(index);
				if(temp.getType() == Physical.TYPE)
				{
					if(OutVal != null)
					{
						if(OutVal.getEndDate().before(temp.getEndDate()))
						{
							OutVal = (Physical)temp;
						}
					}
					else
					{
						OutVal = (Physical)temp;
					}
				}
				index++;
			}
		}
		return OutVal;
	}
	
	public void addToHistory(History_Item newItem){
		newItem.setOwner(this);
		c_History.add(newItem);
		
	}
}
