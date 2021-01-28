package TestCases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import PageObject.LoggedInMainPage;
import PageObject.LoginPageObjects;
import PageObject.MainPageObjects;
import PageObject.PersonalInfoPage;
import Utilities.ConfigPropData;
import Utilities.ExcelData;

public class TestCase extends BaseClass {
	MainPageObjects mpob;
	LoginPageObjects lp;
	LoggedInMainPage lmp;
	PersonalInfoPage pip;
	
	@Test
	//check login page title
	public void test001() throws Exception{
		configData =  new ConfigPropData();
		mpob = new MainPageObjects();
		mpob.getLoginLink(driver).click();
		Assert.assertEquals(driver.getTitle(),configData.getPropertiesFromFile("logintitle"));
	}

	@Test(dependsOnMethods = "test001")
	//check login successful/fail state
	public void test002() throws Exception{
		configData =  new ConfigPropData();
		lp = new LoginPageObjects();
		lmp = new LoggedInMainPage();
		lp.getEmailBox(driver).sendKeys("webLogic@live.com");
		lp.getPasswordBox(driver).sendKeys("password");
		lp.getSignInButton(driver).click();
		String usersName = lmp.getLoggedInUser(driver).getText();
		String title = driver.getTitle();
		Assert.assertTrue(usersName.equalsIgnoreCase("Darshan Raut"));
		Assert.assertTrue(title.equalsIgnoreCase(configData.getPropertiesFromFile("loggedintitle")));

	}
	
	@Test(dependsOnMethods = "test002",dataProvider = "UserData")
	//To Update Personal Information 
	public void test003(String email) throws Exception {
		configData =  new ConfigPropData();
		lmp = new LoggedInMainPage();
		lmp.getPersonalInfoBtn(driver).click();
		pip = new PersonalInfoPage();
		pip.getGenderRadio(driver,"Mr.").click();
		pip.getFirstNameBox(driver).clear();
		pip.getFirstNameBox(driver).sendKeys(configData.getPropertiesFromFile("firstname"));
		pip.getlastNameBox(driver).clear();
		pip.getlastNameBox(driver).sendKeys(configData.getPropertiesFromFile("lastname"));
		pip.getEmailBox(driver).clear();
		pip.getEmailBox(driver).sendKeys(email);
		pip.selectOptionFromDropdown(driver,"10","days");
		pip.selectOptionFromDropdown(driver,"10","months");
		pip.selectOptionFromDropdown(driver,"2020","years");
		pip.getConfirmationPassword(driver).isDisplayed();
		pip.getOldPassword(driver).sendKeys("password");
		pip.getNewPassword(driver).sendKeys("password");
		pip.getConfirmationPassword(driver).sendKeys("password");
		pip.getSaveSubmitBtn(driver).click();
		WebElement popupMessage = pip.getSavedSuccessMessage(driver);
		boolean isMessageDisplayed = popupMessage.isDisplayed();
		String color = popupMessage.getCssValue("background-color");
		Assert.assertTrue(color.equals(configData.getPropertiesFromFile("successcolor")));
		Assert.assertTrue(isMessageDisplayed);
		pip.getGotoAccountLink(driver).click();
	}

	@DataProvider(name="UserData")
	public String[] dataPro() throws Exception {
		ExcelData edata = new ExcelData();
		String [] emailData =  new String[3];
		emailData[0]=edata.getExcelDataCellValue(1,1,"emailInfo");
		emailData[1]=edata.getExcelDataCellValue(2,1,"emailInfo");
		emailData[2]=edata.getExcelDataCellValue(3,1,"emailInfo");
		return emailData;
	}
	 
	@AfterClass
	//And I logout 
	public void test004() throws Exception{
		lmp = new LoggedInMainPage();
		lmp.getLogoutBtn(driver).click();
		Assert.assertEquals(driver.getTitle(),configData.getPropertiesFromFile("logintitle"));
	}

	
}
