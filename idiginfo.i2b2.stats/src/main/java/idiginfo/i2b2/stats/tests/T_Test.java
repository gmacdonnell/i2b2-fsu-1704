package idiginfo.i2b2.stats.tests;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;


import oracle.jdbc.OracleTypes;

import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.stat.inference.TTest;

import idiginfo.i2b2.stats.dao.PriorDAO;
import idiginfo.i2b2.stats.dao.iProcessProcedure;
import edu.harvard.i2b2.common.exception.I2B2Exception;

public class T_Test extends org.apache.commons.math3.stat.inference.TTest
		implements iProcessProcedure {
	protected String Table_1;
	protected String Table_2;
	protected LinkedList<P_VALUE> P_VALUES;
	
	public T_Test()
	{
		P_VALUES = new LinkedList<P_VALUE>();
	}
	public String getTable_1() {
		return Table_1;
	}
	public void setTable_1(String table_1) {
		Table_1 = table_1;
	}
	public String getTable_2() {
		return Table_2;
	}
	public void setTable_2(String table_2) {
		Table_2 = table_2;
	}
	public LinkedList<P_VALUE> getP_VALUES() {
		return P_VALUES;
	}
	public double tTest(double m1, double m2, double v1, double v2, double n1,
			double n2) throws MaxCountExceededException,
			MathIllegalArgumentException {
		return super.tTest(m1, m2, v1, v2, n1, n2);
	}

	public void ProcessResults(CallableStatement callStmt, int[] outArgs)
			throws I2B2Exception {
		// TODO Needs to be implamented
		try {
			callStmt.executeQuery();
			ResultSet rS = callStmt.getResultSet();
			ProcessResults(rS);

		} catch (Exception e) {
			throw new I2B2Exception(e.getMessage());
		}
		//
	}

	public void ProcessResults(ResultSet RS) throws I2B2Exception {
		if (RS != null) {
			try {
				while (RS.next()) {
					String concept_CD = RS.getString(1);
					double n1 = RS.getDouble(2);
					double m1 = RS.getDouble(3);
					double v1 = RS.getDouble(4);
					double n2 = RS.getDouble(5);
					double m2 = RS.getDouble(6);
					double v2 = RS.getDouble(7);

					Double p_value = new Double(tTest(m1, m2, v1, v2, n1, n2));
					if (!p_value.isNaN()) {
						/*String[] inArgs = {
								"i2b2Bayes.updateprior_p_value(?,?,?)",
								getTarget(), p_value.toString(), concept_CD };
						try {

							PriorDAO.RunProcedure(inArgs, null, null);
						} catch (Exception e) {
							throw new I2B2Exception(e.getMessage());
						}
						*/
						P_VALUE  NewValue = new P_VALUE(concept_CD,n1,m1,v1,n2,m2,v2,getTable_1(), getTable_2(),  p_value);
						P_VALUES.add(NewValue);
					}
				}
			} catch (Exception e) {
				throw new I2B2Exception(e.getMessage());
			}
		}
	}

	public void Calc_P_Values(String table_1, String table_2)
			throws I2B2Exception {
		setTable_1(table_1);
		setTable_2(table_2);
		String[] inArgs = { "i2b2Bayes.GET_FOR_T_TEST(?,?,?)", table_1,
				table_2 };

		int[] outArgs = { OracleTypes.CURSOR };

		PriorDAO.RunProcedure(inArgs, outArgs, this);
	}

	
}