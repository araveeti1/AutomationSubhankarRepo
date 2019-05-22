package com.test.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.test.base.BaseTestClass;

public class ExtentManager extends BaseTestClass {

	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null)
			createInstance(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\extent.html");

		return extent;
	}

	public static ExtentReports createInstance(String fileName) {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		htmlReporter.loadXMLConfig(
				System.getProperty("user.dir") + "\\src\\test\\resources\\extentconfig\\ExtentProperties.xml");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		return extent;
	}
}
