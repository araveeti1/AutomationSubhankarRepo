package com.w2a.pages;

import com.w2a.base.Page;

public class HomePage extends Page {

	public void goToSignUp() {

		click("gotosignup_CSS");
	}

	// This below method is responsible for taking us to the login page. So this
	// method should return an object of the login page.
	public LoginPage goToLogin() {

		click("gotologin_CSS");
		return new LoginPage();

	}

	public void goToSupport() {

		click("gotosupport_CSS");
	}

	public void goToContactSales() {

		click("gotocontactsales_CSS");
	}

	public void goToCustomers() {

		click("gotocustomers_CSS");
	}

	public void goToLearnMore() {

		click("gotolearnmore_CSS");
	}

	public void validateFooterLinks() {

	}
}
