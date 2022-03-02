package com.jtaf.qa.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jtaf.qa.base.TestBase;
import com.jtaf.qa.pages.HomePage;
import com.jtaf.qa.pages.LoginPage;

/**
 * 
 * @implNote This class contains the login page test functionality.
 * @author Jaga
 * @since 02-03-2022
 * @version v0.5
 *
 */
public class LoginPageTest extends TestBase {

	@Test(priority = 1)
	public void verifyLoginTest() {
		try {
			String title = page.getInstance(LoginPage.class).loginPageTitle();
			String header = page.getInstance(LoginPage.class).loginPageHeader();
			Assert.assertEquals(title, getTestData("login.page.title"));
			Assert.assertEquals(header, getTestData("login.page.header"));
			HomePage homePage = page.getInstance(LoginPage.class).doLogin(getTestData("app.username"),
					getTestData("app.password"));
			String homePageHeader = homePage.getElementText(homePage.getHomePageHeader());
			Assert.assertEquals(homePageHeader, getTestData("home.page.header"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
