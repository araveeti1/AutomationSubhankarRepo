package com.w2a.suite.customer.test;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.w2a.utilities.Constants;
import com.w2a.utilities.DataProviders;
import com.w2a.utilities.DataUtil;
import com.w2a.utilities.ExcelReaderClass;

public class AddCustomerTest {

	@Test(dataProviderClass = DataProviders.class, dataProvider = "customerTestDP")
	public void addCustomerTest(Hashtable<String, String> data) {

		ExcelReaderClass excel = new ExcelReaderClass(Constants.SUITE2_XLSX_PATH);
		DataUtil.checkExecution(Constants.TESTSUITE1_NAME, Constants.TESTCASE1_NAME, data.get("Runmode"), excel);

//		System.out.println("Printing com.w2a.suite.customer.test.AddCustomerTest");
//		System.out.println(data.get("Runmode") + "-----" + data.get("firstname") + "-----" + data.get("lastname")
//				+ "-----" + data.get("postcode"));

	}
}
