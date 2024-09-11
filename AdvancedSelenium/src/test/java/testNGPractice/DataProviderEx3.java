package testNGPractice;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx3 
{
	
	@Test(dataProvider= "readData")
	public void organisationModuleTest(String orgName,String phoneNo, String mailID) throws Throwable
	{
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(orgName);
		driver.findElement(By.id("phone")).sendKeys(phoneNo);
		driver.findElement(By.id("email1")).sendKeys(mailID);
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();		
	}
		
	
	@DataProvider
	public Object[][] readData()
	{
		Object[][] objArr = new Object[2][3];
		
		Random ranNum = new Random();
		int ranNums = ranNum.nextInt(1000);
		
		
		  objArr[0][0]="AAA"+ranNums; 
		  objArr[0][1]="1234";
		  objArr[0][2]="abc@gmail.com";
		 
		
		objArr[1][0]="BBB"+ranNums;
		objArr[1][1]="1234";
		objArr[1][2]="abc@gmail.com";
		
		return objArr;
		
	}
}

// NOTE: Try the same program by fetching details from Excel for the orgName, Phone & EMail for creating 'n' no of orgs
