package  idiginfo.i2b2.stats.subpopulation;

import idiginfo.i2b2.stats.dao.PriorDAO;
import idiginfo.i2b2.stats.dao.TableMaker;
import idiginfo.i2b2.stats.tests.T_Test;

public class FullSubPop {

	// make sub pop
	// take in full pop table as source.
	// take in critiera for sub pop

	public void MakePop(String popName, String sourceTable) {

		try {
			// Summary Table
			String PRIORS = "_PRIORS";
			// String subPop ="Two_K";
			// String subPop ="Female";
			String subPop = "Female_TWO_K";
			String subPopSummary = subPop + PRIORS;
			// String fullPop = "SIM_TEST";
			String fullPop = "FEMALE";
			String fullPopSummary = fullPop + PRIORS;
			PriorDAO PD = new PriorDAO();
			TableMaker tM = new TableMaker();
			PD.DropTempTable(subPop);
			// String[] inArgs =
			// {" patient_num in (select A.patient_num from SIM_TEST A where A.Concept_CD = 'GENDER' and A.TVAL_CHAR ='F' )"
			// };
			String[] inArgs = { " to_char(PATIENT_NUM) like '200%' " };
			// (String field, String[] with, String[] withOut,String[]
			// conditions, String sourceTable, String targetTable)
			tM.makeTable( inArgs, fullPop, subPop);

			PD.DropTempTable(subPopSummary);
			PD.createPriorTable(subPop);
			PD.fillpriorTablNumberse(subPop, subPopSummary);
			PD.DropTempTable(fullPopSummary);
			PD.createPriorTable(fullPop);
			PD.fillpriorTablNumberse(fullPop, fullPopSummary);
			// T test
			T_Test T = new T_Test();
			try {
				T.Calc_P_Values(fullPopSummary, subPopSummary);
				System.out.println("Success");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println("Success");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
