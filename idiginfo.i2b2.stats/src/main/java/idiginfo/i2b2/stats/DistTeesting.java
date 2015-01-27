package idiginfo.i2b2.stats;

import static org.junit.Assert.*;
import idiginfo.i2b2.stats.bayes.DataTable;
//import idiginfo.i2b2.stats.bayes.Distribution;

import idiginfo.i2b2.stats.dao.PriorDAO;
import idiginfo.i2b2.stats.dao.TableMaker;

import org.junit.Test;

public class DistTeesting {

	@Test
	public void test() {
		try{
			//String sourceTable = "SIM_TEST";
			String sourceTable = "OBSERVATION_FACTS";
			MakeDists(sourceTable);
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("Success");
	}
	
	//	@Test
	public void test02()
	{
		//DividePop("SIM_TEST");
		DividePop("DATA_TEST");
	}
	
	
	public void DividePop(String source)
	{
		PriorDAO DA = new PriorDAO();
		String[] with2 = {"'2%'"};
		String[] with1 = {"'1%'"};
		String LikeClause1 = TableMaker.makeClause("PATIENT_NUM", with1, "LIKE" );
		String LikeClause2 = TableMaker.makeClause("PATIENT_NUM", with2, "LIKE" );
		String[] withF = {"'F' "};
		String[] withM = { "'M'"};
		String inClauseF = "CONCEPT_CD = 'GENDER' and " + TableMaker.makeClause("TVAL_CHAR", withF, "IN");
		String inClauseM = "CONCEPT_CD = 'GENDER' and " + TableMaker.makeClause("TVAL_CHAR", withM, "IN");
		String[] conditionsF2 = {LikeClause2, inClauseF};
		String[] conditionsM2 = {LikeClause2, inClauseM};
		String[] conditionsF1 = {LikeClause1, inClauseF};
		String[] conditionsM1 = {LikeClause1, inClauseM};
		try{
		DA.DropTempTable("TWO_K_FEMALE");
		DA.DropTempTable("TWO_K_MALE");
		DA.DropTempTable("ONE_K_FEMALE");
		DA.DropTempTable("ONE_K_MALE");
		TableMaker.makeTable(conditionsF2, source, "Two_K_FEMALE");
		TableMaker.makeTable(conditionsM2, source, "Two_K_MALE");
		TableMaker.makeTable(conditionsF1, source, "ONE_K_FEMALE");
		TableMaker.makeTable(conditionsM1, source, "ONE_K_MALE");
		DA.fillTempTable("GENDER", source, "Two_K_FEMALE");
		DA.fillTempTable("GENDER", source, "ONE_K_FEMALE");
		DA.fillTempTable("GENDER", source, "Two_K_MALE");
		DA.fillTempTable("GENDER", source, "ONE_K_MALE");
		MakeDists("Two_K_FEMALE");
		MakeDists("ONE_K_FEMALE");
		MakeDists("Two_K_MALE");
		MakeDists("ONE_K_MALE");
		System.out.println("Sucess");
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	public void MakeDists(String source) throws Exception
	{
		DataTable DT = new DataTable(source);
		DT.Drop_Mean_Table();
		DT.Create_Mean_Table();
		DT.Fill_Mean_Table();
		
		DT.Drop_DIST_Table();
		DT.Create_DIST_Table();
		DT.Fill_DIST_Table();
		DT.Drop_DIST_OF_MEANS_Table();
		DT.Create_DIST_OF_MEANS_Table();
		DT.Fill_DIST__OF_MEANS_Table();

	}
	
	
}
