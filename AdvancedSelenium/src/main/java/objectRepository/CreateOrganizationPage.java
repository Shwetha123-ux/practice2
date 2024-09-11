package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {
	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[alt='Create Organization...']")
	private WebElement OrganizationPlusSign;
	
	@FindAll({ @FindBy(xpath = "//input[@name=\"accountname\"]"), @FindBy(name = "accountname") })
	private WebElement OrganizationName;

	@FindBy(id = "phone")
	private WebElement PhoneNumber;

	@FindBy(id = "email1")
	private WebElement EmailID;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveButton;
	
	
	//Getters
	
	public WebElement getOrganizationPlusSign()
	{
		return OrganizationPlusSign;
		
	}
	
	public WebElement getOrganizationName() {
		return OrganizationName;

	}
	
	public WebElement getPhoneNumber() {
		return PhoneNumber;
	}

	public WebElement getEmailID() {
		return EmailID;
	}

	public WebElement getSaveButton()
	{
		return SaveButton;
		
	}
	
	
	//Business Logics

	public void clickOrgPlusSign()
	{
		OrganizationPlusSign.click();
	}
	
	
	public void enterOrganisationData(String orgName, String phnNum, String mailID)
	{
		OrganizationName.sendKeys(orgName);
		PhoneNumber.sendKeys(phnNum);
		EmailID.sendKeys(mailID);	
	}
	
	public void clickOnSaveButton()
	{
		SaveButton.click();
	}

}
