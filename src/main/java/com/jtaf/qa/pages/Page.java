package com.jtaf.qa.pages;

import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.SelenideWait;
import com.codeborne.selenide.impl.SelenidePageFactory;

import static com.codeborne.selenide.Condition.*;

/**
 * 
 * @author Jaga
 * 
 * This class contains the reusable abstract method definitions used in the framework
 * 
 * @since 22-01-2022
 * 
 * @version v0.1
 *
 */
public abstract class Page {

	public SelenideDriver driver = null;
	public SelenideWait wait = null;

	public Page(SelenideDriver driver) {
		this.driver = driver;
		this.wait = new SelenideWait((WebDriver) this.driver, 30, 5);
	}

	public abstract String getPageTitle();

	public abstract String getPageHeader();

	public abstract SelenideElement getElement();

	public abstract ElementsCollection getElements();

	public abstract void waitForElementPresent();

	public abstract void waitForElementVisible();

	public abstract void waitForPageTitle();

	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
		try {
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
