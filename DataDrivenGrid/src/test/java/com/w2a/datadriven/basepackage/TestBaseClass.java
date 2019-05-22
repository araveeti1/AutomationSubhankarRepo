package com.w2a.datadriven.basepackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.w2a.utilities.Constants;
import com.w2a.utilities.ExtentManager;
import com.w2a.utilities.TestUtil;

public class TestBaseClass {

	/*
	 * What will be initialized here- Webdriver, Logs, Properties, Excel, DataBases,
	 * Mail, Extent Reports
	 * 
	 */

	// For creating unique threads while running parallel test cases.
	public static ThreadLocal<RemoteWebDriver> remotedr = new ThreadLocal<RemoteWebDriver>();
	
	// While working with Grid, we don't just use WebDriver. We generally use a
	// RemoteWebDriver. As we execute our test cases in remote browsers.
	public static RemoteWebDriver driver = null;

	// To initialize properties files, variables are declared here and will be initialized later.
	public static Properties OR = new Properties();
	public static Properties Config = new Properties();

	// To convert String data from excel sheet into binary data-streams, we need to
	// declare one FileInputStream.
	public FileInputStream fis;

	// Initializing log4j logger variable here.
	public Logger log = Logger.getLogger("devpinoyLogger");

	// Introducing explicit wait variable.
	public WebDriverWait wait;

	// Initialize ExtentTest variable for initializing Extent Reports.
	public static ExtentReports report = ExtentManager.getInstance();
	public static ExtentTest test;

	// As the extent report follows a single node in general, we need to implement
	// multi-threading concept here as well.
	public static ThreadLocal<ExtentTest> extest = new ThreadLocal<ExtentTest>();

	public String browser;

//	@BeforeSuite
	// While using BeforeSuite, it is being called once for the whole execution
	// timeframe. But we need to call it for each thread. So removing the
	// BeforeSuite annotation and using Super Class concept.

	public void addLog(String message) throws Exception{

		log.debug("Thread: "+getThreadValue(remotedr.get()));
		log.debug("Browser: " + browser + "-->" + message);

	}

	public void setUp() {

		// PropertiesConfigurator is used to configure logger from properties file
		PropertyConfigurator.configure(System.getProperty("user.dir") + "\\src\\test\\resources\\log4j.properties");
		if (driver == null) {

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Config.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			log.debug("Config File Loaded");

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			log.debug("Object Repository File Loaded");

		}

	}

	// Set-Get for Remote Web Driver
	public void setWebDriver(RemoteWebDriver driver) {

		remotedr.set(driver);
	}

	public static WebDriver getDriver() {

		return remotedr.get();

	}

	// Set-Get for Extent Report
	public void setExtentReport(ExtentTest test) {

		extest.set(test);
	}

	public static ExtentTest getExtentReport() {

		return extest.get();

	}

	// This can take any type of values including String,Int. As it is taking Object
	// as an input type and returning an object also.
	public String getThreadValue(Object value) {

		String text1 = value.toString();

		// This splits the String into an array based on the argument provided. Here
		// Each string before a single space is entered into different indexes of the
		// array.
		String[] text2 = text1.split(" ");

		// This string holds the last value in the array.
		String baseOutput = text2[text2.length - 1].replace("(", "").replace(")", "");

		String[] text3 = baseOutput.split("-");

		String finalOutput = text3[text3.length - 1];

		return finalOutput;

	}

	public void openBrowser(String browser) throws MalformedURLException {

		this.browser = browser;
		DesiredCapabilities cap = null;

		if (browser.equals("firefox")) {
			// Setting capabilities and platform for the browser
			try {
				addLog("Firefox Started!!!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cap = DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.ANY);

		} else if (browser.equals("chrome")) {

			try {
				addLog("Chrome Started!!!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cap = DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.ANY);

		} else if (browser.equals("iexplore")) {

			try {
				addLog("IE Started!!!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cap = DesiredCapabilities.internetExplorer();
			cap.setBrowserName("iexplore");
			cap.setPlatform(Platform.WINDOWS);
		}

		driver = new RemoteWebDriver(new URL(Constants.REMOTE_HUB_URL), cap);
		setWebDriver(driver);

		// getDriver() method returns a unique value for the threadlocal
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit-wait")),
				TimeUnit.SECONDS);
		getExtentReport().log(Status.INFO, "Browser opened successfully:" + browser);

		// Returns the value of the current thread
//		System.out.println(remotedr.get());
		System.out.println("The running thread is: " + getThreadValue(remotedr.get()));

	}

	public void navigate(String url) {

		getDriver().get(Config.getProperty(url));
		getExtentReport().log(Status.INFO, "Navigating to: " + Config.getProperty(url));
	}

	public void reportPass(String passMessage) {

		getExtentReport().log(Status.PASS, passMessage);
	}

	public void reportFail(String failMessage) {

		getExtentReport().log(Status.FAIL, failMessage);
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.fail(failMessage);
	}

	public void click(String locator) {

		try {
			if (locator.endsWith("_CSS")) {
				getDriver().findElement(By.cssSelector(OR.getProperty(locator))).click();
			} else if (locator.endsWith("_XPATH")) {
				getDriver().findElement(By.xpath(OR.getProperty(locator))).click();
			} else if (locator.endsWith("_ID")) {
				getDriver().findElement(By.id(OR.getProperty(locator))).click();
			}

			addLog("Clicking on element: " + locator);
		} catch (Throwable t) {

			reportFail("Failing when clicking on an element: " + locator);
		}
		getExtentReport().log(Status.INFO, "Clicking On :" + locator);
	}

	public void type(String locator, String value) {
		try {
			if (locator.endsWith("_CSS")) {
				getDriver().findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
			} else if (locator.endsWith("_XPATH")) {
				getDriver().findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
			} else if (locator.endsWith("_ID")) {
				getDriver().findElement(By.id(OR.getProperty(locator))).sendKeys(value);
			}
			addLog("Typing in element: " + locator);
		} catch (Throwable t) {

			reportFail("Failing when typing in an element: " + locator);
		}
		getExtentReport().log(Status.INFO, "Writing in: " + locator + "\n Entered Value :" + value);
	}

	static WebElement dropdown;

	public void select(String locator, String value) {

		try {
			if (locator.endsWith("_CSS")) {
				dropdown = getDriver().findElement(By.cssSelector(OR.getProperty(locator)));
			} else if (locator.endsWith("_XPATH")) {
				dropdown = getDriver().findElement(By.xpath(OR.getProperty(locator)));
			} else if (locator.endsWith("_ID")) {
				dropdown = getDriver().findElement(By.id(OR.getProperty(locator)));
			}

			Select select = new Select(dropdown);
			select.selectByVisibleText(value);
			addLog("Selecting the element: " + locator);
		} catch (Throwable t) {

			reportFail("Failing when selecting an element: " + locator);
		}

		getExtentReport().log(Status.INFO, "Selecting from dropdown: " + locator + "\n Selected Value :" + value);
	}

	@AfterSuite
	public void tearDown() {

		getDriver().close();
		getDriver().quit();

	}
}
