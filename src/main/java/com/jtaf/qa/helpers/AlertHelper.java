package com.jtaf.qa.helpers;

import org.apache.log4j.Logger;
import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;

import com.jtaf.qa.utilties.LoggerUtility;

/**
 * 
 * @implNote This class contains the components that handle the Alert pop-ups.
 * 
 * @author Jaga
 * @since 05-03-2022
 * @version v0.1
 *
 */
public class AlertHelper extends LoggerUtility {

	Logger log = getLogger(AlertHelper.class);

	public Alert getAlert() {
		return switchTo().alert();
	}

	public void acceptAlert() {
		try {
			getAlert().accept();
			log.info("Alert Handler ===> Alert popup accept is succesful");
		} catch (Exception ex) {
			log.info("Error occured while accept the alert" + "\n" + ex);
		}
	}

	public void dismissAlert() {
		try {
			getAlert().dismiss();
			log.info("Alert Handler ===> Alert popup dismiss is succesful");
		} catch (Exception ex) {
			log.info("Error occured while dismiss the alert" + "\n" + ex);
		}
	}

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

	public boolean isAlertPresent() {
		try {
			return getAlert() != null;
		} catch (NoAlertPresentException ex) {
			log.info("Error occured while check for the alert popup" + "\n" + ex);
			return false;
		}

	}

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
