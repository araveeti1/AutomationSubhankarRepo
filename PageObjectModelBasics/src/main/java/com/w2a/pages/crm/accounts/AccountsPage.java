package com.w2a.pages.crm.accounts;

import com.w2a.base.Page;

public class AccountsPage extends Page {

	// This below method is responsible for taking us to the Create Account page.
	// So,
	// this method should return an object of Create Account home page.
	public CreateAccounts gotoCreateAccounts() {

		click("gotocreateaccounts_XPATH");
		System.out.println("Clicked on create account page!!");
		return new CreateAccounts();

	}

	public void gotoImportAccounts() {

		click("gotoimportaccounts_XPATH");
		System.out.println("Clicked on import account page!!");
	}

}
