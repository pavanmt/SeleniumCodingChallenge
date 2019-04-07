package com.zoopla.webautomation.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchListingPage extends BasePage{

	private By listingResults = new By.ByXPath("//ul[contains(@class,'listing-results')]");

	@FindBy(xpath="//ul[contains(@class,'listing-results ')]/li[contains(@class,'srp clearfix')]//a[contains(@class,'listing-results-price')]")
	private List<WebElement> priceList;

	public SearchListingPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		waitForWebElement(listingResults, LONG_WAIT);
		System.out.println("Navigating to Search Listing Page.");
	}

	public List<String> getRawPriceList(){
		List<String> priceListDetails = new ArrayList<>();
		priceList.forEach(priceWebElement->priceListDetails.add(priceWebElement.getText()));
		return priceListDetails;
	}

	public List<Integer> getPriceList(){
		List<String> rawPriceListDetails = getRawPriceList();
		List<Integer> priceListDetails = new ArrayList<>();
		for(String price : rawPriceListDetails) {
			priceListDetails.add(Integer.parseInt(price.replaceAll("\\D+","")));
		}
		return priceListDetails;
	}

	public PropertyDetailsPage selectTheProperty(int propertyNo) {
		driver.findElement(By.xpath(String.format("(//ul[contains(@class,'listing-results ')]/li[contains(@class,'srp clearfix')]//a[@class='photo-hover'])[%d]",propertyNo))).click();
		return new PropertyDetailsPage(driver);
	}

}
