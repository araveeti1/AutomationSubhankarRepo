package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.w2a.utilities.ExcelReaderClass;
import com.w2a.utilities.ExtentManager;
import com.w2a.utilities.Utilities;

/*
 * @Author - Subhankar Mukherjee
 * 
 * Here we will initialize the followings-
 * WebDriver --> Completed		
 * Logs	-- log4j.jar, .log files, log4j.properties, Logger --> Completed
 * Properties --> Completed
 * ReportNG,ExtentReport --> Completed
 * DB
 * Excel --> Completed	
 * Email 
 * Jenkins
 * Implicit and Explicit Waits --> Completed
 */
public class Page {

	public static WebDriver driver;
	public static TopMenu menu;
	public static GetWindowHandles getwh;
	public static Properties Config = new Properties(); /* Initializing Config.properties using Properties class */
	public static Properties OR = new Properties(); /* Initializing OR.properties using Properties class */
	public static FileInputStream fis; /* Create an object of FileInputStream class to read input file */
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReaderClass exl = new ExcelReaderClass(
			System.getProperty("user.dir") + "\\src\\test\\resources\\com\\w2a\\excel\\TestData1.xlsx");
	public static WebDriverWait wait;
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static String browser;

	public Page() {

		if (driver == null) {
			try {
				/*
				 * System.getProperty("user.dir") provides the path till the project base
				 * directory. Here we are loading the properties files created for the project
				 */
				fis = new FileInputStream(System.getProperty("user.dir")
						+ "\\src\\test\\resources\\com\\w2a\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				Config.load(fis);
				log.debug("Config File Loaded !!!"); /* Writes in log file */
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\com\\w2a\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				OR.load(fis);
				log.debug("Object File Loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Jenkins Browser filter configuration
			if (System.getenv("browser") != null && !System.getenv("browser").isEmpty()) {

				// Gets the value of the specified environment variable. An environment variable
				// is a system-dependent external named value.
				browser = System.getenv("browser");

			} else {

				// If no value is coming from Jenkins, then local Config.properties will be
				// read.
				browser = Config.getProperty("browser");

			}

			Config.setProperty("browser", browser);

			if (Config.getProperty("browser").equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")
						+ "\\src\\test\\resources\\com\\w2a\\executables\\geckodriver.exe");
				driver = new FirefoxDriver();
				log.debug("Firefox launched !!!");
			}

			if (Config.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
						+ "\\src\\test\\resources\\com\\w2a\\executables\\chromedriver.exe");

				// Using HashMap to define some properties of chrome.
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_setting_values.notifications", 2);
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);
				options.addArguments("--disable-extensions");
				options.addArguments("--disable-infobars");

				driver = new ChromeDriver(options);
				log.debug("Chrome launched !!!");
			}

			if (Config.getProperty("browser").equals("ie")) {
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
			driver.get(Config.getProperty("testsiteurl"));
			/*
			 * As implicit wait only takes integer arguments, we need to convert the
			 * incoming value into an integer using - Integer.parseInt() argument
			 */
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit-wait")),
					TimeUnit.SECONDS);
			/* Adding explicit wait as implicit waits can not handle window alerts */
			wait = new WebDriverWait(driver, 5);
			getwh = new GetWindowHandles(driver);
			menu = new TopMenu(driver);

		}
	}

	public static void quit() {

		driver.close();
		driver.quit();
	}

	public void click(String locator) {
		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_LINKTEXT")) {
			driver.findElement(By.linkText(OR.getProperty(locator))).click();
		}

		log.debug("Clicking on an element: " + locator);
		test.log(Status.INFO, "Clicking On :" + locator);
	}

	public void type(String locator, String value) {
		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_LINKTEXT")) {
			driver.findElement(By.linkText(OR.getProperty(locator))).sendKeys(value);
		}
		log.debug("Typing in an element: " + locator + " and the entered value is: " + value);
		test.log(Status.INFO, "Writing in: " + locator + "\n Entered Value :" + value);
	}

	static WebElement dropdown;

	public void select(String locator, String value) {

		if (locator.endsWith("_CSS")) {
			dropdown = driver.findElement(By.cssSelector(OR.getProperty(locator)));
		} else if (locator.endsWith("_XPATH")) {
			dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));
		} else if (locator.endsWith("_ID")) {
			dropdown = driver.findElement(By.id(OR.getProperty(locator)));
		}

		Select select = new Select(dropdown);
		select.selectByVisibleText(value);
		log.debug("Selecting an element: " + locator + " and the selected value is: " + value);
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
			Utilities.captureScreenshot();
			// ReportNG
			Reporter.log("<br>" + "Verification Failure message: " + t.getMessage() + "<br>");
			Reporter.log("<a target=\"_blank\" href=" + Utilities.screenShotName + ">Error Screenshot<img src="
					+ Utilities.screenShotName + " height=150 width=100></img></a>");
			Reporter.log("<br>");
			Reporter.log("<br>");
			// Extent Report
			test.log(Status.FAIL, "Failed with Exception: " + t.getMessage());
			try {
				Utilities.captureScreenshot();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
