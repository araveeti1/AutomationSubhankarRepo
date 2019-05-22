package com.w2a.pages.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.w2a.base.Page;
import com.w2a.pages.locators.TopNavigationLocator;

// As this class in encapsulated in Page class, we cannot extend Page class here.
// So we will pass the driver reference fromPage.java itself as a parameter and will also parameterize the constructor here for the same.
public class TopNavigation {

	public TopNavigationLocator toplocator;

	public TopNavigation(WebDriver driver) {

		this.toplocator = new TopNavigationLocator();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 20);
		PageFactory.initElements(factory, this.toplocator);
	}

	public void gotoAccountButton() {

		Page.click(toplocator.accountButton);
		Page.log.debug("Clicked on the 'Account' button at the top menu");
		
	}

	// As clicking on Sign In Button redirects us to the signin dialog box, it means
	// that this method returns an object of the SignInPage class.
	public SignInPage gotoSignIn() {

		Page.click(toplocator.signInButton);
		Page.log.debug("Clicked on the 'Sign In' button from the Account submenu");
		return new SignInPage();
	}

	public void gotoCreateAccount() {

	}

	public void gotoMyLists() {

	}

	public void gotoSupport() {

	}

	public void gotoManageTrips() {

	}

	public void gotoHome() {

	}

	public void gotoFlights() {

	}

	public void gotoFlightAndHotels() {

	}
}
