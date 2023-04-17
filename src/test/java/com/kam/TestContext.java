package com.kam;

import com.kam.manager.PageObjectManager;
import com.kam.stepdefinition.DriverFactory;

/**
 * @author kamlesh
 *
 */
public class TestContext {
	private PageObjectManager pageObjectManager;

	private DriverFactory driverFactory;

	public TestContext() {
		driverFactory = new DriverFactory();
		pageObjectManager = new PageObjectManager(driverFactory.init());
	}

	public DriverFactory getDriverFactory() {
		return driverFactory;
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

}
