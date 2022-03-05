
package com.jtaf.qa.helpers;

import org.apache.log4j.Logger;

import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.SelenideElement;
import com.jtaf.qa.utilties.LoggerUtility;

/**
 * 
 * @implNote This class contains the components that handle the java script
 *           functions.
 * 
 * @author Jaga
 * @since 05-03-2022
 * @version v0.1
 *
 */
public class JavaScriptHelper extends LoggerUtility {

	Logger log = getLogger(JavaScriptHelper.class);

	public Object executeScript(String script, Object... arguments) {
		return executeJavaScript(script, arguments);
	}

	public void elementClick(SelenideElement webElement) {
		try {
			executeJavaScript("arguments[0].click();", webElement);
			log.info("Element click using JavaScript is successful");
		} catch (Exception ex) {
			log.info("Error occured while click element using JavaScript" + "\n" + ex);
		}
	}

	public void scrollToElement(SelenideElement webElement) {
		try {
			executeJavaScript("window.scrollTo(arguments[0],arguments[1])", webElement.getLocation().x,
					webElement.getLocation().y);
			log.info("Scroll to element using JavaScript is successful");
		} catch (Exception ex) {
			log.info("Error occured while scroll to element using JavaScript" + "\n" + ex);
		}
	}

	public void scrollToElementAndClick(SelenideElement webElement) {
		try {
			scrollToElement(webElement);
			webElement.click();
			log.info("Scroll to element and click using JavaScript is successful");
		} catch (Exception ex) {
			log.info("Error occured while scroll to and click element using JavaScript" + "\n" + ex);
		}
	}

	public void scrollIntoView(SelenideElement webElement) {
		try {
			executeJavaScript("arguments[0].scrollIntoView()", webElement);
			log.info("Scroll to view using JavaScript is successful");
		} catch (Exception ex) {
			log.info("Error occured while scroll into view using JavaScript" + "\n" + ex);
		}
	}

	public void scrollIntoViewAndClick(SelenideElement element) {
		try {
			scrollIntoView(element);
			element.click();
			log.info("Scroll to view and click using JavaScript is successful");
		} catch (Exception ex) {
			log.info("Error occured while scroll into view and click element using JavaScript" + "\n" + ex);
		}
	}

	public void scrollUpVertical() {
		try {
			executeJavaScript("window.scrollTo(0, -document.body.scrollHeight)");
			log.info("Scroll up vertical using JavaScript is successful");
		} catch (Exception ex) {
			log.info("Error occured while scroll up vertical using JavaScript" + "\n" + ex);
		}
	}

	public void scrollDownVertical() {
		try {
			executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
			log.info("Scroll down vertical using JavaScript is successful");
		} catch (Exception ex) {
			log.info("Error occured while scroll down vertical using JavaScript" + "\n" + ex);
		}
	}

	public void ScrollUpByPixel(String pixel) {
		try {
			executeJavaScript("window.scrollBy(0, -'" + pixel + "')");
			log.info("Scroll up by pixel using JavaScript is successful");
		} catch (Exception ex) {
			log.info("Error occured while scroll up by pixel using JavaScript" + "\n" + ex);
		}
	}

	public void ScrollDownByPixel(String pixel) {
		try {
			executeJavaScript("window.scrollBy(0, '" + pixel + "')");
			log.info("Scroll down by pixel using JavaScript is successful");
		} catch (Exception ex) {
			log.info("Error occured while scroll down by pixel using JavaScript" + "\n" + ex);
		}
	}

	public void zoomInByPercentage(String percent) {
		try {
			executeJavaScript("document.body.style.zoom='" + percent + "'");
			log.info("Zoom in by percent using JavaScript is successful");
		} catch (Exception ex) {
			log.info("Error occured while zoom using JavaScript" + "\n" + ex);
		}
	}

}
