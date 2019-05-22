package com.w2a.suite.customer.test;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.w2a.utilities.Constants;
import com.w2a.utilities.DataProviders;
import com.w2a.utilities.DataUtil;
import com.w2a.utilities.ExcelReaderClass;

public class OpenAccountTest {

	@Test(dataProviderClass = DataProviders.class, dataProvider = "customerTestDP")
	public void openAccountTest(Hashtable<String, String> data) {

		ExcelReaderClass excel = new ExcelReaderClass(Constants.SUITE2_XLSX_PATH);
		DataUtil.checkExecution(Constants.TESTSUITE2_NAME, Constants.TESTCASE2_NAME, data.get("Runmode"), excel);
		
//		System.out.println("Printing com.w2a.suite.customer.test.openAccountTest");
//		System.out.println(data.get("Runmode") + "-----" + data.get("customer") + "-----" + data.get("currency"));

	}
}
