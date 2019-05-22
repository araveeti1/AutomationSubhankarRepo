package com.w2a.base;

import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.w2a.pages.actions.TopNavigation;
import com.w2a.utilities.ExcelReaderClass;
import com.w2a.utilities.ExtentManager;

public class Page {

	/*
	 * WebDrivers, ExcelReader, Logs, Waits - Explicit and Implicit, Extent Report
	 */

	
	public static WebDriver driver;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReaderClass exl = new ExcelReaderClass(Constants.EXCEL_WB_PATH);
	public static WebDriverWait wait;
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static String browser;
	// As any page has the top navigation bar available and we can travel to top
	// navigation menus from anywhere. We can even call the top navigation from any
	// methods present in home page to move to that particular option.
	public static TopNavigation topNav;

	public static void initConfiguration() {

		PropertyConfigurator.configure(Constants.LOG4J_PROPERTIES_PATH);

		if (Constants.BROWSER.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", Constants.FIREFOX_GECKODRIVER_PATH);
			driver = new FirefoxDriver();
			log.debug("Firefox launched!!");

		}

		else if (Constants.BROWSER.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);

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

			log.debug("Chrome launched!!");
		}

		else if (Constants.BROWSER.equals("ie")) {

			System.setProperty("webdriver.ie.driver", Constants.IEXPLORERDRIVER_PATH);
			driver = new InternetExplorerDriver();
			log.debug("IE Launched!!");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(Constants.TESTSITEURL);

		// Here we are parameterizing the object of TopNavigation we have created. So it
		// can provide the WebDriver reference to the constructor of the TopNavigation
		// class.
		topNav = new TopNavigation(driver);

		/*driver.manage().timeouts().implicitlyWait(Integer.parseInt(Constants.implicit_wait), TimeUnit.SECONDS);
		wait= new WebDriverWait(driver, 5);*/
	}
	
	public static void click(WebElement element) {
		
		element.click();
		
		log.debug("Clicking on an element: " + element);
		test.log(Status.INFO, "Clicking On :" + element);
	}

	public static void type(WebElement element, String value) {
		
		element.sendKeys(value);
		log.debug("Typing in an element: " + element + " and the entered value is: " + value);
		test.log(Status.INFO, "Writing in: " + element + "\n Entered Value :" + value);
	}

	public static void closeBrowser() throws Exception{
	    if (driver == null) {
	        return;
	    }
	    driver.quit();
	    driver = null;
	}

}
