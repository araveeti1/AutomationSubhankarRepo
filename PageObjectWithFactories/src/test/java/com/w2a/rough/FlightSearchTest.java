package com.w2a.rough;

import com.w2a.base.Page;
import com.w2a.pages.actions.HomePage;

public class FlightSearchTest {

	public static void main(String[] args) throws InterruptedException {

		Page.initConfiguration();
		// HomePage home = PageFactory.initElements(driver, HomePage.class);
		// As we have initiated PageFactory in Home Page already.
		HomePage home = new HomePage();
		home.gotoFlights().bookAFlight("one way", "Kolkata", "Delhi", "12/05/2019", "15/05/2019", "3", "2", "12", "9");

		try {
			Page.closeBrowser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(5000);
	}

}
