package com.w2a.rough;

import com.w2a.base.Page;
import com.w2a.pages.actions.SignInPage;

public class SignInTest {

	public static void main(String[] args) throws InterruptedException {

		Page.initConfiguration();
		Page.topNav.gotoAccountButton();
		Thread.sleep(2000);
		// As topNav.gotoSignIn() does return an object of SignInPage, we can directly
		// initialize an object of SignInPage using the returned value from
		// topNav.gotoSignIn() .
		SignInPage signin = Page.topNav.gotoSignIn();
		Thread.sleep(2000);
		signin.doLogin("abcd@gmail.com", "Xck!2k18");
		
		try {
			Page.closeBrowser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(2000);
	}

}
