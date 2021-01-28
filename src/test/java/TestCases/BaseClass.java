package TestCases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Utilities.ConfigPropData;

public class BaseClass{
	static WebDriver driver;
	static ConfigPropData configData;

	@BeforeClass
	public void setup() throws Exception{
		configData =  new ConfigPropData();
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+configData.getPropertiesFromFile("chromedriverpath"));
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.SECONDS);				
		driver.manage().window().maximize();
		driver.get(configData.getPropertiesFromFile("url"));
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();	
	}

//	public void ExecuteJs() {
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeAsyncScript(script, args)
//	}
	
}		
