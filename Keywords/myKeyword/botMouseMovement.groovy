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
import java.awt.Robot
import java.awt.event.KeyEvent
import java.awt.event.InputEvent
import org.openqa.selenium.Capabilities
import org.openqa.selenium.Dimension
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.Point
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.driver.SmartWaitWebDriver
import groovy.transform.CompileStatic

public class botMouseMovement {
	static int timeoutSecond = 60
	static int timeoutMilisecond = 1500

	@Keyword
	def dndRobot(){
		WebUI.delay(3)

		Robot robot = new Robot()
		robot.mouseMove(198, 603)
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK)
		robot.delay(1000)
		robot.mouseMove(221, 601)
		robot.delay(1000)
		robot.mouseMove(353, 600)
		robot.delay(1000)
		robot.mouseMove(669, 600)
		robot.delay(1000)
		robot.mouseMove(905, 598)
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK)
	}

	@Keyword
	static void dragAndDropBy(TestObject sourceObject, TestObject destinationObject, int xOffset, int yOffset)
	throws Exception {
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement from = WebUiCommonHelper.findWebElement(sourceObject, timeoutSecond)
		WebElement to = WebUiCommonHelper.findWebElement(destinationObject, timeoutSecond)
		Capabilities caps = ((RemoteWebDriver) driver).getCapabilities()
		String browserName = caps.getBrowserName().capitalize()
		//Setup robot
		Robot robot = new Robot();
		robot.setAutoDelay(timeoutSecond);

		//Fullscreen page so selenium coordinates work
		if (browserName.toLowerCase().equals("chrome"))
			robot.keyPress(KeyEvent.VK_F11)
		else
			WebUI.maximizeWindow()
		Thread.sleep(timeoutMilisecond);

		//Get size of elements
		Dimension fromSize = from.getSize();
		Dimension toSize = to.getSize();

		//Get centre distance
		int xCentreFrom = fromSize.width / 2;
		int yCentreFrom = fromSize.height / 2;
		int xCentreTo = toSize.width / 2;
		int yCentreTo = toSize.height / 2;

		//Get x and y of WebElement to drag to
		Point toLocation = to.getLocation();
		Point fromLocation = from.getLocation();

		//Make Mouse coordinate centre of element
		toLocation.x += xOffset + xCentreTo;
		toLocation.y += yOffset + yCentreTo;
		fromLocation.x += xCentreFrom;
		fromLocation.y += yCentreFrom;

		//Move mouse to drag from location
		robot.mouseMove(fromLocation.x.intValue(), fromLocation.y.intValue());
		Thread.sleep(timeoutMilisecond);

		//Click and drag
		robot.mousePress(InputEvent.BUTTON1_MASK);

		//Drag events require more than one movement to register
		//Just appearing at destination doesn't work so move halfway first
		robot.mouseMove((((toLocation.x - fromLocation.x) / 2) + fromLocation.x).intValue(), (((toLocation.y
				- fromLocation.y) / 2) + fromLocation.y).intValue());

		//Move to final position
		robot.mouseMove(toLocation.x.intValue(), toLocation.y.intValue());

		//Drop
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
	}

	@Keyword
	def dragAndDropCanvas(TestObject objectSource, TestObject objectDestination, int xOffset, int yOffset){
		WebElement from = WebUiCommonHelper.findWebElement(objectSource, timeoutSecond)
		WebElement to = WebUiCommonHelper.findWebElement(objectDestination, timeoutSecond)
		WebDriver driver = DriverFactory.getWebDriver()
		Capabilities cap = ((SmartWaitWebDriver) driver).getCapabilities()
		String browserName =  cap.getBrowserName()

		Robot robot = new Robot();

		//Fullscreen page so selenium coordinates work
		if (browserName.toLowerCase().equals('firefox')
		|| browserName.toLowerCase().equals('chrome')){
			robot.keyPress(KeyEvent.VK_F11)
			robot.keyRelease(KeyEvent.VK_F11)
		}
		else
			WebUI.maximizeWindow()
		Thread.sleep(timeoutMilisecond)

		//Getting the object
		WebUI.clickImage(findTestObject('objectDashboard/canvasElement/sinkPaletteImages'))

		//Get size of canvas
		Dimension fromSize = from.getSize();
		Dimension toSize = to.getSize();

		//Get centre distance
		int xCentreFrom = fromSize.width / 2;
		int yCentreFrom = fromSize.height / 2;
		int xCentreTo = toSize.width / 2;
		int yCentreTo = toSize.height / 2;

		//Get x and y of WebElement to drag to
		Point toLocation = to.getLocation();
		Point fromLocation = from.getLocation();

		//Make Mouse coordinate centre of element
		toLocation.x += xOffset + xCentreTo;
		toLocation.y += yOffset + yCentreTo;
		fromLocation.x += xCentreFrom;
		fromLocation.y += yCentreFrom;

		//Click and drag
		robot.mousePress(InputEvent.BUTTON1_MASK);

		//Move mouse to drag from location
		robot.mouseMove(fromLocation.x.intValue(), fromLocation.y.intValue());
		Thread.sleep(timeoutMilisecond)

		//Drag events require more than one movement to register
		//Just appearing at destination doesn't work so move halfway first
		robot.mouseMove(toLocation.x - xOffset.intValue(), toLocation.y - yOffset.intValue());
		Thread.sleep(timeoutMilisecond)

		//Move to final position
		robot.mouseMove(toLocation.x.intValue(), toLocation.y.intValue());

		//Drop
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		Thread.sleep(timeoutMilisecond)

		robot.keyPress(KeyEvent.VK_F11)
		robot.keyRelease(KeyEvent.VK_F11)
	}

	@Keyword
	def doubleClicking(TestObject to){
		WebUI.clickImage(to)

		Robot bot = new Robot();
		bot.mousePress(InputEvent.BUTTON1_MASK)
		bot.mouseRelease(InputEvent.BUTTON1_MASK)
		bot.mousePress(InputEvent.BUTTON1_MASK)
		bot.mouseRelease(InputEvent.BUTTON1_MASK)
	}
}
