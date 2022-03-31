package com.jtaf.qa.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.codeborne.selenide.SelenideElement;
import com.jtaf.qa.pages.BasePage;

/**
 * @implNote This class stores the login page web objects used for the
 *           application under test.
 * @author Jaga
 * @since 01-03-2022
 * @version v0.3
 */
public class LoginPageObject extends BasePage {

	private By emailId = By.id("Email");
	private By password = By.id("Password");
	private By loginButton = By.xpath("//button[text()='Log in']");
	private By loginPageHeader = By.className("page-title");

	public LoginPageObject(WebDriver selDriver) {
		super(selDriver);
	}

	/**
	 * @return the loginPageHeader element
	 */
	public SelenideElement getLoginPageHeader() {
		return getSelenideElement(loginPageHeader);
	}

	/**
	 * @return the emailId element
	 */
	public SelenideElement getEmailId() {
		return getSelenideElement(emailId);
	}

	/**
	 * @return the password element
	 */
	public SelenideElement getPassword() {
		return getSelenideElement(password);
	}

	/**
	 * @return the loginButton element
	 */
	public SelenideElement getLoginButton() {
		return getSelenideElement(loginButton);
	}

}
