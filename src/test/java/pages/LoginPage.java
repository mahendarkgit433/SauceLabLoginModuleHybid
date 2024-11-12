package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

public class LoginPage
{
	WebDriver driver;
	FluentWait<WebDriver> wait;
	@FindBy(id = "user-name")
	private WebElement username;
	
	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(id = "login-button")
	private WebElement loginButton;
	
	@FindBy(xpath = "//h3[@data-test='error']")
	private WebElement errorMessage;
	
	public LoginPage(WebDriver driver, FluentWait<WebDriver> wait)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = wait;
	}
	
	public void fillUserNameField(String username)
	{
		this.username.sendKeys(username);
	}
	
	public void fillPasswordField(String password)
	{
		this.password.sendKeys(password);
	}
	
	public void clickLogin()
	{
		loginButton.click();
	}
	public String getErrorMessage()
	{
		return errorMessage.getText();
	}
}
