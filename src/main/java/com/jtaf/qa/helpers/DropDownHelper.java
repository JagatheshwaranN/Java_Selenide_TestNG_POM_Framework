package com.jtaf.qa.helpers;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.jtaf.qa.utilties.LoggerUtility;

/**
 * 
 * @implNote This class contains the components that handle the Drop downs.
 * 
 * @author Jaga
 * @since 05-03-2022
 * @version v0.1
 *
 */
public class DropDownHelper extends LoggerUtility {

	Logger log = getLogger(DropDownHelper.class);

	public void selectByValue(SelenideElement webElement, String value) {
		try {
			webElement.selectOptionByValue(value);
			log.info("The value " + value + " is selected in the drop down");
		} catch (Exception ex) {
			log.info("Error occured while select the option from drop down" + "\n" + ex);
		}
	}

	public void selectByIndex(SelenideElement webElement, int index) {
		try {
			webElement.selectOption(index);
			log.info("The value at index " + index + " is selected in the drop down");
		} catch (Exception ex) {
			log.info("Error occured while select the option from drop down" + "\n" + ex);
		}
	}

	public void selectByVisibleText(SelenideElement webElement, String visibleText) {
		try {
			webElement.selectOption(visibleText);
			log.info("The visible text " + visibleText + " is selected in the drop down");
		} catch (Exception ex) {
			log.info("Error occured while select the option from drop down" + "\n" + ex);
		}
	}

	public String getSelectValue(SelenideElement webElement) {
		String value = null;
		try {
			webElement.getSelectedValue();
			log.info("The drop down option selected value text is ===> " + value);
		} catch (Exception ex) {
			log.info("Error occured while get the selected option text from drop down" + "\n" + ex);
		}
		return value;
	}

	public List<String> getAllDropDownValue(SelenideElement webElement) {
		List<String> dropdownvalues = null;
		try {
			ElementsCollection eleCollection = webElement.getSelectedOptions();
			dropdownvalues = new LinkedList<String>();
			for (SelenideElement webElement1 : eleCollection) {
				log.info("The drop down option values are ===> " + webElement1.getText());
				dropdownvalues.add(webElement1.getText());
			}
		} catch (Exception ex) {
			log.info("Error occured while get the drop down option values" + "\n" + ex);
		}
		return dropdownvalues;
	}

}
