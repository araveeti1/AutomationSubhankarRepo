package rough;

import utilities.XMLReader;

public class RoughtTestXML {

	public static void main(String[] args) {

		XMLReader myxml = new XMLReader(
				System.getProperty("user.dir") + "\\src\\test\\resources\\locators\\ObjRep.xml");
		//String mylocatorString = myxml.getLocator("homepage.header.username.css");
		String mylocatorString = myxml.getLocator("username.css");
		String mylocatorString1 = myxml.getLocator("username.xpath");
		System.out.println(mylocatorString);
		System.out.println(mylocatorString1);
		//driver.findElement(By.xpath(myxl.getLocator("homepage.header.username.css"))).sendKeys();
		
	}

}
