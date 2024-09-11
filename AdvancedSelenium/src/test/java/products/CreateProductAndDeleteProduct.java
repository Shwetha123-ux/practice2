package products;

import java.io.FileInputStream;
import java.util.List;
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
import objectRepository.DeleteProductPage;
import objectRepository.DeleteProductValidationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

/*5.Login to vtiger application->click on products link->click on create product lookup image->Enter product name->
click on save Btn->verify whether the product is created in product Information page->click on product link->
navigate to product table page ->select the product created checkbox->click on delete->Handle the Alert popup and 
verify product deleted or not and Logout from the application */

public class CreateProductAndDeleteProduct {

	public static void main(String[] args) throws Throwable {
		WebDriver driver;

		File_Utility flib = new File_Utility();
		Excel_Utility elib = new Excel_Utility();
		Java_Utility jlib = new Java_Utility();
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

		driver.get(URL);
		wlib.maximizeWindow(driver);
		wlib.waitPageToLoad(driver);

//		FileInputStream fis = new FileInputStream("./src/test/resources/Vtigerlogins.properties");
//		Properties pro = new Properties();
//		pro.load(fis);
//
//		String URL = pro.getProperty("url");
//		String USERNAME = pro.getProperty("username");
//		String PASSWORD = pro.getProperty("password");

//		driver.manage().window().maximize();
		
		LoginPage login=new LoginPage(driver);
		login.loginToApp(USERNAME, PASSWORD);
//		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(USERNAME);
//		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();

		HomePage home=new HomePage(driver);
		home.clickProductsLink();
		//driver.findElement(By.linkText("Products")).click();
		CreateProductPage prdPage = new CreateProductPage(driver);
		prdPage.clickProductPlusSign();
		//driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();

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
		//driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(prodName);
		prdPage.clickSaveProductButton();
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		Thread.sleep(2000);
		home.clickProductsLink();
	//	driver.findElement(By.linkText("Products")).click();
		
		DeleteProductPage deleteProd = new DeleteProductPage(driver);
		deleteProd.selectProductName(driver, prodName);
		deleteProd.clickDeleteButton();
		wlib.alertAccept(driver);
		deleteProd.validateProductDeleted(driver, prodName);
	//	DeleteProductValidationPage prdValidate = new DeleteProductValidationPage(driver);
//		prdValidate.deleteProduct(driver, prodName);
	//prdValidate.clickOnDeleteButton(wlib, driver);
//		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='" + prodName
//				+ "']/../preceding-sibling::td/input[@type='checkbox']")).click();
//		driver.findElement(By.xpath("//input[@value='Delete']")).click();
//
//		wlib.alertAccept(driver);
		// driver.switchTo().alert().accept();

	//	prdValidate.validateProductDeleted(driver, prodName);
		
//		List<WebElement> allProd = driver
//				.findElements(By.xpath("(//table[@class=\"lvt small\"]/tbody/tr//td[3])[position()>1]"));
//		boolean flag = false;
//
//		for (WebElement prod : allProd) {
//			String actData = prod.getText();
//			if (actData.contains(prodName)) {
//				flag = true;
//				break;
//			}
//
//		}
//
//		if (flag) {
//			System.out.println(flag);
//
//			System.out.println("Product Data is Deleted....");
//		}
//
//		else {
//
//			System.out.println("Product Data is NOT Deleted....");
//		}
		Thread.sleep(2000);
		home.logoutFromApp();
//		WebElement signoutImage = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//		wlib.mouseHoveronElement(driver, signoutImage);
////	Actions act = new Actions(driver);
////	
////	act.moveToElement(signoutImage).click().perform();
//
//		driver.findElement(By.linkText("Sign Out")).click();

	}

}
