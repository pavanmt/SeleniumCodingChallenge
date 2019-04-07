package com.zoopla.webautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PropertyAgentPage extends BasePage{
	
	@FindBy(id="agent-details-tabs")
	private WebElement agentDetailsTab;
	
	@FindBy(xpath = "//div[@id='listings-agent']//img[@class='agent_logo']")
	private WebElement agentLogo;

	@FindBy(xpath="(//div[@id='listings-agent']//p//strong)[1]")
	private WebElement agentName;

	@FindBy(xpath="//div[@id='listings-agent']//span[@class='agent_phone']")
	private WebElement agentPhoneNo;
	
	public PropertyAgentPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		waitForWebElement(agentDetailsTab, LONG_WAIT);
		System.out.println("Navigating to Property Agent Page.");
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

}
