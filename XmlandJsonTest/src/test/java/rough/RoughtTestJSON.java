package rough;

import java.io.IOException;

import utilities.JsonReader;;

public class RoughtTestJSON {

	public static void main(String[] args) throws IOException {

		JsonReader myjson = new JsonReader(
				System.getProperty("user.dir") + "\\src\\test\\resources\\locators\\ObjRep.json");
		//String mylocatorString = myxml.getLocator("homepage.header.username.css");
		String mylocatorString = myjson.getData("locators.homepage.username.xpath");
		System.out.println(mylocatorString);
		
	}

}
