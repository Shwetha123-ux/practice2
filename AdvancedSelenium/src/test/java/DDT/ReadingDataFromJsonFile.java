package DDT;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadingDataFromJsonFile 
{

	public static void main(String[] args) throws Throwable 
	{
		File fis = new File("./src/test/resources/Jackson.json");
		ObjectMapper jsonData = new ObjectMapper();
		
		 JsonNode data = jsonData.readTree(fis);
		 
		 String URL = data.get("url").asText();
		 String USERNAME = data.get("username").asText();
		 String PASSWORD = data.get("password").asText();
		 
		 
		 WebDriver driver = new ChromeDriver();
		 driver.get(URL);
		 driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		 Thread.sleep(3000);
		 driver.findElement(By.id("password")).sendKeys(PASSWORD);
		 Thread.sleep(3000);
		 driver.findElement(By.id("login-button")).click();
		 
		 
		

	}

}
