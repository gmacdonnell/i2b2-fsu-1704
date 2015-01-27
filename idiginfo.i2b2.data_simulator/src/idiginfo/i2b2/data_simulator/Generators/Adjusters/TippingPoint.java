package idiginfo.i2b2.data_simulator.Generators.Adjusters;

public abstract class TippingPoint  extends Adjuster{
	protected double Point;
	protected double Value;
	
	
	public TippingPoint(double value, double point ){
		super();
		Point = point;
		Value = value;
	}
	double HighToLow(double Age, double Point)
	{
		return (Point-Age)/Point;
	}
	double LowToHigh (double Age, double Point)
	{
		return (Age- Point)/ Point;
	}
	/**
	 * @return the point
	 */
	public double getPoint() {
		return Point;
	}
	/**
	 * @param point the point to set
	 */
	public void setPoint(double point) {
		Point = point;
	}
	/**
	 * @return the value
	 */
	public double getInValue() {
		return Value;
	}
	/**
	 * @param value the value to set
	 */
	public void setInValue(double value) {
		Value = value;
	}
	
	

}
