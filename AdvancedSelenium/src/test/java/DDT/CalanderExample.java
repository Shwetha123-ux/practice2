package DDT;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CalanderExample 
{
//pull
	public static void main(String[] args) throws Throwable 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Actions act = new Actions(driver);
		act.moveByOffset(10, 20).click().perform();
		
		Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Departure']")).click();
        
        
        // Example of Dynamic XPaths
        
        Thread.sleep(2000);
        String monthName = "September 2024";
        String dateList = "6";
        driver.findElement(By.xpath("//div[text()='"+monthName+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+dateList+"']")).click();


	}

}
