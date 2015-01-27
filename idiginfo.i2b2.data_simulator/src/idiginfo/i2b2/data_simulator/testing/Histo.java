package idiginfo.i2b2.data_simulator.testing;

import java.lang.Math;

public class Histo {

	protected int min, max, size, above, below;
	protected int[] counts;
	protected int Scale =1;
	protected double StepSize ;

	public Histo(int lowEnd, int Size) {
		min = lowEnd;
		counts = new int[Size];
		size = Size;
		max = size + min - 1;
		above = below = 0;
		StepSize = 1.0;

	}
	public Histo(int lowEnd, int Size, double stepSize) {
		min = lowEnd;
		counts = new int[Size];
		size = Size;
		max = size + min - 1;
		above = below = 0;
		StepSize = stepSize;

	}

	public void add(double Value) {
		int index = (int) Math.floor(Value * (1/StepSize));
		index -= min;
		if (index >= 0) {
			if (index < size) {
				counts[index]++;
				if(counts[index]>Scale)
				{
					Scale = counts[index];
				}
			} else {
				above++;
			}
		} else {
			below++;
		}

	}
	public void display(){
		Scale();
		Print("Below: "+ MakeBar(below));
		for(int index = 0 ; index < size; index ++)
		{
			String Current = (double)(((double)index*StepSize) + (double)min ) + " : ";
			Current+=MakeBar(counts[index]);
			Print(Current);
		}
		Print("Above: "+ MakeBar(above));
	}
	public void Scale()
	{
		 int Deca=0;
		 if(Scale > 100)
		 {
			 while(Scale > 10)
			 {
				 Deca++;
				 Scale = Scale/10;
			 }
		 }
		 Scale = Deca;
	}
	public String MakeBar(int length)
	{
		if(Scale>0){
			length = length/(Scale*10);
		}
		String Bar = "";
		for(int index =0 ; index < length; index++)
		{
			Bar+="*";
		}
		return Bar;
	}
	public void Print(String text)
	{
		System.out.println(text);
	}

}
