package utilis;

import java.util.Date;

public class Constatnts {

	public static final Date DATE = new Date();
	public static final String EXTENT_REPORT_NAME = "extent_" + DATE.toString().replace(":", "_").replace(" ", "_") + ".html";
	public static final String EXTENT_REPORT_PATH=System.getProperty("user.dir")+"\\Reports\\HtmlReport\\";
}
