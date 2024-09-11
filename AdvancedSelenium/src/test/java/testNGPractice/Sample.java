package testNGPractice;

import org.testng.annotations.Test;

public class Sample 
{
	@Test(priority=2, invocationCount = 3)
	public void createContact()
	{
		System.out.println("contact created");
	}
	@Test(dependsOnMethods = "createContact")
	public void modifyContact()
	{
		System.out.println("contact modified");
	}
	
	@Test(dependsOnMethods = {"createContact","modifyContact"})
	public void deleteContact()
	{
		System.out.println("contact deleted");
	}
}
