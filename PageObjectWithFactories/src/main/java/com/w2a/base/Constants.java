package com.w2a.base;

public class Constants {

	// Cofiguration

	// When we declare a variable with final keyword, it means the value assigned to
	// it- is constant.
	public static final String BROWSER = "chrome";
	public static final String TESTSITEURL = "https://www.expedia.co.in/";
	public static final String IMPLICIT_WAIT = "5";

	// Excel Path
	public static final String EXCEL_WB_PATH = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\com\\w2a\\excel\\TestData1.xlsx";

	// Log4j Properties Path
	public static final String LOG4J_PROPERTIES_PATH = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\log4j.properties";

	// Driver Executables Path
	public static final String FIREFOX_GECKODRIVER_PATH = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\com\\w2a\\executables\\geckodriver.exe";
	public static final String CHROMEDRIVER_PATH = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\com\\w2a\\executables\\chromedriver.exe";
	public static final String IEXPLORERDRIVER_PATH = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\com\\w2a\\executables\\IEDriverServer.exe";

	// Screenshots
	public static final String SCREENSHOT_PATH = System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\";
}
