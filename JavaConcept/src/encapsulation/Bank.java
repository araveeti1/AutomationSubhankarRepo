package encapsulation;

public class Bank {
	public int accountNum = 12589579;
	private int pinNum = 1478;
	private double balanceAmount = 2000000;

	public void withdrawAmount(int accNum, int pin, int amount) {
		if (accNum == accountNum && pin == pinNum) {
			System.out.println("Credentials matched!!");

			if (amount < balanceAmount) {
				balanceAmount = balanceAmount - amount;
				System.out.println("The amount you have withdrawn: " + amount);
				System.out.println("The balance amount in your account is: " + balanceAmount);
			}

			else {
				System.out.println("Not enough balance in your account!!");
			}
		} else {
			System.out.println("Invalid crdentials!!");
		}
	}

	public void updatePinNum(int oldPin, int newPin, int accNum) {
		if (accNum == accountNum && oldPin == pinNum) {
			pinNum = newPin;
			System.out.println("Pin changed successfully!!");
		} else {
			System.out.println("Invalid credentials.. Pin not changed!!");
		}
	}
}
