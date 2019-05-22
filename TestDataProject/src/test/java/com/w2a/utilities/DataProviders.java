package com.w2a.utilities;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "bankManagerDP")
	public static Object[][] getDataSuite1(Method m) {

		/*
		 * Method 'm' returns the method under test. Here '.getName()' returns the name
		 * of the test method that is being executed.
		 */
		String testCaseName = m.getName();

		ExcelReaderClass excel = new ExcelReaderClass(Constants.SUITE1_XLSX_PATH);

		return DataUtil.getData(testCaseName, excel);

	}

	@DataProvider(name = "customerTestDP")
	public static Object[][] getDataSuite2(Method m) {

		/*
		 * Method 'm' returns the method under test. Here '.getName()' returns the name
		 * of the test method that is being executed.
		 */
		String testCaseName = m.getName();

		ExcelReaderClass excel = new ExcelReaderClass(Constants.SUITE2_XLSX_PATH);

		return DataUtil.getData(testCaseName, excel);

	}

	
}
