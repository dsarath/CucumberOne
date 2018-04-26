package steps;

import base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook extends BaseUtil{
	
	private BaseUtil base;

	public Hook(BaseUtil base) {
		super();
		this.base = base;
	}

	@Before
	public void InitializeTest() {
		System.out.println("\nOpening the Browser ");
		//Passing a WebDriver Instance
		base.StepInfo = "FirefoxDriver";
	}
	
	@After
	public void TearDownTest(Scenario scenario) {
		
		if(scenario.isFailed()) {
			//Take a screenshot
			System.out.println("\nThe Scenario "+scenario.getName()+" is failed, so a screenshot will be saved.");
		}
			
		System.out.println("\nClosing the Browser ");
	}
}
