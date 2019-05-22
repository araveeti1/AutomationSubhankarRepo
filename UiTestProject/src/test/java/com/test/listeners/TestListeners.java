package com.test.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;
import com.test.base.BaseTestClass;
import com.test.util.TestUtilClass;


public class TestListeners extends BaseTestClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test=rep.createTest("!!Automation Employee Check!!");
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, result.getName().toUpperCase()+"PASS");
		rep.flush();
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String failureScreenShot=TestUtilClass.takeScreenshot(driver, result.getName());
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		test.log(Status.FAIL, result.getName().toUpperCase()+" Failed with exception: " + result.getThrowable());
		try {
			test.addScreenCaptureFromPath(failureScreenShot);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("Click to see the screnshot");
		Reporter.log("<a target=\"_blank\" href=" + TestUtilClass.screenshotName + ">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href=" + TestUtilClass.screenshotName + "><img src=" + TestUtilClass.screenshotName
				+ " height=200 width=200></img></a>");
		rep.flush();
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.SKIP, result.getName().toUpperCase() + " Skipped the test");
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
