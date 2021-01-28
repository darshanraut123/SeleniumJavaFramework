package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjects {

	WebElement emailBox;
	WebElement passwordBox;
	WebElement submitBtn;
	
	public WebElement getEmailBox(WebDriver driver) {
		emailBox = driver.findElement(By.id("email"));	
		return emailBox;
	}

	public WebElement getPasswordBox(WebDriver driver) {
		passwordBox = driver.findElement(By.id("passwd"));
		return passwordBox;
	}

	public WebElement getSignInButton(WebDriver driver) {
		submitBtn = driver.findElement(By.id("SubmitLogin"));
		return submitBtn;
	}
}
