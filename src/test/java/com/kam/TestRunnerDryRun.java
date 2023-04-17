/*
 * Copyright (c) 2022 - 2023 [Fanclash.in].
 * All rights reserved.
 */
package com.kam;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * @author kamlesh
 *
 */
@CucumberOptions(features = "src/test/resources/features", glue = {"com.kam.stepdefinition"}, plugin = {"pretty",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, monochrome = true, dryRun = true)
public class TestRunnerDryRun extends AbstractTestNGCucumberTests {

}
