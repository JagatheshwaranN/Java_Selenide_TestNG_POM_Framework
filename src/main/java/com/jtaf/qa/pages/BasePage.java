package com.jtaf.qa.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

import java.time.Duration;


import org.openqa.selenium.support.ui.ExpectedConditions;

import com.codeborne.selenide.Condition;

/**
 * 
 * @author Jaga
 * @implNote This class contains the reusable components used in the framework.
 * @since 30-01-2022
 * @version v0.1
 *
 */
public class BasePage extends Page {

	public BasePage(SelenideDriver selDriver) {
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
	public SelenideElement getElement(SelenideElement webElement) {
		return null;
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
	public void waitForPageTitle(String title) {
		try {
			Wait().until(ExpectedConditions.titleContains(title));
		} catch (Exception ex) {
			System.out.println("Some error occured while wait for page title : " + title);
			ex.printStackTrace();
		}

	}

}
