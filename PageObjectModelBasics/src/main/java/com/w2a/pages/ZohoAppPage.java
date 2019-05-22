package com.w2a.pages;

import com.w2a.base.Page;
import com.w2a.pages.crm.CRMHomePage;

public class ZohoAppPage extends Page {

	// This below method is responsible for taking us to the CRM home page. So, this
	// method should return an object of CRM home page.
	public CRMHomePage gotoCRM() {

		click("gotocrm_XPATH");

		return new CRMHomePage();
	}

	public void gotoMail() {

		click("gotomail_XPATH");

	}

	public void gotoCreator() {

		click("gotocreator_XPATH");

	}

	public void gotoBooks() {

		click("gotobooks_XPATH");

	}

	public void gotoDesk() {

		click("gotodesk_XPATH");

	}
}
