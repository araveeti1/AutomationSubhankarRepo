package polymorphism;

public class RBIOverriding {
	/** Example of Overriding --> */

	public double getHomeLoanROI() {

		return 8.5;
	}

	public double getCarLoanROI() {

		return 10.5;
	}
	
	public RBIOverriding getObject() {
		
		RBIOverriding obj = new RBIOverriding();
		return obj;
	}
	
	public Number show() {
		return 10;
	}
}
