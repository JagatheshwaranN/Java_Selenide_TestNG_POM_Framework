package com.jtaf.qa.helpers;

import org.apache.log4j.Logger;
import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;

import com.jtaf.qa.utilties.LoggerUtility;

/**
 * @implNote This class contains the components that handle the Alert pop-ups.
 * @author Jaga
 * @since 16-03-2022
 * @version v0.2
 */
public class AlertHelper extends LoggerUtility {

	Logger log = getLogger(AlertHelper.class);

	/**
	 * @implNote This method is used to switch to alert window from normal window.
	 * @return alert instance
	 */
	public Alert getAlert() {
		return switchTo().alert();
	}

	/**
	 * @implNote This method is used to switch to alert window and accept.
	 */
	public void acceptAlert() {
		try {
			getAlert().accept();
			log.info("Alert Handler ===> Alert popup accept is succesful");
		} catch (Exception ex) {
			log.info("Error occured while accept the alert" + "\n" + ex);
		}
	}

	/**
	 * @implNote This method is used to switch to alert window and dismiss.
	 */
	public void dismissAlert() {
		try {
			getAlert().dismiss();
			log.info("Alert Handler ===> Alert popup dismiss is succesful");
		} catch (Exception ex) {
			log.info("Error occured while dismiss the alert" + "\n" + ex);
		}
	}

	/**
	 * @implNote This method is used to switch to alert window and get the text.
	 */
	public String getAlertText() {
		String text = null;
		try {
			text = getAlert().getText();
			log.info("Alert Handler ===> Alert popup content is ===>> " + text);
		} catch (Exception ex) {
			log.info("Error occured while get the alert contents" + "\n" + ex);
		}
		return text;

	}

	/**
	 * @implNote This method is used to check whether the alert window is present.
	 */
	public boolean isAlertPresent() {
		try {
			return getAlert() != null;
		} catch (NoAlertPresentException ex) {
			log.info("Error occured while check for the alert popup" + "\n" + ex);
			return false;
		}

	}

	/**
	 * @implNote This method is used to check whether the alert window is present
	 *           and accept.
	 */
	public void acceptAlertIfPresent() {
		try {
			if (!isAlertPresent()) {
				return;
			}
			log.info("Alert Handler ===> Alert present - Alert popup accept is succesful");
			getAlertText();
			acceptAlert();
		} catch (Exception ex) {
			log.info("Error occured while check for the alert popup" + "\n" + ex);
		}
	}

	/**
	 * @implNote This method is used to check whether the alert window is present
	 *           and dismiss.
	 */
	public void dismissAlertIfPresent() {
		try {
			if (!isAlertPresent()) {
				return;
			}
			log.info("Alert Handler ===> Alert present - Alert popup dismiss is succesful");
			dismissAlert();
		} catch (Exception ex) {
			log.info("Error occured while check for the alert popup" + "\n" + ex);
		}
	}

	/**
	 * @implNote This method is used to check whether the prompt alert window is
	 *           present, then enter the values and accept.
	 */
	public void acceptPrompt(String text) {
		try {
			if (!isAlertPresent()) {
				return;
			}
			Alert alert = getAlert();
			alert.sendKeys(text);
			alert.accept();
			log.info("Alert Handler ===> Alert present - Alert popup accept is succesful");
		} catch (Exception ex) {
			log.info("Error occured while check for the alert popup" + "\n" + ex);
		}
	}

}
