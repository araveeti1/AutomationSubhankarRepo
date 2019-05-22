package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import utils.SeleniumDriverClass;

public class AfterActions {

	@After
	public static void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			try {
				byte[] screenshot = ((TakesScreenshot) SeleniumDriverClass.getDriver()).getScreenshotAs(OutputType.BYTES);
				String testName = scenario.getName();
				scenario.embed(screenshot, "image/png");
				scenario.write(testName);
			} catch (WebDriverException wde) {
				System.err.println(wde.getMessage());
			} catch (ClassCastException cce) {
				cce.printStackTrace();
			}
		}
		SeleniumDriverClass.tearDown();
	}
	
}
