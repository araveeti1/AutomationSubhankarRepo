package overriding;

public class FirefoxDriverClass extends WebDriver {
	public void click() {
		System.out.println("Clicking on the webelement on FireFox - FireFoxDriver()");
	}

	public void sendkeys() {
		System.out.println("Typing in the webelement on FireFox - FireFoxDriver()");
	}
}
