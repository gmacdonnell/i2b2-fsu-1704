package idiginfo.i2b2.simulator.Medical;

import idiginfo.i2b2.data_simulator.Human.Human;

import java.util.Calendar;

public abstract class History_Item {
	protected static Long count = (long) 0;
	protected long HistID;
	protected String Type;
	protected long PatientID;
	protected Long EncounterID;
	protected int ProviderID;
	protected Calendar StartDate;
	protected Calendar EndDate;

	public History_Item(History_Item other) {
		init();
		copy(other);

	}
	public void copy(History_Item other)
	{
		this.EncounterID = other.EncounterID;

		this.Type = other.Type;
		this.setPatientID(other.getPatientID());
		this.ProviderID = other.getProviderID();
		this.StartDate = (Calendar)other.getStartDate().clone();
		this.EndDate = (Calendar)other.getEndDate().clone();
	}

	public History_Item(Human owner)
	{
		init();
		setOwner(owner);
		setPatientID(owner.getPatientID());
		setProviderID(owner.getPrimarary());
	}
	public History_Item() {
		super();
		init();
		// TODO Auto-generated constructor stub
	}

	public History_Item(Calendar event_Date, String patientID, String Type,
			long encounterID) {

		init();
		setStartDate(event_Date);
		setEndDate(event_Date);
		setPatientID(patientID);
	}

	public long getHistID() {
		return HistID;
	}

	public History_Item(String patientIDD, String type, int providerID,
			Calendar startDate, Calendar endDate) {

		Type = type;
		ProviderID = providerID;
		StartDate = startDate;
		EndDate = endDate;

	}

	private void init() {
		HistID = count++;
		if (this.EncounterID == null) {
			this.EncounterID = HistID;
		}
		if (EndDate == null) {
			EndDate = Calendar.getInstance();
		}
		if (StartDate == null) {
			StartDate = Calendar.getInstance();
		}
	}

	/*
	 * public History_Item(Record_Object Parent,String type, int providerID,
	 * Calendar startDate, Calendar endDate) { super(Parent); Type = type;
	 * ProviderID = providerID; StartDate = startDate; EndDate = endDate;
	 * init(); }
	 */
	@Override
	public String toString() {
		return "History_Item [Type=" + Type + ", EncounterID="
				+ getEncounterID() + ", ProviderID=" + ProviderID
				+ ", StartDate=" + StartDate + ", EndDate="
				+ EndDate.get(Calendar.YEAR) + ", Event_Date="
				+ getStartDate().get(Calendar.YEAR) + ", ID=" + getPatientID()
				+ "]";
	}

	public abstract int getConceptCount();

	public abstract Concept getConcept(int index);

	public String getPatientIDString() {
		return new Long(PatientID).toString();
	}

	public long getPatientID() {
		return PatientID;
	}

	public void setPatientID(long patientID) {
		PatientID = patientID;
	}

	public void setPatientID(String patientID) {
		PatientID = Long.valueOf(patientID);
	}

	public void setOwner(Human owner) {
		this.setPatientID(owner.getPatientID());
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getEncounterID() {
		return new Long(EncounterID).toString();
	}

	public void setEncounterID(long value) {
		HistID = value;
	}

	public int getProviderID() {
		return ProviderID;
	}

	public String getProviderIDString() {
		return new Long(ProviderID).toString();
	}

	public void setEncounterID(Long encounterID) {
		EncounterID = encounterID;
	}

	public void setProviderID(int providerID) {
		ProviderID = providerID;
	}

	public Calendar getStartDate() {
		return StartDate;
	}

	public void setStartDate(Calendar startDate) {
		StartDate = (Calendar)startDate.clone();
	}

	public Calendar getEndDate() {
		return EndDate;
	}

	public void setEndDate(Calendar endDate) {
		EndDate = (Calendar)endDate.clone();
	}

	public static Long getCount() {
		return count;
	}

}
