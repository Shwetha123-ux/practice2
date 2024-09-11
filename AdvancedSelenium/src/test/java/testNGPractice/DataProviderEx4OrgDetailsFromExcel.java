package testNGPractice;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utilities.Excel_Utility;

public class DataProviderEx4OrgDetailsFromExcel 
{
	@Test(dataProvider = "readExcelData")
	public void organizationModuleTest(String orgName,String phnNum,String mailId) throws Throwable
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		Random ranNum = new Random();
		int ranNums = ranNum.nextInt(1000);
		driver.findElement(By.name("accountname")).sendKeys(orgName+ranNums);
		driver.findElement(By.id("phone")).sendKeys(phnNum);
		driver.findElement(By.id("email1")).sendKeys(mailId);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		}


	@DataProvider
	public Object[][] readExcelData() throws Throwable 
	{

		Excel_Utility elib = new Excel_Utility();
		Object[][] values = elib.getDataProviderData("DataProvider");

		return values;

	}
}
