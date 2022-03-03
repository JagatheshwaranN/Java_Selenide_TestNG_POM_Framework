package com.jtaf.qa.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jtaf.qa.base.TestBase;
import com.jtaf.qa.pages.CustomerSearchPage;
import com.jtaf.qa.pages.HomePage;
import com.jtaf.qa.pages.LoginPage;

/**
 * 
 * @implNote This class contains the customer search page test functionality.
 * @author Jaga
 * @since 03-03-2022
 * @version v0.2
 *
 */
public class CustomerSearchPageTest extends TestBase {

	@Test(priority = 3)
	public void verifyCustomerSearchTest() {
		try {
			HomePage homePage = page.getInstance(LoginPage.class).doLogin(getTestData("app.username"),
					getTestData("app.password"));
			String title = page.getInstance(HomePage.class).homePageTitle();
			String homePageHeader = homePage.homePageHeader();
			Assert.assertEquals(title, getTestData("home.page.title"));
			Assert.assertEquals(homePageHeader, getTestData("home.page.header"));
			CustomerSearchPage customerSearchPage = homePage.navigateToCustomerSearchPage();
			String customerSearchPageHeader = customerSearchPage.customerSearchPageHeader();
			Assert.assertEquals(customerSearchPageHeader, getTestData("customer.search.page.header"));
			customerSearchPage.customerSearch(getTestData("customer.name"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
