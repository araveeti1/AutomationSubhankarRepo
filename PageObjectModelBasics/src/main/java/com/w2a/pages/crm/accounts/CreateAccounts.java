package com.w2a.pages.crm.accounts;

import com.w2a.base.Page;

public class CreateAccounts extends Page {

	public void createAccount(String accountName) {

		type("createaccount_CSS", accountName);

	}

}
