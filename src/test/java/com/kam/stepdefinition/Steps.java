/*
 * Copyright (c) 2022 - 2023 [Fanclash.in].
 * All rights reserved.
 */
package com.kam.stepdefinition;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.kam.TestContext;
import com.kam.manager.PageObjectManager;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

/**
 * @author kamlesh
 *
 */
public class Steps {

	private Scenario scenario;
	WebDriver driver;
	PageObjectManager pageObjectManager;
	private DriverFactory driverFactory;

	/**
	 *
	 */
	public Steps(final TestContext testContext) {
		driverFactory = testContext.getDriverFactory();
		pageObjectManager = testContext.getPageObjectManager();
	}

	@Before
	public void before(final Scenario scenario) {
		this.scenario = scenario;
		driver = driverFactory.getDriver();
		// pageObjectManager = new PageObjectManager(driver);
	}

	@Before(order = 0, value = "@tag2")
	public void beforeTag2(final Scenario scenario) {
		scenario.log("before tag2");
	}

	@Given("I want to search keyword in google")
	public void i_want_to_search_keyword_in_google() {
		scenario.log("Start scenario");

		//
	}

	@When("I navigate to google search page")
	public void i_navigate_to_google_search_page() {
		driver.navigate().to("https://www.google.com/");
	}

	@When("search for {string}")
	public void search_for(final String string) {
		pageObjectManager.getSearchPage().fillSearchText(string);
		// driver.findElement(By.name("q")).sendKeys(string);
	}

	@Given("search for")
	public void search_for(final io.cucumber.datatable.DataTable dataTable) {
		pageObjectManager.getSearchPage().fillSearchText(dataTable.asList().get(0));
		// driver.findElement(By.name("q")).sendKeys(dataTable.asMap().get(""));
	}

	@And("click on enter")
	public void click_on_enter() {
		pageObjectManager.getSearchPage().enterSearchText();
		// String parent = driver.getWindowHandle();
		// Set<String> wh = driver.getWindowHandles();
		// for (String string : wh) {
		// if(!string.equals(parent)) {
		// driver.switchTo().window(string);
		// }
		// }
		//
	}

	/**
	 *
	 */
	private void waitForAjax() {
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(d -> {
			Boolean isJqueryCallDone = (Boolean) ((JavascriptExecutor) d).executeScript("return jQuery.active==0");
			if (!isJqueryCallDone) {
				System.out.println("JQuery call is in Progress");
			}
			return isJqueryCallDone;
		});

	}

}
