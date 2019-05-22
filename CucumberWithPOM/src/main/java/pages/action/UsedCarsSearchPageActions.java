package pages.action;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import pages.locator.UsedCarSearchLocator;
import utils.SeleniumDriverClass;

public class UsedCarsSearchPageActions {

	UsedCarSearchLocator usedarSearchPageLocator = null;

	public UsedCarsSearchPageActions() {

		this.usedarSearchPageLocator = new UsedCarSearchLocator();
		PageFactory.initElements(SeleniumDriverClass.getDriver(), usedarSearchPageLocator);
	}

	public void selectCarMaker(String carMaker) throws Exception {

		Select select = new Select(usedarSearchPageLocator.carMakerDropdown);
		select.selectByVisibleText(carMaker);
		
	}

	public void selectCarModel(String carModel) throws Exception {

		Select select = new Select(usedarSearchPageLocator.carModelDropdown);
		select.selectByVisibleText(carModel);
		
	}

	public void selectCarLocation(String carLoc) throws Exception {

		Select select = new Select(usedarSearchPageLocator.carLocationDropdown);
		select.selectByVisibleText(carLoc);
		
	}

	public void selectCarPrice(String carPrice) throws Exception {

		Select select = new Select(usedarSearchPageLocator.carPriceDropdown);
		select.selectByVisibleText(carPrice);
		Thread.sleep(2000);
	}

	public void clickOnFindCarBtn() {

		usedarSearchPageLocator.findMyNextCarBtn.click();
	}

}
