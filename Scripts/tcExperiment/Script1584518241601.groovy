import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

import org.openqa.selenium.Keys as Keys

WebUI.doubleClick(findTestObject('objectDashboard/itemSelected/selectedProj'))

WebUI.delay(1)

WebUI.doubleClick(findTestObject('objectDashboard/itemSelected/selectedFile'))

WebUI.delay(3) //waktu tunggu untuk munculnya object di setiap canvas

//CustomKeywords.'myKeyword.botMouseMovement.doubleClicking'(findTestObject('objectDashboard/canvasElement/workFieldImages'))

CustomKeywords.'myKeyword.botMouseMovement.dragAndDropCanvas'(findTestObject('objectDashboard/canvasElement/sinkPalette'), findTestObject('objectDashboard/canvasElement/workField'), 150, 150)
