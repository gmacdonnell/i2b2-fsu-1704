package fileMapper.util;

import java.io.IOException;
import java.io.StringWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.ListIterator;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

import edu.harvard.i2b2.common.exception.I2B2Exception;
import edu.harvard.i2b2.common.util.ServiceLocator;


public class Utils {
	 /** property file name which holds application directory name **/
    public static final String APPLICATION_DIRECTORY_PROPERTIES_FILENAME = "fileMapper_application_directory.properties";

    /** application directory property name **/
    public static final String APPLICATIONDIR_PROPERTIES = "fileMapper.applicationdir";

    /** application property filename**/
    public static final String APPLICATION_PROPERTIES_FILENAME = "fileMapper.properties";
    
    public static final String DATA_SOURCE_URL = "fileMapper.ws.crc.datasource";
    public static final String  DATA_SOURCE_USER= "fileMapper.ws.crc.datasource.user";
    public static final String  DATA_SOURCE_PASSWORD= "fileMapper.ws.crc.datasource.password";
    public static final String  DATA_SOURCE_DRIVER= "fileMapper.ws.crc.datasource.driver";
   

    /** property name for datasource present in app property file**/
 //   private static final String DATASOURCE_JNDI_PROPERTIES = "pm.jndi.datasource_name";

    /** property name for metadata schema name**/
  //  private static final String METADATA_SCHEMA_NAME_PROPERTIES = "pm.bootstrapdb.metadataschema";

    /** spring bean name for datasource **/
  //  private static final String DATASOURCE_BEAN_NAME = "dataSource";

    /** class instance field**/
    private static Utils thisInstance = null;

    /** service locator field**/
    private static ServiceLocator serviceLocator = null;

    /** field to store application properties **/
    private static Properties appProperties = null;

    /** log **/
    protected final Log log = LogFactory.getLog(getClass());

    /** field to store app datasource**/
    private DataSource dataSource = null;

    /** single instance of spring bean factory**/
    private BeanFactory beanFactory = null;

    /**
     * Private constructor to make the class singleton
     */
    private Utils() {
    }

    /**
     * Return this class instance
     * @return OntologyUtil
     */
    public static Utils getInstance() {
        if (thisInstance == null) {
            thisInstance = new Utils();
        }

        serviceLocator = ServiceLocator.getInstance();

        return thisInstance;
    }

    /**
     * Return the map spring config
     * @return
     */
    public BeanFactory getSpringBeanFactory() {
        if (beanFactory == null) {
            String appDir = null;

            try {
                //read application directory property file via classpath
                Properties loadProperties = ServiceLocator.getProperties(APPLICATION_DIRECTORY_PROPERTIES_FILENAME);
                //read directory property
                appDir = loadProperties.getProperty(APPLICATIONDIR_PROPERTIES);
            } catch (I2B2Exception e) {
                log.error(APPLICATION_DIRECTORY_PROPERTIES_FILENAME +
                    "could not be located from classpath ");
            }

            if (appDir != null) {
                FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext(
                        "file:" + appDir + "/" +
                        "PMApplicationContext.xml");
                beanFactory = ctx.getBeanFactory();
            } else {
                FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext(
                        "classpath:" + "PMApplicationContext.xml");
                beanFactory = ctx.getBeanFactory();
            }
        }

        return beanFactory;
    }

    /**
     * Return metadata schema name
     * @return
     * @throws I2B2Exception
    
    public String getMetaDataSchemaName() throws I2B2Exception {
        return getPropertyValue(METADATA_SCHEMA_NAME_PROPERTIES).trim()+ ".";
    }
 */
    
    /**
     * Return app server datasource
     * @return datasource
     * @throws I2B2Exception
     */
    public DataSource getDataSource(String dataSourceName) throws I2B2Exception {    	
    	dataSource = (DataSource) serviceLocator
		.getAppServerDataSource(dataSourceName);
    	return dataSource;
  
    }
    

