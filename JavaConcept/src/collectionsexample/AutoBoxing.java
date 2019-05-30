package collectionsexample;

/**
Boxing- It indicates that we create an object of a primitive data type variable using Classes.
Unboxing- It indicates that we convert the object of the class to a variable of a primitive.
*/
public class AutoBoxing {
	public static void main(String[] args) {
		int var = 10;

		// Here it is converting primitive int into an object of the Integer class.
		// This is an example of wrapping. ---> Auto Boxing
		Integer obj = new Integer(var);

		System.out.println(obj);

		int i = obj;/* This is an example of unwrapping  ---> Unboxing */
		
		System.out.println(i);
	}
}
