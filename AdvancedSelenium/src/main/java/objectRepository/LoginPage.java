package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	// Initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Declaration
	@FindBy(name = "user_name")
	private WebElement UserTextField;

	@FindBy(name = "user_password")
	private WebElement PasswordTextField;

	@FindBy(xpath = "//input[@id=\"submitButton\"]")
	private WebElement LoginButton;
	

	// Getter Methods

	public WebElement getUserTextField() {
		return UserTextField;
	}

	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}
	
	//Business Logics
	
	public void loginToApp(String UserName, String PassWord)
	{
		UserTextField.sendKeys(UserName);
		PasswordTextField.sendKeys(PassWord);
		LoginButton.click();
		
	}
	

}
