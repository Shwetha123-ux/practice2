package DDT;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IPhoneColorVariations 
{

	public static void main(String[] args) throws Throwable 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@aria-label=\"Search Amazon.in\"]")).sendKeys("iphone");
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		
		List<WebElement> allcolors = driver.findElements(By.xpath("//span[text()='Apple iPhone 15 (128 GB) - Blue']"
				+ "/../../../..//div[@class=\"a-section s-color-swatch-container s-quick-"
				+ "view-text-align-start\"]//a"));
		
		for (WebElement colors : allcolors) 
		{
			System.out.println(colors.getAttribute("aria-label"));
		}
		
	}

}
