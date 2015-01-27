package idiginfo.i2b2.data_simulator.testing;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import idiginfo.i2b2.data_simulator.Generators.GammaDist;
import idiginfo.i2b2.data_simulator.Generators.GeneratePhysical;
import idiginfo.i2b2.data_simulator.Generators.Generator;
import idiginfo.i2b2.data_simulator.Generators.GeneratorType2;
import idiginfo.i2b2.data_simulator.Generators.Adjusters.TipHighToLow;
import idiginfo.i2b2.data_simulator.Human.Human;
import idiginfo.i2b2.simulator.Medical.Concept;

import org.junit.Test;

import idiginfo.i2b2.stats.dao.PriorDAO;

public class GeneratorMake {
	int Size = 10;

	// @Test
	public void test() {
		try {
			Human[] MyPeople = new Human[Size];
			Generator G = new Generator();
			for (int i = 0; i < Size; i++) {
				MyPeople[i] = G.Make();
				Print(MyPeople[i].toString());

			}

		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	// @Test
	public void PhysAge() {
		/*
		 * int runs = 1000; Generator Gen = new Generator(); Human person =
		 * Gen.Make();
		 * 
		 * GeneratePhysical GP = new GeneratePhysical(); Histo H = new
		 * Histo(89,20); for(int i = 0; i < runs; i++) {
		 * H.add(GP.getNextTEMP()); } H.display();
		 */
	}

	// @Test
	public void BP_DIST() {
		int runs = 10000;
		Generator Gen = new Generator();
		Human person = Gen.Make();
		int ageAtPhys = 45;
		GeneratePhysical GP = new GeneratePhysical();
		Histo H = new Histo(89, 100);
		double temp = 0.0;
		// for(int i = 0; i < runs; i++)
		while (temp < 200) {
			temp = GP.getNextBP_DIA(person, ageAtPhys);
			person.getLastPhysical().setBP_SYS(temp);
			H.add(temp);
			System.out.println(temp);

		}
		H.display();
	}

	public static void Print(String txt) {
		System.out.println(txt);
	}

	// @Test
	public void Gamma() {
		int runs = 10000;
		double Shape = 3.5;
		double Scale = 1.0;
		GammaDist G = new GammaDist(Shape, Scale);
		Histo H = new Histo(0, 10);
		for (int i = 0; i < runs; i++) {
			H.add(G.getNext());
		}
		H.display();
	}

	// @Test
	public void AgeTest() {
		GeneratePhysical GP = new GeneratePhysical();
		Human person = new Human();
		person.setLifeSpan(80);
		Calendar DOB = Calendar.getInstance();
		DOB.add(Calendar.YEAR, -40);
		person.setDOB(DOB);
		double weight = 126;
		Histo H = new Histo(0, 200, 1);
		for (int i = 0; i < 1000; i++) {
			H.add(GP.getNewValue(weight, new TipHighToLow((double) 26,
					(double) person.getLifeSpan() / 2), GP
					.getRandWeightChange()));
			// H.add(new TipHighToLow((double) 26,(double) person.getLifeSpan()
			// / 2).getValue());
		}
		H.display();
	}

	public static void main(String[] args) {
		PersonTest01();
	}

	 @Test
	public static void PersonTest01() {
		//String targetTable = "SIM_TEST";
			String targetTable = "DATA_TEST";
			targetTable = "test_sample";
			try{
			PriorDAO DAO = new PriorDAO();
			DAO.DropTempTable(targetTable);
			String[] inArgs ={"CREATE_EMPTY_FACT_TABLE",targetTable};
			DAO.RunProcedure(inArgs, null, null);
		Generator Gen = new Generator();
		int crowedSize = 10000;
		crowedSize = 1000;
		makePop(Gen, crowedSize, targetTable);
		GeneratorType2 Gen2 = new GeneratorType2();
		makePop(Gen2, crowedSize, targetTable);
		Print("Finished");
			}catch(Exception e)
			{
				Print("Failed :"+e.getMessage());
			}
	}

	public static void makePop(Generator gen, int crowedSize, String targetTable) {
		try {
			// LinkedList<Human> myPeople = new LinkedList<Human>();
			for (int count = 0; count < crowedSize; count++) {
				try {
					Human current = gen.Make();
					current.getHistory().recordHistory(
							Concept.INSERT_PROCEDURE, targetTable);
					// myPeople.add(current);
				} catch (Exception e) {
					Print(e.getMessage());
				}
			}
			Print("Success");
		} catch (Exception e) {
			Print(e.getMessage());
		}
	}

	// @Test
	public void ConnectionTest() {
		try {
			String[] inArgs = { "i2b2Bayes.TESTPROC(?)", "AA_TEST_TEMP" };
			int[] outArgs = null;

			PriorDAO.RunProcedure(inArgs, outArgs, null);
		} catch (Exception e) {
			Print(e.getMessage());
		}
	}

	// @Test
	public void DateTest() {
		Calendar Cal = Calendar.getInstance();
		Print(new Long(Cal.getTimeInMillis()).toString());
	}
}
