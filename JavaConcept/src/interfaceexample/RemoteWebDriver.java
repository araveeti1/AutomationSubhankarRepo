package interfaceexample;

// As here an interface inherits another interface, we are using 'extends' keyword.
public interface RemoteWebDriver extends WebDriver {
	
	// By default the methods inside an interface is abstract.
	// We can not create a concrete method inside an interface.
	
	public void maximizeWindow();
}
