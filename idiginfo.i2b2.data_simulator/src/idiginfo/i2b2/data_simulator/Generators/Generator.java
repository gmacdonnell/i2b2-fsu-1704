package idiginfo.i2b2.data_simulator.Generators;


import java.util.Calendar;
import java.util.Random;

import idiginfo.i2b2.data_simulator.Human.Address;
import idiginfo.i2b2.data_simulator.Human.Human;
import idiginfo.i2b2.data_simulator.Human.Races;
import idiginfo.i2b2.simulator.Medical.Provider;

public class Generator {
	
	
	protected int AverageAge = 35;
	protected double StdDevAge= 20;
	protected int AverageLifeSpan = 73;
	protected double StdDevLifeSpan=15.5;
	protected NormalDist AgeDist;
	protected NormalDist LifeSpanDist;
	protected Double ProbOfFemale = 0.50;
	protected Random Rand;
	protected GeneratePhysical GenPhys;
	protected static long GENERATOR_ID = 100000;
	protected static long count ;
	public Generator(){
		count =GENERATOR_ID;
		AgeDist = new NormalDist(AverageAge, StdDevAge);
		LifeSpanDist = new NormalDist(AverageLifeSpan, StdDevLifeSpan);
		Rand = new Random(System.currentTimeMillis());
		GenPhys = new GeneratePhysical();
	}
	public Human Make()
	{
		
		
		Calendar event_Date = Calendar.getInstance();
		String parentID = new Long(GENERATOR_ID).toString();
		String ID = new Long(count++).toString();
	
		int Age = getAge();
		Calendar dOB = getDOB(Age);
		String gender = getGender();
		String race = getRace();
		
		Human person = new Human();
		person.setPatientID(ID);
		person.setDOB(dOB);
		person.setGender(gender);
		person.setRace(race);
		person.getAddresses().add(getAddress(person));
		int LifeSpan = getLifeSpan();
		while(LifeSpan < Age)
		{
			LifeSpan = getLifeSpan();
		}
		person.setPrimarary(Rand.nextInt(133) );
		person.setLifeSpan(LifeSpan);
		doPhysicals(person);
		return person;
		
	}
	public int getAge(){
		int Age = 0;
		while(Age < 15)
		{
			Age = (int)AgeDist.getNext();
		}
		return Age;
		}
	
	public int getLifeSpan(){return (int)LifeSpanDist.getNext();}
	
	public String getRace()
	{
		String sRace = "Unknown";
		Double sum, target;
		sum =0.0;
		target = Rand.nextDouble();
		
		for(Races R : Races.values())
		{
			sum+=R.prob();
			sRace = R.toString();
			if(sum>target)
			{
				return sRace;
			}
			
		}
		
		return sRace;
	}
	
	public String getGender()
	{
		
		if(this.ProbOfFemale>Rand.nextDouble())
		{
			return "F";
		}
		return "M";
	}
	
	public Calendar getDOB(int Age)
	{
		Calendar CA = Calendar.getInstance();
		CA.setTimeInMillis(System.currentTimeMillis());
		CA.add(Calendar.YEAR, -1*(Age));
		return CA;
		
	}
	
	public Address getAddress(Human Owner)
	{
		Address add = new Address(Owner);
		return add;
	}
	
	public void doPhysicals(Human person){
		
		GenPhys.fillPhysicals(person);
	}
	

}
