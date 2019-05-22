package com.w2a.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.w2a.base.Page;
import com.w2a.pages.actions.SignInPage;
import com.w2a.utilities.Utilities;

public class SignInTest {

	@Test(dataProviderClass = Utilities.class, dataProvider = "dp", priority = 1)
	public void signInTest(Hashtable<String, String> data) throws InterruptedException {

		if (!data.get("runmode").equalsIgnoreCase("Y")) {

			throw new SkipException("Skipping the the test as runmode in NO");
		}
		Page.initConfiguration();
		Page.topNav.gotoAccountButton();

		// As topNav.gotoSignIn() does return an object of SignInPage, we can directly
		// initialize an object of SignInPage using the returned value from
		// topNav.gotoSignIn() .
		SignInPage signin = Page.topNav.gotoSignIn();
		Thread.sleep(2000);
		signin.doLogin(data.get("username"), data.get("password"));

	}

	@AfterMethod
	public void tearDown() throws Exception {
		Page.closeBrowser();
	}

}
