/*
 * Copyright (c) 2022 - 2023 [Fanclash.in].
 * All rights reserved.
 */
package com.kam.stepdefinition;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * @author kamlesh
 *
 */
public class DriverFactory {

	private WebDriver driver;

	private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

	/**
	 *
	 */
	public WebDriver init() {
		System.setProperty(" webdriver.http.factory ", " jdk-http-client ");
		// Initi browser
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		options.addArguments("--remote-allow-origins=*");
		// options.addArguments("--headless");
		options.addArguments("--window-size=1920x1080");
		// docker
		options.addArguments("--ignore-ssl-errors=yes");
		options.addArguments("--ignore-certificate-errors");
		// options.setBrowserVersion("latest");
		// init driver
		driver = new ChromeDriver(options);
		// try {
		// driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
		// } catch (MalformedURLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		threadLocal.set(driver);
		return getDriver();

	}

	/**
	 * @return the driver
	 */
	public static WebDriver getDriver() {
		return threadLocal.get();
	}
}
