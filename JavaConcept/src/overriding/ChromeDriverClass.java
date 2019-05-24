package overriding;

public class ChromeDriverClass extends WebDriver {
	public void click() {
		System.out.println("Clicking on the webelement on Chrome - ChromeDriver()");
	}

	public void sendkeys() {
		System.out.println("Typing in the webelement on Chrome - ChromeDriver()");
	}
}
