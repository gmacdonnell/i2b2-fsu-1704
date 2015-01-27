package idiginfo.i2b2.stats.util;

import idiginfo.i2b2.stats.dao.PriorDAO;
import idiginfo.i2b2.stats.dao.iProcessProcedure;

import java.sql.CallableStatement;
import java.sql.ResultSet;

import edu.harvard.i2b2.common.exception.I2B2Exception;
import oracle.jdbc.OracleTypes;

public class ProbTools implements iProcessProcedure{
static String GET_PROB_VALUE = "GET_PROB_VALUE";
static String OUT_PROB ="O_PROB";
private double ProbValue;
private boolean isSet;
public PopProb getMaxProb(String[] popTables, String patient_ID)
{
	return null;
}

public double getPatientProb(String popTable, String patient_ID)
{
	

	return 0.0;
}

public double calcProb(ResultSet RS, String pop_Table)
{
	// if pop_Table_Dist not exist create_Dist_Table
	return 0.0;
}

public double getProbOfValue(String popTable, String concept_CD, String value) throws I2B2Exception
{
	isSet = false;
	ProbValue = 0.0;
	String[] inArgs = {GET_PROB_VALUE, popTable, concept_CD , value};
	int[] outArgs = {OracleTypes.DOUBLE};
	PriorDAO.RunProcedure(inArgs, outArgs, this);
	if(isSet){
		isSet = false;
	return ProbValue;
	}
	else
		return 0.0;
}
public void ProcessResults(ResultSet RS) throws I2B2Exception
{
	try{
		isSet= true;
	float probValue = RS.getFloat(0);
	while(RS.next())
	{
		probValue *= RS.getFloat(0);
	}
	ProbValue =(double)probValue;
//	probValue =(double) RS.getObject(OUT_PROB);
	}catch(Exception e)
	{
		throw new I2B2Exception(e.getMessage());
	}
	
	
}
public void ProcessResults(CallableStatement callStmt, int[] outArgs)throws I2B2Exception
{
	
}

}