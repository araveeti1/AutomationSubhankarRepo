package collectionsexample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HashMapExample {
	
	public static void main(String[] args) {
		
	/*	Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("Subhankar", 1478523690);
		map.put("Raman", 1587419870);
		map.put("Janvi", 1987453258);
		map.put("Agnimitra", 1632587469);
		
	//	System.out.println(map);
		
	//	System.out.println(map.get("Janvi"));
		
		Set<String> keys= map.keySet();
		for (String key : keys) {
			System.out.println("Key--> "+key+" Value--> "+map.get(key));
		}*/
	
		Map<String, List<String>> map1 = new HashMap<String, List<String>>();
		
		List<String> listofEmails= new ArrayList<String>();
		listofEmails.add("abc@xyz.com");
		listofEmails.add("cdf@swtr.com");
		listofEmails.add("pqr@gmail.com");
		listofEmails.add("atk@hotmail.com");
		
		map1.put("emails", listofEmails);
		
		Set<String> keys= map1.keySet();
		for (String key : keys) {
			System.out.println("Key--> "+key+" Value--> "+map1.get(key));
		}
		
	//	Map<String, Map<String,String>> map2 = new HashMap<String,Map<String,String>>();
	
	}

}
