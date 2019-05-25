package abstractclass;

public abstract class ChromeDriver extends WebDriver {

	public abstract void getChromeInstance();

	public void showBrowserName() {

		System.out.println("The browser is : Chrome");

	}
}
