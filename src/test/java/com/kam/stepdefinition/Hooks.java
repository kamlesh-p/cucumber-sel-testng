/*
 * Copyright (c) 2022 - 2023 [Fanclash.in].
 * All rights reserved.
 */
package com.kam.stepdefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

/**
 * @author kamlesh
 *
 */
public class Hooks {

	private WebDriver driver = null;

	private Scenario scenario;

	public WebDriver getDriver() {
		return driver;
	}

	@Before
	public void before(final Scenario scenario) {
		this.scenario = scenario;
		driver = DriverFactory.getDriver();
	}

	@After
	public void cleanup(final Scenario scenario) {
		if (scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "github");
		}

		if (driver != null) {
			// close
			driver.close();
			driver.quit();
		}
	}

}
