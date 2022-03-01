package com.jtaf.qa.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.codeborne.selenide.SelenideElement;
import com.jtaf.qa.pages.BasePage;

/**
 * 
 * @implNote This class stores the home page web objects used for the
 *           application under test.
 * @author Jaga
 * @since 01-03-2022
 * @version v0.2
 *
 */
public class HomePageObject extends BasePage {

	private By homePageHeader = By.xpath("//div[@class='content-header']");
	private By leftNavCustomersOption = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	private By leftNavInlineCustomersOption = By
			.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");
	private By customerSearchSection = By.xpath("//div[@class='card card-default card-search']");

	public HomePageObject(WebDriver selDriver) {
		super(selDriver);
	}

	/**
	 * @return the homePageHeader element
	 */
	public SelenideElement getHomePageHeader() {
		return getSelenideElement(homePageHeader);
	}

	/**
	 * @return the leftNavCustomersOption element
	 */
	public SelenideElement getLeftNavCustomersOption() {
		return getSelenideElement(leftNavCustomersOption);
	}

	/**
	 * @return the leftNavInlineCustomersOption element
	 */
	public SelenideElement getLeftNavInlineCustomersOption() {
		return getSelenideElement(leftNavInlineCustomersOption);
	}

	/**
	 * @return the customerSearchSection element
	 */
	public SelenideElement getCustomerSearchSection() {
		return getSelenideElement(customerSearchSection);
	}

}
