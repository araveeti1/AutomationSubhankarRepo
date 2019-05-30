package generics;

public class Account {

	public static void main(String[] args) {
		
		// This is possible.
		Account ac = new Account();
		
		// But this is not possible until we create a parent-child relationship.
		// This is what happens when we don't use generic.
		/* Account obj = new SavingsAccount(); */
		
	}

}
