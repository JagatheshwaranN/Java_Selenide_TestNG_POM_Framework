package com.jtaf.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.jtaf.qa.objects.CustomerSearchPageObject;

/**
 * @implNote This class contains the customer search page functionalities used
 *           for the application under test.          
 * @author Jaga
 * @since 09-03-2022
 * @version v0.5
 */
public class CustomerSearchPage extends CustomerSearchPageObject {

	Logger log = logUtil.getLogger(CustomerSearchPage.class);

	public CustomerSearchPage(WebDriver selDriver) {
		super(selDriver);
	}

	/**
	 * @implNote This method is used to get the title value of the customer search
	 *           page
	 * @return CustomerSearchPage title
	 */
	public String customerSearchPageTitle() {
		return getPageTitle();
	}

	/**
	 * @implNote This method is used to get the header value of the customer search
	 *           page
	 * @return CustomerSearchPage header
	 */
	public String customerSearchPageHeader() {
		return getElementText(getCustomerSearchPageHeader());
	}

	/**
	 * @implNote This method takes the input as customer name and search the
	 *           customer
	 * @param customerName
	 */
	public void customerSearch(String customerName) {
		try {
			log.info("The application customer search page is displayed");
			getCustomerSearchSection().isDisplayed();
			getFirstName().sendKeys(customerName);
			getCustomerSearchButton().click();
			boolean flag = waitForElementPresent(getTableCustomerGrid());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException ex) {
				log.info(ex);
			}
			if (true == flag) {
				int customerNameGrid = getTableCustomerGridName().size();
				if (1 == customerNameGrid) {
					String actualCustomerName = getTableCustomerGridName().get(0).getText();
					log.info("Actual customer name ===> " + actualCustomerName);
					if (actualCustomerName.equalsIgnoreCase("Victoria Terces")) {
						log.info("Customer search match is successful");
					} else {
						Assert.assertFalse(true, "Customer search match is unsuccessful");
					}
				} else {
					log.info("Empty table data found ===> " + getTableCustomerGridEmpty().isDisplayed());
					Assert.assertFalse(true, "No customer data is found");
				}
			} else {
				Assert.assertFalse(true, "No customer search result section is found");
			}
		} catch (Exception ex) {
			log.info("Error occured while search the customer in the application" + "\n" + ex);
		}
	}

}
