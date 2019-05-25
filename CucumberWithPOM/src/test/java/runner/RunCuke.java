package runner;

import org.testng.annotations.BeforeClass;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import pages.base.Constants;

@CucumberOptions(plugin = { "json:target/RunCuke/cucumber.json", "pretty", "html:target/RunCuke/cucumber.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, features = "src/test/resources/features/", glue = "steps", tags = "@Search-Cars, @Used-Cars-Search")
public class RunCuke extends AbstractTestNGCucumberTests {

	@BeforeClass
	public static void writeExtentReport() {
		// Configure extent report using 'cucumber.adapter.ExtentCucumberAdapter' for
		// cucumber version 4 as the old extent cucumber formatter does not work with
		// cucumber V4 anymore.
		System.setProperty("extent.reporter.html.start", "true");
		System.setProperty("extent.reporter.html.config", Constants.REPORT_CONFIG);
		System.setProperty("extent.reporter.html.out", Constants.EXTENT_REPORT_PATH + Constants.EXTENT_REPORT_NAME);
		System.setProperty("screenshot.dir", Constants.SCREENSHOT_PATH);

		// Configure logger report using 'cucumber.adapter.ExtentCucumberAdapter' for
		// cucumber version 4
		System.setProperty("extent.reporter.logger.start", "true");
		System.setProperty("extent.reporter.logger.config", Constants.REPORT_CONFIG);
		System.setProperty("extent.reporter.logger.out", Constants.LOGGER_REPORT_PATH + Constants.LOGGER_REPORT_NAME);
	}
}
