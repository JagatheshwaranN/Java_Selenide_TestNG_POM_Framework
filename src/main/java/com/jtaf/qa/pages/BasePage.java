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
 * 
 * @implNote This class contains the reusable components used in the framework.
 * 
 * @author Jaga
 * @since 09-03-2022
 * @version v0.5
 *
 */
public class BasePage extends Page {

	protected LoggerUtility logUtil = new LoggerUtility();

	Logger log = logUtil.getLogger(BasePage.class);

	public BasePage(WebDriver selDriver) {
		super(selDriver);
	}

	@Override
	public String getPageTitle() {
		return title();
	}

	@Override
	public String getPageHeader(SelenideElement webElement) {
		return webElement.getText();
	}

	@Override
	public SelenideElement getSelenideElement(By locator) {
		SelenideElement element = null;
		try {
			element = $(locator);
		} catch (Exception ex) {
			log.info("Error occured while creation of the WebElement " + locator.toString() + "\n" + ex);
		}
		return element;
	}

	@Override
	public ElementsCollection getSelenideElements(By locator) {
		ElementsCollection element = null;
		try {
			element = $$(locator);
		} catch (Exception ex) {
			log.info("Error occured while creation of the WebElement " + locator.toString() + "\n" + ex);
		}
		return element;
	}

	@Override
	public boolean waitForElementPresent(SelenideElement webElement) {
		return webElement.shouldBe(Condition.appear, Duration.ofSeconds(3)) != null;
	}

	@Override
	public void waitForElementVisible(SelenideElement webElement) {
		webElement.shouldBe(Condition.visible, Duration.ofSeconds(3));
	}

	@Override
	public String getElementText(SelenideElement webElement) {
		return webElement.getText();
	}

	@Override
	public void waitForPageTitle(String title) {
		try {
			Wait().until(ExpectedConditions.titleContains(title));
		} catch (Exception ex) {
			log.info("Error occured while wait for page title ===> " + title + "\n" + ex);
		}

	}

}
