package pages.base;

import java.util.Date;

public class Constants {
	// This page declares all the constants.
	
	// Browsers
	public static final String BROWSER_NAME = "chrome";

	// URL for web application under test
	public static final String TESTSITE_URL = "https://www.carsguide.com.au/";

	// Define waits
	public static final String IMPLICIT_WAIT_TIME = "5";
	public static final String EXPLICIT_WAIT_TIME = "30";
	public static final String PAGELOAD_TIMEOUT = "50";

	// Webdriver path
	public static final String FIREFOX_DRIVER_PATH = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\executables\\geckodriver.exe";
	public static final String CHROME_DRIVER_PATH = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\executables\\chromedriver.exe";

	// Reporting variable declaration
	public static Date date = new Date();
	public static final String EXTENT_REPORT_PATH = System.getProperty("user.dir") + "\\test-output\\html\\";
	public static final String EXTENT_REPORT_NAME = "extent_" + date.toString().replace(":", "_").replace(" ", "_")
			+ ".html";
	public static final String REPORT_CONFIG = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\extent-config.xml";
	public static final String LOGGER_REPORT_PATH = System.getProperty("user.dir") + "\\test-output\\logger\\";
	public static final String LOGGER_REPORT_NAME = "logger_" + date.toString().replace(":", "_").replace(" ", "_")
			+ ".html";
	// Screenshot capture path
	public static final String SCREENSHOT_PATH = System.getProperty("user.dir") + "\\test-output\\html\\" + "error_"
			+ date.toString().replace(":", "_").replace(" ", "_");

}
