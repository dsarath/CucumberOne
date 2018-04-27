package steps;

import org.openqa.selenium.firefox.FirefoxDriver;

import base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook extends BaseUtil{
	
	private BaseUtil base;

	public Hook(BaseUtil base) {
		this.base = base;
	}

	@Before
	public void InitializeTest() {
		System.out.println("\nOpening the Browser ");
		//Passing a WebDriver Instance
		System.setProperty("webdriver.gecko.driver", "c:\\geckodriver.exe");
		base.Driver = new FirefoxDriver();
	}
	
	@After
	public void TearDownTest(Scenario scenario) {
		
		if(scenario.isFailed()) {
			//Take a screenshot
			System.out.println("\nThe Scenario <"+scenario.getName()+"> is failed, so a screenshot will be saved.");
		}
		else {
			System.out.println("Scenario: "+scenario.getName()+" was Approved!!\nStatus: "+scenario.getStatus());
		}
		base.Driver.close();	
		System.out.println("\nClosing the Browser ");
	}
}
