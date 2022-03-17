package com.jtaf.qa.base;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.jtaf.qa.pages.BasePage;
import com.jtaf.qa.pages.Page;
import com.jtaf.qa.utilties.FileReaderUtility;

import static com.codeborne.selenide.Selenide.*;

/**
 * @implNote This class contains the base functionalities needed for the kick
 *           start of the test execution of the application under test.
 * @author Jaga
 * @since 16-03-2022
 * @version v0.6
 */
public class TestBase extends FileReaderUtility {

	Logger log = getLogger(TestBase.class);

	public static WebDriver selDriver;
	public static Page page;

	/**
	 * @implNote This method is used to load the property file used for application
	 *           under test.
	 * @throws IOException
	 */
	@BeforeSuite
	public void init() throws IOException {
		loadPropertyFile();
		log.info("======================== [ Property file load is successful ] ========================");
	}

	/**
	 * @implNote This method is used to invoke the browser based on the param passed
	 *           from the testNG.xml file.
	 * @param browser
	 */
	@BeforeMethod
	@Parameters(value = { "browser" })
	public void setUpTest(String browser) {
		if (System.getProperty("os.name").contains(getTestData("operating.system"))) {
			if (browser.equalsIgnoreCase(getTestData("browser.chrome"))) {
				Configuration.browser = browser;
				log.info(
						"======================== [ Launching " + browser + " Browser] ==============================");
			} else if (browser.equalsIgnoreCase("browser.firefox")) {
				System.setProperty("webdriver.chrome.driver", getTestData("firefox.driver"));
				Configuration.browser = browser;
				log.info(
						"======================== [ Launching " + browser + " Browser] ==============================");
			} else {
				log.info("No browser is defined in the XML file");
			}
			open(getTestData("app.url"));
			selDriver = WebDriverRunner.getWebDriver();
			log.info("Driver Information ===> " + "" + selDriver);
			page = new BasePage(selDriver);
		} else {
			log.info("======================== [ The operating system is not WINDOWS ] ==================");
			Assert.fail();
		}
	}

	/**
	 * @implNote This method is used to close the active browser window of the
	 *           application under test.
	 */
	@AfterMethod
	public void tearDown() {
		selDriver.close();
	}

	/**
	 * @implNote This method is used to close all the active browser windows of the
	 *           application under test.
	 */
	@AfterSuite
	public void exit() {
		selDriver.quit();
	}
}
