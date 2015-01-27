package idiginfo.i2b2.data_simulator.Human;

public enum Races {
	White (.16), 
	Black (.16), 
	Hispanic (.16), 
	Asian (.16), 
	Native_American (.16), 
	Other (.2);
	private final double prob;
	public double prob(){return prob;}
	
	Races(double prob){ this.prob = prob;}
}
