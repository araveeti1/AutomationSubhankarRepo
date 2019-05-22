package steps;

import java.util.List;
import java.util.Map;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class LoginStep{

	// These @Before and @After when imported through cucumber apis, they are called
	// hooks.
	// These tags will help in execuiting the steps each time a scenario is called
	// from the associated feature file.
	// These after and before tags can be called 'n' number of times and can alsobe
	// parameterized.
	@Before
	public void setUp() {

		System.out.println("Launch a Browser");
		//test.log(LogStatus.INFO, "Launching a browser");
	}

	@After
	public void tearDown() {

		System.out.println("driver.quit()");
	}

	@Before("@prod1")
	public void setUpProd() {

		System.out.println("Launch a Browser on production");
		//test.log(LogStatus.INFO, "Launching a browser on production");
	}

	@After("@prod1")
	public void tearDownProd() {

		System.out.println("driver.quit() on production");
	}

	@Given("^user navigates to facebook website$")
	public void user_navigates_to_facebook_website() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("@Given-- User navigates to facebook.com");
		//test.log(LogStatus.INFO, "User navigates to the target URL");
	}

	@When("^user validates the homepage title$")
	public void user_validates_the_homepage_title() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("@When-- User validates the homepage title");
		//test.log(LogStatus.INFO, "User Validates the title");
	}

	@Then("^user entered the \"([^\"]*)\" username$")
	public void user_entered_the_valid_username(String usernameStatus) {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("@Then-- User entered the " + usernameStatus + " username");
		//test.log(LogStatus.INFO, "User enters the " + usernameStatus + " username");
	}

	@Then("^user entered the \"([^\"]*)\" password$")
	public void user_entered_the_valid_password(String passwordStatus) {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("@And-- User entered the " + passwordStatus + " password");
		//test.log(LogStatus.INFO, "User enters the " + passwordStatus + " password");
	}

	@Then("^user selects the age category$")
	public void user_selects_the_age_category(DataTable table) {
		// The below DataTable has some indexes as it is implemented with List<Map<Key,
		// Value>>.
		// | Age | Location | --> Key
		// |Below 18| India | --> Index 0
		// |Above 18| USA | --> Index 1
		// To select the value at index 1, we can use the statement--
		// 'data.get(<index number>).get("<object key>")'

		// Here we are taking a ordered collection type here.
		List<Map<String, String>> data = table.asMaps(String.class, String.class);

		System.out.println("@And-- User selects the age category: " + data.get(0).get("Age")
				+ " and selected location is: " + data.get(0).get("Location"));
		//test.log(LogStatus.INFO, "User selects the age category");
	}

	@Then("^user \"([^\"]*)\" successfully logged in$")
	public void user_should_be_successfully_logged_in(String loginStatus) {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("@And-- User " + loginStatus + " successfully logged in");
		//test.log(LogStatus.INFO, "User " + loginStatus + " successfully logged in");
	}

}
