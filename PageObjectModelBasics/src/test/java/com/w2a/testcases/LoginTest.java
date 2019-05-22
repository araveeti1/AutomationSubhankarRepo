package com.w2a.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.base.Page;
import com.w2a.pages.HomePage;
import com.w2a.pages.LoginPage;
import com.w2a.utilities.Utilities;

public class LoginTest extends BaseTest {

	@Test(dataProviderClass = Utilities.class, dataProvider = "dp", priority = 1)
	public void loginTest(Hashtable<String, String> data) throws Exception {

		HomePage home = new HomePage();
		LoginPage login = home.goToLogin();
		login.doLogin(data.get("username"), data.get("password"));
		Thread.sleep(2000);
		
		Assert.fail("Just a dummy failure!");

	}
}
