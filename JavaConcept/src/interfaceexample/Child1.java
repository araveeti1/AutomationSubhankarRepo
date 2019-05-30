package interfaceexample;

public class Child1 extends ParentClass1 implements Parent1,Parent2 {
	@Override
	public void show() {
				System.out.println("show() method from Child called");
			}
}
