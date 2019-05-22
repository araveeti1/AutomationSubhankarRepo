package rough;

import com.w2a.utilities.Constants;
import com.w2a.utilities.ExcelReaderClass;

public class TestDataReader {

	public static void main(String[] args) {

		ExcelReaderClass exl = new ExcelReaderClass(
				System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\BankManagerSuite.xlsx");

		int rows = exl.getRowCount(Constants.DATA_SHEET);
		int cols = exl.getColumnCount(Constants.DATA_SHEET);
		System.out.println("Total Rows: " + rows + " and " + "Total Columns: " + cols + " are present in the Sheet");

//		String testName = "OpenAccountTest";
		String testName = "AddCustomerTest";
		int testCaseRowNum = 1;

		for (testCaseRowNum = 1; testCaseRowNum < rows; testCaseRowNum++) {

			String testCaseName = exl.getCellData(Constants.DATA_SHEET, 0, testCaseRowNum);
			if (testCaseName.equalsIgnoreCase(testName)) {

				break;
			}
		}
		System.out.println("The test case start fom Row number= " + testCaseRowNum);

		// Checking total rows in testcase
		// This below variable tracks from where the test data starts
		int dataStartRowNum = testCaseRowNum + 2;
		System.out.println("Test Data starts from row: " + dataStartRowNum);

		int testRows = 0;
		/* It will iterate and check until it finds a blank row */
		while (!exl.getCellData(Constants.DATA_SHEET, 0, dataStartRowNum + testRows).equals("")) {

			testRows++;
		}

		System.out.println("Total Rows of data are: " + testRows);

		// Checking total columns in the test

		int colStartColNum = testCaseRowNum + 1;
		int testColNum = 0;

		while (!exl.getCellData(Constants.DATA_SHEET, testColNum, colStartColNum).equals("")) {

			testColNum++;
		}

		System.out.println("Total Cols of data are: " + testColNum);

		for(int rNum=dataStartRowNum; rNum<dataStartRowNum+testRows; rNum++) {
			
			for (int cNum=0; cNum<testColNum; cNum++) {
				
				System.out.println(exl.getCellData(Constants.DATA_SHEET, cNum, rNum));
			}
		}

	}

}
