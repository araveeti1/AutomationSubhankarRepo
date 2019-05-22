package com.w2a.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.w2a.base.Page;
import com.w2a.errorcollectors.ErrorCollector;
import com.w2a.pages.actions.HomePage;
import com.w2a.utilities.Utilities;

public class FlightSearchTest {

	@Test(dataProviderClass = Utilities.class, dataProvider = "dp", priority = 2)
	public void flightSearchTest(Hashtable<String, String> data) throws InterruptedException {

		if (!data.get("runmode").equalsIgnoreCase("Y")) {

			throw new SkipException("Skipping the test as the runmode is NO");
		}
		Page.initConfiguration();
		// HomePage home = PageFactory.initElements(driver, HomePage.class);
		// As we have initiated PageFactory in Home Page already.
		HomePage home = new HomePage();

		// This is a hard assertion.The test fails when this assertion fails.
		// Assert.assertEquals(home.findTabCount(), 6);

		// We will now implement soft assertion. So if the there is an assertion error
		// for one step, the whole test should not fail.

		ErrorCollector.verifyEquals(home.findTabCount(), 7);
		home.gotoFlights().bookAFlight(data.get("journeytype"), data.get("from"), data.get("to"),
				data.get("departingdate"), data.get("returingdate"), data.get("noofadults"), data.get("noofchildren"),
				data.get("ageofchild1"), data.get("ageofchild2"));

	}

	
	@AfterMethod
	public void tearDown() throws Exception {
		Page.closeBrowser();
	}

}
