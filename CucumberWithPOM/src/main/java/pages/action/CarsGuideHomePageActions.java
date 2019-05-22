package pages.action;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import pages.locator.CarsGuideHomePageLocator;
import utils.SeleniumDriverClass;

public class CarsGuideHomePageActions {

	CarsGuideHomePageLocator carsGuideHomeLocator = null;

	public CarsGuideHomePageActions() {

		this.carsGuideHomeLocator = new CarsGuideHomePageLocator();
		PageFactory.initElements(SeleniumDriverClass.getDriver(), carsGuideHomeLocator);
	}

	public void moveToBuyAndSellMenu() {

		Actions action = new Actions(SeleniumDriverClass.getDriver());
		action.moveToElement(carsGuideHomeLocator.buyAndSellLink).perform();

	}

	public void clickOnSearchCarsMenu() {

		// While calling this method, moveToBuyAndSellMenu() should be called before it.
		// As this method is under buy + sell menu.
		carsGuideHomeLocator.searchCarsLink.click();

	}

	public void clickOnUsedCarsMenu() {

		// While calling this method, moveToBuyAndSellMenu() should be called before it.
		// As this method is under buy + sell menu.
		carsGuideHomeLocator.usedCarsSearchLink.click();

	}

	public void moveToReviewsMenu() {

		Actions action = new Actions(SeleniumDriverClass.getDriver());
		action.moveToElement(carsGuideHomeLocator.reviewsLink).perform();

	}

}
