package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriver_Utility;

public class HomePage
{
	//initialization
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	
	@FindBy(linkText = "Organizations")
	private WebElement OrgLink;
	
	@FindBy(xpath = "//a[text()='Products']")
	private WebElement ProductsLink;
	
	@FindBy(xpath ="//a[text()='More']")
	private WebElement MoreLink;
	
	@FindBy(xpath="//a[text()='Campaigns']")
	private WebElement CampaignsLink;
	
	@FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement AdminLink;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement SignOut;
	
//	@FindBy(linkText="Sign Out'")
//	private WebElement SignOut;

	
	//Getter Methods
	
	public WebElement getOrgLink()
	{
		return OrgLink;
	}
	
	public WebElement getProductsLink()
	{
		return ProductsLink;
		
	}
	
	public WebElement getMoreLink()
	{
		return MoreLink;
		
	}
	
	public WebElement getCampaignsLink()
	{
		return CampaignsLink;
		
	}

	public WebElement getAdminLink()
	{
		return AdminLink;
	}

	public WebElement getSignOut()
	{
		return SignOut;
	}
	
	
	//Business Logic
	
	public void clickOrganizationLink()
	{
		OrgLink.click();
	}
	
	public void clickProductsLink()
	{
		ProductsLink.click();
	}
	
	public void clickMoreLink()
	{
		MoreLink.click();
	}
	
	public void clickCampaignsLink()
	{
		CampaignsLink.click();
	}
	
	
	public void signOutApp(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.moveToElement(AdminLink).click().perform();
		SignOut.click();
		
	}
	
	public void logoutFromApp()
	{
		AdminLink.click();
		SignOut.click();
	}

	public void logout(WebDriver driver)
	{
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.moveToElement(driver, AdminLink);
		SignOut.click();
	}
	
	
}
