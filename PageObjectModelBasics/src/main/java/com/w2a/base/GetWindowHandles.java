package com.w2a.base;
/*
 * @Author -Subhankar Mukherjee
 * 
 * 
 */
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

public class GetWindowHandles {

	WebDriver driver;

	public GetWindowHandles(WebDriver ldriver) {
		this.driver = ldriver;
	}

	public void getWindowHandles() {

		System.out.println("The Parent window URL is: " + driver.getCurrentUrl());
		ArrayList<String> availableWindows = new ArrayList<String>(driver.getWindowHandles());
		/*if (!availableWindows.isEmpty()) {
			driver.switchTo().window(availableWindows.get(1));
		}*/
		if (availableWindows.isEmpty()) {
			
			System.out.println("No child window available!!");
		}
		else
		{
			driver.switchTo().window(availableWindows.get(1));
		}
		System.out.println("Navigated to the child window");
		System.out.println("The Child window URL is: " + driver.getCurrentUrl());
	}

}
