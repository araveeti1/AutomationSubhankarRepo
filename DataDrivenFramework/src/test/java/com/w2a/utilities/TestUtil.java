package com.w2a.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import com.sun.media.jfxmedia.logging.Logger;
import com.w2a.base.TestBase;

public class TestUtil extends TestBase {

	public static String screenshotPath;
	public static String screenshotName;

	public static void captureScreenshot() throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		FileUtils.copyFile(scrFile,
				new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName));

	}

	public static String captureScreenshot(String screenPath) throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		screenshotPath = System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\";

		String outputscreenshot = screenshotPath + screenshotName;

		File destFile = new File(outputscreenshot);

		FileUtils.copyFile(scrFile, destFile);
		return outputscreenshot;

	}

	@DataProvider(name = "dp")
	public Object[][] getData(Method m) {

		String sheetName = m.getName();
		int rows = exl.getRowCount(sheetName);
		int cols = exl.getColumnCount(sheetName);
		/*
		 * Taking only one column as we will passing only one argument in our test
		 * cases. i.e- Object[][] obj
		 */
		Object[][] data = new Object[rows - 1][1];

		Hashtable<String, String> table = null;

		for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2
			/* For every row we are creating a hash table */
			table = new Hashtable<String, String>();

			for (int colNum = 0; colNum < cols; colNum++) {

				// data[0][0]
				/* getCellData(sheetName, colNum, 1) ==> For Key
				 * getCellData(sheetName, colNum, rowNum) ==> For Value
				 *  */
				table.put(exl.getCellData(sheetName, colNum, 1), exl.getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][0] = table;
			}

		}

		return data;

	}

	public static boolean isTestRunnable(String testName, ExcelReaderClass excel) {

		String sheetName = "test_suite";
		int rows = excel.getRowCount(sheetName);

		for (int rNum = 2; rNum <= rows; rNum++) {

			String testCase = excel.getCellData(sheetName, "TCID", rNum);

			if (testCase.equalsIgnoreCase(testName)) {

				String runmode = excel.getCellData(sheetName, "Runmode", rNum);

				if (runmode.equalsIgnoreCase("Y"))
					return true;
				else
					return false;
			}

		}
		return false;
	}

}
