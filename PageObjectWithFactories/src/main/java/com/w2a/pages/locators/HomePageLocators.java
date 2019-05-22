package com.w2a.pages.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class HomePageLocators {

	// This returns the list of 6 button elements that needs to be present in the
	// page under test as per the requirements.
	@FindBy(xpath = "//button[contains(@id,'tab-hp')]//span[contains(@class,'uitk-icon')]")
	@CacheLookup
	public List<WebElement> elementBlock;

	@FindBy(css = "#tab-flight-tab-hp")
	@CacheLookup
	public WebElement homepageFlightTab;

	@FindBy(css = "#flight-type-roundtrip-label-hp-flight")
	@CacheLookup
	public WebElement journeyReturn;

	@FindBy(css = "#flight-type-one-way-label-hp-flight")
	@CacheLookup
	public WebElement journeyOneWay;

	@FindBy(css = "#flight-origin-hp-flight")
	@CacheLookup
	public WebElement flightOrigin;

	// @FindAll goes and search for elements individually that are mentioned inside
	// it with @FindBy tag.
	// Even one of the locator is not proper, it will consider the other available
	// ones and will locate the element.
	// @FindAll({ @FindBy(css = "#flight-destination-hp-flight123"), @FindBy(id =
	// "flight-destination-hp-flight") })
	// @CacheLookup
	// public WebElement flightDestination;

	// @FindBys goes and search for elements one after another as their
	// relationships are mentioned inside it with @FindBy tag.
	// For the below example, it will first go and look for the css locator and then
	// it will look for a locator called id in it. So, if there is any error in the
	// css locator, it will not move to id locator and will throw an error
	// eventually that it could not locate the element.
	//@FindBys({ @FindBy(css = "#flight-destination-hp-flight"), @FindBy(id = "flight-destination-hp-flight") })
	//@CacheLookup
	//public WebElement flightDestination;
	
	@FindBy(css="#flight-destination-hp-flight")
	@CacheLookup
	public WebElement flightDestination;

	@FindBy(xpath = "//input[@id='flight-departing-hp-flight']")
	@CacheLookup
	public WebElement flightDeptDate;

	@FindBy(xpath = "//input[@id='flight-departing-single-hp-flight']")
	@CacheLookup
	public WebElement flightDeptDateOneWay;

	@FindBy(xpath = "//input[@id='flight-returning-hp-flight']")
	@CacheLookup
	public WebElement flightReturnDate;

	@FindBy(css = "#traveler-selector-hp-flight > div > ul > li > button")
	@CacheLookup
	public WebElement travellerNumberButton;

	@FindBy(xpath = "(//span[@class='uitk-step-input-value'])[1]")
	@CacheLookup
	public WebElement adultCount;

	@FindBy(xpath = "(//*[@class='uitk-step-input-button uitk-step-input-plus'])[1]")
	@CacheLookup
	public WebElement addAdult;

	@FindBy(xpath = "(//span[@class='uitk-step-input-value'])[2]")
	@CacheLookup
	public WebElement childCount;

	@FindBy(xpath = "(//*[@class='uitk-step-input-button uitk-step-input-plus'])[2]")
	@CacheLookup
	public WebElement addChild;

	@FindBy(xpath = "(//select[@id='flight-age-select-1-hp-flight'])[1]")
	@CacheLookup
	public WebElement ageOfChild1;

	@FindBy(xpath = "(//select[@id='flight-age-select-2-hp-flight'])[1]")
	@CacheLookup
	public WebElement ageOfChild2;

	@FindBy(xpath = "(//span[@class='uitk-step-input-value'])[3]")
	@CacheLookup
	public WebElement infantCount;

	@FindBy(xpath = "(//*[@class='uitk-step-input-button uitk-step-input-plus'])[3]")
	@CacheLookup
	public WebElement addInfant;

	@FindBy(xpath = "(//*[@class='btn-primary btn-action gcw-submit'])[1]")
	@CacheLookup
	public WebElement submitBtn;
}
