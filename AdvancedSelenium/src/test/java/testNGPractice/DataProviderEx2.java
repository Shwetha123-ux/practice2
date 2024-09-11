package testNGPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx2 
{
	@Test(dataProvider="dataProvider_BookTickets")
	public void bookTickets(String src, String dest, String noOfppl)
	{
		System.out.println("Booked Tickets from " +src +"\t" + "to" +"\t" +dest+ "\t" + "for" + "\t" + noOfppl + "\t" +" People" );
	}
	
	
	
	@DataProvider
	public Object[][] dataProvider_BookTickets()
	{
		Object[][] objArr = new Object[2][3];
		
		objArr[0][0]="Bangalore";
		objArr[0][1]="Goa";
		objArr[0][2]="4";
		
		objArr[1][0]="Bangalore";
		objArr[1][1]="Mysore";
		objArr[1][2]="8";
		
		return objArr;
		
	}
	
	
	
}
