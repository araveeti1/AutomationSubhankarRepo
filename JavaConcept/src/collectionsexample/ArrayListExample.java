package collectionsexample;

import java.util.ArrayList;
import java.util.Iterator;


public class ArrayListExample {

	public static void main(String[] args) {

		ArrayList<Object> list = new ArrayList<Object>();

		// In the order, that we are putting the values in Array List, it will store the
		// values in same order.
		list.add(10);
		list.add("Subhankar");
		list.add(5.75);
		list.add(true);
		list.add(null);
		// We can add duplicate values in List.
		list.add(5.75);

		// Size
		System.out.println(list.size()+"\n");

		System.out.println(list+"\n");

		// How to fetch values from a list?
		for (int i = 0; i < list.size(); i++) {
			System.out.println("The value at index " + i + " is: " + list.get(i));
		}
		System.out.println("\n");
		
		// Remove a value from the List.
		list.remove(2);
		/*for (int i = 0; i < list.size(); i++) {
			System.out.println("The value at index " + i + " is: " + list.get(i));
		}*/
		/*for(Object var:list) {
			System.out.println(var);
		}*/
		Iterator itr= list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println("\n");
	}
}
