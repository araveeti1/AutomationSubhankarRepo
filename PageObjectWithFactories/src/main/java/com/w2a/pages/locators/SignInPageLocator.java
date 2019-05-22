package com.w2a.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class SignInPageLocator {
	
	@FindBy(css = "#gss-signin-email")
	@CacheLookup
	public WebElement loginEmail;

	@FindBy(css = "#gss-signin-password")
	@CacheLookup
	public WebElement loginPass;
	
	@FindBy(css = "#gss-keep-signin-check")
	@CacheLookup
	public WebElement keepSignedIn;
	
	@FindBy(css = "#gss-signin-submit")
	@CacheLookup
	public WebElement signInBtn;
	
}
