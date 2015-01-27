package dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;
import org.apache.commons.dbcp.BasicDataSource;

public class TestConnection {

	@Test
	public void test() {
		try{
//javax.sql
			//com.dbaccess.BasicDataSource ds = new com.dbaccess.BasicDataSource();
org.apache.commons.dbcp.BasicDataSource ds = new org.apache.commons.dbcp.BasicDataSource();
ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
ds.setUsername("i2b2demodata");
ds.setPassword("iolkIOLK");
ds.setDriverClassName("oracle.jdbc.OracleDriver");

Connection conn = ds.getConnection();
String querySql= "select count(*), CONCEPT_CD from I2B2DEMODATA.OBSERVATION_FACT group by CONCEPT_CD";
int counter =0;
PreparedStatement stmt = conn.prepareStatement(querySql);
ResultSet resultSet = stmt.executeQuery();
while (resultSet.next()){
	counter++;
}
System.out.println("Counter:"+counter);
assertTrue(counter>0);

//			javax.sql.DataSource dataSource = null;
		}catch(Exception e){
			fail("Failed: "+ e.toString());
		}
		
	}

}
