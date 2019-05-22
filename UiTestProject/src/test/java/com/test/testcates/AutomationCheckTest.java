package com.test.testcates;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.base.BaseTestClass;
import com.test.util.TestUtilClass;

public class AutomationCheckTest extends BaseTestClass {
	
	@Test
	public void automationCheckTest() throws InterruptedException {

		logger.debug("Testcases for Automation Test is initiated");
		Thread.sleep(1000);
		type("username_CSS", "Subhankar Mukherjee");
		type("usermail_CSS", "abc@xyz.com");
		type("userphone_CSS", "12365");
		type("useraddress_XPATH", "India");
		select("testtype_CSS", "Test Type");
		select("framwork_CSS", "Framework");
		click("submitbtn_XPATH");
		
	}

}
