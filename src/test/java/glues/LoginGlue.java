package glues;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Reporter;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utilities.BrowserWindowUtility;
import utilities.ExcelFileUtility;
import utilities.PropertiesFileUtility;
import utilities.WebSiteUtility;

public class LoginGlue 
{
	WebDriver driver;
	FluentWait<WebDriver> wait;
	WebSiteUtility website;
	PropertiesFileUtility pf;
	ExcelFileUtility excel;
	LoginPage login;
	
	@Given("open {string} browser")
	public void open_browser(String browser) throws Exception
	{
		website = new WebSiteUtility();
		driver = website.openBrowser(PropertiesFileUtility.getValueFromPropertiesFile("src/test/resources/properties/config.properties", "browser"));
		//driver = website.openBrowser(browser);//takes browser name from feature file
		wait = website.defineExplicitWait(driver,30,1000);
		BrowserWindowUtility.browserMaximize(driver);
		login = new LoginPage(driver, wait);
	}
	
	@When("launch site")
	public void launch_site() throws Exception
	{
		website.launchSite(driver, PropertiesFileUtility.getValueFromPropertiesFile("src/test/resources/properties/config.properties", "url"));
	}
	
	@Then("verify login page is displayed")
	public void verify_login_page()
	{
		if(driver.getTitle().equals("Swag Labs"))	Reporter.log("Login page is displayed",true);
		else	Reporter.log("Login page is not displayed",true);
	}
	@When("enter valid username {string} into username field")
	public void enter_username(String username)
	{
		login.fillUserNameField(username);
	}
	@When("enter valid password {string} into password field")
	public void enter_password(String password)
	{
		login.fillPasswordField(password);
	}
	@When("click on login button")
	public void click_login() throws Exception
	{
		login.clickLogin();
	}
	@Then("verify login success")
	public void verify_login_success()
	{
		if(driver.getCurrentUrl().contains("inventory")) Reporter.log("<br>"+"Login successful",true);
		else	Reporter.log("<br>"+"Login failed",true);
	}
	@When("enter invalid username {string} into username field")
	public void enter_invalid_username(String username)
	{
		login.fillUserNameField(username);
	}
	@When("enter invalid password {string} into password field")
	public void enter_invalid_password(String password)
	{
		login.fillPasswordField(password);
	}
	@When("enter blank password into password field")
	public void enter_blank_password()
	{
		login.fillPasswordField("");
	}
	@When("enter blank username into username field")
	public void enter_blank_username()
	{
		login.fillUserNameField("");
	}
	@Then("verify login failure")
	public void verify_login_failure()
	{
		String error = login.getErrorMessage();
		Reporter.log("<br>"+"Error message is "+error,true);
	}
	@Then("close browser")
	public void close_browser()
	{
		website.closeSite(driver);
	}
}
