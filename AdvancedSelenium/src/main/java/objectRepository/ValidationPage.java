package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ValidationPage 

{
	public ValidationPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void validatePrd(WebDriver driver, String data)
	{
		
	}
}
