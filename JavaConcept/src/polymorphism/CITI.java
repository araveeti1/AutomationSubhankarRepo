package polymorphism;

public class CITI extends RBIOverriding {
	public static void main(String[] args) {
		CITI obj = new CITI();
		System.out.println(obj.getHomeLoanROI());
	}

	public double getHomeLoanROI() {
		return 10.5;
	}

	/**
	 * Here return type is class name as this method is returning an object of that
	 * class.
	 */
	public CITI getObject() {
		CITI obj = new CITI();
		return obj;
	}
}
