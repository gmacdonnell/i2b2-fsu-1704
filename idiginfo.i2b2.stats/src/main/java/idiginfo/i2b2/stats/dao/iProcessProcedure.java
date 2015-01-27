package  idiginfo.i2b2.stats.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;

import edu.harvard.i2b2.common.exception.I2B2Exception;


public interface iProcessProcedure {
	public void ProcessResults(ResultSet RS) throws I2B2Exception;
	public void ProcessResults(CallableStatement callStmt, int[] outArgs)throws I2B2Exception;

}

