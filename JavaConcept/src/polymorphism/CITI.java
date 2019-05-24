package polymorphism;

public class CITI extends RBIOverriding {
	
	public static void main(String[] args) {
		
		CITI obj = new CITI();
		System.out.println(obj.getHomeLoanROI());
	}
	
	public double getHomeLoanROI() {

		return 10.5;
	}

}
