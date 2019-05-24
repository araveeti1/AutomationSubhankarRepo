package overriding;

public class InternetExplorerDriverClass extends WebDriver {
	public void click() {
		System.out.println("Clicking on the webelement on IE - InternetExplorerDriver()");
	}

	public void sendkeys() {
		System.out.println("Typing in the webelement on IE - InternetExplorerDriver()");
	}
}
