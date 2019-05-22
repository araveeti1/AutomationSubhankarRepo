package com.w2a.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.w2a.base.Page;
import com.w2a.pages.ZohoAppPage;
import com.w2a.pages.crm.accounts.AccountsPage;
import com.w2a.pages.crm.accounts.CreateAccounts;
import com.w2a.utilities.Utilities;

public class CreateAccountTest extends BaseTest {

	@Test(dataProviderClass = Utilities.class, dataProvider = "dp", priority = 2)
	public void createAccountTest(Hashtable<String, String> data) throws InterruptedException {

		ZohoAppPage apps =new ZohoAppPage();
		apps.gotoCRM();
		Thread.sleep(2000);
		Page.getwh.getWindowHandles();
		AccountsPage acp = Page.menu.gotoAccounts();
		System.out.println("Clicked on Accounts");
		Thread.sleep(2000);
		CreateAccounts createAccount = acp.gotoCreateAccounts();
		createAccount.createAccount(data.get("accountname"));
		Thread.sleep(2000);
		Page.menu.signOut();
		System.out.println("Sign Out successful");
	}

}
