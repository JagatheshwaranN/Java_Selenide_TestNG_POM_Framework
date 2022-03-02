package com.jtaf.qa.pages;

import org.openqa.selenium.WebDriver;

import com.jtaf.qa.objects.HomePageObject;

/**
 * 
 * @implNote This class contains the home page functionalities used for the
 *           application under test.
 * @author Jaga
 * @since 02-03-2022
 * @version v0.3
 *
 */
public class HomePage extends HomePageObject {

	public HomePage(WebDriver selDriver) {
		super(selDriver);
	}

	/**
	 * 
	 * @implNote This method is used to get the title value of the home page
	 * @return HomePage title
	 * 
	 */
	public String homePageTitle() {
		return getPageTitle();
	}
	
	/**
	 * 
	 * @implNote This method is used to get the header value of the home page
	 * @return HomePage header
	 * 
	 */
	public String homePageHeader() {
		return getElementText(getHomePageHeader());
	}
	
	/**
	 * @implNote This method is used to navigate to the customer search page of the
	 *           application.
	 * @return CustomerSearchPage instance
	 */
	public CustomerSearchPage navigateToCustomerSearchPage() {
		try {
			getLeftNavCustomersOption().click();
			getLeftNavInlineCustomersOption().click();
			getCustomerSearchSection().isDisplayed();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return getInstance(CustomerSearchPage.class);
	}

}
