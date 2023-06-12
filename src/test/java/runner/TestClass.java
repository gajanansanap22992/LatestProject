package runner;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass {
	
	@Test
	public void runTest() throws IOException
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		 driver.get("http://demo.guru99.com/test/newtours/");           
         WebElement link_Home = driver.findElement(By.linkText("Home"));
         WebElement td_Home = driver
                 .findElement(By
                 .xpath("//html/body/div"
                 + "/table/tbody/tr/td"
                 + "/table/tbody/tr/td"
                 + "/table/tbody/tr/td"
                 + "/table/tbody/tr"));    
          
         Actions builder = new Actions(driver);
         Action mouseOverHome = builder
                 .moveToElement(link_Home)
                 .build();
          
         String bgColor = td_Home.getCssValue("background-color").toString();
         System.out.println("Before hover: " + bgColor);        
         mouseOverHome.perform();        
         bgColor = td_Home.getCssValue("background-color").toString();
         System.out.println("After hover: " + bgColor);
         driver.close();
 	}
	

}
