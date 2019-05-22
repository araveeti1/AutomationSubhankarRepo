package com.w2a.pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import com.w2a.base.Page;
import com.w2a.pages.locators.HomePageLocators;

public class HomePage extends Page {

	public HomePageLocators homelocator;

	public HomePage() {

		// Here we are initializing Page Factory elements
		this.homelocator = new HomePageLocators();
		// AjaxElementLocatorFactory is used to define a lazy-wait, when the element is
		// being used by by other operation. Generally we define this wait while project
		// is using Page factory.
		AjaxElementLocatorFactory ajaxfactory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(ajaxfactory, this.homelocator);

	}

	// This method is returning an object of the HomePage itself. As clicking on
	// this element redirects us to the HomePage itself. So this methods has a
	// return type of HomePage as we discussed in POM.
	public HomePage gotoFlights() {

		// Here we have created another wrapper over our locators.
		click(homelocator.homepageFlightTab);
		return this;
	}

	public void bookAFlight(String journeyType, String from, String to, String departingDate, String returingDate,
			String noOfAdults, String noOfChildren, String ageofChild1, String ageofChild2) {

		if (journeyType.equalsIgnoreCase("return")) {
			click(homelocator.journeyReturn);
		} else if (journeyType.equalsIgnoreCase("one way")) {
			click(homelocator.journeyOneWay);
		}

		click(homelocator.flightOrigin);
		// homelocator.flightOrigin.sendKeys(from);
		type(homelocator.flightOrigin, from);
		click(homelocator.flightDestination);
		type(homelocator.flightDestination, to);

		if (journeyType.equalsIgnoreCase("return")) {
			type(homelocator.flightDeptDate, departingDate);
		} else if (journeyType.equalsIgnoreCase("one way")) {
			type(homelocator.flightDeptDateOneWay, departingDate);
		}
		if (journeyType.equalsIgnoreCase("return")) {
			type(homelocator.flightReturnDate, returingDate);
		}

		click(homelocator.travellerNumberButton);

		if (Integer.parseInt(noOfAdults) > 1) {
			for (int i = 1; i < Integer.parseInt(noOfAdults); i++) {

				click(homelocator.addAdult);
			}
			System.out.println(noOfAdults + " number of adults added ");
		}

		if (Integer.parseInt(noOfChildren) > 0) {
			for (int i = 0; i < Integer.parseInt(noOfChildren); i++) {

				click(homelocator.addChild);
			}
			System.out.println(noOfChildren + " number of children added ");
		}

		type(homelocator.ageOfChild1, ageofChild1);

		type(homelocator.ageOfChild2, ageofChild2);

		click(homelocator.submitBtn);

	}

	public void gotoHotels() {

	}

	public void gotoFlightsAndHotels() {

	}

	public void gotoCarHire() {

	}

	public void gotoHolidayActivities() {

	}

	public int findTabCount() {

		return homelocator.elementBlock.size();

	}

}
