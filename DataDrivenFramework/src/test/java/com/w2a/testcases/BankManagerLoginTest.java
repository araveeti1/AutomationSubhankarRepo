package com.w2a.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.By;
import com.w2a.base.TestBase;

public class BankManagerLoginTest extends TestBase {

	@Test(priority=0)
	public void bankManagerLoginTest() throws Exception {
		
		BasicConfigurator.configure();
		verifyEquals("ADC", "XYZ");
		log.debug("Inside login test case !!!");
		Thread.sleep(1000);
		//driver.findElement(By.cssSelector(objrep.getProperty("bmlbtn"))).click();
		click("bmlbtn_CSS");
		Thread.sleep(1000);
		log.debug("Bank Manager Login successful !!!");
		
//		Assert.fail("Test not successful");

	}
}
