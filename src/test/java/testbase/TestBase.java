package testbase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	
	public static WebDriver driver;
	public static Properties property;
	public static WebDriver getWebDriver() throws IOException
	{
		
	    property=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\configproperty\\config.properties");
		property.load(fis);
		String browser=property.getProperty("browser");
		if(browser.contains("Chrome"))
		{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(options);		
		return driver;
		}
		else
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();		
			return driver;
			
		}
	}
	}
