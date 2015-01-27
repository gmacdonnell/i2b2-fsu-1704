package idiginfo.i2b2.data_simulator.Generators;

public class Util {
	
	
	public static String[] combineArrays(String[] first, String[] second)
	{
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

}
