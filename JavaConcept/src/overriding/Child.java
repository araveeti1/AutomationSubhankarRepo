package overriding;

public class Child extends Parent{
	public void show() {
	}
	public void display() {
	}
	public static void main(String[] args) {
		Parent obj = new Child();
		obj.show();
		obj.add();
		//obj.display();
	}
}