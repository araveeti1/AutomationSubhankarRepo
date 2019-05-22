package com.test.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.test.util.ExcelReaderClass;
import com.test.util.ExtentManager;

public class BaseTestClass {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties objrep = new Properties();
	public static FileInputStream fis;
	public static Logger logger = Logger.getLogger("devpinoylogger");
	public static ExcelReaderClass exl = new ExcelReaderClass(
			System.getProperty("user.dir") + "\\src\\test\\resources\\datasource\\TestData.xlsx");
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static WebDriverWait wait;

	@BeforeSuite
	public void setup() throws Exception {

		if (driver == null) {
			try {
				/*
				 * System.getProperty("user.dir") provides the path till the project base
				 * directory. Here we are loading the properties files created for the project
				 */
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\BaseConfig.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				config.load(fis);
				logger.debug("Config File Loaded !!!"); /* Writes in log file */
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\ObjRep.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				objrep.load(fis);
				logger.debug("Object File Loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (config.getProperty("browser").equals("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");
				driver = new FirefoxDriver();
				logger.debug("Firefox launched !!!");
			}
			if (config.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
				driver = new ChromeDriver();
				logger.debug("Chrome launched !!!");
			}
			if (config.getProperty("browser").equals("opera")) {
				System.setProperty("webdriver.opera.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\operadriver.exe");
				driver = new OperaDriver();
				logger.debug("Opera launched !!!");
			}
			if (config.getProperty("browser").equals("ie")) {
				/*
				 * Please make sure that this is available on your $PATH (or %PATH% on Windows)
				 * in order for the IE Driver to work as expected.
				 */
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				logger.debug("IE launched !!!");
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
		test.log(Status.INFO, "Clicking on :" + locator);
	}

	public void type(String locator, String value) {

		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(objrep.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(objrep.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(objrep.getProperty(locator))).sendKeys(value);
		}
		test.log(Status.INFO, "Typing in :" + locator);
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}

	}

	@AfterTest
	public void closeBrowser() {

		driver.close();
	}

	@AfterSuite
	public void teardown() {

		driver.quit();
	}
}
