package com.w2a.listeners;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class CustomListeners extends TestBase implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = rep.createTest("Test Suite Started: To Verify The Bank Website");	
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		test.log(Status.PASS, result.getName().toUpperCase() + " PASS");
		rep.flush();

	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		test.log(Status.FAIL, result.getName().toUpperCase() + " Failed with Exception: " + result.getThrowable());
		try {
			test.addScreenCaptureFromPath(TestUtil.captureScreenshot(result.getName()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("Click to see Screenshot");
		Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + ">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src=" + TestUtil.screenshotName
				+ " height=200 width=200></img></a>");
		rep.flush();

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

		test.log(Status.SKIP, result.getName().toUpperCase() + " Skipped the test as the Run mode is NO");
		rep.flush();

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		rep.flush();
	}

}
