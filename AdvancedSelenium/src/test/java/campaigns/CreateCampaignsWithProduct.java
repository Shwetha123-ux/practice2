package campaigns;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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
import objectRepository.CreateProductPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.WindowSwitchingToProductPage;

public class CreateCampaignsWithProduct {

	public static void main(String[] args) throws Throwable {

		WebDriver driver;

		File_Utility flib = new File_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();

		String BROWSER = flib.gettKeyAndValueData("browser");

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
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
		// driver.manage().window().maximize();
		LoginPage login = new LoginPage(driver);
		login.loginToApp(USERNAME, PASSWORD);

//		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(USERNAME);
//		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();

		HomePage home = new HomePage(driver);
		home.clickProductsLink();

		// driver.findElement(By.linkText("Products")).click();

		CreateProductPage prdPage = new CreateProductPage(driver);
		prdPage.clickProductPlusSign();
		// driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();

		int ranNum = jlib.getRandomNum();
//		Random ran = new Random();
//		int ranNum = ran.nextInt(1000);

		String prodName = elib.getExcelData("Products", 0, 0) + ranNum;

//		FileInputStream fis1 = new FileInputStream("E:\\AdvancedSelenium\\TestData8.xlsx");
//		Workbook book = WorkbookFactory.create(fis1);
//		Sheet sheet = book.getSheet("Products");
//
//		// To get Product name
//		Row row = sheet.getRow(0);
//		Cell cell = row.getCell(0);
//		String prodName = cell.getStringCellValue() + ranNum;
		System.out.println(prodName);

		prdPage.enterProductName(prodName);
		// driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(prodName);
		prdPage.clickSaveProductButton();
		// driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		home.clickMoreLink();
		// WebElement moreLink = driver.findElement(By.linkText("More"));

		// wlib.mouseHoveronElement(driver, moreLink);
//		Actions act = new Actions(driver);
//		act.moveToElement(moreLink).click().perform();

		home.clickCampaignsLink();
		// driver.findElement(By.xpath("//a[@name=\"Campaigns\"]")).click();
		Thread.sleep(2000);
		CreateCampaignsPage campPage = new CreateCampaignsPage(driver);
		campPage.clickcampaignPlusSign();
		// driver.findElement(By.xpath("//img[@title=\"Create Campaign...\"]")).click();

		int ranNum1 = jlib.getRandomNum();

//		Random ran1 = new Random();
//		int ranNum1 = ran1.nextInt(1000);

		String campName = elib.getExcelData("Campaigns", 0, 0) + ranNum1;
//		FileInputStream fis11 = new FileInputStream("E:\\AdvancedSelenium\\TestData8.xlsx");
//		Workbook book1 = WorkbookFactory.create(fis11);
//		Sheet sheet1 = book1.getSheet("Campaigns");
//
//		// To get Campaign name
//		Row row1 = sheet1.getRow(0);
//		Cell cell1 = row1.getCell(0);
//		String campName = cell1.getStringCellValue() + ranNum1;
		System.out.println(campName);
		Thread.sleep(2000);

		campPage.enterCampaignName(campName);
		// driver.findElement(By.xpath("//input[@name=\"campaignname\"]")).sendKeys(campName);

		campPage.clickPlusSignToNavigateToProductPage();
		// driver.findElement(By.xpath("//img[@src=\"themes/softed/images/select.gif\"]")).click();

		wlib.switchingWindows(driver, "Products&action");

//		Set<String> allwin = driver.getWindowHandles(); //win1, win2
//		Iterator<String> it = allwin.iterator();
//		
//		while(it.hasNext())
//		{
//			String win = it.next();
//			driver.switchTo().window(win);
//			String currentTitle = driver.getTitle();
//			
//			if(currentTitle.contains("Products&action"))
//			{
//				break;
//			}
//		}
		WindowSwitchingToProductPage campPrdpage = new WindowSwitchingToProductPage(driver);
		campPrdpage.enterProductName(prodName);
		campPrdpage.serachProduct();

//		driver.findElement(By.xpath("//input[@name=\"search_text\"]")).sendKeys(prodName);
//		driver.findElement(By.xpath("//input[@type=\"button\"]")).click();
		Thread.sleep(2000);
		campPrdpage.productNamePresent(driver, prodName);
		// driver.findElement(By.xpath("//a[text()='"+prodName+"']")).click();
		Thread.sleep(2000);

		wlib.switchingWindows(driver, "Campaigns&action");
//		Set<String> allwin1 = driver.getWindowHandles();
//		Iterator<String> it1 = allwin1.iterator();
//		
//		while(it1.hasNext())
//		{
//			String win1 = it1.next();
//			driver.switchTo().window(win1);
//			String currentTitle1 = driver.getTitle();
//			if(currentTitle1.contains("Campaigns&action"))
//			{
//				break;
//			}
//		}

		campPage.clickSaveCampaignButton();
		// driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		Thread.sleep(2000);
		home.logoutFromApp();
//		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
//		driver.findElement(By.linkText("Sign Out")).click();	

	}

}
