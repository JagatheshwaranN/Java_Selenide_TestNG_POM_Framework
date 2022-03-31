package com.jtaf.qa.helpers;

import org.apache.log4j.Logger;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.SelenideElement;
import com.jtaf.qa.utilties.LoggerUtility;

/**
 * @implNote This class contains the components that handle the mouse over and
 *           click functions.
 * @author Jaga
 * @since 05-03-2022
 * @version v0.1
 */
public class MouseActionHelper extends LoggerUtility {

	Logger log = getLogger(MouseActionHelper.class);

	/**
	 * @implNote This method is used to mouse over the web elements using the
	 *           actions.
	 * @param webElement1
	 * @param webElement2
	 */
	public void mouseHover(SelenideElement webElement1, SelenideElement webElement2) {
		try {
			actions().moveToElement(webElement1).build().perform();
			webElement2.click();
			log.info("Mouse hover and click on element is successful");
		} catch (Exception ex) {
			log.info("Error occured while mouse over on element" + "\n" + ex);
		}
	}

	/**
	 * @implNote This method is used to right click on the web element using the
	 *           actions.
	 * @param webElement
	 */
	public void rightClick(SelenideElement webElement) {
		try {
			actions().contextClick(webElement).build().perform();
			log.info("Right click on element is successful");
		} catch (Exception ex) {
			log.info("Error occured while right click on element" + "\n" + ex);
		}
	}

	/**
	 * @implNote This method is used to double click on the web element using the
	 *           actions.
	 * @param webElement
	 */
	public void doubleClick(SelenideElement webElement) {
		try {
			actions().doubleClick(webElement).build().perform();
			log.info("Double click on element is successful");
		} catch (Exception ex) {
			log.info("Error occured while double click on element" + "\n" + ex);
		}
	}

}
