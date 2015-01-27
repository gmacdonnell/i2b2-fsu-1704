package idiginfo.i2b2.data_simulator.Generators.Adjusters;

public class TipHighToLow extends TippingPoint{
	
	public TipHighToLow(double value, double point) {
		super(value, point);
		// TODO Auto-generated constructor stub
	}

	public double getValue()
	{
	 return   1.0 + super.HighToLow(this.getInValue(),this.getPoint());
	}

}
