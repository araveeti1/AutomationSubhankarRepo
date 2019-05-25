package abstractclass;

/**
 * As ChromeDriver was defined as Abstract so it could not override the Abstract
 * methods defined in it's Parent WebDriver class. So down the hierarchy, this
 * ChildChrome becomes the the first class to implement Concrete overridden
 * methods.
 */

public class ChildChrome extends ChromeDriver {

	@Override
	public void click() {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendkeys() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getTitle() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getChromeInstance() {
		// TODO Auto-generated method stub

	}
	
	public void displayChildChrome() {
		
		System.out.println("Inside child of chrome");
	}

}
