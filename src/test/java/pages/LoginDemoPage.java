package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginDemoPage {

	WebDriver driver;

	public LoginDemoPage(WebDriver dr) {
		this.driver = dr;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='email']")
	WebElement txtEmail;

	@FindBy(xpath = "//div[@class='form-group'][2]//input[contains(@class,'is_re')]")
	WebElement txtPassword;

	@FindBy(id = "SubmitLogin")
	WebElement submitButton;

	public void enterEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void enterPassword(String pass) {
		txtPassword.sendKeys(pass);
	}

	public void clickOnSingIn() {
		submitButton.click();
	}

}
