package idiginfo.i2b2.stats.bayes;
import idiginfo.i2b2.stats.dao.*;

public class Distribution {
	DataSource DS;
	String SourceTable;
	
	public Distribution(String sourceTable)
	{
		this.SourceTable = sourceTable;
		DS = DataSourceFactory.getDataSource();
	}
	

}
