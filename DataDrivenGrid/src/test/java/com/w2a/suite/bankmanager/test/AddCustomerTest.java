package com.w2a.suite.bankmanager.test;

import java.net.MalformedURLException;
import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.w2a.datadriven.basepackage.TestBaseClass;
import com.w2a.utilities.Constants;
import com.w2a.utilities.DataProviders;
import com.w2a.utilities.DataUtil;
import com.w2a.utilities.ExcelReaderClass;

public class AddCustomerTest extends TestBaseClass {

	@Test(dataProviderClass = DataProviders.class, dataProvider = "bankManagerDP", priority = 1)
	public void addCustomerTest(Hashtable<String, String> data) {

		super.setUp();
		test = report.createTest("Add Customer Test" + " " + data.get("browser"));
		setExtentReport(test);
		ExcelReaderClass excel = new ExcelReaderClass(Constants.SUITE1_XLSX_PATH);
		DataUtil.checkExecution(Constants.TESTSUITE1_NAME, Constants.TESTCASE1_NAME, data.get("Runmode"), excel);

		try {
			openBrowser(data.get("browser"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		navigate("testsiteurl");

		click("bmlbtn_CSS");
		click("addcust_CSS");
		type("firstname_CSS", data.get("firstname"));
		type("lastname_XPATH", data.get("lastname"));
		type("postcode_CSS", data.get("postcode"));
		click("addbtn_CSS");
		
//		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		alert.accept();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		reportPass("Add Customer Test is passed");
//		Assert.fail();
//		reportFail("Add Customer Test is failed");
	}

	@AfterMethod
	public void tearDown() {

		if (report != null) {

			report.flush();
		}

		getDriver().quit();
	}

}
