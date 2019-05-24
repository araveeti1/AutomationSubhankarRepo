package overriding;

public class TestCase1 extends Base {

	String browserName = "chrome";

	public static void main(String[] args) {

		TestCase1 obj =new TestCase1();
		obj.initBrowser();
	}

	public void initBrowser() {

		WebDriver driver = getBrowserInstance(browserName);
		driver.click();
		driver.sendkeys();
		driver.getTitle();
		System.out.println("\n");

	}
}
