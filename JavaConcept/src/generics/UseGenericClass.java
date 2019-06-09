package generics;

import java.util.ArrayList;

public class UseGenericClass {
	public static void main(String[] args) {
		// Object type should be of Class type, not the integer type.
		// e.g: Integer in place of int.
		GenericClassExample<Integer> obj1 = new GenericClassExample<Integer>(10);
		obj1.show();
		System.out.println(obj1.get());

		GenericClassExample<String> obj2 = new GenericClassExample<String>("Subhankar");
		obj2.show();
		System.out.println(obj2.get());

		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<String> list2 = new ArrayList<String>();
		ArrayList<Double> list3 = new ArrayList<Double>();
		list1.add(20);
		list1.add(50);
		list2.add("10");
		list2.add("Subhankar");
		list3.add(10.75);
		list3.add(2.25);
		m1(list1);
//		m1(list2);
		m1(list3);
	}
	
	// Using wildcard character, we can use the same method for different object types.
	// Here we are bounding parameter type in the method level. We can do it at class level as well.
	public static void m1(ArrayList<? extends Number> list) {
		
		System.out.println(list);
		
	}

/*	public static void m1(ArrayList<Integer> list) {
		int var = 0;
		for (Integer i : list) {
			var = var + i;
		}
		System.out.println("The result for integer is: " + var);
	}

	public static void m2(ArrayList<String> list) {
		String var = "";

		for (String s : list) {
			var = var + s + "_";
		}
		var = var.substring(0, var.length() - 1);
		System.out.println("The result for string is: "+var);
	}
	
	public static void m3(ArrayList<Double> list) {
		double var = 0;
		for (Double i : list) {
			var = var + i;
		}
		System.out.println("The result for double is: " + var);
	}
*/
}
