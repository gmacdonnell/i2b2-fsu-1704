package idiginfo.i2b2.data_simulator.Generators;
import java.util.Random;

public class NormalDist implements iDistribution{
	protected double Mean;
	protected double StDev;
	protected Random Rand;

	
	public double getNext()
	{
		return StDev * Rand.nextGaussian() + Mean;
	}
	public NormalDist(double mean, double stDev) {
	
		Mean = mean;
		StDev = stDev;
		Rand = new Random(System.currentTimeMillis());
	}
	public NormalDist(){
		StDev = .5;
		Mean = 1.0;
		Rand = new Random(System.currentTimeMillis());
		
	}
	/**
	 * @return the mean
	 */
	public double getMean() {
		return Mean;
	}
	/**
	 * @param mean the mean to set
	 */
	public void setMean(double mean) {
		Mean = mean;
	}
	/**
	 * @return the stDev
	 */
	public double getStDev() {
		return StDev;
	}
	/**
	 * @param stDev the stDev to set
	 */
	public void setStDev(double stDev) {
		StDev = stDev;
	}
}
