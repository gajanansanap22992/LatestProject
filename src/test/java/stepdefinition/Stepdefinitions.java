package stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonutility.CommonUtilityMethods;
import io.cucumber.java.en.*;
import pages.GooglePage;

public class Stepdefinitions {
	
	public  WebDriver driver;
	public GooglePage gp;
	@Given("I launch browser and open google url")
	public void i_launch_browser_and_open_google_url() {
		driver=Hooks.driver;	
		driver.get("https://www.google.com");
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[@aria-label='No thanks']")).click();
		driver.switchTo().defaultContent();
	
		gp=new GooglePage(driver);
		  
	}

	@Given("I enter a string {string} in the search box")
	public void i_enter_a_string_in_the_search_box(String text) {
		
		gp.enterText(text);
		new CommonUtilityMethods().explicitWait(driver.findElement(By.xpath("//div[@class='wM6W7d']//span[contains(text(),'java')]")), driver);
	    }

	@Given("I verified the list of options populted for entered string")
	public void i_verified_the_list_of_options_populted_for_entered_string() {
		
		List<WebElement> elements=gp.getWebElementList();
		
		for(WebElement e:elements)
		{
			String text=e.getText();
			if(text.contains("javat"))
			{
				
				e.click();
				break;
			}
		}
	   
	}


}
