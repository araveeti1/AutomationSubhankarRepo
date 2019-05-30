package collectionsexample;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {

	public static void main(String[] args) {

		// HashSet<String> set = new HashSet<String>();
		Set<String> set = new HashSet<String>();

		set.add("Ashoka");
		set.add("was");
		set.add("a good");
		set.add("Ashoka");
		set.add("king");

		// Here we find that indexes are unordered and duplicate values are not
		// accepted.
		System.out.println(set);

		// We can't use simple for loop here as it works on index and in set, we don't
		// have indexes.
		// So we can use for each loop as below.

		/*
		 * for (String var : set) {
		 * 
		 * System.out.println(var); }
		 */

		// We can use iterator as well to get the values out of the set.
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			String var = itr.next();
			if (var.equalsIgnoreCase("ashoka")) {
				System.out.println(var);
			}
		}
	}

}
