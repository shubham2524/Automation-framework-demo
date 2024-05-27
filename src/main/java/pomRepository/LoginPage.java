package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user-name")
	public WebElement usernameTextFeild;
	@FindBy(id = "password")
	public WebElement passwordTextFeild;
	@FindBy(id = "login-button")
	public WebElement loginButton;

	@FindBy(xpath = "//h3[text()='Epic sadface: Username and password do not match any user in this service']")
	public WebElement errormessage;

	public WebElement getUsernameTextFeild() {
		return usernameTextFeild;
	}

	public WebElement getPasswordTextFeild() {
		return passwordTextFeild;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public void login(String username, String password) {
		usernameTextFeild.sendKeys(username);
		passwordTextFeild.sendKeys(password);
		loginButton.click();

	}

}
