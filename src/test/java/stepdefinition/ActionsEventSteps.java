package stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ActionsEventSteps {
	public  WebDriver driver;
	@Given("I validate the background color of home element")
	public void i_validate_the_background_color_of_home_element() {
		this.driver=Hooks.driver;
	    String bgcolor=driver.findElement(By.linkText("Home")).getCssValue("background-color");
	    System.out.println("background coor before mouse hover "+bgcolor);
	}
	@When("I mouseOver the Home link")
	public void i_mouse_over_the_home_link() {
	    Actions builder=new Actions(driver);
	    Action mouseOverHome=builder.moveToElement(driver.findElement(By.linkText("Home"))).build();
	    mouseOverHome.perform();
	}
	@Then("the background colour of link home should be changed")
	public void the_background_colour_of_link_home_should_be_changed() {
		 String bgcolor=driver.findElement(By.linkText("Home")).getCssValue("background-color");
		    System.out.println("background coor before mouse hover "+bgcolor);
	}

}
