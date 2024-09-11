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
import org.openqa.selenium.interactions.Actions;

import Generic_Utilities.Java_Utility;

//Login to vtiger application->click on products link->click on create product lookup image->Enter product name->click on save Btn->
//verify whether the product is created in product Information page and Logout from the application.

public class CreateProductHC 
{

	public static void main(String[] args) throws Throwable 
			{
				WebDriver driver = new ChromeDriver();

				FileInputStream fis = new FileInputStream("./src/test/resources/Vtigerlogins.properties");
				Properties pro = new Properties();
				pro.load(fis);

				String URL = pro.getProperty("url");
				String USERNAME = pro.getProperty("username");
				String PASSWORD = pro.getProperty("password");

				driver.get(URL);
				driver.manage().window().maximize();
				driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(USERNAME);
				driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();

				driver.findElement(By.linkText("Products")).click();
				driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();

				Random ran = new Random();
				int ranNum = ran.nextInt(1000);

				FileInputStream fis1 = new FileInputStream("E:\\AdvancedSelenium\\TestData8.xlsx");
				Workbook book = WorkbookFactory.create(fis1);
				Sheet sheet = book.getSheet("Products");

				// To get Product name
				Row row = sheet.getRow(0);
				Cell cell = row.getCell(0);
				String prodName = cell.getStringCellValue() + ranNum;
				System.out.println(prodName);

				driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(prodName);
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

				Thread.sleep(2000);

				WebElement signoutImage = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

				Actions act = new Actions(driver);
				act.moveToElement(signoutImage).click().perform();

				driver.findElement(By.linkText("Sign Out")).click();

			}

		}

