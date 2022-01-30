package com.jtaf.qa.objects;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;
import com.jtaf.qa.pages.BasePage;

/**
 * 
 * @author Jaga
 * @implNote This class stores the login page web objects used for the
 *           application under test.
 * @since 30-01-2022
 * @version v0.1
 *
 */
public class LoginPageObject extends BasePage {

	@FindBy(how = How.CSS, using = "#Email")
	private SelenideElement emailId;
	@FindBy(how = How.CSS, using = "#Password")
	private SelenideElement password;
	@FindBy(how = How.XPATH, using = "//button[text()='Log in']")
	private SelenideElement loginButton;
	@FindBy(how = How.CLASS_NAME, using = "page-title")
	private SelenideElement header;

	public LoginPageObject(SelenideDriver selDriver) {
		super(selDriver);
		PageFactory.initElements((SearchContext) selDriver, this);
	}

	/**
	 * @return the emailId
	 */
	public SelenideElement getEmailId() {
		return emailId;
	}

	/**
	 * @return the password
	 */
	public SelenideElement getPassword() {
		return password;
	}

	/**
	 * @return the loginButton
	 */
	public SelenideElement getLoginButton() {
		return loginButton;
	}

	/**
	 * @return the header
	 */
	public SelenideElement getHeader() {
		return header;
	}

}
