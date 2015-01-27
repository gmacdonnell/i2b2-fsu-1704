package idiginfo.i2b2.data_simulator.Generators;

import org.apache.commons.math3.distribution.GammaDistribution;

public class GammaDist implements iDistribution {
	
	protected double Shape;
	protected double Rate;
	protected GammaDistribution Gamma;
	
	public GammaDist(double Shape, double Rate)
	{
		this.Rate=Rate;
		this.Shape=Shape;
		Gamma = new GammaDistribution(Shape, Rate);
	}

	public double getNext() {
		return Gamma.sample();
	}

}
