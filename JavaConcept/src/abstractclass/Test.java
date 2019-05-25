package abstractclass;

public class Test {

	public static void main(String[] args) {

		// As we can not create an object of the Abstract Class, we must create an
		// object of the child class in the hierarchy that has the first implementation
		// of the abstract methods.
		ChildChrome obj = new ChildChrome();

		// Now we can call the concrete methods present in the parent abstract classes
		// in the hierarchy.
		obj.captureScreenshot();
		obj.showBrowserName();
		obj.displayChildChrome();

	}

}
