package DDT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicXpathExampleOlympicMedalCount1
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver =	new ChromeDriver();
		driver.get("https://olympics.com/en/paris-2024/medals");
		driver.manage().window().maximize();
		
		String countryName="Germany";
		
		String goldmedals = driver.findElement(By.xpath("//span[text()='"+countryName+"']/../..//span[@class='e1oix8v91 emotion-srm-19huvme'][1]")).getText();
		System.out.println(goldmedals);
		
		String silvermedals = driver.findElement(By.xpath("//span[text()='AUS']/../..//span[@class='e1oix8v91 emotion-srm-19huvme'][2]")).getText();
		System.out.println(silvermedals);
		
		String bronzemedals = driver.findElement(By.xpath("//span[text()='USA']/../..//span[@class=\"e1oix8v91 emotion-srm-19huvme\"][3]")).getText();
		System.out.println(bronzemedals);
		
		Thread.sleep(3000);
	String Germanygoldmedals = driver.findElement(By.xpath("//span[text()='Germany']/../..//span[@class=\"e1oix8v91 emotion-srm-19huvme\"][1]")).getText();
	
	
	System.out.println(Germanygoldmedals);
	}

}
