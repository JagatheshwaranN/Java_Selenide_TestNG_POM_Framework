package com.jtaf.qa.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import com.jtaf.qa.utilties.LoggerUtility;

import static com.codeborne.selenide.Selenide.*;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.codeborne.selenide.Condition;

/**
 * @implNote This class contains the reusable components used in the framework.
 * @author Jaga
 * @since 31-03-2022
 * @version v0.6
 */
public class BasePage extends Page {

	protected LoggerUtility logUtil = new LoggerUtility();

	Logger log = logUtil.getLogger(BasePage.class);

	public BasePage(WebDriver selDriver) {
		super(selDriver);
	}

	/**
	 * This method is used to get the web page title.
	 * @return title
	 */
	@Override
	public String getPageTitle() {
		return title();
	}

	/**
	 * This method is used to get the web page header web element text. It takes the
	 * webElement as input and return the text of the web element.
	 * @param webElement
	 * @return WebElement Text
	 */
	@Override
	public String getPageHeader(SelenideElement webElement) {
		return webElement.getText();
	}

	/**
	 * This method is used to construct the selenide web element. It takes the web
	 * locator object as input and return the web element.
	 * @param locator
	 * @return SelenideElement
	 */
	@Override
	public SelenideElement getSelenideElement(By locator) {
		SelenideElement webElement = null;
		try {
			webElement = $(locator);
		} catch (Exception ex) {
			log.info("Error occured while creation of the WebElement " + locator.toString() + "\n" + ex);
		}
		return webElement;
	}

	/**
	 * This method is used to construct the selenide web elements. It takes the web
	 * locator object as input and return the web elements.
	 * @param locator
	 * @return ElementsCollection
	 */
	@Override
	public ElementsCollection getSelenideElements(By locator) {
		ElementsCollection webElements = null;
		try {
			webElements = $$(locator);
		} catch (Exception ex) {
			log.info("Error occured while creation of the WebElement " + locator.toString() + "\n" + ex);
		}
		return webElements;
	}

	/**
	 * This method is used to wait for the presence of the selenide web element.
	 * @param webElement
	 * @return WebElement Status
	 */
	@Override
	public boolean waitForElementPresent(SelenideElement webElement) {
		return webElement.shouldBe(Condition.appear, Duration.ofSeconds(3)) != null;
	}

	/**
	 * This method is used to wait for the visibility of the selenide web element.
	 * @param webElement
	 */
	@Override
	public void waitForElementVisible(SelenideElement webElement) {
		webElement.shouldBe(Condition.visible, Duration.ofSeconds(3));
	}

	/**
	 * This method is used to get the text of the web element. It takes the
	 * webElement as input and return the text of the web element.
	 * @param webElement
	 * @return WebElement Text
	 */
	@Override
	public String getElementText(SelenideElement webElement) {
		return webElement.getText();
	}

	/**
	 * This method is used to wait for the web page title.
	 * @param title
	 */
	@Override
	public void waitForPageTitle(String title) {
		try {
			Wait().until(ExpectedConditions.titleContains(title));
		} catch (Exception ex) {
			log.info("Error occured while wait for page title ===> " + title + "\n" + ex);
		}

	}

}
