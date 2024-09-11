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
		import org.openqa.selenium.interactions.Actions;

public class CreateOrganizationHC
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
				
				
				driver.findElement(By.linkText("Organizations")).click();
				driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
				
				Random ran = new Random();
				int ranNum = ran.nextInt(1000);
				
				FileInputStream fis1 = new FileInputStream("E:\\AdvancedSelenium\\TestData8.xlsx");
				Workbook book = WorkbookFactory.create(fis1);
				Sheet sheet = book.getSheet("Organisations");
				
				//To get Org name
				Row row = sheet.getRow(0);
				Cell cell = row.getCell(0);
				String orgName = cell.getStringCellValue()+ranNum;		
				System.out.println(orgName);
				
				Row row1 = sheet.getRow(1);
				Cell cell1 = row1.getCell(0);
				
				DataFormatter format = new DataFormatter();
				String phnNum = format.formatCellValue(cell1);
				System.out.println(phnNum);
				
				Row row2 = sheet.getRow(2);
				Cell cell2 = row2.getCell(0);
				String email = format.formatCellValue(cell2);
				System.out.println(email);
				
				driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(orgName);
				driver.findElement(By.id("phone")).sendKeys(phnNum);
				driver.findElement(By.id("email1")).sendKeys(email);
				
				driver.findElement(By.xpath("//input[@value=\"  Save  \"]")).click();
				Thread.sleep(2000);
				WebElement logoutimage = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));	
				
				Actions act = new Actions(driver);
				act.moveToElement(logoutimage).click().perform();
				Thread.sleep(2000);
				driver.findElement(By.linkText("Sign Out")).click();
					

			}

		}

