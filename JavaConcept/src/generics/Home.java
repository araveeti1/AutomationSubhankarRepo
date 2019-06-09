package generics;

public class Home {

	public <T> void m1(T obj) {
		System.out.println(obj);
	}
	
	public static void main(String[] args) {
		
		Home home = new Home();
		home.m1(5);
	}
	
}
