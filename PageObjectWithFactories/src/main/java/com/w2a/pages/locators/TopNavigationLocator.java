package com.w2a.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class TopNavigationLocator {
	
	@FindBy(css = "#header-account-menu")
	@CacheLookup
	public WebElement accountButton;
	
	@FindBy(css = "#account-signin")
	@CacheLookup
	public WebElement signInButton;

}
