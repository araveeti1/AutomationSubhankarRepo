package steps;

import cucumber.api.java.Before;
import utils.SeleniumDriverClass;

public class BeforeActions {

	@Before
	public static void setUp() {
		
		SeleniumDriverClass.setUpDriver();
	}
	
}
