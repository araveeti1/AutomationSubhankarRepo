package com.w2a.suite.bankmanager.test;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.w2a.utilities.Constants;
import com.w2a.utilities.DataProviders;
import com.w2a.utilities.DataUtil;
import com.w2a.utilities.ExcelReaderClass;

public class OpenAccountTest {

	@Test(dataProviderClass = DataProviders.class, dataProvider = "bankManagerDP")
	public void openAccountTest(Hashtable<String, String> data) {

		ExcelReaderClass excel = new ExcelReaderClass(Constants.SUITE1_XLSX_PATH);
		System.out.println("Suite: " + DataUtil.isSuiteRunable("BankManagerSuite"));
		System.out.println("Is the test runable: " + DataUtil.isTestRunable("OpenAccountTest", excel));
		System.out.println("Runmode for Test Data: "+ data.get("Runmode"));
	
		
//		System.out.println("Printing com.w2a.suite.bankmanager.test.OpenAccountTest");
//		System.out.println(data.get("Runmode") + "-----" + data.get("customer") + "-----" + data.get("currency"));

	}
}
