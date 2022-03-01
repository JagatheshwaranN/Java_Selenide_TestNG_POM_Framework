package com.jtaf.qa.pages;

import org.openqa.selenium.WebDriver;
import com.jtaf.qa.objects.LoginPageObject;

/**
 * 
 * @implNote This class contains the login page functionality used for the
 *           application under test.
 * @author Jaga
 * @since 30-01-2022
 * @version v0.1
 *
 */
public class LoginPage extends LoginPageObject {

	public LoginPage(WebDriver selDriver) {
		super(selDriver);
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
