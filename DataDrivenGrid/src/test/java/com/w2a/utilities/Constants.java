package com.w2a.utilities;

import java.util.Date;

public class Constants {
	
	public static String REMOTE_HUB_URL="http://localhost:4488/wd/hub";

	public static String DATA_SHEET = "TestData";

	public static String TESTCASE_COL = "TestCases";
	public static String TESTCASE_SHEET = "TestCases";
	public static String TESTCASE1_NAME= "AddCustomerTest";
	public static String TESTCASE2_NAME= "OpenAccountTest";

	public static String SUITE_SHEET = "Suite";
	public static String SUITENAME_COL = "SuiteName";
	public static String TESTSUITE1_NAME= "BankManagerSuite";
	public static String TESTSUITE2_NAME= "CustomerTestSuite";

	public static String RMODENAME_COL = "Runmode";
	public static String RUNMODE_YES = "Y";
	public static String RUNMODE_NO = "N";

	public static String SUITE_XLSX_PATH = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\testdata\\SuiteRun.xlsx";
	public static String SUITE1_XLSX_PATH = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\testdata\\BankManagerSuite.xlsx";
	public static String SUITE2_XLSX_PATH = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\testdata\\CustomerTestSuite.xlsx";

	public static String SCREENSHOT_PATH = System.getProperty("user.dir") + "\\reports\\";
}
