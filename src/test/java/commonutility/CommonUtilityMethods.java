package commonutility;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtilityMethods {
	
	public void explicitWait(WebElement element,WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.ignoring(StaleElementReferenceException.class);
	}

}
