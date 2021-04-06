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
import org.openqa.selenium.Capabilities
import org.openqa.selenium.WebDriver
//import org.openqa.selenium.remote.RemoteWebDriver
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.driver.SmartWaitWebDriver
import java.awt.Robot
import java.awt.event.KeyEvent

public class browserChecker {
	@Keyword
	def browserUsed(){
		WebDriver driver = DriverFactory.getWebDriver()
		Capabilities cap = ((SmartWaitWebDriver) driver).getCapabilities()
		String browserName =  cap.getBrowserName()

		if(browserName == 'firefox'){
			WebUI.delay(3)
			WebUI.comment('Browser Active: '+browserName)
			WebUI.click(findTestObject('objectDashboard/itemSelected/menuDownloadFile'))

			Robot bot = new Robot()
			bot.delay(1500)
			bot.keyPress(KeyEvent.VK_ENTER)
			bot.keyRelease(KeyEvent.VK_ENTER)
		}

		else{
			WebUI.comment('Browser Active Isnt: '+browserName)
			WebUI.click(findTestObject('objectDashboard/itemSelected/menuDownloadFile'))
		}
	}
}
