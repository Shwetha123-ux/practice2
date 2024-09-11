package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowSwitchingToProductPage
{
	public WindowSwitchingToProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id = "search_txt")
	private WebElement ProductName;
	
	@FindBy(name = "search")
	private WebElement ProductSearchButton;

	
	public WebElement getProductName() {
		return ProductName;
	}

	public WebElement getProductSearchButton() {
		return ProductSearchButton;
	}
	
	
	//Business Logic
	
	public void enterProductName(String prodName)
	{
		ProductName.sendKeys(prodName);
	}
	
	public void serachProduct()
	{
		ProductSearchButton.click();
	}
	
	public void productNamePresent(WebDriver driver, String productData)
	{
		driver.findElement(By.xpath("//a[text()='"+productData+"']")).click();
	}

}

