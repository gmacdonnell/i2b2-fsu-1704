package idiginfo.i2b2.stats.bayes;
import edu.harvard.i2b2.common.exception.I2B2Exception;
import idiginfo.i2b2.stats.dao.*;

public class DataTable {
	
	static String	CREATE_MEAN_TABLE	=	"i2b2bayes.CREATE_MEAN_TABLE";
	static String 	FILL_MEAN_TABLE 	=	"i2b2bayes.FILL_MEANS_TABLE";
	static String	CREATE_DIST_TABLE	=	"i2b2bayes.CREATE_DIST_TABLE";
	static String	FILL_DIST_TABLE		=	"i2b2bayes.FILL_DIST_TABLE";
	static String	FILL_PATIENT_MEANS	=	"i2b2bayes.FILL_PATIENT_MEANS";
	static String	DROP_TEMP_TABLE		=	"i2b2bayes.DROP_TEMP_TABLE";
	static String	GET_PROB_DIST		=	"i2b2bayes.GET_PROB_DIST";
	static String	GET_PROB_VALUE		=	"i2b2bayes.GET_PROB_VALUE";
	static String	INSERT_FACT			=	"i2b2bayes.INSERTFACT";
	static String 	MEANS				=	"_MEANS";
	static String 	DIST				=	"_DIST";
	static String FILL_DIST_OF_MEANS_TABLE = "FILL_DIST_OF_MEANS_TABLE";
	/*
	 * static String	=	"i2b2bayes.";
	*/
	
	
	

	String SourceTable;
	
	public DataTable(String sourceTable)
	{
		SourceTable = sourceTable;
		

	}
	
	public void Create_Mean_Table() throws I2B2Exception
	{
		String[] inArgs ={CREATE_MEAN_TABLE, SourceTable };
		PriorDAO.RunProcedure(inArgs, null, null);
	}
	
	public void Fill_Mean_Table()throws I2B2Exception
	{
		String[] inArgs ={FILL_MEAN_TABLE, SourceTable };
		PriorDAO.RunProcedure(inArgs, null, null);
	}
	
	public void Drop_Mean_Table() throws I2B2Exception
	{
		String[] inArgs ={DROP_TEMP_TABLE, SourceTable+MEANS };
		PriorDAO.RunProcedure(inArgs, null, null);
	}
	

	public void Create_DIST_Table() throws I2B2Exception
	{
		String[] inArgs ={CREATE_DIST_TABLE, SourceTable };
		PriorDAO.RunProcedure(inArgs, null, null);
	}
	
	public void Create_DIST_OF_MEANS_Table() throws I2B2Exception
	{
		String[] inArgs ={CREATE_DIST_TABLE, SourceTable+MEANS };
		PriorDAO.RunProcedure(inArgs, null, null);
	}
	public void Fill_DIST__OF_MEANS_Table()throws I2B2Exception
	{
		String[] inArgs ={FILL_DIST_OF_MEANS_TABLE, SourceTable+MEANS, SourceTable+MEANS+DIST };
		PriorDAO.RunProcedure(inArgs, null, null);
	}
	public void Fill_DIST_Table()throws I2B2Exception
	{
		String[] inArgs ={FILL_DIST_TABLE, SourceTable, SourceTable+DIST };
		PriorDAO.RunProcedure(inArgs, null, null);
	}
	
	public void Drop_DIST_Table() throws I2B2Exception
	{
		String[] inArgs ={DROP_TEMP_TABLE, SourceTable+DIST };
		PriorDAO.RunProcedure(inArgs, null, null);
	}
	public void Drop_DIST_OF_MEANS_Table() throws I2B2Exception
	{
		String[] inArgs ={DROP_TEMP_TABLE, SourceTable+MEANS+DIST };
		PriorDAO.RunProcedure(inArgs, null, null);
	}
}
