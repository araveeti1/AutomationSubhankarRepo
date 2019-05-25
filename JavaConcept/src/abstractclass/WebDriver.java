package abstractclass;

/**
 * An Abstract class may contain all methods as Abstract or a combination of
 * Abstract and Concrete methods or it can contain all the methods as concrete
 * methods.
 */

public abstract class WebDriver {

	// As an Abstract method, the below methods do not have any body.
	public abstract void click();

	public abstract void sendkeys();

	public abstract void getTitle();

	// Concrete method. The first concrete method should override the abstract
	// method.
	public void captureScreenshot() {

		System.out.println("The screenshot is captured!");
		
	}
}
