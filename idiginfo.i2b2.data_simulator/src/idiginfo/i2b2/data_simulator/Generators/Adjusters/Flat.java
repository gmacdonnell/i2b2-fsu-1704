package idiginfo.i2b2.data_simulator.Generators.Adjusters;

public class Flat extends Adjuster {

	protected double value;
	
	public Flat()
	{
		value = 1;
	}
	public Flat(double value)
	{
		this.setValue( value);
	}
	@Override
	public double getValue() {
		// TODO Auto-generated method stub
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}

}
