package idiginfo.i2b2.data_simulator.Generators.Adjusters;

public class TipLowToHigh extends TippingPoint {
	public TipLowToHigh(double value, double TippingPoint)
	{
		super(value, TippingPoint);
	}

	public double getValue()
	{
		return super.LowToHigh(this.getValue(), this.getPoint());
	}
}
