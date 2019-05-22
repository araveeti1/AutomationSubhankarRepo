package com.test.testcates;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.base.BaseTestClass;
import com.test.util.TestUtilClass;

public class ManualCheckTest extends BaseTestClass {
	
	@Test()
	public void manualCheckTest() {
		
		logger.debug("Testcases for Manual Test check initiated");
		type("username_CSS", "Rakesh Nair");
		type("usermail_CSS", "ser@abc.com");
		type("userphone_CSS", "426358");
		type("useraddress_XPATH", "England");
		select("testtype_CSS", "Manual");
		click("submitbtn_XPATH");
		
		Assert.fail("This is a failure");
		
	}

}
