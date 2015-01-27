package  idiginfo.i2b2.stats.dao;
/* A Data source for testing only 
 * 
 */
import org.apache.commons.dbcp.BasicDataSource;
public class DataSource  extends  BasicDataSource{
	
	public DataSource()
	{
	setUrl("jdbc:oracle:thin:@localhost:1521:XE");
	setUsername("i2b2Bayes");
	setPassword("iolkIOLK");
	setDriverClassName("oracle.jdbc.OracleDriver");
	}
}
