package pages.locator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CarSearchPageLocator {

	@FindBy(how = How.CSS, using = "#makes")
	@CacheLookup
	public WebElement carMakerDropdown;

	@FindBy(how = How.CSS, using = "#models")
	@CacheLookup
	public WebElement carModelDropdown;

	@FindBy(how = How.CSS, using = "#locations")
	@CacheLookup
	public WebElement carLocationDropdown;

	@FindBy(how = How.CSS, using = "#price-max")
	@CacheLookup
	public WebElement carPriceDropdown;
	
	@FindBy(how = How.CSS, using = "#search-submit")
	@CacheLookup
	public WebElement findMyNextCarBtn;
}
