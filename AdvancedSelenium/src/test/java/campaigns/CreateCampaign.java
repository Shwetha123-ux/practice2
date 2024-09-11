package campaigns;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
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
import objectRepository.CreateCampaignsPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.ValidationAndVerification;

//Login to vtiger application->mouseOverOn more Link->click on campaigns->click on create campaign lookup image->
//Enter campaignName-> click on save Btn->verify whether the campaign is created in campaign Information page and Logout from the application.

public class CreateCampaign {

	public static void main(String[] args) throws Throwable {
		//WebDriver driver = new ChromeDriver();
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

//		FileInputStream fis = new FileInputStream("./src/test/resources/Vtigerlogins.properties");
//		Properties pro = new Properties();
//		pro.load(fis);
//
//		String URL = pro.getProperty("url");
//		String USERNAME = pro.getProperty("username");
//		String PASSWORD = pro.getProperty("password");

		driver.get(URL);
		wlib.maximizeWindow(driver);
		wlib.waitForElementInDOM(driver);
		//driver.manage().window().maximize();
		
		LoginPage login = new LoginPage(driver);
		login.loginToApp(USERNAME, PASSWORD);
		
//		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(USERNAME);
//		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();

		HomePage home = new HomePage(driver);
		home.clickMoreLink();
		home.clickCampaignsLink();
		//WebElement moreLink = driver.findElement(By.linkText("More"));
		
		//wlib.mouseHoveronElement(driver, moreLink);
//		Actions act = new Actions(driver);
//		act.moveToElement(moreLink).click().perform();

		//driver.findElement(By.xpath("//a[@name=\"Campaigns\"]")).click();
		Thread.sleep(2000);
		CreateCampaignsPage campPage = new CreateCampaignsPage(driver);
		campPage.clickcampaignPlusSign();
		//driver.findElement(By.xpath("//img[@title=\"Create Campaign...\"]")).click();

		
		int ranNum = jlib.getRandomNum();

//		Random ran = new Random();
//		int ranNum = ran.nextInt(1000);

	
		String campName = elib.getExcelData("Campaigns", 0, 0) + ranNum;
		System.out.println(campName);
		

//		FileInputStream fis1 = new FileInputStream("E:\\AdvancedSelenium\\TestData8.xlsx");
//		Workbook book = WorkbookFactory.create(fis1);
//		Sheet sheet = book.getSheet("Campaigns");
//
//		// To get Campaign name
//		Row row = sheet.getRow(0);
//		Cell cell = row.getCell(0);
//		String campName = cell.getStringCellValue() + ranNum;

//      System.out.println(campName);
		
		Thread.sleep(2000);
		campPage.enterCampaignName(campName);
		//driver.findElement(By.xpath("//input[@name=\"campaignname\"]")).sendKeys(campName);
		campPage.clickSaveCampaignButton();
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		Thread.sleep(2000);

		
		 ValidationAndVerification campvalidate = new ValidationAndVerification(driver);
	        campvalidate.campData(driver, campName);
	        
	        home.logoutFromApp();
		//WebElement signoutImage = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

		//wlib.mouseHoveronElement(driver, signoutImage);
//		Actions act1 = new Actions(driver);
//		act1.moveToElement(signoutImage).click().perform();

		//driver.findElement(By.linkText("Sign Out")).click();

	}

}
