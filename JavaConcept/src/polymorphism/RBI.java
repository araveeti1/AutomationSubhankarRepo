package polymorphism;

public class RBI {

	/*
	 * Example of Overloading --
	 * 
	 * We can use a same method name as below with different method signatures.
	 * 
	 */

	public void getHomeLoanROI(String bankName) {

	}

	// Here we are using a different method signature by providing some different
	// parameter/parameters.
	public void getHomeLoanROI(String bankName, int amount) {

	}

	// We can also change the sequence of parameters to create a different method
	// signature.
	public void getHomeLoanROI(int amount, String bankName) {

	}

	// If we create a same method without any parameters, it is also a different method
	// signature.
	public void getHomeLoanROI() {
		
	}
}
