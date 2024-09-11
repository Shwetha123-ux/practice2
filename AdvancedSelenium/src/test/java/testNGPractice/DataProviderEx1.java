package testNGPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx1 
{
	//
	//
	
	//Booking Bus Tickets
	@Test(dataProvider="dataProvider_BookTickets")
	public void bookTickets(String src, String dest)
	{
		System.out.println("Booked Tickets from " +src+ " to "+dest);
	}
	
	
	@DataProvider
	public Object[][] dataProvider_BookTickets()
	{
		Object[][] objArr = new Object[3][2];   // [3] is set of data & [2] no of items in each set
		
		objArr[0][0]="Bangalore";
		objArr[0][1]="Goa";
		
		objArr[1][0]="Bangalore";
		objArr[1][1]="Chennai";
		
		objArr[2][0]="Bangalore";
		objArr[2][1]="Mysore";
		
		return objArr;
	}
}
