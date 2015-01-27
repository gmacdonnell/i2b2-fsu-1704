package idiginfo.i2b2.data_simulator.Generators;

import java.util.Calendar;
import java.util.Random;

import idiginfo.i2b2.data_simulator.Generators.Adjusters.Adjuster;
import idiginfo.i2b2.data_simulator.Generators.Adjusters.Flat;
import idiginfo.i2b2.data_simulator.Generators.Adjusters.TipHighToLow;
import idiginfo.i2b2.data_simulator.Human.Human;
import idiginfo.i2b2.simulator.Medical.Physical;

public class GeneratePhysical {

	/*
	 * values to be generated double C_Weight; //lbs int C_BP_SYS; //mm hg int
	 * C_BP_DIA; //mm hg int C_HR; // / min int C_RESP_Rate; // / min double
	 * c_Temp; // deg F
	 */
	static  protected int PERSISION = 10;
	protected  double MaleHightMean = 70.0;
	protected  double MaleHightStDev = 0.57;
	protected  double FemaleHightMean = 64.4;
	protected  double FemaleHightStDev = 0.53;
	protected  double MaleWeightMean = 175.3;
	protected  double MaleWeightStDev = 1.73;
	protected  double FemaleWeightMean = 149.9;
	protected  double FemaleWeightStDev = 25.0;// 1.4;
	protected  double TPWeightMean = 60.0;
	protected  double TPWeightStDev = 4;
	protected  double WeightChangeMean = 0.0;
	protected  double WeightChangeStDev = 4.0;
	protected  double TempMean = 98.6;
	protected  double TempVarStDev = 1.0;
	protected  double TempVarMean = 0.0;
	protected  double HRMean = 64.0;
	protected  double HRStDev = 2.5;
	protected  double MaleBP_SMean = 110;
	protected  double MaleBP_SStDev = 5.0;
	protected  double MaleBP_DMean = 70;
	protected  double MaleBP_DStDev = 5.0;
	protected  double VarMean =0.0;
	protected  double RespMean = 30.0;
	protected  double RespStDev = 10;
	

	protected  double FemaleBP_SMean = 100;
	protected  double FemaleBP_SStDev = 5.0;
	protected  double FemaleBP_DMean = 70;
	protected  double FemaleBP_DStDev = 5.0;
	protected  int FIRST_PHYSICAL = 17;
	protected  double Yrs_Btwn_PhysMean = 3.5;
	protected  double Yrs_Btwn_PhysStDev =1.0;

	protected  String FEMALE = "F";
	protected iDistribution RandHightFemale;
	protected iDistribution RandHightMale;
	protected iDistribution RandWeightFemale;
	protected iDistribution RandWeightMale;
	protected iDistribution RandTPWeight;
	protected iDistribution RandWeightChange;
	protected iDistribution RandTempVar;
	protected iDistribution RandHR;
	protected iDistribution BPRandMaleS;
	protected iDistribution BPRandFemaleS;
	protected iDistribution BPRandMaleD;
	protected iDistribution BPRandFemaleD;
	protected iDistribution RespRandD;
	protected Random Rand;
	protected GammaDist BetweenPhys;

	protected Physical LastPhys;
protected  long Encounters=0;

	public GeneratePhysical() {
		init();
	}

	public static double getNewValue(double current, Adjuster adj, iDistribution rand) {
		return Round(current * (adj.getValue() * rand.getNext()));

	}

	protected void init() {
		RandWeightFemale = new NormalDist(FemaleWeightMean, FemaleWeightStDev);
		RandWeightMale = new NormalDist(MaleWeightMean, MaleWeightStDev);

		RandHightFemale = new NormalDist(FemaleHightMean, FemaleHightStDev);
		RandHightMale = new NormalDist(MaleHightMean, MaleHightStDev);
		RandTPWeight = new NormalDist(TPWeightMean, TPWeightStDev);

		RandWeightChange = new NormalDist(WeightChangeMean, WeightChangeStDev);
		Rand = new Random(System.currentTimeMillis());
		BetweenPhys = new GammaDist(Yrs_Btwn_PhysMean, Yrs_Btwn_PhysStDev);
		RandTempVar = new NormalDist(TempMean, TempVarStDev);
		LastPhys = null;
		RandHR = new NormalDist(HRMean, HRStDev);
		BPRandMaleS = new NormalDist(MaleBP_SMean, MaleBP_SStDev);
		BPRandMaleD = new NormalDist(MaleBP_DMean, MaleBP_DStDev);
		BPRandFemaleS = new NormalDist(FemaleBP_SMean, FemaleBP_SStDev);
		BPRandFemaleD = new NormalDist(FemaleBP_DMean, FemaleBP_DStDev);
		RespRandD = new NormalDist(RespMean, RespStDev);
	}

	public double getInitialWeight(Human person) {
		if (person.getGender() == FEMALE) {
			return RandWeightFemale.getNext();
		} else {
			return RandWeightMale.getNext();
		}
	}

