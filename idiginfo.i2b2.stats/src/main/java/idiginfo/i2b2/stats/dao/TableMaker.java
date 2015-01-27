package   idiginfo.i2b2.stats.dao;

public class TableMaker {
	
	public static void makeTable( String[] conditions, String sourceTable, String targetTable) throws Exception
	{
		String SQL = "CREATE TABLE " + targetTable + " AS SELECT * FROM " + sourceTable ;
		
		if(conditions != null){
			
			SQL+=" WHERE ";
			if(conditions != null)
			{
				SQL+= conditions[0];
				for(int index = 1; index < conditions.length; index++)
				{
					SQL+=" and "+ conditions[index];
				}
			}
			
		}
		
System.out.println(SQL);
	
		try{
			DataSource dS =PriorDAO.getDataSource();
			dS.getConnection().createStatement().execute(SQL);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		
	}
	
	public static  String makeClause( String field, String[] with, String oper)
	{
		String sWith;
		String space = " ";
		if(with != null && with.length >0)
		{
		
			sWith =field + space+ oper + space + "  ( ";
			
	
			for(int iwith = 0; iwith < with.length; iwith++)
			{
				if(iwith > 0){sWith+=" , ";}
				sWith+=  with[iwith];
			}
			sWith += " ) ";
		}else{
			sWith = "";
		}
		
		return sWith;
	}

}
