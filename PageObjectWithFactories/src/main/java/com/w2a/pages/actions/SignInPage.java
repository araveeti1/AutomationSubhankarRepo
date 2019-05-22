package com.w2a.pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.w2a.base.Page;
import com.w2a.pages.locators.SignInPageLocator;

public class SignInPage extends Page {

	public SignInPageLocator signinlocator;

	public SignInPage() {

		// Here we are initializing Page Factory elements
		this.signinlocator = new SignInPageLocator();
		// AjaxElementLocatorFactory is used to define a lazy-wait, when the element is
		// being used by by other operation. Generally we define this wait while project
		// is using Page factory.
		AjaxElementLocatorFactory ajaxfactory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(ajaxfactory, this.signinlocator);

	}

	public void doLogin(String userName, String userPass) throws InterruptedException {

		type(signinlocator.loginEmail, userName);
		type(signinlocator.loginPass, userPass);
		
		if (signinlocator.keepSignedIn.isEnabled()) {
			click(signinlocator.keepSignedIn);
		}
		click(signinlocator.signInBtn);
		log.debug("Clicked on Sign In!!");
	}

}
