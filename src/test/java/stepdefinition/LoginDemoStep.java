package stepdefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GooglePage;
import pages.LoginDemoPage;

public class LoginDemoStep {
	public  WebDriver driver;
	public LoginDemoPage ld;
	
	@Given("I launch browser and open base url {string}")
	public void i_launch_browser_and_open_base_url(String baseUrl) {
	 Hooks.driver.get(baseUrl);
	  this.driver=Hooks.driver;
	//  driver.get(baseUrl);
	  
	}
	@When("I enter email id as {string} and password as {string}")
	public void i_enter_email_id_as_and_password_as(String email, String password) {
		ld= new LoginDemoPage(driver);
		ld.enterEmail(email);
	   ld.enterPassword(password);
	}
	@When("I clicked on login button")
	public void i_clicked_on_login_button() {
	ld.clickOnSingIn();   
	}
	@Then("I should be successfully logged in")
	public void i_should_be_successfully_logged_in() {
	    String pageSource=driver.getPageSource();
	    Assert.assertTrue(pageSource.contains("Successfully Logged in."));
	}

}