	public void convertToUppercaseStrings( List< String > list )
	{
		ListIterator< String > iterator = list.listIterator();

		while ( iterator.hasNext() ) 
		{
			String color = iterator.next();  // get item                 
			iterator.set( color.toUpperCase() ); // convert to upper case
		} // end while
	}
	public  String toHex(byte[] digest) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < digest.length; i++) {
			buf.append(Integer.toHexString((int) digest[i] & 0x00FF));
		}
		return buf.toString();
	}

	public String generateMessageId() {
		StringWriter strWriter = new StringWriter();
		for(int i=0; i<20; i++) {
			int num = getValidAcsiiValue();
			//System.out.println("Generated number: " + num + " char: "+(char)num);
			strWriter.append((char)num);
		}
		return strWriter.toString();
	}
	
	private int getValidAcsiiValue() {
		int number = 48;
		while(true) {
			number = 48+(int) Math.round(Math.random() * 74);
			if((number > 47 && number < 58) || (number > 64 && number < 91) 
				|| (number > 96 && number < 123)) {
					break;
				}
		}
		return number;
		
	}

	
	public String getHashedPassword(String pass) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(pass.getBytes());
			return toHex(md5.digest());
		} catch (NoSuchAlgorithmException e) {
			log.error("NoSuchAlgorithm MD5!", e);    
		}
		return null;
	}
    
    //---------------------
    // private methods here
    //---------------------

    /**
     * Load application property file into memory
     */
    private String getPropertyValue(String propertyName)
        throws I2B2Exception {
        if (appProperties == null) {
            //read application directory property file
            Properties loadProperties = ServiceLocator.getProperties(APPLICATION_DIRECTORY_PROPERTIES_FILENAME);

            //read application directory property
            String appDir = loadProperties.getProperty(APPLICATIONDIR_PROPERTIES);

            if (appDir == null) {
                throw new I2B2Exception("Could not find " +
                    APPLICATIONDIR_PROPERTIES + "from " +
                    APPLICATION_DIRECTORY_PROPERTIES_FILENAME);
            }

            String appPropertyFile = appDir + "/" +
                APPLICATION_PROPERTIES_FILENAME;

            try {
                FileSystemResource fileSystemResource = new FileSystemResource(appPropertyFile);
                PropertiesFactoryBean pfb = new PropertiesFactoryBean();
                pfb.setLocation(fileSystemResource);
                pfb.afterPropertiesSet();
                appProperties = (Properties) pfb.getObject();
            } catch (IOException e) {
                throw new I2B2Exception("Application property file(" +
                    appPropertyFile +
                    ") missing entries or not loaded properly");
            }

            if (appProperties == null) {
                throw new I2B2Exception("Application property file(" +
                    appPropertyFile +
                    ") missing entries or not loaded properly");
            }
        }

        String propertyValue = appProperties.getProperty(propertyName);

        if ((propertyValue != null) && (propertyValue.trim().length() > 0)) {
            ;
        } else {
            throw new I2B2Exception("Application property file(" +
                APPLICATION_PROPERTIES_FILENAME + ") missing " + propertyName +
                " entry");
        }

        return propertyValue;
    }
    
  
	public static String[] combineArrays(String[] first, String[] second)
	{
		if(first == null){ return second;}
		if(second == null){ return first;}
		String[] outVals = new String[first.length + second.length];
		for(int i = 0; i < first.length; i ++)
		{
			outVals[i]=first[i];
		}
		
		for(int j = 0; j< second.length; j++)
		{
			outVals[first.length + j]= second[j];
		}
		
		return outVals;
	}
	
	public String getDataSourceUrl() throws I2B2Exception {
		return getPropertyValue(DATA_SOURCE_URL);
	}
	public String getDataSourceUser() throws I2B2Exception {
		return getPropertyValue(DATA_SOURCE_USER);
	}
	public String getDataSourcePassword() throws I2B2Exception {
		return getPropertyValue(DATA_SOURCE_PASSWORD);
	}
	public String getDataSourceDriver() throws I2B2Exception {
		return getPropertyValue(DATA_SOURCE_DRIVER);
	}
}
