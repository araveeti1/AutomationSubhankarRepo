package com.w2a.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.Status;
import com.w2a.datadriven.basepackage.TestBaseClass;

public class TestUtil extends TestBaseClass {

	public static String screenshotName;

	public static void captureScreenshot() throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = "jenkins_"+d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		
		String outputScreenshot = Constants.SCREENSHOT_PATH + screenshotName;

		File destFile = new File(outputScreenshot);

		FileUtils.copyFile(scrFile, destFile);

		getExtentReport().log(Status.INFO, " Screenshot --> " + getExtentReport().addScreenCaptureFromPath(outputScreenshot));

	}
}
