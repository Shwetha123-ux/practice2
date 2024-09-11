package products;

import java.io.FileInputStream;
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
import objectRepository.CreateProductPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

//Login to vtiger application->click on products link->click on create product lookup image->Enter product name->click on save Btn->
//verify whether the product is created in product Information page and Logout from the application.

public class CreateProduct {

	public static void main(String[] args) throws Throwable {
		File_Utility flib = new File_Utility();
		Excel_Utility elib = new Excel_Utility();
		Java_Utility jlib = new Java_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();

		WebDriver driver;

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

		driver.get(URL);
		wlib.maximizeWindow(driver);
		// wlib.implicity_Wait(driver);

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

		String prodName = elib.getExcelData("Products", 0, 0) + ranNum;
		System.out.println(prodName);

		prdPage.enterProductName(prodName);
		prdPage.clickSaveProductButton();
//		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(prodName);
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		Thread.sleep(2000);

		home.signOutApp(driver);
//		WebElement signoutImage = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//
//		wlib.mouseHoveronElement(driver, signoutImage);
//
//		driver.findElement(By.linkText("Sign Out")).click();

	}

}
