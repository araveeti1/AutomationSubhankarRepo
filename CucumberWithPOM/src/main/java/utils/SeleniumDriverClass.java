package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.base.Constants;

public class SeleniumDriverClass {

	// Defining a class referrence
	private static SeleniumDriverClass seleniumDriver;

	// Initialize the Webdriver
	private static WebDriver driver;

	// Defining explicit-wait
	private static WebDriverWait wait;

	// The constructor is private as we do not want to create an instant of it
	// everytime, whenever it is referenced.
	private SeleniumDriverClass() {

		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		// Explicit wait initialized
		wait = new WebDriverWait(driver, Integer.parseInt(Constants.EXPLICIT_WAIT_TIME));
		// Implicit wait initialized
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(Constants.IMPLICIT_WAIT_TIME), TimeUnit.SECONDS);
		// Pageload wait initialized
		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(Constants.PAGELOAD_TIMEOUT), TimeUnit.SECONDS);
	}

	public static void openPage(String url) {

		driver.get(url);
	}

	public static WebDriver getDriver() {

		return driver;
	}

	// This method calls the constructor with private access modifier.
	public static void setUpDriver() {
		if (seleniumDriver == null) {

			seleniumDriver = new SeleniumDriverClass();
		}
	}

	public static void tearDown() {

		if (driver != null) {

			driver.close();
			driver.quit();
		}

		seleniumDriver = null;
	}

}
