package com.jtaf.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.jtaf.qa.objects.LoginPageObject;

/**
 * @implNote This class contains the login page functionalities used for the
 *           application under test.          
 * @author Jaga
 * @since 09-03-2022
 * @version v0.4
 */
public class LoginPage extends LoginPageObject {
	
	Logger log = logUtil.getLogger(LoginPage.class);

	public LoginPage(WebDriver selDriver) {
		super(selDriver);
	}

	/**
	 * @implNote This method is used to get the title value of the login page
	 * @return LoginPage title
	 */
	public String loginPageTitle() {
		return getPageTitle();
	}

	/**
	 * @implNote This method is used to get the header value of the login page
	 * @return LoginPage header
	 */
	public String loginPageHeader() {
		return getElementText(getLoginPageHeader());
	}

	/**
	 * @implNote This method takes the inputs as user name & password and log in to
	 *           the application.
	 * @param username
	 * @param password
	 * @return HomePage instance
	 */
	public HomePage doLogin(String username, String password) {
		try {
			log.info("The application login page is displayed");
			getEmailId().setValue(username);
			getPassword().setValue(password);
			getLoginButton().click();
			log.info("Login to the application is successful");
		} catch (Exception ex) {
			log.info("Error occured while login to the application" + "\n" + ex);
		}
		return getInstance(HomePage.class);
	}
}
