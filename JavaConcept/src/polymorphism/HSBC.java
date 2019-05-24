package polymorphism;

public class HSBC extends RBIOverriding {
	
	public static void main(String[] args) {
		
		HSBC obj = new HSBC();
		System.out.println(obj.getHomeLoanROI());
	}
	
	public double getHomeLoanROI() {

		return 9.75;
	}
	
	public Integer show() {
		return 10;
	}

}
