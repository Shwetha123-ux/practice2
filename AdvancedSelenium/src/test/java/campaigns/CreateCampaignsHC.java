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
		import org.openqa.selenium.interactions.Actions;

		import Generic_Utilities.Excel_Utility;
		import Generic_Utilities.File_Utility;
		import Generic_Utilities.Java_Utility;

public class CreateCampaignsHC 
{

	//Login to vtiger application->mouseOverOn more Link->click on campaigns->click on create campaign lookup image->
		//Enter campaignName-> click on save Btn->verify whether the campaign is created in campaign Information page and Logout from the application.

		

			public static void main(String[] args) throws Throwable
			{
				WebDriver driver = new ChromeDriver();

				File_Utility flib = new File_Utility();
				String URL = flib.gettKeyAndValueData("url");
				String USERNAME = flib.gettKeyAndValueData("username");
				String PASSWORD = flib.gettKeyAndValueData("password");

//				FileInputStream fis = new FileInputStream("./src/test/resources/Vtigerlogins.properties");
//				Properties pro = new Properties();
//				pro.load(fis);
		//
//				String URL = pro.getProperty("url");
//				String USERNAME = pro.getProperty("username");
//				String PASSWORD = pro.getProperty("password");

				driver.get(URL);
				driver.manage().window().maximize();
				driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(USERNAME);
				driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();

				WebElement moreLink = driver.findElement(By.linkText("More"));
				Actions act = new Actions(driver);
				act.moveToElement(moreLink).click().perform();

				driver.findElement(By.xpath("//a[@name=\"Campaigns\"]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//img[@title=\"Create Campaign...\"]")).click();

				Java_Utility jlib = new Java_Utility();
				int ranNum = jlib.getRandomNum();

//				Random ran = new Random();
//				int ranNum = ran.nextInt(1000);

				Excel_Utility elib = new Excel_Utility();
				String campName = elib.getExcelData("Campaigns", 0, 0) + ranNum;
				System.out.println(campName);

//				FileInputStream fis1 = new FileInputStream("E:\\AdvancedSelenium\\TestData8.xlsx");
//				Workbook book = WorkbookFactory.create(fis1);
//				Sheet sheet = book.getSheet("Campaigns");
		//
//				// To get Campaign name
//				Row row = sheet.getRow(0);
//				Cell cell = row.getCell(0);
//				String campName = cell.getStringCellValue() + ranNum;

//		      System.out.println(campName);
				
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@name=\"campaignname\"]")).sendKeys(campName);
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

				Thread.sleep(2000);

				WebElement signoutImage = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

				Actions act1 = new Actions(driver);
				act1.moveToElement(signoutImage).click().perform();

				driver.findElement(By.linkText("Sign Out")).click();

			}

}

	
