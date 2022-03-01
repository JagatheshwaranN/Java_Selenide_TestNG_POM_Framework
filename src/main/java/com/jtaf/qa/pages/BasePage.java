package com.jtaf.qa.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.codeborne.selenide.Condition;

/**
 * 
 * @author Jaga
 * @implNote This class contains the reusable components used in the framework.
 * @since 26-02-2022
 * @version v0.3
 *
 */
public class BasePage extends Page {

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
			System.out.println("Some error occured while creation of element : " + locator.toString());
			ex.printStackTrace();
		}
		return element;
	}

	@Override
	public ElementsCollection getElements(ElementsCollection webElements) {
		return null;
	}

	@Override
	public void waitForElementPresent(SelenideElement webElement) {
		webElement.shouldBe(Condition.appear, Duration.ofSeconds(3));
	}

	@Override
	public void waitForElementVisible(SelenideElement webElement) {
		webElement.shouldBe(Condition.visible, Duration.ofSeconds(3));
	}

	@Override
	public String getElementText(SelenideElement element) {
		return element.getText();
	}

	@Override
	public void waitForPageTitle(String title) {
		try {
			Wait().until(ExpectedConditions.titleContains(title));
		} catch (Exception ex) {
			System.out.println("Some error occured while wait for page title : " + title);
			ex.printStackTrace();
		}

	}

}
