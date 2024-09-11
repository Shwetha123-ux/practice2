package DDT;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicXpathUsingFlipkart
{

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com");
		driver.findElement(By.name("q")).sendKeys("iPhone",Keys.ENTER);
		
		String phoneName = "Apple iPhone 15 Plus (Black, 128 GB)";
		String price = driver.findElement(By.xpath("//div[text()='"+phoneName+"']/ancestor::div[@class=\"yKfJKb row\"]/descendant::div[@class=\"Nx9bqj _4b5DiR\"]")).getText();
		System.out.println(price);
	}

}

