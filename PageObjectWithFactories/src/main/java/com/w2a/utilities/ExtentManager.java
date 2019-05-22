package com.w2a.utilities;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports getInstance() {

		Date d = new Date();
		String reportName = "extent_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";

		if (extent == null) {
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
					System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + reportName);
			htmlReporter.loadXMLConfig(System.getProperty("user.dir")
					+ "\\src\\test\\resources\\com\\w2a\\extentconfig\\ReportsConfig.xml");
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
		}

		return extent;
	}

}