package generics;

/**
 * @author SUBHANKAR
 *
 * @param <T> --> It implies that it can take any type of object.
 */
public class GenericClassExample<T> {
	T obj;

	public GenericClassExample(T obj) {
		this.obj = obj;
	}
	
	public void show() {
		
		System.out.println("Type");

	}
}
