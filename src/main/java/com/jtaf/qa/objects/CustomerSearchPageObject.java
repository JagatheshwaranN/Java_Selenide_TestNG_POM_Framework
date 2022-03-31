package com.jtaf.qa.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.jtaf.qa.pages.BasePage;

/**
 * @implNote This class stores the customer search page web objects used for the
 *           application under test.
 * @author Jaga
 * @since 03-03-2022
 * @version v0.3
 */
public class CustomerSearchPageObject extends BasePage {

	private By customerSearchPageHeader = By.xpath("//h1[@class='float-left']");
	private By customerSearchSection = By.xpath("//div[@class='card card-default card-search']");
	private By firstName = By.id("SearchFirstName");
	private By customerSearchButton = By.id("search-customers");
	private By tableCustomerGrid = By.xpath("//table[@id='customers-grid']");
	private By tableCustomerGridName = By.xpath("//table[@id='customers-grid']//tbody//tr//td[3]");
	private By tableCustomerGridEmpty = By.xpath("//table//td[@class='dataTables_empty']");

	public CustomerSearchPageObject(WebDriver selDriver) {
		super(selDriver);
	}

	/**
	 * @return the customerSearchPageHeader element
	 */
	public SelenideElement getCustomerSearchPageHeader() {
		return getSelenideElement(customerSearchPageHeader);
	}

	/**
	 * @return the customerSearchSection element
	 */
	public SelenideElement getCustomerSearchSection() {
		return getSelenideElement(customerSearchSection);
	}

	/**
	 * @return the firstName element
	 */
	public SelenideElement getFirstName() {
		return getSelenideElement(firstName);
	}

	/**
	 * @return the customerSearchButton element
	 */
	public SelenideElement getCustomerSearchButton() {
		return getSelenideElement(customerSearchButton);
	}

	/**
	 * @return the tableCustomerGrid element
	 */
	public SelenideElement getTableCustomerGrid() {
		return getSelenideElement(tableCustomerGrid);
	}

	/**
	 * @return the tableCustomerGridName element
	 */
	public ElementsCollection getTableCustomerGridName() {
		return getSelenideElements(tableCustomerGridName);
	}

	/**
	 * @return the tableCustomerGridEmpty element
	 */
	public SelenideElement getTableCustomerGridEmpty() {
		return getSelenideElement(tableCustomerGridEmpty);
	}

}
