package com.kam.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.kam.pages.SearchPage;
import com.kam.pages.SearchResultPage;

/**
 * @author kamlesh
 *
 */
public class PageObjectManager {

	private WebDriver driver;

	private SearchPage searchPage;

	private SearchResultPage searchResultPage;

	public PageObjectManager(final WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * @return the searchPage
	 */
	public SearchPage getSearchPage() {
		if (searchPage == null) {
			searchPage = PageFactory.initElements(driver, SearchPage.class);
		}
		return searchPage;
	}

	/**
	 * @return the SearchResultPage
	 */
	public SearchResultPage getSearchResultPage() {
		if (searchResultPage == null) {
			searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);
		}
		return searchResultPage;
	}

}
