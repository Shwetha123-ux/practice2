package DDT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.google.protobuf.Duration;

public class DynamicXpathExMakeMyTripCalendar 
{

	public static void main(String[] args) throws Throwable 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
		
		Actions act = new Actions(driver);
		act.moveByOffset(10,20).click().perform();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		Thread.sleep(2000);
		String monthName = "October 2024";
		String dateName ="10";
		driver.findElement(By.xpath("//div[text()='"+monthName+"']/ancestor::div[@class=\"DayPicker-Month\"]/descendant::p[text()='"+dateName+"']")).click();
	}

}
