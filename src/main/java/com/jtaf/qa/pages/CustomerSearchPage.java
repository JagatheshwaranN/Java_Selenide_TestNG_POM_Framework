package com.jtaf.qa.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.jtaf.qa.objects.CustomerSearchPageObject;

/**
 * 
 * @implNote This class contains the customer search page functionalities used
 *           for the application under test.
 * @author Jaga
 * @since 03-03-2022
 * @version v0.4
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

	/**
	 * @implNote This method takes the input as customer name and search the
	 *           customer
	 * @param customerName
	 * 
	 */
	public void customerSearch(String customerName) {
		try {
			getCustomerSearchSection().isDisplayed();
			getFirstName().sendKeys(customerName);
			getCustomerSearchButton().click();
			boolean flag = waitForElementPresent(getTableCustomerGrid());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			if (true == flag) {
				int customerNameGrid = getTableCustomerGridName().size();
				if (1 == customerNameGrid) {
					String actualCustomerName = getTableCustomerGridName().get(0).getText();
					System.out.println("Actual customer name : " + actualCustomerName);
					if (actualCustomerName.equalsIgnoreCase("Victoria Terces")) {
						System.out.println("Customer search match successful");
					} else {
						Assert.assertFalse(true, "Customer match unsuccessful");
					}
				} else {
					System.out.println("Empty table data found : " + getTableCustomerGridEmpty().isDisplayed());
					Assert.assertFalse(true, "No customer data found");
				}
			} else {
				Assert.assertFalse(true, "No customer search result section found");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
