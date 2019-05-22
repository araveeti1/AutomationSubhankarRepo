package rough;

import com.w2a.utilities.ExcelReaderClass;
import com.w2a.utilities.DataUtil;

public class CheckingRunmodes {

	public static void main(String[] args) {

		String suiteName = "BankManagerSuite";
		//String suiteName = "CustomerTestSuite";

		boolean suiteRunMode = DataUtil.isSuiteRunable(suiteName);

		System.out.println(suiteRunMode);

		String testCaseName = "AddCustomerTest";

		boolean testRunMode = DataUtil.isTestRunable(testCaseName, new ExcelReaderClass(
				System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\"+suiteName+".xlsx"));
		
		System.out.println(testRunMode);

	}

}
