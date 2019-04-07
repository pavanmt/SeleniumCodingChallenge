package com.zoopla.webautomation;

import java.util.Comparator;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.zoopla.webautomation.pages.PropertyAgentPage;
import com.zoopla.webautomation.pages.PropertyDetailsPage;
import com.zoopla.webautomation.pages.SearchListingPage;
import com.zoopla.webautomation.pages.SearchPage;

public class SaleTests extends TestBase{
	
	private SearchPage searchPage;
	private SearchListingPage searchListingPage;
	private PropertyDetailsPage propertyDetailsPage;
	private PropertyAgentPage propertyAgentDetailsPage;
	
	@Test(description="Verify agent details for the propery selected.")
	public void agentDetailsVerification() {
		
		//Searching for London Location
		searchPage = new SearchPage(webdriver);
		searchPage.enterLocation("London");
		searchListingPage = searchPage.clickSearchBtn();
		
		//Prices on the search listing screen
		List<Integer> prices = searchListingPage.getPriceList();
		System.out.println("Prices Before Sorting: "+prices);
		//Sorting the prices in descending order.
		prices.sort(Comparator.reverseOrder());
		System.out.println("Prices After Sorting in decending order : "+prices);
		
		//Selecting the 5th property
		propertyDetailsPage = searchListingPage.selectTheProperty(5);
		
		//Verifying logo, name and phone no.
		Assert.assertTrue(propertyDetailsPage.isAgentLogo(), "Agent logo is missing on the details page.");
		Assert.assertTrue(propertyDetailsPage.isAgentName(), "Agent name is missing on the details page.");
		Assert.assertTrue(propertyDetailsPage.isAgentPhoneNo(), "Agent phoneno is missing on the details page.");
	
		//Storing property details page properties.
		String detailsPageAgentLogo = propertyDetailsPage.getAgentLogoSrc();
		String detailsPageAgentName = propertyDetailsPage.getAgentName();
		String detailsPageAgentPhoneNo = propertyDetailsPage.getAgentPhoneNo();
	
		//Opening agent details page
		propertyAgentDetailsPage = propertyDetailsPage.openAgentDetailsPage();
		
		//Verifying logo, name and phone no.
		Assert.assertTrue(propertyAgentDetailsPage.isAgentLogo(), "Agent logo is missing on the details page.");
		Assert.assertTrue(propertyAgentDetailsPage.isAgentName(), "Agent name is missing on the details page.");
		Assert.assertTrue(propertyAgentDetailsPage.isAgentPhoneNo(), "Agent phoneno is missing on the details page.");

		//Storing agent details page properties.
		String agentDetailsPageAgentLogo = propertyAgentDetailsPage.getAgentLogoSrc();
		String agentDetailsPageAgentName = propertyAgentDetailsPage.getAgentName();
		String agentDetailsPageAgentPhoneNo = propertyAgentDetailsPage.getAgentPhoneNo();
	
		//Verifying logo, name and phone no between property details and agent page.
		Assert.assertEquals(agentDetailsPageAgentLogo, detailsPageAgentLogo, "Miss match in Agent logo between agent and property details page.");
		Assert.assertEquals(agentDetailsPageAgentName, detailsPageAgentName, "Miss match in Agent name between agent and property details page.");
		//On agent details page country code gets added to the phone so asserting with contains.
		Assert.assertTrue(agentDetailsPageAgentPhoneNo.replaceAll("\\D+", "").contains(detailsPageAgentPhoneNo.replaceAll("\\D+", "").substring(1)), "Miss match in Agent phone no between agent and property details page.");
	
	}

}
