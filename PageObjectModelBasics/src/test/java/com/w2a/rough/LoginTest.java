package com.w2a.rough;

import java.net.InetAddress;

import com.w2a.base.Page;
import com.w2a.pages.HomePage;
import com.w2a.pages.LoginPage;
import com.w2a.pages.ZohoAppPage;
import com.w2a.pages.crm.accounts.AccountsPage;
import com.w2a.pages.crm.accounts.CreateAccounts;

public class LoginTest {

	public static void main(String[] args) throws Exception {
	
//		HomePage home = new HomePage();
//		// Here .goToLogin() method from homepage returns an object of the LoginPage
//		LoginPage login = home.goToLogin();
//		// As .doLogin method from LoginPage returns an object of ZohoAppPage
//		ZohoAppPage apps =login.doLogin("subhamukh007@yahoo.in", "Rocksubh@007");
//		// As .gotoCRM() method from ZohoAppPage returns an object of the CRMHomePage
//		//CRMHomePage crmhome= apps.gotoCRM();
//		apps.gotoCRM();
//		Thread.sleep(5000);
//		Page.getwh.getWindowHandles();
//		// As .gotoAccounts() method from TopMenu returns an object of the AccountsPage
//		AccountsPage acp= Page.menu.gotoAccounts();
//		System.out.println("Clicked on Accounts");
//		Thread.sleep(2000);
//		// As .gotoCreateAccounts() method from AccountsPage returns an object of the CreateAccounts
//		CreateAccounts createAccount = acp.gotoCreateAccounts();
//		createAccount.createAccount("ABCD_TEST");
//		/*Page.menu.gotoContacts();
//		System.out.println("Clicked on Contacts");
//		Thread.sleep(2000);*/
//		Page.menu.signOut();
//		System.out.println("Sign Out successful");
		
		System.out.println(InetAddress.getLocalHost().getHostAddress());

	}

}
