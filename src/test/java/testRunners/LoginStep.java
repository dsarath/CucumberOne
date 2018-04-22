package testRunners;

import java.util.ArrayList;
import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginStep {
	@Given("^I navigate to the login page$")
	public void iNavigateToTheLoginPage() throws Throwable {
		//throw new PendingException();
	}
	
	@And("^I enter the username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void iEnterTheUsernameAsAndPasswordAs(String userName, String password) throws Throwable {
		System.out.println("The username is " + userName);
		System.out.println("The password is " + password);
	}

	@And("^I enter the data for login$")
	public void isEnterTheDataForLogin(DataTable table) throws Throwable {
		//List<List<String>> data = table.raw();
		//System.out.println(data.get(1).get(0));
		//System.out.println(data.get(1).get(1));
		List<User> users = new ArrayList<User>();
		users = table.asList(LoginStep.User.class);
		for (User user : users) {
			System.out.println("The username is " + user.username);
			System.out.println("The password is " + user.password);
		}
	}
	
	@And("^I enter ([^\"]*) and ([^\"]*)$")
	public void iEnterUserNameAndPassword(String userName, String password) throws Throwable {
		System.out.println("The username is " + userName);
		System.out.println("The password is " + password);
	}

	@And("^I click login button$")
	public void iClickLoginButton() throws Throwable {
		//throw new PendingException();
	}

	@Then("^I should see the userform page$")
	public void iShouldSeeTheUserFormPage() throws Throwable {
		//throw new PendingException();
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
