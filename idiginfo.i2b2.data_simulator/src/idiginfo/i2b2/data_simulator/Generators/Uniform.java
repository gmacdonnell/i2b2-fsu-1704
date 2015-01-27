package idiginfo.i2b2.data_simulator.Generators;

import java.util.Random;

public class Uniform implements iDistribution {

	protected double Min,Max;
	protected Random Rand;
	public Uniform(double Min, double Max) {
		super();
		this.Min = Min;
		this.Max = Max;
		Rand = new Random(System.currentTimeMillis());
	}
	public Uniform()
	{
		Min=Max=0;
		Rand = new Random(System.currentTimeMillis());
	}
	public double getNext() {
	
		return Rand.nextFloat()* Max + Min;
	}

}
