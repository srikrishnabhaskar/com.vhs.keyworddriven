package executionEngine;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import utility.ExcelUtils;
import config.ActionKeywords;
import config.Constants;

public class ActionsMobile {

	public static boolean bResult;

public static void execute_Actions() throws Exception {

			
			if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Open Browser"))
			{
				//ActionKeywords.openBrowser(MobileApplicationTest.sLocatorValue, MobileApplicationTest.sValue, MobileApplicationTest.sPlatformBrowser);
			}
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Open Mobile Application"))
			{
				
				ActionKeywords.openMobileApplication(MobileApplicationTest.sPlatformName, MobileApplicationTest.sPlatformVersion, MobileApplicationTest.sPlatformDeviceName,  MobileApplicationTest.sPlatformIpAddress, MobileApplicationTest.sPlatformSauceUserName, MobileApplicationTest.sPlatformSauceLabAccessKey, MobileApplicationTest.sPlatformAppName, MobileApplicationTest.sPlatformAppPath, MobileApplicationTest.sPlatformEmulatorPlayerPath, MobileApplicationTest.sPlatformBrowser, MobileApplicationTest.sPlatformCloudRunMode, MobileApplicationTest.sPlatformEmulatorRunMode );

			}
			else if (MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Open Eyes"))
			{
				ActionKeywords.openEyes(MobileApplicationTest.sValue);
			}
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Navigate"))
			{
				ActionKeywords.navigate(MobileApplicationTest.sLocatorValue, MobileApplicationTest.sValue, MobileApplicationTest.sPlatformBrowser);
			}
			
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Click"))
			{
				ActionKeywords.click(MobileApplicationTest.sLocatorValue);
			}
			
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Double Click"))
			{
				ActionKeywords.doubleClick(MobileApplicationTest.sLocatorValue);
			}
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Wait For"))
			{
				ActionKeywords.waitFor(MobileApplicationTest.sLocatorValue);
			}
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Wait"))
			{
				ActionKeywords.wait(MobileApplicationTest.sLocatorValue, MobileApplicationTest.sValue);
				
			}
			
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Input"))
			{
				ActionKeywords.input(MobileApplicationTest.sLocatorValue, MobileApplicationTest.sValue, MobileApplicationTest.sPlatformBrowser);
			}
			
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Assert"))
			{
				ActionKeywords.assert_table(MobileApplicationTest.sLocatorValue, MobileApplicationTest.sValue);
			}
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Assert Upload"))
			{
				ActionKeywords.assert_upload(MobileApplicationTest.sLocatorValue, MobileApplicationTest.sValue);

			}
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Assert ToolTip"))
			{
				ActionKeywords.assert_tooltip(MobileApplicationTest.sLocatorValue, MobileApplicationTest.sValue);

			}
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Eye Scanner"))
			{
				ActionKeywords.eyeScanner(MobileApplicationTest.sValue);

			}
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Upload File"))
			{
				ActionKeywords.uploadFile(MobileApplicationTest.sLocatorValue, MobileApplicationTest.sValue, MobileApplicationTest.sPlatformBrowser);
			}
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Mouse Hover"))
			{
				ActionKeywords.mouseHover(MobileApplicationTest.sLocatorValue, MobileApplicationTest.sValue, MobileApplicationTest.sPlatformBrowser);
			}
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Refresh Page"))
			{
				ActionKeywords.refreshPage();
			}
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Navigate Backward"))
			{
				ActionKeywords.forwardPage();
			}
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Navigate Forward"))
			{
				ActionKeywords.backwardPage();
			}
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("DragAndDrop"))
			{
				ActionKeywords.dragAndDrop(MobileApplicationTest.sLocatorValue, MobileApplicationTest.sValue, MobileApplicationTest.sPlatformBrowser);
			}
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Right Click"))
			{
				ActionKeywords.rightClick(MobileApplicationTest.sLocatorValue);
			}
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Scroll Down"))
			{
				ActionKeywords.scrollDown(MobileApplicationTest.sLocatorValue);
			}
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Scroll Up"))
			{
				ActionKeywords.scrollUp(MobileApplicationTest.sValue);
			}
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Switch To Frame"))
			{
				ActionKeywords.switchToFrame(MobileApplicationTest.sValue);
			}
			
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Switch Outside Frame"))
			{
				ActionKeywords.switchOutsideFrame();
			}
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Select Text"))
			{
				ActionKeywords.selectText(MobileApplicationTest.sLocatorValue);
			}
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Clear Text"))
			{
				ActionKeywords.clearText(MobileApplicationTest.sLocatorValue);
			}
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Keyboard Enter"))
			{
				ActionKeywords.keyboardEnter(MobileApplicationTest.sLocatorValue);
			}
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Keyboard Tab"))
			{
				ActionKeywords.keyboardEnter(MobileApplicationTest.sLocatorValue);
			}
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Keyboard PageUp"))
			{
				ActionKeywords.keyboardPageUp(MobileApplicationTest.sLocatorValue);
			}
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Keyboard PageDown"))
			{
				ActionKeywords.keyboardPageDown(MobileApplicationTest.sLocatorValue);
			}
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Assert Watermark Text"))
			{
				ActionKeywords.assert_WaterMarkText(MobileApplicationTest.sLocatorValue,MobileApplicationTest.sValue);
			}
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Assert Pagetitle Text"))
			{
				ActionKeywords.assert_PageTitleText(MobileApplicationTest.sValue);
			}
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Assert IsEnabled"))
			{
				ActionKeywords.assert_IsEnabled(MobileApplicationTest.sLocatorValue);
			}
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Assert IsDisabled"))
			{
				ActionKeywords.assert_IsDisabled(MobileApplicationTest.sLocatorValue);
			}
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Assert IsDisabled_Mobile"))
			{
				ActionKeywords.assert_IsDisabled_Mobile(MobileApplicationTest.sLocatorValue);
			}
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Assert Name"))
			{
				ActionKeywords.assert_Name(MobileApplicationTest.sLocatorValue,MobileApplicationTest.sValue);
			}
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Assert Text"))
			{
				ActionKeywords.assert_Text(MobileApplicationTest.sLocatorValue, MobileApplicationTest.sValue);
			}
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Assert TextHighlight"))
			{
				ActionKeywords.assert_TextHighlight(MobileApplicationTest.sLocatorValue);
			}
			
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Tap"))
			{
				ActionKeywords.tap(MobileApplicationTest.sLocatorValue, MobileApplicationTest.sValue);
			}
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Long Press"))
			{
				ActionKeywords.longPress(MobileApplicationTest.sLocatorValue);
			}
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Press"))
			{
				ActionKeywords.press(MobileApplicationTest.sLocatorValue);
			}
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Scroll To"))
			{
				ActionKeywords.scrollTo(MobileApplicationTest.sValue);

			}
		
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Swipe Right"))
			{
				ActionKeywords.swipeRight();
			}
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Swipe Left"))
			{
				ActionKeywords.swipeLeft();
			}
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Login Code"))
			{
				ActionKeywords.loginCode(MobileApplicationTest.sLocatorValue, MobileApplicationTest.sValue);
			}
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Pass Code"))
			{
				ActionKeywords.passCode(MobileApplicationTest.sLocatorValue, MobileApplicationTest.sValue);
			}
			else if (MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Dynamic Method_QM"))
			{
				ActionKeywords.dynamicMethodQm(MobileApplicationTest.sLocatorValue, MobileApplicationTest.sValue);

			}
			else if (MobileApplicationTest.sActionKeyword.equalsIgnoreCase("BackMenuButtonClick_QM"))
			{
				ActionKeywords.BackMenuButtonClickQm(MobileApplicationTest.sLocatorValue);

			}
			else if (MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Android Back Button"))
			{
				ActionKeywords.mobileBackButton();
			}
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Hide Keyboard"))
			{
				ActionKeywords.hideKeyboard();

			}
			
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Close Emulator"))
			{
				ActionKeywords.closeEmulator();
			}
			else if(MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Close Eyes"))
			{
				ActionKeywords.closeEyes();
			}
			
			// *******************************************EXPERIMENT*******************************************
//			else if (MobileApplicationTest.sActionKeyword.equalsIgnoreCase("Store Value in Variable X"))
//			{
//				ActionKeywords.StoreInVariableX();
//			}
			// *******************************************EXPERIMENT*******************************************
			
			else
			{
				ActionKeywords.closeApplication(MobileApplicationTest.sLocatorValue, MobileApplicationTest.sValue, MobileApplicationTest.sPlatformBrowser);
			}
				
					
				if(bResult==true)
				{
					ExcelUtils.setCellData(Constants.Keyword_Pass, MobileApplicationTest.iTestStep, Constants.Col_TestStepResult, Constants.Sheet_TestSteps);
				}			
				if(bResult==false)
				{

					File scrFile = ((TakesScreenshot) ActionKeywords.driver).getScreenshotAs(OutputType.FILE);

					int stepno=(MobileApplicationTest.iTestStep)+1;
					
					FileUtils.copyFile(scrFile, new File(VerifyingExcel.screenShotsPath+"//"+MobileApplicationTest.sTestCaseID+"//"+stepno+".jpg"));

					ExcelUtils.setCellData(Constants.Keyword_Fail, MobileApplicationTest.iTestStep, Constants.Col_TestStepResult, Constants.Sheet_TestSteps);


				}
				

			}
			
			}
