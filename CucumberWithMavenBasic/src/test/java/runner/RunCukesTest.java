//package runner;
//
//import cucumber.api.CucumberOptions;
//import cucumber.api.SnippetType;
//import cucumber.api.junit.Cucumber;
//import utils.ExtentManager;
//
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.runner.RunWith;
//import base.Page;
//
//@RunWith(Cucumber.class)
//@CucumberOptions(features = { "src/featurefiles" }, glue = { "steps" }, monochrome = true, tags = {
//		"@sanity, @bvt" }, snippets = SnippetType.CAMELCASE, plugin = { "pretty", "html:output/html-report",
//				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })
//public class RunCukesTest extends Page {
//
//	
//	@BeforeClass
//	public static void setUp() {
//
//		test = rep.createTest("Cucumber Test Suite Started!!");
//
//	}
//	
//	@AfterClass
//	public static void tearDown() {
//		
//		// User provided system informations can be added here.
//		rep.setSystemInfo("User", System.getProperty("user.name"));
//		rep.setSystemInfo("OS Version", "Windows 10");
//		rep.setSystemInfo("Browser Name", "Chrome");
//		rep.setSystemInfo("Browser Version", "74.0.3729.131");
//		rep.setSystemInfo("Selenium Version", "3.9.1");
//		rep.flush();
//	}
//}