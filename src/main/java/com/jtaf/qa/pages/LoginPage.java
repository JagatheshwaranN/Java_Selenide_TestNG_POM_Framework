package com.jtaf.qa.pages;

import com.codeborne.selenide.SelenideDriver;
import com.jtaf.qa.objects.LoginPageObject;

/**
 * 
 * @author Jaga
 * @implNote This class contains the login functionality used for the application under test.
 * @since 30-01-2022
 * @version v0.1
 *
 */
public class LoginPage extends LoginPageObject {

	public LoginPage(SelenideDriver selDriver) {
		super(selDriver);
	}

	/**
	 * 
	 * @param username
	 * @param password
	 * @return HomePage instance
	 * @implNote This method takes the inputs as user name & password and log in to the application.
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