	public double getHightAdult(Human person) {
		if (person.getGender() == FEMALE) {
			return RandHightFemale.getNext();
		} else {
			return RandHightMale.getNext();
		}
	}

	public void fillPhysicals(Human person) {
		int ageAtPhys = person.getAge(); // do only
																// adult
		LastPhys = person.getLastPhysical();																// physicals
		
		while (ageAtPhys > FIRST_PHYSICAL) {
			
			
			
			Calendar now =  (Calendar)person.getDOB().clone();
			now.add(Calendar.YEAR, ageAtPhys );
			Physical phys = new Physical(person, now);
			

			phys.setProviderID(getProvider(person));
			
			phys.setWeight(getNextWeight(person, ageAtPhys));
			phys.setBP_SYS(getNextBP_SYS(person, ageAtPhys));
			phys.setBP_DIA(getNextBP_DIA(person, ageAtPhys));
			phys.setRESP_Rate(getNextRESP(person, ageAtPhys));
			phys.setHR(getNextHR(person, ageAtPhys));
			phys.setTemp(getNextTEMP());
			person.addToHistory(phys);
			LastPhys = phys;
			ageAtPhys -= (int) Math.round(BetweenPhys.getNext());
			
		}

	}
	public void Print(int value)
	{
		Print(new Integer(value).toString());
	}
public void Print(String Txt)
{
	System.out.println(Txt);
}
	public int getProvider(Human person) {
		return person.getPrimarary();
	}

	// Weight//lbs
	public double getNextWeight(Human person, int ageAtPhys) {
		double weight ;

		if (LastPhys != null) {
			weight = LastPhys.getWeight();
		}
		else{
			weight = this.getInitialWeight(person);
		}
				weight=  weight+ (new TipHighToLow( ageAtPhys,
						(double) (person.getLifeSpan() / 2)).getValue() * RandWeightChange.getNext());
			
			
		
		return Round(weight);
	}

	public iDistribution getRandWeightChange() {
		return RandWeightChange;
	}

	public void setRandWeightChange(iDistribution randWeightChange) {
		RandWeightChange = randWeightChange;
	}

	// BP_SYS mm hg
	public double getNextBP_SYS(Human person, int ageAtPhys) {
		double sys = 0.0;
		iDistribution BPRand;
		if (LastPhys != null) {
			sys = LastPhys.getBP_SYS();
		}

		if (person.getGender() == FEMALE) {
			if (sys < 1) {
				sys = FemaleBP_SMean;
			}
			BPRand = this.BPRandFemaleS;
			sys = sys/FemaleBP_SMean;
		} else {
			if (sys < 1) {
				sys = MaleBP_SMean;
			}
			BPRand = BPRandMaleS;
			sys = sys / MaleBP_SMean;
		}
		
		return getNewValue(sys, new Flat(1.01), BPRand);
	}

	// BP_DIAmm hg
	public double getNextBP_DIA(Human person, int ageAtPhys) {
		double DIA = 0.0;
		iDistribution BPRand;
		if (LastPhys != null) {
			DIA = LastPhys.getBP_DIA();
		}else
		{
			DIA = 0;
		}

		if (person.getGender() == FEMALE) {
			if (DIA < 1) {
				DIA = FemaleBP_DMean;
			}
			DIA = DIA/FemaleBP_DMean;
			BPRand = this.BPRandFemaleD;
		} else {
			if (DIA < 1) {
				DIA = MaleBP_DMean;
			}
			DIA = DIA/MaleBP_DMean;
			BPRand = BPRandMaleD;
		}

		return getNewValue(DIA, new Flat(1.0), BPRand);
	}

	// HR min
	public double getNextHR(Human person, int ageAtPhys) {
		Double Rate = 0.0;
		if (LastPhys != null) {
			Rate = LastPhys.getHR();
		}
		if (Rate < 1) {
			Rate = RandHR.getNext();
		}
		Rate = Rate/HRMean;
		
		 return getNewValue(Rate, new Flat(1.0),RandHR);

	}

	// RESP_/ min
	public double getNextRESP(Human person, int ageAtPhys) {
		double rate =0.0;
		if(LastPhys !=null)
		{
			rate = LastPhys.getRESP_Rate();
		}
		else{
			rate = RespMean;
		}
		rate = rate/RespMean;
		
		return getNewValue(rate, new Flat(1.0),RespRandD );
	}

	// Temp // deg F
	public double getNextTEMP() {
		Double Temp = 0.0;
		if (LastPhys != null) {
			Temp = LastPhys.getTemp();

		}
		if (Temp < 1) {
			Temp = TempMean;
		}
		Temp = Temp/TempMean;
		return getNewValue(Temp, new Flat(1), RandTempVar);
	}

	public static double Round(double value)
	{
		double newVal= value * PERSISION;
		newVal = Math.round(newVal)/(double)PERSISION;
		
		return newVal;
	}
}
