package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
// @CucumberOptions is an annotation that helps locating and running of several types of files associated with cucumber. 
// features={"path of the package containing feature files"} .
// glue = {"name of the package containing step files"}.
// monochrome defines the formatting of the output.
// tags runs the feature file/files with the tag mentioned.
// plugin = {"pretty","html:target/cucumber"} --> generates a HTML report.
@CucumberOptions(features = { "src/main/java/featurefiles" }, glue = {
		"steps" }, monochrome = true, tags = { "@sanity, @bvt" },
		/* plugin = { "pretty", "html:target/cucumber"}) */
		snippets = SnippetType.CAMELCASE, plugin = { "pretty", "html:target/cucumber",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })
public class RunCuke {


	
}
