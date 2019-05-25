package interfaceexample;

// We can not use 'final' keyword in interface or abstract classes.
public interface WebDriver {
	
	// By default the methods inside an interface is abstract.
	// We can not create a concrete method inside an interface.
	
	public void click();
	public void sendkeys();
}
