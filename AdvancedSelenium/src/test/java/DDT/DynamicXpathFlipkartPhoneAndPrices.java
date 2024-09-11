package DDT;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicXpathFlipkartPhoneAndPrices 
{

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@title=\"Search for Products, Brands and More\"]")).sendKeys("iPhone",Keys.ENTER);
		
		int count=0;
		 List<WebElement> phoneList = driver.findElements(By.xpath("//div[@class=\"KzDlHZ\"]"));
		 
		 for (WebElement phoneName : phoneList)
		 {
			System.out.println(phoneName.getText());
			count++;
			
		}
		 
		System.out.println("Total no of count:----->"+count);
		 
		
		int count1=0;
		List<WebElement> phonePrices = driver.findElements(By.xpath("//div[@class=\"Nx9bqj _4b5DiR\"]"));
		
		for (WebElement PhonePrice : phonePrices)
		{
			System.out.println(PhonePrice.getText());
			count1++;
		}
		System.out.println("Total no of count :------>" + count1); 

		for(int i=0;i<phoneList.size();i++)
		{
			System.out.println(phoneList.get(i).getText()+"-------->"+phonePrices.get(i).getText());
		}
	}

}
