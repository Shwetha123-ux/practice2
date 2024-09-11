package DDT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicXpathExForProKabbadi 
{

	public static void main(String[] args) throws Throwable 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.prokabaddi.com/standings");
		Thread.sleep(2000);
		String teamName = "Bengal Warriorz";
		
		String BBlost = driver.findElement(By.xpath("//p[text()='"+teamName+"']/../../../..//div[@class=\"table-data matches-lost\"]/p[@class=\"count\"]")).getText();
	System.out.println(BBlost);
	
	
	}

}
