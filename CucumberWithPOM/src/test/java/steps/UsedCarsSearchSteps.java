package steps;

import java.util.List;

import pages.action.CarsGuideHomePageActions;
import pages.action.UsedCarsSearchPageActions;

import cucumber.api.java.en.Then;

public class UsedCarsSearchSteps {

	CarsGuideHomePageActions carsGuideHomeAction = new CarsGuideHomePageActions();
	UsedCarsSearchPageActions usedCarSearchAction = new UsedCarsSearchPageActions();

	@Then("I click on Used linktext")
	public void i_click_on_Used_linktext() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		carsGuideHomeAction.clickOnUsedCarsMenu();
	}

	@Then("I select the car model")
	public void i_select_the_car_model(List<String> list) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		String menu = list.get(1);
		System.out.println("The sected option is: " + menu);
		usedCarSearchAction.selectCarModel(menu);
	}

}
