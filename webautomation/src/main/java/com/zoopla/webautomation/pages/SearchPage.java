package com.zoopla.webautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BasePage{

	@FindBy(id="search-submit")
	private WebElement searchBtn;

	@FindBy(id="search-input-location")
	private WebElement searchLocation;

	public SearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		waitForWebElement(searchBtn, LONG_WAIT);
		System.out.println("Navigating to Search Page.");
	}

	public void enterLocation(String locationName) {
		searchLocation.sendKeys(locationName);
	}

	public SearchListingPage clickSearchBtn() {
		searchBtn.click();
		return new SearchListingPage(driver);
	}

}
