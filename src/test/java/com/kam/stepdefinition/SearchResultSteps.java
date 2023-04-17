/*
 * Copyright (c) 2022 - 2023 [Fanclash.in].
 * All rights reserved.
 */
package com.kam.stepdefinition;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.kam.TestContext;
import com.kam.manager.PageObjectManager;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

/**
 * @author kamlesh
 *
 */
public class SearchResultSteps {

	private Scenario scenario;

	private WebDriver driver;

	private PageObjectManager pageObjectManager;

	private DriverFactory driverFactory;

	/**
	 *
	 */
	public SearchResultSteps(final TestContext testContext) {
		driverFactory = testContext.getDriverFactory();
		pageObjectManager = testContext.getPageObjectManager();
	}

	@Before
	public void before(final Scenario scenario) {
		this.scenario = scenario;
		driver = driverFactory.getDriver();
		// pageObjectManager = new PageObjectManager(driver);
	}

	@Then("I should see google result page contsins {string}")
	public void i_should_see_google_result_page(final String string) {
		assertTrue(driver.getPageSource().contains(string));
	}

	@Then("check result contain search keyword")
	public void check_result_contain_search_keyword() {
		driver.navigate().back();

	}

	@Given("I want to search multiple keywords")
	public void i_want_to_search_multiple_keywords() {
		driver.navigate().to("https://www.google.com/");
	}

	@Then("verify and go back to search page")
	public void verify_and_go_back_to_search_page() {
		driver.navigate().back();
	}

	/**
	 * @param findElement
	 */
	private void scrollIntoView(final WebElement findElement) {
		Actions actions = new Actions(driver);
		actions.scrollToElement(findElement);
		actions.build().perform();
	}

	/**
	 * @param findElement
	 */
	private void click(final WebElement findElement) {
		waitUntillElementIsClickable(findElement);
		findElement.click();
	}

	private void waitUntillElementIsClickable(final WebElement findElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.ignoring(StaleElementReferenceException.class);
		wait.until(ExpectedConditions.elementToBeClickable(findElement));
	}

	private void waitUntillElementIsVisible(final WebElement findElement) {
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// wait.until(driver -> findElement.getAttribute("class").contains("ui-ele"));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(findElement)));
	}

	private void waitUntillElementIsVisibleFW2(final WebElement findElement) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).pollingEvery(Duration.ofMillis(500))
				.withTimeout(Duration.ofSeconds(30)).ignoring(StaleElementReferenceException.class);
		wait.until(driver -> findElement.getAttribute("class").contains("ui-ele"));

	}

	/**
	 * @param findElement
	 */
	private void hover(final WebElement findElement) {
		waitUntillElementIsVisible(findElement);
		Actions action = new Actions(driver);
		action.moveToElement(findElement);
		action.build().perform();
	}

}
