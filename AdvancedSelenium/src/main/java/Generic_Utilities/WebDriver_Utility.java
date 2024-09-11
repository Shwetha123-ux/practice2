package Generic_Utilities;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriver_Utility 
{
	/**
	 * This method is used to maximize window
	 * @param driver
	 * @author Shwetha M
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is used to minimize window
	 * @param driver
	 * @author Shwetha M
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	
	/**
	 * This method is used to fullscreen the window/webpage
	 * @param driver
	 * @author Shwetha M
	 */
	public void fullScreenWindow(WebDriver driver)
	{
		driver.manage().window().fullscreen();
	}
	
	/**
	 * This method is used to wait element to get loaded in window/webpage
	 * @param driver
	 */
	public void waitPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	/**
	 * This method is used for switching windows/tabs
	 * @param driver
	 * @param title
	 */
	public void switchingWindows(WebDriver driver, String title)
	{
	Set<String> allwin = driver.getWindowHandles(); //win1, win2
	Iterator<String> it = allwin.iterator();
	
	while(it.hasNext())
	{
		String win = it.next();
		driver.switchTo().window(win);
		String currentTitle = driver.getTitle();
		
		if(currentTitle.contains(title))
		{
			break;
		}
	}
	
}
	/**
	 * This method is used to mouse hover on a webelement
	 * @param driver
	 * @param ele
	 * @author Shwetha M
	 */
	public void  mouseHoveronElement(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		
		act.moveToElement(element).click().perform();
	}
	
	/**
	 * This method is used to move the cursor to a particular element
	 * @param driver
	 * @param element
	 */
	public void moveToElement(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	
	/**
	 * 	 used to right click  on specified element

	 * @param driver
	 * @param element
	 */
	
	public void rightClickOnElement(WebDriver driver , WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	
	/**
	 *   it's an implicitly wait  Always wait for Element in DOM document & release the control if element available 
	 * @param driver
	 */
	public void waitForElementInDOM(WebDriver driver) 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 *   it's an Explicitly wait Always wait for Page to be loaded & available in GUI
	 * @param driver
	 * @param partailPageURL
	 */
//	public void waitForPage(WebDriver driver , String partialPageURL) 
//	{
//		WebDriverWait wait = new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.urlContains(partialPageURL));
//	}

	/**
	 *   it's an Explicitly wait Always wait for Page to be loaded & available in GUI
	 * @param driver
	 * @param partailPageURL
	 */
//	public void waitForElement (WebDriver driver , WebElement element) {
//		WebDriverWait wait = new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.visibilityOf(element));
//	}
	
	/**
	 * this method is used to accept the alert popup
	 * @param driver
	 */
	public void alertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/** this method is used to dismiss the alert popup
	 * 
	 * @param driver
	 */
	public void alertDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * used to Switch to Frame Window based on index
	 * @param driver
	 * @param index
	 */
	public void swithToFrame(WebDriver driver , int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * used to Switch to Frame Window based on id or name attribute
	 * @param driver
	 * @param id_name_attribute
	 */
	public void swithToFrame(WebDriver driver , String id_name_attribute) 
	{
		driver.switchTo().frame(id_name_attribute);
	}
	
	/**
	 * used to select the value from the dropDwon  based on index
	 * @param driver
	 * @param index
	 */
	public void select(WebElement element , int index) 
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * used to select the value from the dropDwon  based on value / option available in GUI
	 * @param element
	 * @param value
	 */
	public void select(WebElement element , String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	

	/**
	 * 
	 * @param driver
	 * @param javaScript
	 */
	public void executeJavaScript(WebDriver driver , String javaScript) 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeAsyncScript(javaScript, null);
	}
	
	/**
     * pass enter Key appertain in to Browser
     * @param driver
     */
   public void passEnterKey(WebDriver driver) 
   {
	   Actions act = new Actions(driver);
	   act.sendKeys(Keys.ENTER).perform();
   } 
	
	
   
}
