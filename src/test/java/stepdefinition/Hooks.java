package stepdefinition;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import testbase.TestBase;

public class Hooks extends TestBase  {
	
	public static WebDriver driver;
	
	@Before
	public void driverSetup() throws IOException
	{
		driver=getWebDriver();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}

	 @After
	    public void tearDown(Scenario scenario) {
	        try {
	            String screenshotName = scenario.getName().replaceAll("", "_");
	            if (scenario.isFailed()) {
	                TakesScreenshot ts = (TakesScreenshot) driver;
	                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
	                scenario.attach(screenshot, "img/png", screenshotName);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	       driver.quit();
	    }
	 
	 @AfterStep
		public void addScreenshot(Scenario scenario) throws IOException {
			  File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			  byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
			  scenario.attach(fileContent, "image/png", "screenshot");
			
		}
	
}
