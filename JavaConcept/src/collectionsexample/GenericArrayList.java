package collectionsexample;

import java.util.ArrayList;

public class GenericArrayList {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(null);
		
		int i=list.get(0);
		System.out.println(i);
	}
}