package generics;

/**
 * @author SUBHANKAR
 *
 * @param <T> --> It implies that it can take any type of object.
 * Whatever type of object we pass, the whole code will get converted accordingly 
 * to accommodate that type of object. That is how generics works.
 */
public class GenericClassExample<T> {
	T obj;

	public GenericClassExample(T obj) {
		this.obj = obj;
	}

	public void show() {
		System.out.println("Type of object is: " + obj.getClass().getSimpleName());
	}

	public T get() {
		return this.obj;
	}
}
