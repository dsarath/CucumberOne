package testRunners;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;

public class LoginStep {
	@Then("^I shoud see the userform page$")
	public void IShoudSeeTheUserFormPage() throws Throwable{
		throw new PendingException();
	}
}
