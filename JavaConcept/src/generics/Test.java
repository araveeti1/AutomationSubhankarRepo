package generics;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(10);
		list.add("Subhankar");
		System.out.println(list);

		/**
		 * Now if we want to store any of the value from the list to a relevant type of
		 * variable, we can not achieve that and will be in need of type casting. As
		 * objects can not be converted into some primitive data types. Example below.
		 */
		
		String var= (String) list.get(1);
		System.out.println(var);
	}
}
