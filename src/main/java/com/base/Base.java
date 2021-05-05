package com.base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.extent.ExtentTestManager;

public class Base {

	/*
	 * public static void initBrowser(String browser) { if
	 * (browser.equalsIgnoreCase("chrome")) {
	 * System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
	 * + "/src/test/resources/driver/chromedriver.exe"); driver = new
	 * ChromeDriver(); } else if (browser.equalsIgnoreCase("edge")) {
	 * System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") +
	 * "/src/test/resources/driver/msedgedriver.exe"); driver = new EdgeDriver(); }
	 * driver.manage().window().maximize();
	 * 
	 * }
	 */
	public static void openUrl() {
		DriverManager.getDriver().get("https://blazedemo.com/index.php");
	}

	public static void clickElement(WebElement element) {
		element.click();
	}

	public static void type(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static String getTitle(WebElement element) {
		return element.getText();
	}
	
	public void tearDown() {
		DriverManager.getDriver().quit();
	}

	public static void logInfo(String logMessage) {
		ExtentTestManager.getTest().info(MarkupHelper.createLabel(logMessage, ExtentColor.WHITE));
	}

	public static void logPass(String logMessage) {
		ExtentTestManager.getTest().pass(MarkupHelper.createLabel(logMessage, ExtentColor.GREEN));
	}

	public static void logFail(String logMessage) {
		ExtentTestManager.getTest().fail(MarkupHelper.createLabel(logMessage, ExtentColor.RED));
	}

	public static void logSkip(String logMessage) {
		ExtentTestManager.getTest().skip(MarkupHelper.createLabel(logMessage, ExtentColor.GREY));
	}

	public static void logWarning(String logMessage) {
		ExtentTestManager.getTest().warning(MarkupHelper.createLabel(logMessage, ExtentColor.AMBER));
	}

	public static void logInfoUnorderedList(Object obj) {
		ExtentTestManager.getTest().info(MarkupHelper.createUnorderedList(obj).getMarkup());
	}

	public static void logInfoJsonCode(Object obj) {
		ExtentTestManager.getTest().info(MarkupHelper.createJsonCodeBlock(obj).getMarkup());
	}

	public String takeSnapShot() {
		return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);

	}
}
