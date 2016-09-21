package executionEngine;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import config.*;
import utility.*;
public class ActionsWeb 
{
	public static boolean bResult;

public static void execute_Actions() throws Exception {

			
			if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Open Browser"))
			{
				ActionKeywords.openBrowser(WebApplicationTest.sLocatorValue, WebApplicationTest.sValue, WebApplicationTest.sBrowserName, WebApplicationTest.sBrowserVersion, WebApplicationTest.sOperatingSystem, WebApplicationTest.sIpAddress, WebApplicationTest.sSauceUserName,WebApplicationTest.sSauceLabAccessKey,  WebApplicationTest.sCloudRunMode );
			}
			else if (WebApplicationTest.sActionKeyword.equalsIgnoreCase("Open Eyes"))
			{
				ActionKeywords.openEyes(WebApplicationTest.sValue);
			}
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Navigate"))
			{
				ActionKeywords.navigate(WebApplicationTest.sLocatorValue, WebApplicationTest.sValue, WebApplicationTest.sBrowserName);
			}
			
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Click"))
			{
				ActionKeywords.click(WebApplicationTest.sLocatorValue);
			}
			
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Double Click"))
			{
				ActionKeywords.doubleClick(WebApplicationTest.sLocatorValue);
			}
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Wait For"))
			{
				ActionKeywords.waitFor(WebApplicationTest.sLocatorValue);
			}
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Wait"))
			{
				ActionKeywords.wait(WebApplicationTest.sLocatorValue, WebApplicationTest.sValue);
				
			}
			
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Input"))
			{
				ActionKeywords.input(WebApplicationTest.sLocatorValue, WebApplicationTest.sValue, WebApplicationTest.sBrowserName);
			}
			
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Assert"))
			{
				ActionKeywords.assert_table(WebApplicationTest.sLocatorValue, WebApplicationTest.sValue);
			}
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Assert Upload"))
			{
				ActionKeywords.assert_upload(WebApplicationTest.sLocatorValue, WebApplicationTest.sValue);

			}
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Assert ToolTip"))
			{
				ActionKeywords.assert_tooltip(WebApplicationTest.sLocatorValue, WebApplicationTest.sValue);

			}
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Eye Scanner"))
			{
				ActionKeywords.eyeScanner(WebApplicationTest.sValue);

			}
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Upload File"))
			{
				ActionKeywords.uploadFile(WebApplicationTest.sLocatorValue, WebApplicationTest.sValue, WebApplicationTest.sBrowserName);
			}
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Mouse Hover"))
			{
				ActionKeywords.mouseHover(WebApplicationTest.sLocatorValue, WebApplicationTest.sValue, WebApplicationTest.sBrowserName);
			}
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Refresh Page"))
			{
				ActionKeywords.refreshPage();
			}
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Navigate Backward"))
			{
				ActionKeywords.forwardPage();
			}
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Navigate Forward"))
			{
				ActionKeywords.backwardPage();
			}
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("DragAndDrop"))
			{
				ActionKeywords.dragAndDrop(WebApplicationTest.sLocatorValue, WebApplicationTest.sValue, WebApplicationTest.sBrowserName);
			}
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Right Click"))
			{
				ActionKeywords.rightClick(WebApplicationTest.sLocatorValue);
			}
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Scroll Down"))
			{
				ActionKeywords.scrollDown(WebApplicationTest.sLocatorValue);
			}
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Scroll Up"))
			{
				ActionKeywords.scrollUp(WebApplicationTest.sValue);
			}
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Switch To Frame"))
			{
				ActionKeywords.switchToFrame(WebApplicationTest.sValue);
			}
			
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Switch Outside Frame"))
			{
				ActionKeywords.switchOutsideFrame();
			}
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Select Text"))
			{
				ActionKeywords.selectText(WebApplicationTest.sLocatorValue);
			}
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Clear Text"))
			{
				ActionKeywords.clearText(WebApplicationTest.sLocatorValue);
			}
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Keyboard Enter"))
			{
				ActionKeywords.keyboardEnter(WebApplicationTest.sLocatorValue);
			}
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Keyboard Tab"))
			{
				ActionKeywords.keyboardEnter(WebApplicationTest.sLocatorValue);
			}
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Keyboard PageUp"))
			{
				ActionKeywords.keyboardPageUp(WebApplicationTest.sLocatorValue);
			}
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Keyboard PageDown"))
			{
				ActionKeywords.keyboardPageDown(WebApplicationTest.sLocatorValue);
			}
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Assert Watermark Text"))
			{
				ActionKeywords.assert_WaterMarkText(WebApplicationTest.sLocatorValue,WebApplicationTest.sValue);
			}
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Assert Pagetitle Text"))
			{
				ActionKeywords.assert_PageTitleText(WebApplicationTest.sValue);
			}
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Assert IsEnabled"))
			{
				ActionKeywords.assert_IsEnabled(WebApplicationTest.sLocatorValue);
			}
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Assert IsDisabled"))
			{
				ActionKeywords.assert_IsDisabled(WebApplicationTest.sLocatorValue);
			}
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Assert Name"))
			{
				ActionKeywords.assert_Name(WebApplicationTest.sLocatorValue,WebApplicationTest.sValue);
			}
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Assert Text"))
			{
				ActionKeywords.assert_Text(WebApplicationTest.sLocatorValue, WebApplicationTest.sValue);
			}
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Assert TextHighlight"))
			{
				ActionKeywords.assert_TextHighlight(WebApplicationTest.sLocatorValue);
			}
			
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Close Eyes"))
			{
				ActionKeywords.closeEyes();
			}
			
			else
			{
				ActionKeywords.closeApplication(WebApplicationTest.sLocatorValue, WebApplicationTest.sValue, WebApplicationTest.sBrowserName);
			}
				
					
				if(bResult==true)
				{
					ExcelUtils.setCellData(Constants.Keyword_Pass, WebApplicationTest.iTestStep, Constants.Col_TestStepResult, Constants.Sheet_TestSteps);
				}			
				if(bResult==false)
				{

					File scrFile = ((TakesScreenshot) ActionKeywords.driver).getScreenshotAs(OutputType.FILE);

					int stepno=(WebApplicationTest.iTestStep)+1;
					
					FileUtils.copyFile(scrFile, new File(VerifyingExcel.screenShotsPath+"//"+WebApplicationTest.sTestCaseID+"//"+stepno+".jpg"));

					ExcelUtils.setCellData(Constants.Keyword_Fail, WebApplicationTest.iTestStep, Constants.Col_TestStepResult, Constants.Sheet_TestSteps);


				}
				

			}
			
			}