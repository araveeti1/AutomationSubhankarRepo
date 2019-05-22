package com.test.util;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import com.test.base.BaseTestClass;
import org.apache.commons.io.FileUtils;

public class TestUtilClass extends BaseTestClass {

	public static String screenshotName;
	public static String screenshotPath;

	public static void takeScreenshot(WebDriver driver) {

		Date date = new Date();
		screenshotName = date.toString().replace(":", "_").replace(" ", "_")+ ".PNG";
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File(
				System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName);
		try {
			FileUtils.copyFile(sourceFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Screenshot Capture Failed!!");
		}
	}

	public static String takeScreenshot(WebDriver driver, String outputscrShot) {

		screenshotPath = System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\";

		Date date = new Date();
		screenshotName = date.toString().replace(":", "_").replace(" ", "_") + ".PNG";

		outputscrShot = screenshotPath + screenshotName;

		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File(outputscrShot);

		try {
			FileUtils.copyFile(sourceFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Screenshot Capture Failed!!");
		}

		return outputscrShot;

	}

//	@DataProvider(name = "testdata")
//	public Object[][] getData(Method m) {
//
//		String sheetName = m.getName();
//		int rows = exl.getRowCount(sheetName);
//		int cols = exl.getColumnCount(sheetName);
//
//		Object[][] data = new Object[rows - 1][1];
//
//		Hashtable<String, String> table = null;
//
//		for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2
//
//			table = new Hashtable<String, String>();
//
//			for (int colNum = 0; colNum < cols; colNum++) {
//
//				// data[0][0]
//				table.put(exl.getCellData(sheetName, colNum, 1), exl.getCellData(sheetName, colNum, rowNum));
//				data[rowNum - 2][0] = table;
//			}
//
//		}
//
//		return data;
//
//	}
}
