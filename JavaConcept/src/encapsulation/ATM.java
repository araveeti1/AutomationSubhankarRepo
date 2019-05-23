package encapsulation;

public class ATM {
	/*
	 * Encapsulation--> Data binding,wrapping data and methods in a single unit.
	 * Data Hiding --> Hiding the data from outside world, so that they can not be
	 * accessed directly. 
	 * Abstraction --> Force calling private variables through public methods.
	 */

	public static void main(String[] args) {
		Bank obj = new Bank();
		obj.updatePinNum(1478, 5897, 12589579);
		obj.withdrawAmount(12589579, 5897, 10000);
	}
}
