package com.w2a.utilities;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;

public class DataUtil {

	public static void checkExecution(String testSuiteName, String testCaseName, String dataRunMode,
			ExcelReaderClass excel) {

		if (!isSuiteRunable(testSuiteName)) {

			throw new SkipException("Skipping the test " + testCaseName + " as the Runmode of the Test Suite "
					+ testSuiteName + " is: No ");
		}

		if (!isTestRunable(testCaseName, excel)) {

			throw new SkipException("Skipping the test " + testCaseName + "as the Runmode of the Test Case "
					+ testCaseName + "is: No ");
		}
		
		if(dataRunMode.equalsIgnoreCase(Constants.RUNMODE_NO)) {
			
			throw new SkipException("Skipping the test "+testCaseName+ " As the the Runmode is: No");
		}
	}

	public static boolean isSuiteRunable(String suiteName) {

		ExcelReaderClass excel = new ExcelReaderClass(Constants.SUITE_XLSX_PATH);

		int rows = excel.getRowCount(Constants.SUITE_SHEET);

		for (int rNum = 2; rNum <= rows; rNum++) {

			String data = excel.getCellData(Constants.SUITE_SHEET, Constants.SUITENAME_COL, rNum);

			if (data.equals(suiteName)) {

				String runmode = excel.getCellData(Constants.SUITE_SHEET, Constants.RMODENAME_COL, rNum);

				if (runmode.equals(Constants.RUNMODE_YES)) {

					return true;

				} else {

					return false;
				}
			}
		}
		return false;
	}

	public static boolean isTestRunable(String testCaseName, ExcelReaderClass excel) {

		int rows = excel.getRowCount(Constants.TESTCASE_SHEET);

		for (int rNum = 2; rNum <= rows; rNum++) {

			String data = excel.getCellData(Constants.TESTCASE_SHEET, Constants.TESTCASE_COL, rNum);

			if (data.equals(testCaseName)) {

				String runmode = excel.getCellData(Constants.TESTCASE_SHEET, Constants.RMODENAME_COL, rNum);

				if (runmode.equals(Constants.RUNMODE_YES)) {

					return true;

				} else {

					return false;
				}
			}
		}
		return false;
	}

	@DataProvider
	public static Object[][] getData(String testCase, ExcelReaderClass excel) {

		int rows = excel.getRowCount(Constants.DATA_SHEET);
		int cols = excel.getColumnCount(Constants.DATA_SHEET);
		System.out.println("Total Rows: " + rows + " and " + "Total Columns: " + cols + " are present in the Sheet");

		String testName = testCase;

		int testCaseRowNum = 1;
		for (testCaseRowNum = 1; testCaseRowNum < rows; testCaseRowNum++) {

			String testCaseName = excel.getCellData(Constants.DATA_SHEET, 0, testCaseRowNum);
			if (testCaseName.equalsIgnoreCase(testName)) {

				break;
			}
		}
		System.out.println("The test case " + testName + " starts fom Row number= " + testCaseRowNum);

		// Checking total rows in testcase
		// This below variable tracks from where the test data starts
		int dataStartRowNum = testCaseRowNum + 2;
		System.out.println("Test Data starts from row: " + dataStartRowNum);

		int testRows = 0;
		/* It will iterate and check until it finds a blank row */
		while (!excel.getCellData(Constants.DATA_SHEET, 0, dataStartRowNum + testRows).equals("")) {

			testRows++;
		}

		System.out.println("Total Rows of data are: " + testRows);

		// Checking total columns in the test

		int colStartColNum = testCaseRowNum + 1;
		int testColNum = 0;
		while (!excel.getCellData(Constants.DATA_SHEET, testColNum, colStartColNum).equals("")) {

			testColNum++;
		}

		System.out.println("Total Cols of data are: " + testColNum);

		// Printing Data
		// Here implementing Hashtable so Column=1
		Object[][] data = new Object[testRows][1];

		int i = 0;

		for (int rNum = dataStartRowNum; rNum < dataStartRowNum + testRows; rNum++) {

			Hashtable<String, String> table = new Hashtable<String, String>();

			for (int cNum = 0; cNum < testColNum; cNum++) {

				/*
				 * Here we are iterating on the rows to get the test data as 'Value' in the
				 * Hashtable
				 */
				String testData = excel.getCellData(Constants.DATA_SHEET, cNum, rNum);

				/*
				 * Here we are iterating on the column name to get the column name as the 'Key'
				 * value. The variable colStartColNum holds the value of the columns that
				 * iterates and provides Key values.
				 */
				String colName = excel.getCellData(Constants.DATA_SHEET, cNum, colStartColNum);

				/* Now mapping Keys with a Value */
				table.put(colName, testData);
			}
			data[i][0] = table;
			i++;
		}
		return data;

	}

}
