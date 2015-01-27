package idiginfo.i2b2.data_simulator.Human;

import idiginfo.i2b2.simulator.Medical.Concept;
import idiginfo.i2b2.simulator.Medical.History_Item;

import java.util.Calendar;

public class Address extends History_Item{
protected 
	String Street;
	String City;
	String State;
	String Zip;
	Calendar MoveIn;
	Calendar MoveOut;
	protected static long count = (long)0;
	public Address( String street,
			String city, String state, String zip, Calendar moveIn, Calendar moveOut) {
		super();
		Street = street;
		City = city;
		State = state;
		Zip = zip;
		MoveIn = moveIn;
		MoveOut = moveOut;
	}
	public Address(Human owner)
	{
		super(owner);
		Street ="123 First St";
		City = "AnyTown";
		State = "Fl";
		Zip="12345";
	}
	/**
	 * @return the street
	 */
	public String getStreet() {
		return Street;
	}
	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		Street = street;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return City;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		City = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return State;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		State = state;
	}
	/**
	 * @return the zip
	 */
	public String getZip() {
		return Zip;
	}
	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		Zip = zip;
	}
	/**
	 * @return the moveIn
	 */
	public Calendar getMoveIn() {
		return MoveIn;
	}
	/**
	 * @param moveIn the moveIn to set
	 */
	public void setMoveIn(Calendar moveIn) {
		MoveIn = moveIn;
	}
	/**
	 * @return the moveOut
	 */
	public Calendar getMoveOut() {
		return MoveOut;
	}
	/**
	 * @param moveOut the moveOut to set
	 */
	public void setMoveOut(Calendar moveOut) {
		MoveOut = moveOut;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Address [Street=" + Street + ", City=" + City + ", State="
				+ State + ", Zip=" + Zip + ", MoveIn=" + MoveIn + ", MoveOut="
				+ MoveOut + "]";
	}
	
	public   int getConceptCount()
	{
		//ToDo concept for Streat, city, state, zip, country
		return 0;
	}

	public   Concept getConcept(int index)
	{
		return null;
	}
	
}
