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
 * @implNote This class contains the reusable abstract method definitions used in the framework
 * @since 22-01-2022
 * @version v0.1
 *
 */
public abstract class Page {

	public SelenideDriver selDriver = null;
	public SelenideWait wait = null;

	public Page(SelenideDriver selDriver) {
		this.selDriver = selDriver;
		this.wait = new SelenideWait((WebDriver) this.selDriver, 30, 5);
	}

	public abstract String getPageTitle();

	public abstract String getPageHeader(SelenideElement webElement);

	public abstract SelenideElement getElement(SelenideElement webElement);

	public abstract ElementsCollection getElements(ElementsCollection webElements);

	public abstract void waitForElementPresent(SelenideElement webElement);

	public abstract void waitForElementVisible(SelenideElement element);

	public abstract void waitForPageTitle(String title);

	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
		try {
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.selDriver);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
