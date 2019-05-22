package com.w2a.utilities;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParameterization {

	@Test(dataProvider = "getData")
	/*
	 * The number of parameter= number of columns. While implementing Hashtable, we
	 * are passing only one parameter so the declaration of Hashtable should have
	 * only one column.
	 */
	public void testData(Hashtable<String, String> data) {

		System.out.println(data.get("Runmode") + "-----" + data.get("firstname") + "-----" + data.get("lastname")
				+ "-----" + data.get("postcode"));

	}

	@DataProvider
	public Object[][] getData() {

		ExcelReaderClass exl = new ExcelReaderClass(
				System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\BankManagerSuite.xlsx");

		int rows = exl.getRowCount(Constants.DATA_SHEET);
		int cols = exl.getColumnCount(Constants.DATA_SHEET);
		System.out.println("Total Rows: " + rows + " and " + "Total Columns: " + cols + " are present in the Sheet");

//		String testName = "OpenAccountTest";
		String testName = "AddCustomerTest";
		int testCaseRowNum = 1;

		for (testCaseRowNum = 1; testCaseRowNum < rows; testCaseRowNum++) {

			String testCaseName = exl.getCellData(Constants.DATA_SHEET, 0, testCaseRowNum);
			if (testCaseName.equalsIgnoreCase(testName)) {

				break;
			}
		}
		System.out.println("The test case start fom Row number= " + testCaseRowNum);

		// Checking total rows in testcase
		// This below variable tracks from where the test data starts
		int dataStartRowNum = testCaseRowNum + 2;
		System.out.println("Test Data starts from row: " + dataStartRowNum);

		int testRows = 0;
		/* It will iterate and check until it finds a blank row */
		while (!exl.getCellData(Constants.DATA_SHEET, 0, dataStartRowNum + testRows).equals("")) {

			testRows++;
		}

		System.out.println("Total Rows of data are: " + testRows);

		// Checking total columns in the test

		int colStartColNum = testCaseRowNum + 1;
		int testColNum = 0;

		while (!exl.getCellData(Constants.DATA_SHEET, testColNum, colStartColNum).equals("")) {

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

				// System.out.println(exl.getCellData(Constants.DATA_SHEET, cNum, rNum));
				// data[rNum - dataStartRowNum][cNum] = exl.getCellData(Constants.DATA_SHEET,
				// cNum, rNum);

				/*
				 * Here we are iterating on the rows to get the test data as 'Value' in the
				 * Hashtable
				 */
				String testData = exl.getCellData(Constants.DATA_SHEET, cNum, rNum);

				/*
				 * Here we are iterating on the column name to get the column name as the 'Key'
				 * value. The variable colStartColNum holds the value of the columns that
				 * iterates and provides Key values.
				 */
				String colName = exl.getCellData(Constants.DATA_SHEET, cNum, colStartColNum);

				/* Now mapping Keys with a Value */
				table.put(colName, testData);
			}
			data[i][0] = table;
			i++;
		}
		return data;

	}

}
