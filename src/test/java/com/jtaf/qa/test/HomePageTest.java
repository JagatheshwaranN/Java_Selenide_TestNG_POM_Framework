package com.jtaf.qa.test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jtaf.qa.base.TestBase;
import com.jtaf.qa.pages.HomePage;
import com.jtaf.qa.pages.LoginPage;

/**
 * 
 * @implNote This class contains the home page test functionality.
 * 
 * @author Jaga
 * @since 09-03-2022
 * @version v0.2
 *
 */
public class HomePageTest extends TestBase {
	
	Logger log = getLogger(HomePageTest.class);

	@Test(priority = 2)
	public void verifyHomePageTest() {
		try {
			HomePage homePage = page.getInstance(LoginPage.class).doLogin(getTestData("app.username"),
					getTestData("app.password"));
			String title = page.getInstance(HomePage.class).homePageTitle();
			String homePageHeader = homePage.homePageHeader();
			Assert.assertEquals(title, getTestData("home.page.title"));
			Assert.assertEquals(homePageHeader, getTestData("home.page.header"));
		} catch (Exception ex) {
			log.info("Error occured while verify home page test" + "\n" + ex);
		}
	}
}
