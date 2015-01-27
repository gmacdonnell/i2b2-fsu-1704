package idiginfo.i2b2.data_simulator.Generators;

public class GeneratorType2 extends Generator {
	

	public GeneratorType2() {
		super();
		GENERATOR_ID = 200000;
		count =GENERATOR_ID;
		GenPhys = new GeneratePhysicalType2();
	}

}
