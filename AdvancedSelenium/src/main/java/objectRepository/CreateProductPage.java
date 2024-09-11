package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	// Initialization
	public CreateProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Declaration

	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement ProductPlusSign;

	@FindBy(name = "productname")
	private WebElement ProductNameTextField;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveProductButton;

	// Getter Methods

	public WebElement getProductPlusSign() {
		return ProductPlusSign;
	}

	public WebElement getProductNameTextField() {
		return ProductNameTextField;
	}

	public WebElement getSaveProductButton() {
		return SaveProductButton;
	}

	// BUsiness Logic

	public void clickProductPlusSign() {
		ProductPlusSign.click();
	}

	public void enterProductName(String prodName) {
		ProductNameTextField.sendKeys(prodName);
	}

	public void clickSaveProductButton() {
		SaveProductButton.click();
	}

}
