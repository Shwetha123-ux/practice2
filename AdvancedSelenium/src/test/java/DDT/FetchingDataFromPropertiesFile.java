package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchingDataFromPropertiesFile 
{

	public static void main(String[] args) throws Throwable 
	{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Normal Approach
		/*driver.get("https://www.saucedemo.com/v1/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.className("btn_action")).click(); */
		
		//Reading data from External Resource---->Properties File
		
		//	step1:-get the java representation object of the physical file
		FileInputStream fis = new FileInputStream("./src/test/resources/DataFile.properties");
		
		//step2:-create an object to property class to load all the keys
		Properties pro=new Properties();
		pro.load(fis);
		
		 
	    //step3:-read the value using getProperty()
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		
		driver.get(URL);
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.className("btn_action")).click();
		

	}

}
