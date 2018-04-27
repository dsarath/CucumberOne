package steps;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseUtil;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginStep extends BaseUtil{
	
	private BaseUtil base;

	public LoginStep(BaseUtil base) {
		this.base = base;
	}
	
	@Given("^I navigate to the login page$")
	public void iNavigateToTheLoginPage() throws Throwable {
		base.Driver.get("http://executeautomation.com/demosite/Login.html");	
	}

	@And("^I enter the data for login$")
	public void isEnterTheDataForLogin(DataTable table) throws Throwable {
		/*List<List<String>> data = table.raw();
		System.out.println(data.get(1).get(0));
		System.out.println(data.get(1).get(1));*/
		WebDriverWait wait = new WebDriverWait(base.Driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("UserName")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Password")));
		
		List<User> users = new ArrayList<User>();
		users = table.asList(LoginStep.User.class);
		for (User user : users) {
			System.out.println("Inserting username " + user.username);
			base.Driver.findElement(By.name("UserName")).sendKeys(user.username);
			System.out.println("Inserting password " + user.password);
			base.Driver.findElement(By.name("Password")).sendKeys(user.password);
		}
	}
	
	@And("^I enter ([^\"]*) and ([^\"]*)$")
	public void iEnterUserNameAndPassword(String userName, String password) throws Throwable {
		WebDriverWait wait = new WebDriverWait(base.Driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("UserName")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Password")));
		
		System.out.println("Inserting username " + userName);
		base.Driver.findElement(By.name("UserName")).sendKeys(userName);;
		System.out.println("Inserting password " + password);
		base.Driver.findElement(By.name("Password")).sendKeys(password);;
	}

	@And("^I click login button$")
	public void iClickLoginButton() throws Throwable {
		WebDriverWait wait = new WebDriverWait(base.Driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(By.name("Login")));
		base.Driver.findElement(By.name("Login")).submit();
	}

	@Then("^I should see the userform page$")
	public void iShouldSeeTheUserFormPage() throws Throwable {
		WebDriverWait wait = new WebDriverWait(base.Driver, 15);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("details")));
			Assert.assertTrue(base.Driver.findElement(By.id("details")).isDisplayed());
		} catch (Exception e) {
			System.out.println("Element not found");
		}
	}
	
	public class User{
		public String username;
		public String password;
		
		public User(String userName, String passWord) {
			super();
			username = userName;
			password = passWord;
		}
	}
	
}
