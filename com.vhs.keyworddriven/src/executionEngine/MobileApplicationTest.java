 package executionEngine;

import java.awt.Desktop;
import java.io.File;
import java.util.HashSet;

import com.applitools.eyes.RectangleSize;

import utility.ExcelUtils;
import utility.Log;
import utility.StartAndStopAppium;
import config.ActionKeywords;
import config.Constants;

public class MobileApplicationTest 
{
	public static int iTotalPlatforms;
	public static int iPlatform;
	public static String sPlatformName;
	public static String sPlatformEmulatorRunMode;
	public static String sPlatformRunMode;
	public static String sPlatformCloudRunMode;
	public static String sPlatformVersion;
	public static String sPlatformDeviceName;
	public static String sPlatformIpAddress;
	public static String sPlatformSauceUserName;
	public static String sPlatformSauceLabAccessKey;
	public static String sPlatformAppliToolApiKey;
	public static String sPlatformAppPath;
	public static String sPlatformAppName;
	public static String sPlatformAppiumServerPath;
	public static String sPlatformEmulatorPlayerPath;
	public static String sPlatformBrowser;
	public static int iTestStep;
	public static int iTestLastStep;
	public static int iTestStepResult;
	public static int iTestLastStepResult;
	public static int iTestCaseResult;
	public static int iTestPlatformCount;
	public static int iTestcase;
	public static int iTotalTestCases;
	public static String sTestCaseID;
	public static String sRunMode;
	public static String sActionKeyword;
	public static String sLocatorValue;
	public static String sLocator;
	public static String sValue;
	public static String sResult;
	public static String sResult1;
	public static String sTestStepRunMode;

	HashSet<String> arrayResult = new HashSet<String>();
	HashSet<String> arrayResult1 = new HashSet<String>();


