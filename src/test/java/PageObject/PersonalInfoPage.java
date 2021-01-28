package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PersonalInfoPage {
	WebElement genderRadioBtn;
	WebElement firstName;
	WebElement lastName;
	WebElement email;
	WebElement oldPassword;
	WebElement newPassword;
	WebElement confirmPassword;
	WebElement saveBtn;
	WebElement savedSuccessMessage;
	WebElement gotoAccountLink;
	
	public WebElement getFirstNameBox(WebDriver driver) {
		firstName = driver.findElement(By.id("firstname"));
		return firstName;
	}
	public WebElement getlastNameBox(WebDriver driver) {
		lastName = driver.findElement(By.id("lastname"));
		return lastName;
	}	
	public WebElement getGenderRadio(WebDriver driver,String option) {
		String radioBtn = "//div[normalize-space()='"+option+"']//input[@type='radio']";
		genderRadioBtn = driver.findElement(By.xpath(radioBtn));
		return genderRadioBtn;
	}
	public WebElement getEmailBox(WebDriver driver) {
		email = driver.findElement(By.xpath("//label[normalize-space()=\"E-mail address\"]//following-sibling::input"));
		return email;
	}
	public WebElement getOldPassword(WebDriver driver) {
		email = driver.findElement(By.id("old_passwd"));
		return email;
	}
	
	public WebElement getNewPassword(WebDriver driver) {
		newPassword = driver.findElement(By.xpath("//label[normalize-space()='New Password']//following-sibling::input"));
		return newPassword;
	}
	
	public WebElement getConfirmationPassword(WebDriver driver) {
		confirmPassword = driver.findElement(By.cssSelector("input#confirmation"));
		return confirmPassword;
	}
	
	public void selectOptionFromDropdown(WebDriver driver,String option, String typeOfDropdown)
	{
		Select selOption = new Select(driver.findElement(By.id(typeOfDropdown)));
		selOption.selectByValue(option);
		
	}
	
	public WebElement getSaveSubmitBtn(WebDriver driver) {
		
		saveBtn = driver.findElement(By.cssSelector("button[name*='submitIdentity'][type='submit']"));
		return saveBtn;
	}
	
	public WebElement getSavedSuccessMessage(WebDriver driver) {
		savedSuccessMessage = driver.findElement(By.xpath("//*[normalize-space()='Your personal information']//following-sibling::*[normalize-space()='Your personal information has been successfully updated.']"));
		return savedSuccessMessage;
	}
	
	public WebElement getGotoAccountLink(WebDriver driver) {
		gotoAccountLink =  driver.findElement(By.cssSelector("a.home~a"));
		return gotoAccountLink;
	}
	
}
