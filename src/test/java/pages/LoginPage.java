package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//how is to specify how the value must be found / using is to specify the value to be found
	@FindBy(how = How.NAME, using = "Username")
	public WebElement txtUserName;
	
	@FindBy(how = How.NAME, using = "Password")
	public WebElement txtPassword;
	
	@FindBy(how = How.NAME, using = "Login")
	public WebElement btnLogin;
	
	@FindBy(how = How.ID, using = "details")
	public WebElement userForm;
	
	public void Login(String userName, String password) {
		txtUserName.sendKeys(userName);
		txtPassword.sendKeys(password);
	}
	
	public void ClickLogin() {
		btnLogin.submit();
	}
	
	public boolean InUserForm() {
		return userForm.isDisplayed();
	}
}
