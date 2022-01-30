package com.jtaf.qa.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;

/**
 * 
 * @author Jaga
 * 
 * This class contains the reusable methods used in the framework
 * 
 * @since 30-01-2022
 * 
 * @version v0.1
 *
 */
public class BasePage extends Page{

	public BasePage(SelenideDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getPageTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPageHeader() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SelenideElement getElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ElementsCollection getElements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void waitForElementPresent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void waitForElementVisible() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void waitForPageTitle() {
		// TODO Auto-generated method stub
		
	}

}
