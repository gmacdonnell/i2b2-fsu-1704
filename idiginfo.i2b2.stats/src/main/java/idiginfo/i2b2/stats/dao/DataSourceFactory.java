package  idiginfo.i2b2.stats.dao;

public class DataSourceFactory {
	static protected  DataSource ds ;
	public DataSourceFactory()
	{
		ds = null;
	}
	
	public static DataSource getDataSource()
	{
		if (ds == null){
			ds = new DataSource();
		}
		return ds;
	}
	
	

}
