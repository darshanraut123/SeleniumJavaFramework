package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPageObjects{
	
	WebElement loginLink;
	
	public WebElement getLoginLink(WebDriver driver) {
		
		loginLink = driver.findElement(By.className("login"));
		return loginLink;
	}

}
