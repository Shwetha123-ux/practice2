package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignsPage 
{
	public CreateCampaignsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title=\"Create Campaign...\"]")
	private WebElement campaignPlusSign;
	
	@FindBy(name = "campaignname")
	private WebElement CampaignName;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement PlusSignToNavigateToProductPage;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveCampaignButton;
	
	public WebElement getcampaignPlusSign()
	{
		return campaignPlusSign;
		
	}
	
	public WebElement getCampaignName()
	{
		return CampaignName;
		
	}
	
	public WebElement getPlusSignToNavigateToProductPage()
	{
		return PlusSignToNavigateToProductPage;
		
	
	}
	
	public WebElement getSaveCampaignButton()
	{
		return SaveCampaignButton;
		
	}
	
	
	public void clickcampaignPlusSign()
	{
		campaignPlusSign.click();
	}
	

	public void enterCampaignName(String campName)
	{
		CampaignName.sendKeys(campName);
	}
	
	
	public void clickPlusSignToNavigateToProductPage()
	{
		PlusSignToNavigateToProductPage.click();
	}
	
	public void clickSaveCampaignButton()
	{
		SaveCampaignButton.click();
	}
	
}
