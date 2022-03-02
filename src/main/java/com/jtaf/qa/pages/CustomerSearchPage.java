package com.jtaf.qa.pages;

import org.openqa.selenium.WebDriver;

import com.jtaf.qa.objects.CustomerSearchPageObject;

/**
 * 
 * @implNote This class contains the customer search page functionalities used for
 *           the application under test.
 * @author Jaga
 * @since 02-03-2022
 * @version v0.3
 *
 */
public class CustomerSearchPage extends CustomerSearchPageObject {

	public CustomerSearchPage(WebDriver selDriver) {
		super(selDriver);
	}

	/**
	 * 
	 * @implNote This method is used to get the title value of the customer search
	 *           page
	 * @return CustomerSearchPage title
	 * 
	 */
	public String customerSearchPageTitle() {
		return getPageTitle();
	}

	/**
	 * 
	 * @implNote This method is used to get the header value of the customer search
	 *           page
	 * @return CustomerSearchPage header
	 * 
	 */
	public String customerSearchPageHeader() {
		return getElementText(getCustomerSearchPageHeader());
	}

}
