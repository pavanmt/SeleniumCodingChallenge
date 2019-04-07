package com.zoopla.webautomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

	public WebDriver webdriver;

	@BeforeMethod
	public void initBrowsers(ITestContext context) {
		String browserName = context.getSuite().getParameter("browser");
		if(browserName==null) {
			browserName = "chrome";
		}
		webdriver = getBrowser(browserName);
		System.out.println(String.format("Running tests on %s browser.", browserName));
		String url = "https://www.zoopla.co.uk/";
		webdriver.get(url);
		System.out.println(String.format("Launching url %s", url));
	}

	@AfterMethod
	public void closeBrowsers() {
		webdriver.quit();
	}
	
	public WebDriver getBrowser(String browserName) {
		switch (browserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
			webdriver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "src/resources/drivers/geckodriver.exe");
			webdriver = new FirefoxDriver();
			break;
		default:
			throw new RuntimeException(browserName+" is not yet implemented.");
		}
		webdriver.manage().window().maximize();
		return webdriver;
	}

}
