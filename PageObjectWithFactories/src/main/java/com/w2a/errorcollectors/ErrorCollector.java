package com.w2a.errorcollectors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ErrorCollector {

	// ITestResult class is from TestNG framework, this describes the result of a
	// test.
	private static Map<ITestResult, List<Throwable>> verificationFailuresMap = new HashMap<ITestResult, List<Throwable>>();

	// This below method is an example of the hard assertion. Once the condition is
	// not met, the test will get failed.
	public static void assertTrue(boolean condition) {
		Assert.assertTrue(condition);
	}

	public static void assertTrue(boolean condition, String message) {
		Assert.assertTrue(condition, message);
	}

	public static void assertFalse(boolean condition) {
		Assert.assertFalse(condition);
	}

	public static void assertFalse(boolean condition, String message) {
		Assert.assertFalse(condition, message);
	}

	public static void assertEquals(boolean actual, boolean expected) {
		Assert.assertEquals(actual, expected);
	}

	public static void assertEquals(Object actual, Object expected) {
		Assert.assertEquals(actual, expected);
	}

	public static void assertEquals(Object[] actual, Object[] expected) {
		Assert.assertEquals(actual, expected);
	}

	public static void assertEquals(Object actual, Object expected, String message) {
		Assert.assertEquals(actual, expected, message);
	}

	// The below class is an example of a soft assertion. Here we are handling the
	// assertion error in a try catch block. Whenever there is an assertion error,
	// we are catching the exception message in the catch block.
	// This exception message catched is returned and thus the test throws an
	// exception message and continues further executions.
	public static void verifyTrue(boolean condition) {
		try {
			assertTrue(condition);
		} catch (Throwable e) {
			addVerificationFailure(e);
		}
	}

	public static void verifyTrue(boolean condition, String message) {
		try {
			assertTrue(condition, message);
		} catch (Throwable e) {
			addVerificationFailure(e);
		}
	}

	public static void verifyFalse(boolean condition) {
		try {
			assertFalse(condition);
		} catch (Throwable e) {
			addVerificationFailure(e);
		}
	}

	public static void verifyFalse(boolean condition, String message) {
		try {
			assertFalse(condition, message);
		} catch (Throwable e) {
			addVerificationFailure(e);
		}
	}

	public static void verifyEquals(boolean actual, boolean expected) {
		try {
			assertEquals(actual, expected);
		} catch (Throwable e) {
			addVerificationFailure(e);
		}
	}

	public static void verifyEquals(String actual, String expected) {
		try {
			assertEquals(actual, expected);
		} catch (Throwable e) {

			addVerificationFailure(e);

		}
	}

	public static void verifyEquals(int actual, int expected) {
		try {
			assertEquals(actual, expected);
		} catch (Throwable e) {

			addVerificationFailure(e);

		}
	}

	public static void verifyEquals(Object actual, Object expected) {
		try {
			assertEquals(actual, expected);
		} catch (Throwable e) {
			addVerificationFailure(e);
		}
	}

	public static void verifyEquals(Object[] actual, Object[] expected) {
		try {
			assertEquals(actual, expected);
		} catch (Throwable e) {
			addVerificationFailure(e);
		}
	}

	public static void fail(String message) {
		Assert.fail(message);
	}

	public static List<Throwable> getVerificationFailures() {
		List<Throwable> verificationFailures = verificationFailuresMap.get(Reporter.getCurrentTestResult());
		return verificationFailures == null ? new ArrayList<Throwable>() : verificationFailures;
	}

	public static void addVerificationFailure(Throwable e) {
		List<Throwable> verificationFailures = getVerificationFailures();
		verificationFailuresMap.put(Reporter.getCurrentTestResult(), verificationFailures);
		verificationFailures.add(e);
	}

}
