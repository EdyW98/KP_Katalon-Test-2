package myKeyword

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.By
import org.openqa.selenium.interactions.Actions
import com.kms.katalon.core.webui.driver.DriverFactory

public class scrollingScrollBar {
	@Keyword
	/**
	 * Hover over an element.
	 * @param selector (String) Xpath selector for the element.
	 */
	def Se_hover(String selector) {
		WebUI.comment('Se_hover hovering ' + selector)
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement elem = driver.findElement(By.xpath(selector))
		WebUI.executeJavaScript('arguments[0].scrollIntoView(true)', Arrays.asList(elem))
		Actions act = new Actions(driver)
		act.moveToElement(elem).build().perform()
		WebUI.comment('Success: ' + selector + ' hovered!')
	}

	@Keyword
	/**
	 * Hover over an element then click it.
	 * @param selector (String) Xpath selector for the element.
	 */
	def Se_hoverClick(String selector) {
		WebUI.comment('Se_hoverClick hoverClicking ' + selector)
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement elem = driver.findElement(By.xpath(selector))
		WebUI.executeJavaScript('arguments[0].scrollIntoView(true)', Arrays.asList(elem))
		Actions act = new Actions(driver)
		act.moveToElement(elem).click(elem).build().perform()
		WebUI.comment('Success: ' + selector + ' hoverClicked!')
	}
}
