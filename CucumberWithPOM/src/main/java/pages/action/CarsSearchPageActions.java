package pages.action;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import pages.locator.CarSearchPageLocator;
import utils.SeleniumDriverClass;

public class CarsSearchPageActions {

	CarSearchPageLocator carSearchPageLocator = null;

	public CarsSearchPageActions() {

		this.carSearchPageLocator = new CarSearchPageLocator();
		PageFactory.initElements(SeleniumDriverClass.getDriver(), carSearchPageLocator);
	}

	public void selectCarMaker(String carMaker) throws Exception {

		Select select = new Select(carSearchPageLocator.carMakerDropdown);
		select.selectByVisibleText(carMaker);
		
	}

	public void selectCarModel(String carModel) throws Exception {

		Select select = new Select(carSearchPageLocator.carModelDropdown);
		select.selectByVisibleText(carModel);
		
	}

	public void selectCarLocation(String carLoc) throws Exception {

		Select select = new Select(carSearchPageLocator.carLocationDropdown);
		select.selectByVisibleText(carLoc);
		
	}

	public void selectCarPrice(String carPrice) throws Exception {

		Select select = new Select(carSearchPageLocator.carPriceDropdown);
		select.selectByVisibleText(carPrice);
		Thread.sleep(2000);
	}

	public void clickOnFindCarBtn() {

		carSearchPageLocator.findMyNextCarBtn.click();
	}

}
