package reflectionexample;

import java.lang.reflect.Constructor;

public class Home {
	public static void main(String[] args) {
		Test t = new Test();

		Class testClass = t.getClass();

		// Returns the name of the class
		System.out.println("Target Class name is --> " + testClass.getSimpleName()+"\n");
		
		Constructor[] cons= testClass.getDeclaredConstructors();
		System.out.println(cons.length);
		for (Constructor constructor : cons) {
			System.out.println(constructor.getName());
		}
		
		/*// As .getDeclaredMethods() returns an array of methods.
		Method[] arrayOfMethods = testClass.getDeclaredMethods();
		System.out.println("Number of methods present in Target Class --> "+arrayOfMethods.length+"\n");
		for (Method m : arrayOfMethods) {
			System.out.println("Method name is --> " + "'" + m.getName() + "'" + " and the Return Type is --> "
					+ m.getReturnType());
			Parameter[] params = m.getParameters();
			for (Parameter param : params) {
				System.out.println(param.getName());
			}
		}*/
	}
}
