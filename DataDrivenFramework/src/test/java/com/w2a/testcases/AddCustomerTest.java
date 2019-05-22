package com.w2a.testcases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class AddCustomerTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void addCustomerTest(Hashtable<String, String> data) throws InterruptedException {

		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}

		click("addcust_CSS");
		type("firstname_CSS", data.get("First Name"));
		type("lastname_XPATH", data.get("Last Name"));
		type("postcode_CSS", data.get("Postcode"));
		Thread.sleep(1000);
		click("addbtn_CSS");

		/* It will check the presence of the alertclass object using explicit wait */
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//		Alert alert = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		/*
		 * Using here testng assertion to verify that the alert conatins the expected
		 * alert text
		 */
		Assert.assertTrue(alert.getText().contains(data.get("Alert")));
		Thread.sleep(1000);

		/*
		 * After finding the alert and verifying the alert test, need to accept the
		 * alert and close it
		 */
		alert.accept();

		Thread.sleep(1000);
//		Assert.fail("Add Customer failed");
	}

}
