package idiginfo.i2b2.simulator.Medical;


import idiginfo.i2b2.data_simulator.Human.Human;

import java.util.Calendar;
import java.util.LinkedList;

import edu.harvard.i2b2.common.exception.I2B2Exception;


public class History {
	protected LinkedList<History_Item> Items;
	protected static long count=0;
	protected int Current =0;;
	protected Human Owner;
	
	/**
	 * @return the items
	 */
	public LinkedList<History_Item> getItems() {
		return Items;
	}
	/**
	 * @param items the items to set
	 */
	public void setItems(LinkedList<History_Item> items) {
		Items = items;
	}

	protected static long getCount() {
		return count;
	}
	
	
	public History(Human owner)
	{
		setOwner(owner);
		
		init();
	}
	
	protected void init()
	{
		Items = new LinkedList<History_Item>();
		Current = 0;
		
	}
	public int size()
	{
		if(getItems() == null)
		{
			return 0;
		}
		return getItems().size();
	}
	public History_Item getItem(int index)
	{
		if(Items.size() > index)
		{
			return Items.get(index);
		}
		return null;
	}
	public String toString()
	{
		String OutVal=" History[ ";
		if(Items.isEmpty())
		{
			OutVal += "Is empty";
		}else
		{
			for(int index = 0; index < Items.size(); index++)
			{
				if(index > 0){
					OutVal+=", ";
				}
				OutVal +=  Items.get(index).toString();
			}
		}
		OutVal+=" ]";
		
		return OutVal;
	}
	
	public void add(History_Item newItem)
	{
	/*	if(newItem.getType() == Physical.TYPE)
		{
			addPhysical((Physical)newItem);
		}
		*/
		Items.add(newItem);
	}
	
/*	public void addPhysical(Physical newPhys)
	{
		for(int index =0; index < newPhys.getConceptCount(); index ++)
		{
			add(newPhys.getConcept(index));
		}
		add(newPhys);
	}
	*/
	public int getLength()
	{
		int length = 0;
		for(int index = 0; index < Items.size(); index++)
		{
			History_Item temp = Items.get(index);
			if(temp != null)
			{
				length+=temp.getConceptCount();
			}
		}
		return length;
	}
	
	
	public Concept getConcept(int index)
	{
		int target = index;
		for(int item = 0; item < Items.size(); item++)
		{
			
			History_Item temp = Items.get(item);
			
			if(temp != null)
			{
				
				if(target < temp.getConceptCount())
				{
				
						return temp.getConcept(target);
					
				}
				else
				{
					target-=temp.getConceptCount();
				}
			}
			if(target < 0 )
			{
				System.out.println("Error");
			}
			
		
			
		}
		return null;
	}
	
	public Concept getNext()
	{
		try{
		Concept temp = getConcept(Current);
		if(temp == null){
			resetNext();
		}
		Current++;
		return temp;
		}catch(Exception e)
		{
			System.out.print(e.getMessage());
		}
		return null;
	}

	public void resetNext()
	{
		Current = 0;
	}
	public void recordHistory(String procedure, String targetTable) throws I2B2Exception
	{
		Concept Temp = getNext();
		while(Temp != null)
		{
			Temp.InsertRecord(procedure, targetTable);
			Temp = getNext();
		}
	}
	public void setOwner(Human owner)
	{
		Owner = owner;
	}
	public Human getOwner()
	{
		return Owner;
	}

}
