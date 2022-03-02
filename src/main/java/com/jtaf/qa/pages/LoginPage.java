package com.jtaf.qa.pages;

import org.openqa.selenium.WebDriver;
import com.jtaf.qa.objects.LoginPageObject;

/**
 * 
 * @implNote This class contains the login page functionalities used for the
 *           application under test.
 * @author Jaga
 * @since 02-03-2022
 * @version v0.3
 *
 */
public class LoginPage extends LoginPageObject {

	public LoginPage(WebDriver selDriver) {
		super(selDriver);
	}

	/**
	 * 
	 * @implNote This method is used to get the title value of the login page
	 * @return LoginPage title
	 * 
	 */
	public String loginPageTitle() {
		return getPageTitle();
	}

	/**
	 * 
	 * @implNote This method is used to get the header value of the login page
	 * @return LoginPage header
	 * 
	 */
	public String loginPageHeader() {
		return getElementText(getLoginPageHeader());
	}

	/**
	 * 
	 * @implNote This method takes the inputs as user name & password and log in to
	 *           the application.
	 * @param username
	 * @param password
	 * @return HomePage instance
	 * 
	 */
	public HomePage doLogin(String username, String password) {
		try {
			getEmailId().setValue(username);
			getPassword().setValue(password);
			getLoginButton().click();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return getInstance(HomePage.class);
	}
}
