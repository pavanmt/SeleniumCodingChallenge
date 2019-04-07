package com.zoopla.webautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	public static int SMALL_WAIT = 5;
	public static int MEDIUM_WAIT = 10;
	public static int LONG_WAIT = 20;
	public static int EXTREME_WAIT = 40;
	
    public WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void waitForWebElement(WebElement webElement, int timeOutInSeconds) {
		new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOf(webElement));
	}
	
	public void waitForWebElement(By byLocator, int timeOutInSeconds) {
		new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOfElementLocated(byLocator));
	}

	public boolean isElementVisible(WebElement webElement, int timeOutInSeconds) {
		try {
			return new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOf(webElement)).isDisplayed();
		}catch(TimeoutException | NoSuchElementException e) {
			return false;
		}
	}

}
