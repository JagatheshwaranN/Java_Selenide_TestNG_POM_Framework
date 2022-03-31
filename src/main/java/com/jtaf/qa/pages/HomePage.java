package com.jtaf.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.jtaf.qa.objects.HomePageObject;

/**
 * @implNote This class contains the home page functionalities used for the
 *           application under test.          
 * @author Jaga
 * @since 09-03-2022
 * @version v0.4
 */
public class HomePage extends HomePageObject {
	
	Logger log = logUtil.getLogger(HomePage.class);

	public HomePage(WebDriver selDriver) {
		super(selDriver);
	}

	/**
	 * @implNote This method is used to get the title value of the home page
	 * @return HomePage title
	 */
	public String homePageTitle() {
		return getPageTitle();
	}

	/**
	 * @implNote This method is used to get the header value of the home page
	 * @return HomePage header
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
			log.info("The application home page is displayed");
			getLeftNavCustomersOption().click();
			getLeftNavInlineCustomersOption().click();
			getCustomerSearchSection().isDisplayed();
			log.info("Navigate to the customer search page in the application is successful");
		} catch (Exception ex) {
			log.info("Error occured while navigate to the customer search page in the application" + "\n" + ex);
		}
		return getInstance(CustomerSearchPage.class);
	}

}
