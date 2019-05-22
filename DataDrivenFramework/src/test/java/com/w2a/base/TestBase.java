package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.w2a.utilities.ExcelReaderClass;
import com.w2a.utilities.ExtentManager;
import com.w2a.utilities.TestUtil;

/*
 * Here we will initialize the followings-
 * Webdriver --> Completed		
 * Logs	-- log4j.jar, .log files, log4j.properties, Logger --> Completed
 * Properties --> Completed
 * Extent Reports --> Completed
 * DB
 * Excel	
 * Email
 * ReportNG,ExtentReport --> Completed
 * Jenkins
 */

public class TestBase {

	public static WebDriver driver;
	public static Properties config = new Properties(); /* Initializing Config.properties using Properties class */
	public static Properties objrep = new Properties(); /* Initializing ObjRep.properties using Properties class */
	public static FileInputStream fis; /* Create an object of FileInputStream class to read input file */
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReaderClass exl = new ExcelReaderClass(
			System.getProperty("user.dir") + "\\src\\test\\resources\\datasource\\TestData1.xlsx");
	public static WebDriverWait wait;
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;

	@BeforeSuite /*
					 * This method will be called before any kind of execution of any testcase
					 * starts as per project build.
					 */
	public void setup() {

		if (driver == null) {
			try {
				/*
				 * System.getProperty("user.dir") provides the path till the project base
				 * directory. Here we are loading the properties files created for the project
				 */
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\testproperties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				config.load(fis);
				log.debug("Config File Loaded !!!"); /* Writes in log file */
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\testproperties\\ObjRep.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				objrep.load(fis);
				log.debug("Object File Loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (config.getProperty("browser").equals("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");
				driver = new FirefoxDriver();
				log.debug("Firefox launched !!!");
			}
			if (config.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
				driver = new ChromeDriver();
				log.debug("Chrome launched !!!");
			}
			if (config.getProperty("browser").equals("opera")) {
				System.setProperty("webdriver.opera.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\operadriver.exe");
				driver = new OperaDriver();
				log.debug("Opera launched !!!");
			}
			if (config.getProperty("browser").equals("ie")) {
				/*
				 * Please make sure that this is available on your $PATH (or %PATH% on Windows)
				 * in order for the IE Driver to work as expected.
				 */
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				log.debug("IE launched !!!");
			}

			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.get(config.getProperty("baseurl"));
			/*
			 * As implicit wait only takes integer arguments, we need to convert the
			 * incoming value into an integer using - Integer.parseInt() argument
			 */
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);
			/* Adding explicit wait as implicit waits can not handle window alerts */
			wait = new WebDriverWait(driver, 5);
		}
	}

	public void click(String locator) {
		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(objrep.getProperty(locator))).click();
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(objrep.getProperty(locator))).click();
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(objrep.getProperty(locator))).click();
		}
		test.log(Status.INFO, "Clicking On :" + locator);
	}

	public void type(String locator, String value) {
		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(objrep.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(objrep.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(objrep.getProperty(locator))).sendKeys(value);
		}
		test.log(Status.INFO, "Writing in: " + locator + "\n Entered Value :" + value);
	}

	static WebElement dropdown;

	public void select(String locator, String value) {

		if (locator.endsWith("_CSS")) {
			dropdown = driver.findElement(By.cssSelector(objrep.getProperty(locator)));
		} else if (locator.endsWith("_XPATH")) {
			dropdown = driver.findElement(By.xpath(objrep.getProperty(locator)));
		} else if (locator.endsWith("_ID")) {
			dropdown = driver.findElement(By.id(objrep.getProperty(locator)));
		}

		Select select = new Select(dropdown);
		select.selectByVisibleText(value);

		test.log(Status.INFO, "Selecting from dropdown: " + locator + "\n Selected Value :" + value);
	}

	public boolean isElementPresent(By by) {

		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			return false;
		}

	}

	/* Here we are doing a soft assert */
	public static void verifyEquals(String expected, String actual) throws IOException {
		try {

			Assert.assertEquals(actual, expected);

		} catch (Throwable t) {
			// TODO: handle exception
			TestUtil.captureScreenshot();
			// ReportNG
			Reporter.log("<br>" + "Verification Failure message: " + t.getMessage() + "<br>");
			Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + ">Error Screenshot<img src="
					+ TestUtil.screenshotName + " height=150 width=100></img></a>");
			Reporter.log("<br>");
			Reporter.log("<br>");
			// Extent Report
			test.log(Status.FAIL, "Verification failed with exception: " + t.getMessage());
			String outputscreenshot = TestUtil.captureScreenshot(t.getMessage());
			test.addScreenCaptureFromPath(outputscreenshot);
		}

	}

	@AfterSuite /*
				 * This method will be called after all kind of execution of all testcases end
				 */
	public void teardown() {

		if (driver != null) {
			driver.close();
			driver.quit();
		}

		log.debug("Test execution completed");
	}

}
