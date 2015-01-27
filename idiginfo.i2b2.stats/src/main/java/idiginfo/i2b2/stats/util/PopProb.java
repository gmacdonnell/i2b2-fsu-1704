package idiginfo.i2b2.stats.util;

public class PopProb {
	protected String Pop;
	
	protected double Prob;
	
	
	public PopProb(String pop, double prob) {
		super();
		Pop = pop;
		Prob = prob;
	}
	public String getPop() {
		return Pop;
	}
	public void setPop(String pop) {
		Pop = pop;
	}
	public double getProb() {
		return Prob;
	}
	public void setProb(double prob) {
		Prob = prob;
	}

}
