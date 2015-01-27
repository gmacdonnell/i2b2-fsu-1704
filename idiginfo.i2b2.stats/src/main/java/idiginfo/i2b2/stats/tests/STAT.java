package  idiginfo.i2b2.stats.tests;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.stat.inference.TTest;

public class STAT extends org.apache.commons.math3.stat.inference.TTest {

public double tTest(double m1,double m2,double v1,double v2, double n1, double n2) throws MaxCountExceededException,
MathIllegalArgumentException
	{
		
		return super.tTest(m1, m2,v1,v2,n1,n2);
	}

}
