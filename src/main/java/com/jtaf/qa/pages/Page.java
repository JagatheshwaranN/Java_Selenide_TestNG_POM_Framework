package com.jtaf.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.SelenideWait;

/**
 * 
 * @implNote This class contains the reusable abstract method definitions used
 *           in the framework.
 * @author Jaga
 * @since 26-02-2022
 * @version v0.3
 *
 */
public abstract class Page {

	public WebDriver selDriver = null;
	public SelenideWait wait = null;

	public Page(WebDriver selDriver) {
		this.selDriver = selDriver;
		this.wait = new SelenideWait(selDriver, 30, 5);
	}

	public abstract String getPageTitle();

	public abstract String getPageHeader(SelenideElement webElement);

	public abstract SelenideElement getSelenideElement(By webElement);

	public abstract ElementsCollection getElements(ElementsCollection webElements);

	public abstract void waitForElementPresent(SelenideElement webElement);

	public abstract void waitForElementVisible(SelenideElement element);

	public abstract String getElementText(SelenideElement element);

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
