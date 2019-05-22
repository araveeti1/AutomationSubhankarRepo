package com.w2a.pages;

import org.openqa.selenium.By;
import com.w2a.base.Page;

public class LoginPage extends Page {

	// This below method is responsible for taking us to the zoho app page. So, this
	// method should return an object of zoho app page.
	public ZohoAppPage doLogin(String userName, String passWord) {

		type("emailid_CSS", userName);
		type("password_CSS", passWord);
		click("checkbox_CSS");
		click("submitbtn_CSS");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.cssSelector("#all-apps")).click();
		return new ZohoAppPage();
	}

}
