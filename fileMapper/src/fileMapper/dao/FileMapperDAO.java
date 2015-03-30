package fileMapper.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import oracle.jdbc.OracleTypes;
import edu.harvard.i2b2.common.exception.I2B2Exception;

public class FileMapperDAO {
	private static DataSource ds = null;

	public String SQLSafeString(String value) {
		byte[] Bytes = value.getBytes();

		for (int counter = 0; counter < Bytes.length; counter++) {
			boolean invalid = false;
			if (Bytes[counter] > 'z' || Bytes[counter] < '0') {
				invalid = true;
			} else if ((Bytes[counter] < 'a' & Bytes[counter] > 'Z')
					|| (Bytes[counter] > '9' & Bytes[counter] < 'A')) {
				invalid = true;
			}
			if (invalid) {
				Bytes[counter] = '_';
			}
		}

		return new String(Bytes);
	}

	static public DataSource getDataSource() {
		// gnm
		// ds = null;
		if (ds == null)
			ds = DataSourceFactory.getDataSource();
		return ds;
	}

	// *combin proc name into Arg[]

	static public void RunProcedure(String process, String[] inArgs,
			int[] outArgs, iProcessProcedure Processor) throws I2B2Exception {
		Connection conn = null;
		ResultSet RS = null;
		int argCount = 0;
		int inCounter = 1;
		try {
			if (inArgs != null) {
				argCount += inArgs.length;
			}
			if (outArgs != null) {
				argCount += outArgs.length;
			}
			conn = getDataSource().getConnection();
			String call = "{call " + process + getArgHolders(argCount) + "}";
			CallableStatement callStmt = conn.prepareCall(call);
			if (inArgs != null) {
				while (inCounter <= inArgs.length) {
					callStmt.setString(inCounter, inArgs[inCounter-1]);
					inCounter++;
				}
			}
			int outCounter = 0;
			if (outArgs != null) {
				while (outCounter < outArgs.length) {
					callStmt.registerOutParameter(inCounter + outCounter,
							outArgs[outCounter]);
					outCounter++;
				}
			}

			callStmt.execute();

			if (Processor != null) {

				if (argCount > 0 && outCounter > 0) {
					Processor.ProcessResults((ResultSet) callStmt
							.getObject(argCount));
				} else {
					Processor.ProcessResults(callStmt, outArgs);
				}

			}
			// this.getSQLServerProcedureError(dataSourceLookup.getServerType(),
			// callStmt, 2);
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
			throw new I2B2Exception(
					"SQLException occured" + sqlEx.getMessage(), sqlEx);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new I2B2Exception("Exception occured " + ex.getMessage(), ex);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException sqlEx) {
					sqlEx.printStackTrace();
					// log.error("Error while closing connection", sqlEx);
				}

			}
		}

	}

	static private String getArgHolders(int args) {
		String outVal = "(";
		int counter = 0;
		while (counter < args) {
			if (counter > 0) {
				outVal += ",";
			}
			outVal += "?";
			counter++;
		}
		outVal += ")";
		return outVal;
	}

}
