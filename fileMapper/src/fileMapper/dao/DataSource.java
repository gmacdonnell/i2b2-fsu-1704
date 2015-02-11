package fileMapper.dao;

/* A Data source for testing only 
 * 
 */
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fileMapper.util.Utils;

public class DataSource extends BasicDataSource {
	protected final Log log = LogFactory.getLog(getClass());

	public DataSource() {
		init();

	}

	private void init() {
		try {
			Utils util = Utils.getInstance();
			setUrl(util.getDataSourceUrl());
			setUsername(util.getDataSourceUser());
			setPassword(util.getDataSourcePassword());
			setDriverClassName(util.getDataSourceDriver());
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
}
