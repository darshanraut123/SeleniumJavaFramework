package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoggedInMainPage {

	WebElement loggedInUser;
	WebElement personalInfoBtn;
	WebElement logoutBtn;

	public WebElement getLoggedInUser(WebDriver driver) {
		loggedInUser = driver.findElement(By.className("account"));
		return loggedInUser;
	}
	public WebElement getPersonalInfoBtn(WebDriver driver) {
		personalInfoBtn = driver.findElement(By.xpath("//span[normalize-space()='My personal information']"));
		return personalInfoBtn;
	}
	
	public WebElement getLogoutBtn(WebDriver driver) {
		logoutBtn = driver.findElement(By.className("logout"));
		return logoutBtn;
	}
}
