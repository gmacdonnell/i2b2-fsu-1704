package  idiginfo.i2b2.stats.bayes;

public class Prior {
	protected String term;
	protected String query;
	protected int fraction;
	protected int total;
	
	public Prior(String Term)
	{
		//this.term= Term;
		generateQuery();
		
	}

	private void generateQuery(){
		query="";
	}
	public boolean runQuery()
	{
		boolean success = false;
		
		return success;
	}
}
