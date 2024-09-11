package organizations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import objectRepository.CreateOrganizationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganisationPage;

// Login to vtiger application->click on organizations link->click on create organization lookup image->Enter organisation name,phone number and 
//email->click on save Btn->verify whether the organization is created in Organization Information page and Logout from the application.

public class CreateOrganisation {

	public static void main(String[] args) throws Throwable {
		
		File_Utility flib = new File_Utility();
		Excel_Utility elib = new Excel_Utility();
		Java_Utility jlib = new Java_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();
		
		WebDriver driver;
		
		String BROWSER = flib.gettKeyAndValueData("browser");
		
		if(BROWSER.equalsIgnoreCase("cHRome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			driver = new ChromeDriver();
		}
		
		String URL = flib.gettKeyAndValueData("url");
		String USERNAME = flib.gettKeyAndValueData("username");
		String PASSWORD = flib.gettKeyAndValueData("password");

		driver.get(URL);
		wlib.maximizeWindow(driver);
		wlib.waitPageToLoad(driver);

		// using getter methods
//		LoginPage login = new LoginPage(driver);
//		login.getUserTextField().sendKeys(USERNAME);
//		login.getPasswordTextField().sendKeys(PASSWORD);
//		login.getLoginButton().click();

		// using Business Logic
		LoginPage login = new LoginPage(driver);
		login.loginToApp(USERNAME, PASSWORD);

//		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(USERNAME);
//		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();

		HomePage home = new HomePage(driver);
		home.getOrgLink().click();
		//driver.findElement(By.linkText("Organizations")).click();
		
		OrganisationPage orgImg = new OrganisationPage(driver);
		orgImg.clickOrgPlusImg();
		//driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();

		int ranNum = jlib.getRandomNum();

		String orgName = elib.getExcelDataUsingDataFormatter("Organizations", 0, 0) + ranNum;
		String phnNum = elib.getExcelDataUsingDataFormatter("Organizations", 1, 0);
		String email = elib.getExcelDataUsingDataFormatter("Organizations", 2, 0);

		CreateOrganizationPage orgPage = new CreateOrganizationPage(driver);
		orgPage.enterOrganisationData(orgName, phnNum, email);
		
//		driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(orgName);
//		driver.findElement(By.id("phone")).sendKeys(phnNum);
//		driver.findElement(By.id("email1")).sendKeys(email);

		System.out.println(orgName);
		System.out.println(phnNum);
		System.out.println(email);

		orgPage.clickOnSaveButton();
		//driver.findElement(By.xpath("//input[@value=\"  Save  \"]")).click();
		Thread.sleep(2000);
		
//		home.getAdminLink().click();
//		Thread.sleep(2000);
//		home.getSignOut().click();
		
		home.signOutApp(driver);
//		WebElement logoutimage = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
//
//		wlib.mouseHoveronElement(driver, logoutimage);
//
//		Thread.sleep(2000);
//		driver.findElement(By.linkText("Sign Out")).click();

	}

}
