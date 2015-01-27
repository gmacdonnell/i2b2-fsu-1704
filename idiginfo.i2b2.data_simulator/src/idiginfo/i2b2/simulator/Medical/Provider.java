package idiginfo.i2b2.simulator.Medical;

import java.util.HashMap;
import java.util.Map;

public enum Provider {
	SMITH( 1, 2 ) , 
	JOHNSON ( 2, 4 ) , 
	WILLIAMS ( 3, 3 ) , 
	JONES ( 4, 9 ) , 
	BROWN ( 5, 7 ) , 
	DAVIS ( 6, 4 ) , 
	MILLER ( 7, 8 ) , 
	WILSON ( 8, 1 ) , 
	MOORE ( 9, 7 ) , 
	TAYLOR ( 10, 3 ) , 
	ANDERSON ( 11, 9 ) , 
	THOMAS ( 12, 5 ) , 
	JACKSON ( 13, 9 ) , 
	WHITE ( 14, 10 ) , 
	HARRIS ( 15, 3 ) , 
	MARTIN ( 16, 4 ) , 
	THOMPSON ( 17, 1 ) , 
	GARCIA ( 18, 7 ) , 
	MARTINEZ ( 19, 9 ) , 
	ROBINSON ( 20, 9 ) , 
	CLARK ( 21, 3 ) , 
	RODRIGUEZ ( 22, 3 ) , 
	LEWIS ( 23, 3 ) , 
	LEE ( 24, 7 ) , 
	WALKER ( 25, 0 ) , 
	HALL ( 26, 9 ) , 
	ALLEN ( 27, 2 ) , 
	YOUNG ( 28, 3 ) , 
	HERNANDEZ ( 29, 8 ) , 
	KING ( 30, 1 ) , 
	WRIGHT ( 31, 5 ) , 
	LOPEZ ( 32, 2 ) , 
	HILL ( 33, 8 ) , 
	SCOTT ( 34, 2 ) , 
	GREEN ( 35, 3 ) , 
	ADAMS ( 36, 8 ) , 
	BAKER ( 37, 5 ) , 
	GONZALEZ ( 38, 1 ) , 
	NELSON ( 39, 2 ) , 
	CARTER ( 40, 0 ) , 
	MITCHELL ( 41, 3 ) , 
	PEREZ ( 42, 1 ) , 
	ROBERTS ( 43, 5 ) , 
	TURNER ( 44, 8 ) , 
	PHILLIPS ( 45, 6 ) , 
	CAMPBELL ( 46, 7 ) , 
	PARKER ( 47, 3 ) , 
	EVANS ( 48, 10 ) , 
	EDWARDS ( 49, 9 ) , 
	COLLINS ( 50, 5 ) , 
	STEWART ( 51, 4 ) , 
	SANCHEZ ( 52, 0 ) , 
	MORRIS ( 53, 1 ) , 
	ROGERS ( 54, 0 ) , 
	REED ( 55, 4 ) , 
	COOK ( 56, 3 ) , 
	MORGAN ( 57, 8 ) , 
	BELL ( 58, 2 ) , 
	MURPHY ( 59, 7 ) , 
	BAILEY ( 60, 10 ) , 
	RIVERA ( 61, 10 ) , 
	COOPER ( 62, 0 ) , 
	RICHARDSON ( 63, 8 ) , 
	COX ( 64, 1 ) , 
	HOWARD ( 65, 4 ) , 
	WARD ( 66, 0 ) , 
	TORRES ( 67, 4 ) , 
	PETERSON ( 68, 9 ) , 
	GRAY ( 69, 5 ) , 
	RAMIREZ ( 70, 5 ) , 
	JAMES ( 71, 9 ) , 
	WATSON ( 72, 7 ) , 
	BROOKS ( 73, 3 ) , 
	KELLY ( 74, 9 ) , 
	SANDERS ( 75, 0 ) , 
	PRICE ( 76, 2 ) , 
	BENNETT ( 77, 3 ) , 
	WOOD ( 78, 0 ) , 
	BARNES ( 79, 8 ) , 
	ROSS ( 80, 4 ) , 
	HENDERSON ( 81, 1 ) , 
	COLEMAN ( 82, 10 ) , 
	JENKINS ( 83, 0 ) , 
	PERRY ( 84, 2 ) , 
	POWELL ( 85, 0 ) , 
	LONG ( 86, 10 ) , 
	PATTERSON ( 87, 2 ) , 
	HUGHES ( 88, 6 ) , 
	FLORES ( 89, 7 ) , 
	WASHINGTON ( 90, 10 ) , 
	BUTLER ( 91, 1 ) , 
	SIMMONS ( 92, 9 ) , 
	FOSTER ( 93, 0 ) , 
	GONZALES ( 94, 8 ) , 
	BRYANT ( 95, 7 ) , 
	ALEXANDER ( 96, 3 ) , 
	RUSSELL ( 97, 10 ) , 
	GRIFFIN ( 98, 0 ) , 
	DIAZ ( 99, 6 ) , 
	HAYES ( 100, 3 ) , 
	MYERS ( 101, 3 ) , 
	FORD ( 102, 5 ) , 
	HAMILTON ( 103, 4 ) , 
	GRAHAM ( 104, 0 ) , 
	SULLIVAN ( 105, 2 ) , 
	WALLACE ( 106, 1 ) , 
	WOODS ( 107, 0 ) , 
	COLE ( 108, 6 ) , 
	WEST ( 109, 4 ) , 
	JORDAN ( 110, 6 ) , 
	OWENS ( 111, 5 ) , 
	REYNOLDS ( 112, 5 ) , 
	FISHER ( 113, 2 ) , 
	ELLIS ( 114, 4 ) , 
	HARRISON ( 115, 8 ) , 
	GIBSON ( 116, 2 ) , 
	MCDONALD ( 117, 6 ) , 
	CRUZ ( 118, 3 ) , 
	MARSHALL ( 119, 0 ) , 
	ORTIZ ( 120, 10 ) , 
	GOMEZ ( 121, 9 ) , 
	MURRAY ( 122, 8 ) , 
	FREEMAN ( 123, 6 ) , 
	WELLS ( 124, 7 ) , 
	WEBB ( 125, 3 ) , 
	SIMPSON ( 126, 7 ) , 
	STEVENS ( 127, 2 ) , 
	TUCKER ( 128, 8 ) , 
	PORTER ( 129, 2 ) , 
	HUNTER ( 130, 0 ) , 
	HICKS ( 131, 0 ) , 
	CRAWFORD ( 132, 5 ) , 
	HENRY ( 133, 9 ) , 
	BOYD ( 134, 4 ) , 
	MASON ( 135, 2 ) , 
	MORALES ( 136, 2 ) ;


	int IDCode;
	int Location;
	private static Map<Integer,  Provider> IDtoProviderMapping;
	private static void initMap()
	{
		IDtoProviderMapping = new HashMap<Integer, Provider>();
		for(Provider p : values() )
		{
			IDtoProviderMapping.put(p.getID(),p);
			
		}
	}
	public static Provider getProvider(int ID)
	{
		if(IDtoProviderMapping == null)
		{
			initMap();
		}
		return IDtoProviderMapping.get(ID);
	}
	private Provider(int ID, int Loc)
	{
		IDCode = ID;
		Location = Loc;
	}
	public int getID(){
		return IDCode;
	}
	int getLocation()
	{
		return Location;
	}
}
