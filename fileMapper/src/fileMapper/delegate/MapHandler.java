package fileMapper.delegate;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;

import oracle.jdbc.OracleTypes;
import edu.harvard.i2b2.common.exception.I2B2Exception;
import edu.harvard.i2b2.common.util.jaxb.JAXBUtil;
import fileMapper.dao.FileMapperDAO;
import fileMapper.dao.iProcessProcedure;
import fileMapper.data.datavo.i2b2message.BodyType;
import fileMapper.data.datavo.i2b2message.RequestMessageType;
import fileMapper.data.datavo.vdo.DataType;
import fileMapper.data.datavo.vdo.DataTypeField;
import fileMapper.data.datavo.vdo.GetDataTypes;
import fileMapper.util.FileMapperJAXBUtil;

public class MapHandler extends Handler implements iProcessProcedure{

	static public String GET_FIELDS="GET_DATA_TYPE_FIELDS";
	static public String TARGET_TABLE="TARGET_TABLE";
	static public String TABLE_CD="TARGET_TABLE";
	static public String FIELD_NAME="FIELD_NAME";
	static public String IS_KEY="IS_KEY";
	static public String DESCR="DESCR";
	static public String FIELD_TYPE="FIELD_TYPE";
	static public String IS_SYS_SET="IS_SYS_SET";
	protected LinkedList<DataType> Types;
	protected String TargetTable;
	protected GetDataTypes ResultTypes;
	private Boolean LoadElements;
	public MapHandler()
	{
		Types = new LinkedList<DataType>();
		LoadElements = false;
	}
	@Override
	public String handleRequest(String message) throws I2B2Exception {
			setTypes(message);
			BodyType body = execute();
			String results = null;
			try{
				results = buildResponseMessage(message, body);
			}catch(Exception e)
			{
				log.error(e.toString());
				throw new I2B2Exception(e.toString());
			}
			return results;
	}


	
	public BodyType execute() throws I2B2Exception {
		for(DataType type: Types)
		{
			getFields(type);
		}
		return fillBody(ResultTypes);
		
	}
	private void getFields(DataType type) throws I2B2Exception
	{
		int[] outArgs = { OracleTypes.CURSOR };
		String[]inArgs = {type.getTableCD()};
		FileMapperDAO.RunProcedure(GET_FIELDS, inArgs, outArgs, this);
		
	}



	@Override
	public void ProcessResults(ResultSet RS) throws I2B2Exception {
		if (RS != null) {
			try {
				if(ResultTypes==null){ResultTypes = new GetDataTypes();}
				DataType current = new DataType();
					while (RS.next()) {
					if(current.getTableCD() != RS.getString(TABLE_CD))
					{
						if(current.getTableCD() != null)
						{
						current = new DataType();
						}
						current.setTableCD(RS.getString(TABLE_CD));
						ResultTypes.getTypes().add(current);

					}
						DataTypeField field = new DataTypeField();
						field.setFieldCD(RS.getString(FIELD_NAME));
						field.setDataType(RS.getString(FIELD_TYPE));
						if(RS.getString(IS_KEY)=="Y")
						{
							field.setIsKey(true);
						}
						else{
							field.setIsKey(false);
						}
						if(RS.getString(IS_SYS_SET)=="Y"){
							field.setIsSystemSet(true);
						}else {field.setIsSystemSet(false);}
					field.setDESCR(RS.getString(DESCR));
					current.getFieldSet().add(field);	
				
					
					}
				
			} catch (Exception e) {
				throw new I2B2Exception(e.getMessage());
			}
		}
		
	}



	@Override
	public void ProcessResults(CallableStatement callStmt, int[] outArgs)
			throws I2B2Exception {
		// TODO Auto-generated method stub
		
	}
	
	private BodyType fillBody(List<DataType> types)
	{
		
		GetDataTypes getTypes = new GetDataTypes();
		for(DataType type : types)
		{
			getTypes.getTypes().add(type);
		}
		
		
		
		return fillBody(getTypes);
	}
	private void setTypes(String requestXml)
	{
		
		String response = null;
		JAXBUtil jaxbUtil = FileMapperJAXBUtil.getJAXBUtil();

		try {
			JAXBElement jaxbElement = jaxbUtil.unMashallFromString(requestXml);
			RequestMessageType requestMessageType = (RequestMessageType) jaxbElement
					.getValue();
			BodyType bodyType = requestMessageType.getMessageBody();

			if (bodyType == null) {
				log.error("null value in body type");
				throw new I2B2Exception("null value in body type");
			}
			Unmarshaller unmarshaller = FileMapperJAXBUtil
					.getUnmarshaller(GetDataTypes.class);
			for(int index = 0; index < bodyType.getAny().size(); index ++)
			{
				Object temp = bodyType.getAny().get(index);
				if(temp.getClass() == JAXBElement.class)
				{
					try{
					GetDataTypes types = (GetDataTypes)((JAXBElement)temp).getValue();
					for(DataType dt : types.getTypes())
					{
						Types.add(dt);
					}
					}catch(Exception e)
					{
						log.equals(e);
					}
					
				}
				
			}
			
		

			
			
					
	}catch(Exception e)
		{
		  log.equals(e);
		}
	}
	public Boolean getLoadElements() {
		return LoadElements;
	}
	public void setLoadElements(Boolean loadElements) {
		LoadElements = loadElements;
	}


}