	public void execute_TestCaseMobile() throws Exception 
	{

		Log.info("Fetching Total Number of Platforms");
		
		iTotalPlatforms = ExcelUtils.getRowCount(Constants.Sheet_Platforms);
		
		Log.info("Total Number of Platforms "+iTotalPlatforms);
		
		for( iPlatform=1;iPlatform<=iTotalPlatforms;iPlatform++){

			Log.info("Fetching Platform Name");

			sPlatformName = ExcelUtils.getCellData(iPlatform, Constants.Col_PlatformName, Constants.Sheet_Platforms); 

			Log.info("The Platform name is "+sPlatformName);
			
			sPlatformVersion = ExcelUtils.getCellData(iPlatform, Constants.Col_PlatformVersion, Constants.Sheet_Platforms); 
			
			Log.info("The Platform Version is "+sPlatformVersion);
			
			sPlatformDeviceName = ExcelUtils.getCellData(iPlatform, Constants.Col_PlatformDeviceName, Constants.Sheet_Platforms); 
			
			Log.info("The Device Name is "+sPlatformDeviceName);
			
            sPlatformIpAddress = ExcelUtils.getCellData(iPlatform, Constants.Col_PlatformIpAddress, Constants.Sheet_Platforms); 
			
			Log.info("The Ip Address of Machine is "+sPlatformIpAddress);
			
			sPlatformSauceUserName = ExcelUtils.getCellData(iPlatform, Constants.Col_PlatformSauceUserName, Constants.Sheet_Platforms); 
			
			Log.info("The Sauce User Name is "+sPlatformSauceUserName);
			
			sPlatformSauceLabAccessKey = ExcelUtils.getCellData(iPlatform, Constants.Col_PlatformSauceLabAccessKey, Constants.Sheet_Platforms); 
			
			Log.info("The Sauce Lab Access Key is "+sPlatformSauceLabAccessKey);
			
			
            sPlatformAppliToolApiKey = ExcelUtils.getCellData(iPlatform, Constants.Col_PlatformAppliToolApiKey, Constants.Sheet_Platforms); 
			
			Log.info("The AppliTool Api Key is "+sPlatformAppliToolApiKey);
			
			sPlatformAppName = ExcelUtils.getCellData(iPlatform, Constants.Col_PlatformAppName, Constants.Sheet_Platforms); 
			
			Log.info("The Application NAME is "+sPlatformAppName);
		
			sPlatformAppPath = ExcelUtils.getCellData(iPlatform, Constants.Col_PlatformAppPath, Constants.Sheet_Platforms); 
			
			Log.info("The path of Application is "+sPlatformAppPath);
			
             sPlatformAppiumServerPath = ExcelUtils.getCellData(iPlatform, Constants.Col_PlatformAppiumServerPath, Constants.Sheet_Platforms); 
			
			Log.info("The path of Appium Server is "+sPlatformAppiumServerPath);
			
			 sPlatformEmulatorPlayerPath = ExcelUtils.getCellData(iPlatform, Constants.Col_PlatformEmulatorPlayerPath, Constants.Sheet_Platforms); 
				
			Log.info("The path of Emulator Player is "+sPlatformEmulatorPlayerPath);
			
			sPlatformBrowser = ExcelUtils.getCellData(iPlatform, Constants.Col_PlatformBrowser, Constants.Sheet_Platforms); 
			
			Log.info("The browser name is "+sPlatformBrowser);
			
			sPlatformCloudRunMode = ExcelUtils.getCellData(iPlatform, Constants.Col_PlatformCloudMode, Constants.Sheet_Platforms);

			Log.info("The Platform Cloud Run mode is "+sPlatformCloudRunMode);


			sPlatformRunMode = ExcelUtils.getCellData(iPlatform, Constants.Col_PlatformRunMode,Constants.Sheet_Platforms);

			Log.info("The Platform Run mode is "+sPlatformRunMode);
			
			sPlatformEmulatorRunMode = ExcelUtils.getCellData(iPlatform, Constants.Col_PlatformEmulatorRunMode,Constants.Sheet_Platforms);

			Log.info("The Platform Emulator Run mode is "+sPlatformEmulatorRunMode);
			
			

			if (sPlatformRunMode.equalsIgnoreCase("Yes"))
			{
				
										
						iTotalTestCases = ExcelUtils.getRowCount(Constants.Sheet_TestCases);

						Log.info("The Total Number of Total Cases are "+iTotalTestCases);

						ActionsMobile.bResult=true;
	
						for( iTestcase=1;iTestcase<=iTotalTestCases;iTestcase++)
						{
								  
								int SequenceValue=ExcelUtils.getCellData1(iTestcase, Constants.Col_Sequence, Constants.Sheet_Sequences);
							  
								Log.info("The value of iTestCase is "+iTestcase);
								
								Log.info("The Sequence value is "+SequenceValue);

								Log.info("Fetching the sequence value "+SequenceValue);
								Log.info("The compareValue is "+Constants.CompareValue);
									
								if(SequenceValue==Constants.CompareValue)
									
								{
									Log.info("Sequence value is equal to CompareValue");

									Log.info("Incrementing the Compare Value");
									
									Constants.CompareValue++;
									
									Log.info("The incremented Compare value is "+Constants.CompareValue );
									
							sTestCaseID = ExcelUtils.getCellData(iTestcase, Constants.Col_TestCaseID, Constants.Sheet_TestCases); 
							Log.info("The Test Case id is "+sTestCaseID);
							

							sRunMode = ExcelUtils.getCellData(iTestcase, Constants.Col_RunMode,Constants.Sheet_TestCases);

							Log.info("The Runmode is "+sRunMode);

							if (sRunMode.equals("Yes"))
							{
								Log.info("Running Test Case "+sTestCaseID);

								iTestStep = ExcelUtils.getRowContains(sTestCaseID,Constants.Col_TestCaseID, Constants.Sheet_TestSteps);

								Log.info("Fetching the Test Step "+iTestStep);

								iTestLastStep = ExcelUtils.getTestStepsCount(Constants.Sheet_TestSteps, sTestCaseID, iTestStep);

								Log.info("Fetching the Test Step Counts for TestCaseID "+iTestLastStep);


								ActionsMobile.bResult=true;
								for (;iTestStep<=iTestLastStep;iTestStep++)
								{
									
									Log.info("Fetching the Action Keyword");
									sActionKeyword = ExcelUtils.getCellData(iTestStep, Constants.Col_ActionKeyword,Constants.Sheet_TestSteps);

									Log.info("The Action Keyword is "+sActionKeyword);

									Log.info("Fetching the locator ID");

									sLocator = ExcelUtils.getCellData(iTestStep, Constants.Col_Locator,Constants.Sheet_TestSteps);

									Log.info("The Locator ID is "+sLocator);

									Log.info(" Fetching the total Number of locators");

									int iTotalLocators=ExcelUtils.getRowCount(Constants.Sheet_Locators);

									Log.info("The total Number of locators are "+iTotalLocators);

									for(int iLocator=1;iLocator<=iTotalLocators;iLocator++)

									{


										if(ExcelUtils.getCellData(iLocator, Constants.Col_LocatorID, Constants.Sheet_Locators).equals(sLocator))
										{

											Log.info("Fetching the Locator Value");

											sLocatorValue=ExcelUtils.getCellData(iLocator, Constants.Col_LocatorValue, Constants.Sheet_Locators);

											Log.info("The Locator Value is "+sLocatorValue);

										}
									}

									Log.info("Fetching the Value");

									sValue = ExcelUtils.getCellData(iTestStep, Constants.Col_Value,Constants.Sheet_TestSteps);

									Log.info("The value is "+sValue);
									
									Log.info("Fetching the Run Mode for Test Step");
									
									sTestStepRunMode=ExcelUtils.getCellData(iTestStep, Constants.Col_TestStep_RunMode, Constants.Sheet_TestSteps);
									
									
                                    if(sTestStepRunMode.equalsIgnoreCase("Yes"))
                                    {

									Log.info("Running the Test Step "+sTestCaseID);
									ActionsMobile.execute_Actions();
                                    }

								}
								
								iTestStepResult = ExcelUtils.getRowContains(sTestCaseID,Constants.Col_TestCaseID, Constants.Sheet_TestSteps);
								
								iTestLastStepResult = ExcelUtils.getTestStepsCount(Constants.Sheet_TestSteps, sTestCaseID, iTestStepResult);
								
								for(;iTestStepResult<=iTestLastStepResult;iTestStepResult++)
								{
									sResult=ExcelUtils.getCellData(iTestStepResult, Constants.Col_TestStepResult,Constants.Sheet_TestSteps);
									arrayResult.add(sResult);
								}
								
								for(String result:arrayResult)
								{
									System.out.println(result);
									
									if(result.equals("FAIL"))
									{
										ExcelUtils.setCellData(Constants.Keyword_Fail,iTestcase,Constants.Col_Results,Constants.Sheet_TestCases);
										break;
									}
									else
									{
										ExcelUtils.setCellData(Constants.Keyword_Pass,iTestcase,Constants.Col_Results,Constants.Sheet_TestCases);


									}

										
								}
								
								arrayResult.clear();

								
							}
						}
						
								else
								{
									Log.info("Incrementing the iTotalTestCases");
									
									iTotalTestCases++;
									
									Log.info("Incremented value of iTotalTestCases is "+iTotalTestCases);
								}
								
								if(Constants.CompareValue>ExcelUtils.getRowCount(Constants.Sheet_Sequences))
								{
									Log.info("Initializng the Compare value to 1");
									
									Constants.CompareValue=1;
									
									Log.info("The Compare value is initialized to "+Constants.CompareValue);
									break;
								}
								
								if(iTestcase==ExcelUtils.getRowCount(Constants.Sheet_Sequences))
								{
									Log.info("Initializng the iTestcase to 1");
									
									iTestcase=1;
									
									Log.info("The iTestcase is initialized to "+iTestcase);

								}
								
					}
						
						
						
						iTestPlatformCount = ExcelUtils.getRowCount(Constants.Sheet_TestCases);
						
						for(int i=1;i<=iTestPlatformCount;i++)
						{
							sResult1=ExcelUtils.getCellData(i, Constants.Col_Results,Constants.Sheet_TestCases);
							arrayResult1.add(sResult1);
						}
						
						for(String result1:arrayResult1)
						{
							System.out.println(result1);
							
							if(result1.equals("FAIL"))
							{
								ExcelUtils.setCellData(Constants.Keyword_Fail,iPlatform,Constants.Col_PlatformResults,Constants.Sheet_Platforms);
								break;
							}
							else
							{
								ExcelUtils.setCellData(Constants.Keyword_Pass,iPlatform,Constants.Col_PlatformResults,Constants.Sheet_Platforms);


							}

								
						}
						
						arrayResult1.clear();
													
			    }
			
		    }
		
		if(iPlatform>iTotalPlatforms)
		{
			Log.info("Stopping Appium Server");
			StartAndStopAppium.stopAppiumServer();
			
			Log.info("Opening Excel File for viewing results");
		    Desktop.getDesktop().open(new File(VerifyingExcel.excelFilePath));
		    
		    Log.info("Stopping the Mobile Application");
		    System.exit(0);
		}
		}
	}	
