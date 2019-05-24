package overriding;

public class Base {
	public WebDriver getBrowserInstance(String browserName) {
		if ("firefox".equalsIgnoreCase(browserName)) {
			return new FirefoxDriverClass();
		} else if ("chrome".equalsIgnoreCase(browserName)) {
			return new ChromeDriverClass();
		} else if ("ie".equalsIgnoreCase(browserName)) {
			return new InternetExplorerDriverClass();
		}else {
			return new FirefoxDriverClass();
		}
	}
}
