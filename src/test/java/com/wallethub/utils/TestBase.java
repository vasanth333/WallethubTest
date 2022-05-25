package com.wallethub.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestBase extends BrowserInitialization {

	// Browser session starts before @Test
	@BeforeClass
	@Parameters(value = { "browserName", "url" })
	public WebDriver initBrowsers(String browserName, String url) throws Exception {

		if (driver == null) {
			createBrowserInstance(browserName);

			driver.get(url);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}
		return driver;
	}

	// Browser session Ends After @Test
	@AfterTest
	public void quitBrowsers() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

}