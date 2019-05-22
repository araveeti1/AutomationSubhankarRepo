package com.w2a.suite.bankmanager.test;

import java.net.MalformedURLException;
import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.w2a.datadriven.basepackage.TestBaseClass;
import com.w2a.utilities.Constants;
import com.w2a.utilities.DataProviders;
import com.w2a.utilities.DataUtil;
import com.w2a.utilities.ExcelReaderClass;

public class OpenAccountTest extends TestBaseClass {

	@Test(dataProviderClass = DataProviders.class, dataProvider = "bankManagerDP", priority = 2)
	public void openAccountTest(Hashtable<String, String> data) {

		super.setUp();
		test = report.createTest("Open Account Test" + " " + data.get("browser"));
		setExtentReport(test);
		ExcelReaderClass excel = new ExcelReaderClass(Constants.SUITE1_XLSX_PATH);
		DataUtil.checkExecution(Constants.TESTSUITE1_NAME, Constants.TESTCASE2_NAME, data.get("Runmode"), excel);

		try {
			openBrowser(data.get("browser"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		navigate("testsiteurl");
		click("bmlbtn_CSS");
		click("openacc_CSS");
		select("custid_CSS", data.get("customer"));
		select("currency_CSS", data.get("currency"));
		click("process_CSS");
		
//		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		alert.accept();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		reportPass("Open Account Test is passed");
	}

	@AfterMethod
	public void tearDown() {

		if (report != null) {

			report.flush();
		}

		getDriver().quit();
	}

}
