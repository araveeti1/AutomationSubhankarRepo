package com.w2a.base;
/*
 * @Author: Subhankar Mukherjee
 * 
 * 
 */

import org.openqa.selenium.WebDriver;
import com.w2a.pages.crm.accounts.AccountsPage;

//As this class is encapsulated in Page class. We can't extend page class here.
//So for calling the driver instance from Page class, we have to follow other ways. 
public class TopMenu {

	Page page = new Page();
	
	WebDriver driver;

	public TopMenu(WebDriver ldriver) {

		this.driver = ldriver;
	}

	public void gotoHome() {

	}

	public void gotoLeads() {

	}

	public void gotoContacts() {

		page.click("gotocontacts_CSS");
	}

	// This below method is responsible for taking us to the Accounts home page. So, this
	// method should return an object of Accounts home page.
	public AccountsPage gotoAccounts() {

		page.click("gotoaccounts_CSS");
		return new AccountsPage();
	}

	public void gotoDeals() {

	}

	public void gotoActivities() {

	}

	public void gotoReports() {

	}

	public void gotoAnalytics() {

	}

	public void gotoProjects() {

	}

	public void signOut() {

		page.click("usericon_CSS");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		page.click("signout_LINKTEXT");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
