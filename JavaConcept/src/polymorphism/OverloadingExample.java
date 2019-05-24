package polymorphism;

public class OverloadingExample {
	public static void main(String[] args) {

		OverloadingExample obj = new OverloadingExample();

		// obj.add(a, b);
		// obj.add(a, b, c);
		// obj.doLogin(userName, password);
		// obj.doLogin(mobileNumber, password);

	}

	public void add(int a, int b) {
	}

	public void add(int a, int b, int c) {
	}

	public void doLogin(int mobileNumber, String password) {

	}

	public void doLogin(String userName, String password) {

	}
}
