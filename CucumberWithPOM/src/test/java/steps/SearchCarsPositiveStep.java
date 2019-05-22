package steps;

import java.util.List;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.action.CarsGuideHomePageActions;
import pages.action.CarsSearchPageActions;
import pages.base.Constants;
import utils.SeleniumDriverClass;

public class SearchCarsPositiveStep {

	CarsGuideHomePageActions carsGuideHomePageActions = new CarsGuideHomePageActions();
	CarsSearchPageActions carsSearchPageActions = new CarsSearchPageActions();

	@Given("I am on the homepage of {string} website")
	public void i_am_on_the_homepage_of_website(String baseURL) throws Throwable {

		SeleniumDriverClass.openPage(Constants.TESTSITE_URL);
	}

	@When("I move my cursor on menu bar")
	public void i_move_my_cursor_on_menu_bar(List<String> list) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.

		String menu = list.get(1);
		System.out.println("Menu selected: " + menu);
		carsGuideHomePageActions.moveToBuyAndSellMenu();

	}

	@Then("I click on Search Cars linktext")
	public void i_click_on_Search_Cars_linktext() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		carsGuideHomePageActions.clickOnSearchCarsMenu();
	}

	@Then("I select make as {string} from CarMaker dropdown")
	public void i_select_make_from_CarMaker_dropdown(String carMaker) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		carsSearchPageActions.selectCarMaker(carMaker);
	}

	@Then("I select the model as {string} from CarModel dropdown")
	public void i_select_the_model_from_CarModel_dropdown(String carModel) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		carsSearchPageActions.selectCarModel(carModel);
	}

	@Then("I select the location as {string} from CarLocation dropdown")
	public void i_select_the_location_from_CarLocation_dropdown(String carLocation) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		carsSearchPageActions.selectCarLocation(carLocation);
	}

	@Then("I select price as {string} from CarPrice dropdown")
	public void i_select_price_from_CarPrice_dropdown(String carPrice) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		carsSearchPageActions.selectCarPrice(carPrice);
	}

	@Then("I click on Find_My_Next_Car button")
	public void i_click_on_Find_My_Next_Car_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		carsSearchPageActions.clickOnFindCarBtn();
	}

	@Then("I should see the list of searched cars")
	public void i_should_see_the_list_of_searched_cars() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		System.out.println("The list of car is shown!");
	}

	@Then("The page title should be {string}")
	public void the_page_title_should_be(String expected_title) throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		String actual_title = SeleniumDriverClass.getDriver().getTitle();
		Assert.assertEquals(actual_title, expected_title);

	}

}
