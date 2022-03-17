package com.jtaf.qa.helpers;

import org.apache.log4j.Logger;

import com.codeborne.selenide.SelenideElement;
import com.jtaf.qa.utilties.LoggerUtility;

/**
 * 
 * @implNote This class contains the components that handle the element
 *           verification functions.
 * 
 * @author Jaga
 * @since 05-03-2022
 * @version v0.1
 *
 */
public class VerificationHelper extends LoggerUtility {

	Logger log = getLogger(VerificationHelper.class);

	/**
	 * @implNote This method is used to verify the element is displayed on the page.
	 * @param webElement
	 * @return webElementDisplay
	 */
	public boolean verifyElementPresent(SelenideElement webElement) {
		boolean webElementDisplay = false;
		try {
			webElementDisplay = webElement.isDisplayed();
			log.info("WebElement is present on the page");
		} catch (Exception ex) {
			log.info("Error occured while check for the element present" + "\n" + ex);
		}
		return webElementDisplay;
	}

	/**
	 * @implNote This methosd is used to verify the web element's text and the given
	 *           text are equal.
	 * @param webElement
	 * @param text
	 * @return flag
	 */
	public boolean verifyTextEquals(SelenideElement webElement, String text) {
		boolean flag = false;
		try {
			String actualText = webElement.getText();
			if (actualText.equals(text)) {
				log.info("WebElement text and given text is equal");
				return flag = true;
			}
		} catch (Exception ex) {
			log.info("Error occured while check for the element text equal" + "\n" + ex);
		}
		return flag;
	}

	/**
	 * @implNote This method is used to get the text of the web element.
	 * @param webElement
	 * @return text
	 */
	public String readTextValueFromElement(SelenideElement webElement) {
		boolean webElementDisplay = false;
		String text = null;
		try {
			webElementDisplay = verifyElementPresent(webElement);
			if (!webElementDisplay)
				return null;
			text = webElement.getText();
			log.info("WebElement text is ===> " + text);
		} catch (Exception ex) {
			log.info("Error occured while check for the element text" + "\n" + ex);
		}
		return text;
	}

	/**
	 * @implNote This method is used to get the value of the web element.
	 * @param webElement
	 * @return value
	 */
	public String readValueFromInput(SelenideElement webElement) {
		String value = null;
		try {
			if (!verifyElementPresent(webElement))
				return null;
			value = webElement.getAttribute("value");
			log.info("WebElement value is ===> " + value);
		} catch (Exception ex) {
			log.info("Error occured while check for the element value" + "\n" + ex);
		}
		return value;
	}

}
