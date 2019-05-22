package com.w2a.utilities;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {

			Date d = new Date();
			String extentrep = "jenkins_"+d.toString().replace(":", "_").replace(" ", "_") + ".html";
			createInstance(System.getProperty("user.dir") + "\\reports\\" + extentrep);
		}

		return extent;
	}

	public static void createInstance(String fileName) {

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		htmlReporter.loadXMLConfig(
				System.getProperty("user.dir") + "\\src\\test\\resources\\extentconfig\\ReportsConfig.xml");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

	}
}