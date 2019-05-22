package pages.locator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CarsGuideHomePageLocator {

	@FindBy(how = How.LINK_TEXT, using = "buy + sell")
	@CacheLookup
	public WebElement buyAndSellLink;
	
	@FindBy(how = How.LINK_TEXT, using = "Search Cars")
	@CacheLookup
	public WebElement searchCarsLink;
	
	@FindBy(how = How.LINK_TEXT, using = "Used")
	@CacheLookup
	public WebElement usedCarsSearchLink;

	@FindBy(how = How.LINK_TEXT, using = "reviews")
	@CacheLookup
	public WebElement reviewsLink;

	@FindBy(how = How.LINK_TEXT, using = "news")
	@CacheLookup
	public WebElement newsLink;
	
	@FindBy(how = How.LINK_TEXT, using = "advice")
	@CacheLookup
	public WebElement adviceLink;
	
	@FindBy(how = How.LINK_TEXT, using = "pricing + specs")
	@CacheLookup
	public WebElement pricingAndSpecsLink;

}
