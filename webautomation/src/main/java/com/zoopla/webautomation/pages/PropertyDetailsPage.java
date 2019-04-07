package com.zoopla.webautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PropertyDetailsPage extends BasePage{

	@FindBy(xpath="//h1[text()='Property Listing Details']")
	private WebElement propertyDetailsHeader;

	@FindBy(xpath = "//div[@class='dp-sidebar-wrapper']//div[@class='ui-agent__logo']/img")
	private WebElement agentLogo;

	@FindBy(xpath="//div[@class='dp-sidebar-wrapper']//h4[@class='ui-agent__name']")
	private WebElement agentName;

	@FindBy(xpath="//div[@class='dp-sidebar-wrapper']//a[@data-track-label='Agent phone number 1']")
	private WebElement agentPhoneNo;

	public PropertyDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
		waitForWebElement(propertyDetailsHeader, LONG_WAIT);
		System.out.println("Navigating to Property Details Page.");
	}

	public boolean isAgentLogo() {
		return isElementVisible(agentLogo, LONG_WAIT);
	}

	public boolean isAgentName() {
		return isElementVisible(agentName, LONG_WAIT);
	}

	public boolean isAgentPhoneNo() {
		return isElementVisible(agentPhoneNo, LONG_WAIT);
	}

	public String getAgentLogoSrc() {
		return agentLogo.getAttribute("src");
	}

	public String getAgentName() {
		return agentName.getText();
	}

	public String getAgentPhoneNo(){
		return agentPhoneNo.getText();
	}
	
	public PropertyAgentPage openAgentDetailsPage() {
		agentName.click();
		return new PropertyAgentPage(driver);
	}
}
