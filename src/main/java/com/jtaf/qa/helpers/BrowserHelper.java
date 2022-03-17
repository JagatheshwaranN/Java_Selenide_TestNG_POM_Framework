package com.jtaf.qa.helpers;

import java.util.LinkedList;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.SelenideElement;
import com.jtaf.qa.utilties.LoggerUtility;

/** 
 * @implNote This class contains the components that handle the Browser
 *           navigations.
 * @author Jaga
 * @since 16-03-2022
 * @version v0.2
 */
public class BrowserHelper extends LoggerUtility {

	Logger log = getLogger(BrowserHelper.class);

	private WebDriver driver;

	public BrowserHelper(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * @implNote This method is used to navigate back to the previous page from
	 *           present page in the browser session.
	 */
	public void goBack() {
		try {
			back();
			log.info("Browser navigate to previous page is successful");
		} catch (Exception ex) {
			log.info("Error occured while navigate to previous page" + "\n" + ex);
		}
	}

	/**
	 * @implNote This method is used to navigate forward to the page from a present
	 *           page in the browser session.
	 */
	public void goForward() {
		try {
			forward();
			log.info("Browser navigate to front page is successful");
		} catch (Exception ex) {
			log.info("Error occured while navigate to front page" + "\n" + ex);
		}
	}

	/**
	 * @implNote This method is used to refresh the current browser page.
	 */
	public void doRefresh() {
		try {
			refresh();
			log.info("Browser refresh of the current page is successful");
		} catch (Exception ex) {
			log.info("Error occured while refresh the page" + "\n" + ex);
		}
	}

	/**
	 * @implNote This method is used to get the current browser page URL.
	 */
	public String getCurrentPageUrl() {
		return driver.getCurrentUrl();
	}

	/**
	 * @implNote This method is used to get the list of browser window handles.
	 */
	public Set<String> getHandles() {
		return driver.getWindowHandles();
	}

	/**
	 * @implNote This method is used to switch to the specific browser window by
	 *           index.
	 * @param index
	 */
	public void SwitchToWindow(int index) {
		try {
			LinkedList<String> windowsId = new LinkedList<String>(getHandles());
			if (index < 0 || index > windowsId.size())
				throw new IllegalArgumentException("Window handle has invalid index ===> " + index);
			switchTo().window(windowsId.get(index));
			log.info("Switch to window with index ===> " + index + " is successful");
		} catch (Exception ex) {
			log.info("Error occured while switch to window" + "\n" + ex);
		}
	}

	/**
	 * @implNote This method is used to switch to the specific browser window by
	 *           name or handle or title.
	 * @param nameOrHandleOrTitle
	 */
	public void SwitchToWindow(String nameOrHandleOrTitle) {
		try {
			switchTo().window(nameOrHandleOrTitle);
			log.info("Switch to window with name ===> " + nameOrHandleOrTitle + " is successful");
		} catch (Exception ex) {
			log.info("Error occured while switch to window" + "\n" + ex);
		}
	}

	/**
	 * @implNote This method is used to switch to the parent browser window.
	 */
	public void switchToParentWindow() {
		try {
			LinkedList<String> windowsid = new LinkedList<String>(getHandles());
			switchTo().window(windowsid.get(0));
			log.info("Switch to parent window is successful");
		} catch (Exception ex) {
			log.info("Error occured while switch to parent window" + "\n" + ex);
		}
	}

	/**
	 * @implNote This method is used to close the child browser windows and switch
	 *           to the parent browser window.
	 */
	public void switchToParentWithChildClose() {
		try {
			switchToParentWindow();
			LinkedList<String> windowsid = new LinkedList<String>(getHandles());
			for (int i = 1; i < windowsid.size(); i++) {
				log.info("Child Window Id ===> " + windowsid.get(i));
				switchTo().window(windowsid.get(i));
				closeWindow();
			}
			switchToParentWindow();
		} catch (Exception ex) {
			log.info("Error occured while switch to parent window" + "\n" + ex);
		}
	}

	/**
	 * @implNote This method is used to switch to the specific frame by index.
	 * @param index
	 */
	public void switchToFrame(int index) {
		try {
			switchTo().frame(index);
			log.info("Switch to frame with index ===> " + index);
		} catch (Exception ex) {
			log.info("Error occured while switch to frame" + "\n" + ex);
		}
	}

	/**
	 * @implNote This method is used to switch to the specific frame by name or id.
	 * @param nameOrid
	 */
	public void switchToFrame(String nameOrid) {
		try {
			switchTo().frame(nameOrid);
			log.info("Switch to frame with name or id ===> " + nameOrid);
		} catch (Exception ex) {
			log.info("Error occured while switch to frame" + "\n" + ex);
		}
	}

	/**
	 * @implNote This method is used to switch to the specific frame by selenide
	 *           element.
	 * @param webElement
	 */
	public void switchToFrame(SelenideElement webElement) {
		try {
			switchTo().frame(webElement);
			log.info("Switch to frame with element ===> " + webElement);
		} catch (Exception ex) {
			log.info("Error occured while switch to frame" + "\n" + ex);
		}
	}

}
