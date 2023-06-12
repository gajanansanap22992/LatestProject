package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {

	WebDriver driver;

	public GooglePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//textarea[@class='gLFyf']")
	WebElement searchBar;

	@FindBy(xpath = "//div[@class='wM6W7d']//span[contains(text(),'java')]")

	List<WebElement> webList;

	public void enterText(String text) {
		searchBar.sendKeys(text);
	}

	public List<WebElement> getWebElementList() {
		return webList;
	}
}
