package  idiginfo.i2b2.stats.testing;

import static org.junit.Assert.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import idiginfo.i2b2.stats.tests.T_Test;
import idiginfo.i2b2.stats.dao.DataSourceFactory;
import idiginfo.i2b2.stats.dao.PriorDAO;
import idiginfo.i2b2.stats.dao.TableMaker;
import edu.harvard.i2b2.common.exception.I2B2Exception;

public class TestTempTable {
	//@Test
	public void TableTest()
	{
	 TableMaker tm = new TableMaker();
	 String field = "SomeField";
	 String[] with ={"One","Two","Three"};
	 String[] withOut={"Alpha","Bravo","Delta"};
	 String sourceTable = "Source_Table";
	 String targetTable="Target_Table";
	 
	// tm.makeTable(field, with, withOut, sourceTable, targetTable);
	}
	
//	@Test
	public void TestMakeTemp()
	{
		try{
		String tempTableName="AA_TEST_TEMP";
		String sourceTable = "i2b2demodata.observation_fact";
		String conceptName = "NDC:00173044702";
		PriorDAO PD = new PriorDAO();
		PD.DropTempTable(tempTableName);
		PD.createTempTable(tempTableName, sourceTable, conceptName);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	 
//	@Test
	public void TestFillTemp()
	{
		TestMakeTemp();
		try{
			String tempTableName="AA_TEST_TEMP";
			String sourceTable = "i2b2demodata.observation_fact";
			String conceptName = "NDC:00173044702";
			PriorDAO PD = new PriorDAO();
			PD.fillTempTable(conceptName, sourceTable, tempTableName);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	//@Test
	public void TestDropPrior()
	{
		try{
		String tempTableName="AA_TEST_TEMP";
		String sourceTable = "i2b2demodata.observation_fact";
		String conceptName = "NDC:00173044702";
		PriorDAO PD = new PriorDAO();
		PD.DropTempTable(PD.SQLSafeString(conceptName)+"_Priors");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	//@Test
	public void TestMakePrior()
	{
		try{
		String tempTableName="AA_TEST_TEMP";
		String sourceTable = "i2b2demodata.observation_fact";
		String conceptName = "NDC:00173044702";
		PriorDAO PD = new PriorDAO();
		PD.DropTempTable(PD.SQLSafeString(conceptName)+"_Priors");
		PD.createPriorTable(conceptName);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
//	@Test
	public void TestMakeBasePrior()
	{
		try{
		String tempTableName="AA_TEST_TEMP";
		String sourceTable = "i2b2demodata.observation_fact";
		String conceptName = "NDC:00173044702";
		PriorDAO PD = new PriorDAO();
		PD.DropTempTable("BASE_Priors");
		PD.createPriorTable();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	//@Test
	public void TestFillPrior()
	{
		TestFillTemp();
		TestMakePrior();
		try{
		String tempTableName="AA_TEST_TEMP";
		String sourceTable = "i2b2demodata.observation_fact";
		String conceptName = "NDC:00173044702";
		PriorDAO PD = new PriorDAO();
		PD.fillpriorTablNumberse(tempTableName, PD.SQLSafeString(conceptName)+"_PRIORS");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	@Test
public void PriorTest()
{
	try{
		//Summary Table
		String PRIORS = "_PRIORS";
		//String subPop ="Two_K";
		//String subPop ="Female";
		String subPop ="Female_TWO_K";
		String subPopSummary = subPop + PRIORS;
		//String fullPop = "SIM_TEST";
		String fullPop = "FEMALE";
		String fullPopSummary = fullPop + PRIORS;
		PriorDAO PD = new PriorDAO();
		TableMaker tM = new TableMaker();
		PD.DropTempTable(subPop);
		//String[] inArgs = {" patient_num in (select A.patient_num from SIM_TEST A where A.Concept_CD = 'GENDER' and A.TVAL_CHAR ='F' )" };
		String[] inArgs = {" to_char(PATIENT_NUM) like '200%' " };
		//(String field, String[] with, String[] withOut,String[] conditions, String sourceTable, String targetTable)
		tM.makeTable(  inArgs, fullPop, subPop);
	
	PD.DropTempTable(subPopSummary);
	PD.createPriorTable(subPop);
	PD.fillpriorTablNumberse(subPop, subPopSummary);
	PD.DropTempTable(fullPopSummary);
	PD.createPriorTable(fullPop);
	PD.fillpriorTablNumberse(fullPop, fullPopSummary);
// T test
	T_Test T = new T_Test();
	try{
	T.Calc_P_Values(fullPopSummary, subPopSummary);
	System.out.println("Success");
	}catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
	System.out.println("Success");	
	}catch(Exception e)
	{
		System.out.println(e.toString());
		}
}
	
	//@Test
	public void TestFillPriorBase()
	{
		
		TestMakeBasePrior();
		try{
		String tempTableName="AA_TEST_B";
		String sourceTable = "i2b2demodata.observation_fact";
		String conceptName = "NDC:00173044702";
		PriorDAO PD = new PriorDAO();
		PD.fillpriorTablNumberse(sourceTable, "BASE_PRIORS");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	
	
	

	public void testPrior() {
		try{
			PriorDAO PD = new PriorDAO();
			PD.createPriorTable("AA_PRIOR_TEST");
		}catch(Exception e)
		{
		fail("GNM Error "+ e.getMessage());
		}
	
		
	}
	
	//@Test
	public void TTest()
	{
		T_Test T = new T_Test();
		try{
		T.Calc_P_Values("TEST_BASE_PRIORS", "TWO_K_PRIORS");
		System.out.println("Success");
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	public void testProcedure(String Name)
	{
	
			Connection conn = null;
			try {
				conn = DataSourceFactory.getDataSource().getConnection();
			//REMOVE_TEMP_TABLE	CallableStatement callStmt = conn.prepareCall("{call "+ "i2b2demodata" + ".CREATE_TEMP_CONCEPT_TABLE(?,?)}");
				CallableStatement callStmt = conn.prepareCall("{call "+ "i2b2demodata" + ".REMOVE_TEMP_TABLE(?)}");
				callStmt.setString(1, Name);
				//callStmt.registerOutParameter(2, java.sql.Types.VARCHAR);
				//PreparedStatement  callStmt = conn.prepareStatement(SQL);
				callStmt.executeUpdate();
				//System.out.println("GNM: "+ " Name: "+ tempTableName);
				//this.getSQLServerProcedureError(dataSourceLookup.getServerType(),
				//		callStmt, 2);
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
				System.out.println(sqlEx.getMessage());
				//throw new I2B2Exception(
				//		"SQLException occured" + sqlEx.getMessage(), sqlEx);
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println(ex.getMessage());
				//throw new I2B2Exception("Exception occured" + ex.getMessage(), ex);
			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException sqlEx) {
						sqlEx.printStackTrace();
					//	log.error("Error while closing connection", sqlEx);
					}
				}
			}
	}

	
	//@Test 
	public void MkeTableTest()
	{
		try{
		TableMaker tM = new TableMaker();
		String[] inArgs = {" to_char(PATIENT_NUM) like '200%' "};
		//(String field, String[] with, String[] withOut,String[] conditions, String sourceTable, String targetTable)
		tM.makeTable(  inArgs, "i2b2bayes.SIM_TEST", "i2b2bayes.TWO_K_SET");
		}catch(Exception e)
		{
			
		}
	}
	

}
