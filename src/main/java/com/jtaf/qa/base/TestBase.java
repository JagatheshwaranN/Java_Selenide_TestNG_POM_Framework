package com.jtaf.qa.base;

import java.io.IOException;

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
 * 
 * @author Jaga
 * @implNote This class contains the base functionalities needed for the kick
 *           start of the test execution of the application under test.
 * @since 16-02-2022
 * @version v0.3
 *
 */
public class TestBase extends FileReaderUtility {

	public static WebDriver selDriver;
	public static Page page;

	@BeforeSuite
	public void init() throws IOException {
		loadPropertyFile();
		System.out.println("======================== [ Property file load is successful ] ========================");
	}

	@BeforeMethod
	@Parameters(value = { "browser" })
	public void setUpTest(String browser) {
		if (System.getProperty("os.name").contains(getTestData("operating.system"))) {
			if (browser.equalsIgnoreCase(getTestData("browser.chrome"))) {
				Configuration.browser = browser;
				System.out.println(
						"======================== [ Launching " + browser + " Browser] ==============================");
			} else if (browser.equalsIgnoreCase("browser.firefox")) {
				System.setProperty("webdriver.chrome.driver", getTestData("firefox.driver"));
				Configuration.browser = browser;
				System.out.println(
						"======================== [ Launching " + browser + " Browser] ==============================");
			} else {
				System.out.println("No browser is defined in the XML file");
			}
			open(getTestData("app.url"));
			selDriver = WebDriverRunner.getWebDriver();
			System.out.println("Driver : " + selDriver);
			page = new BasePage(selDriver);
		} else {
			System.out.println("======================== [ The operating system is not WINDOWS ] ==================");
			Assert.fail();
		}
	}

	@AfterMethod
	public void tearDown() {
		selDriver.close();
	}

	@AfterSuite
	public void exit() {
		selDriver.quit();
	}
}
