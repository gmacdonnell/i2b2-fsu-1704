package fileMapper.delegate;



import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import oracle.jdbc.OracleTypes;
import edu.harvard.i2b2.common.exception.I2B2Exception;
import fileMapper.dao.FileMapperDAO;
import fileMapper.dao.iProcessProcedure;
import filemapper.data.datavo.i2b2message.BodyType;
import filemapper.data.datavo.vdo.DataType;

public class DataTypeHandler extends Handler implements iProcessProcedure {

	static public String GET_DATATYPES="GET_DATA_TYPES";
	static public String GET_FIELDS="GET_DATA_TYPE_FIELDS";
	static public String TARGET_TABLE="TARGET_TABLE";
	static public String TYPE_NAME="TYPE_NAME";
	static public String IS_DIM="IS_DIM_TABLE";
	protected LinkedList<DataType> Types;
	
	public DataTypeHandler()
	{
		Types = new LinkedList<DataType>();
	}
	@Override
	public void ProcessResults(ResultSet RS) throws I2B2Exception {
		if (RS != null) {
			try {
					while (RS.next()) {
					DataType current = new DataType();
					current.setName(RS.getString(TYPE_NAME));
					current.setTableCD(RS.getString(TARGET_TABLE));
					if(RS.getString(IS_DIM)=="Y")
					{
						current.setIsDimension(true);
					}else{
					current.setIsDimension(false);
					}
					Types.add(current);
					
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

	@Override
	public BodyType execute() throws I2B2Exception {
		int[] outArgs = { OracleTypes.CURSOR };
		FileMapperDAO.RunProcedure(GET_DATATYPES, null, outArgs, this);
		return fillBody(Types);
		
	}

	@Override
	public String handleRequest(String message) throws I2B2Exception {
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
	protected BodyType fillBody(List<DataType> types)
	{
		BodyType body = new BodyType();
		Iterator<DataType> i = types.iterator();
		filemapper.data.datavo.vdo.ObjectFactory of = new filemapper.data.datavo.vdo.ObjectFactory();
		while(i.hasNext()){
			DataType current = i.next();
			body.getAny().add(of.createGetDataType(current));
		}
		
		return body;
	}

}
