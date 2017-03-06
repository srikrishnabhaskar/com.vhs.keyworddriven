package config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDeviceActionShortcuts;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.io.*;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.mail.*;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.applitools.eyes.Eyes;
import com.applitools.eyes.RectangleSize;
import com.gargoylesoftware.htmlunit.javascript.host.Element;

import executionEngine.*;
import utility.Log;
import utility.StartAndStopAppium;

public class ActionKeywords extends JFrame {
	public static WebDriver driver;
	public static File scrFile;
	public static JOptionPane jop;
	public static JDialog k;
	public static JPanel contentPane;
    public static JFrame frame1=new JFrame();
    public static Eyes eyes;
    public static String UrlName;
    public static String testName;
    public static void openBrowser(String sLocators, String sValue,String sBrowserName, String sBrowserVersion, String sOperatingSystem, String sIpAddress, String sSauceUserName, String sSauceAccessKey, String sCloudRunMode )
	{			
    	
    	if(sCloudRunMode.equalsIgnoreCase("No"))
	   {
						
		try
		{
			if(sBrowserName.equals("Firefox"))
			{
												
				try
				{
	  				execute_WaitPopup();
					Log.info("Opening Firefox Browser");
					driver=new FirefoxDriver();
					driver.manage().window().maximize();
					frame1.dispose();
				}
			        catch (Exception e) {

						Log.info("Not able to open Firefox browser"+e.getMessage());
						ActionsWeb.bResult=false;			
	   	    			ActionsMobile.bResult=false;

						}
			}
			else if(sBrowserName.equals("Chrome"))
			{
				try
				{
										
					System.setProperty("webdriver.chrome.driver","Log4jConfiguration/chromedriver.exe");					 
					execute_WaitPopup();
					Log.info("Opening Chrome Browser");
					driver=new ChromeDriver();	
					driver.manage().window().maximize();
					frame1.dispose();					
					//scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

				}
				catch(Exception e)
				{
					Log.info("Not able to open Chrome Browser "+e.getMessage());
					ActionsWeb.bResult=false;
  	    			ActionsMobile.bResult=false;

				}

			}
			else if(sBrowserName.equals("Safari"))
			{
				try
				{
					System.setProperty("webdriver.safari.driver","C:/safaridriver.exe");
					
					execute_WaitPopup();
					Log.info("Opening Safari Browser");
				    driver=new SafariDriver();	 
					driver.manage().window().maximize();
					frame1.dispose();					

				}
				catch(Exception e)
				{
					Log.info("Not able to open Safari Browser "+e.getMessage());
					ActionsWeb.bResult=false;
  	    			ActionsMobile.bResult=false;

				}
			}
			else
			{
				try
				{
					System.setProperty("webdriver.ie.driver","Log4jConfiguration/IEDriverServer.exe");

					
					execute_WaitPopup();
					Log.info("Opening IE Browser");
					driver=new InternetExplorerDriver();	
					driver.manage().window().maximize();
					frame1.dispose();					
					//scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

				}
				catch(Exception e)
				{
					Log.info("Not able to open IE Browser "+e.getMessage());
					ActionsWeb.bResult=false;
  	    			ActionsMobile.bResult=false;

				}
			}
		}

		catch(Exception e)
		{
			Log.info("Not able to open browser "+e.getMessage());
			ActionsWeb.bResult=false;
  			ActionsMobile.bResult=false;

		}
	   }

	else
	{
		try
		{
			if(sBrowserName.equals("Firefox"))
			{
												
				try
				{	  				
					DesiredCapabilities capabilities = DesiredCapabilities.firefox();
					capabilities.setCapability("platform", sOperatingSystem);
					capabilities.setCapability("version", sBrowserVersion);
					execute_WaitPopup();
					Log.info("Opening Firefox Browser");
					driver = new RemoteWebDriver(new URL("http://"+sSauceUserName+":"+sSauceAccessKey+"@ondemand.saucelabs.com:80/wd/hub"), capabilities);
					driver.manage().window().maximize();
					frame1.dispose();
				}
			        catch (Exception e) {

						Log.info("Not able to open Firefox browser"+e.getMessage());
						ActionsWeb.bResult=false;			
	   	    			ActionsMobile.bResult=false;

						}
			}
			else if(sBrowserName.equals("Chrome"))
			{
				try
				{
										
					//System.setProperty("webdriver.chrome.driver","Log4jConfiguration/chromedriver.exe");					 
					DesiredCapabilities capabilities = DesiredCapabilities.chrome();
					capabilities.setCapability("platform", sOperatingSystem);
					capabilities.setCapability("version", sBrowserVersion);
					execute_WaitPopup();
					Log.info("Opening Chrome Browser");
					driver = new RemoteWebDriver(new URL("http://"+sSauceUserName+":"+sSauceAccessKey+"@ondemand.saucelabs.com:80/wd/hub"), capabilities);
					driver.manage().window().maximize();
					frame1.dispose();
				}
				catch(Exception e)
				{
					Log.info("Not able to open Chrome Browser "+e.getMessage());
					ActionsWeb.bResult=false;
  	    			ActionsMobile.bResult=false;
				}

			}
			else if(sBrowserName.equals("Safari"))
			{
				try
				{
					//System.setProperty("webdriver.safari.driver","C:/safaridriver.exe");
					
					DesiredCapabilities capabilities = DesiredCapabilities.safari();
					capabilities.setCapability("platform", sOperatingSystem);
					capabilities.setCapability("version", sBrowserVersion);
					execute_WaitPopup();
					Log.info("Opening Safari Browser");
					driver = new RemoteWebDriver(new URL("http://"+sSauceUserName+":"+sSauceAccessKey+"@ondemand.saucelabs.com:80/wd/hub"), capabilities);
					driver.manage().window().maximize();
					frame1.dispose();
				}
				catch(Exception e)
				{
					Log.info("Not able to open Safari Browser "+e.getMessage());
					ActionsWeb.bResult=false;
  	    			ActionsMobile.bResult=false;

				}
			}
			else
			{
				try
				{
					//System.setProperty("webdriver.ie.driver","Log4jConfiguration/IEDriverServer.exe");

					
					DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
					capabilities.setCapability("platform", sOperatingSystem);
					capabilities.setCapability("version", sBrowserVersion);
					execute_WaitPopup();
					Log.info("Opening IE Browser");
					driver = new RemoteWebDriver(new URL("http://"+sSauceUserName+":"+sSauceAccessKey+"@ondemand.saucelabs.com:80/wd/hub"), capabilities);
					driver.manage().window().maximize();
					frame1.dispose();

				}
				catch(Exception e)
				{
					Log.info("Not able to open IE Browser "+e.getMessage());
					ActionsWeb.bResult=false;
  	    			ActionsMobile.bResult=false;

				}
			}
		}

		catch(Exception e)
		{
			Log.info("Not able to open browser "+e.getMessage());
			ActionsWeb.bResult=false;
  			ActionsMobile.bResult=false;

		}
	}
	}	
    
    public static void openMobileApplication(String sPlatformName,  String sPlatformVersion, String sDeviceName,String sIpAddress,  String sSauceUserName, String sSauceAccessKey, String sAppName, String sAppPath, String sEmulatorPath, String sBrowserName,  String sPlatformCloudRunMode, String sPlatformEmulatorRunMode) 
    {
    	try
    	{
    		if(sPlatformCloudRunMode.equalsIgnoreCase("No") && sPlatformEmulatorRunMode.equalsIgnoreCase("No") )
    		{
    		
    			if(sPlatformName.equalsIgnoreCase("Android"))
    			{
    				try
    				{
    					Log.info("Stopping the Appium Server");
    					StartAndStopAppium.stopAppiumServer();
    					
    					Log.info("Starting the Appium Server");
    					StartAndStopAppium.startAppiumServer();
    					

    					if(sPlatformVersion.equals("2.3") || sPlatformVersion.equals("2.3.2") || sPlatformVersion.equals("2.3.3") || sPlatformVersion.equals("2.3.7") || sPlatformVersion.equals("3.1") || sPlatformVersion.equals("3.2") || sPlatformVersion.equals("3.2.6") || sPlatformVersion.equals("4.0") || sPlatformVersion.equals("4.0.2") || sPlatformVersion.equals("4.0.3") || sPlatformVersion.equals("4.0.4") || sPlatformVersion.equals("4.1") || sPlatformVersion.equals("4.1.2"))
    					{
    						   						
    						DesiredCapabilities capabilities = new DesiredCapabilities();
    						capabilities.setCapability("automationName", "Selendroid"); 
    						capabilities.setCapability("deviceName", sDeviceName);
    						capabilities.setCapability("platformName", sPlatformName);
    						capabilities.setCapability("platformVersion", sPlatformVersion);
    						capabilities.setCapability(CapabilityType.BROWSER_NAME, sBrowserName);
    						capabilities.setCapability("appPackage", "");
    						capabilities.setCapability("appActivity", "");
    						File f = new File(sAppPath);
    						capabilities.setCapability("app", f.getAbsolutePath());
    		
    						driver = new AndroidDriver(new URL("http://"+sIpAddress+":4723/wd/hub"),capabilities);
     						
    					}
    					else
    					{
    						DesiredCapabilities capabilities = new DesiredCapabilities();
    						capabilities.setCapability("deviceName", sDeviceName);
    						capabilities.setCapability("platformName", sPlatformName);
    						capabilities.setCapability("platformVersion", sPlatformVersion);
    						capabilities.setCapability(CapabilityType.BROWSER_NAME, sBrowserName);
    						capabilities.setCapability("appPackage", "");
    						capabilities.setCapability("appActivity", "");
    						File f = new File(sAppPath);
    						capabilities.setCapability("app", f.getAbsolutePath());
    		
    						driver = new AndroidDriver(new URL("http://"+sIpAddress+":4723/wd/hub"),capabilities);
    					}
    				}
    				catch(Exception e)
    	    		{
    	    			Log.info("Not able to open Android Mobile Application "+e.getMessage());
    	    			ActionsMobile.bResult=false;

    	    		}
    				
    	   }
    			
    		   else if(sPlatformName.equalsIgnoreCase("iOS"))
    			{
    			   try
    			   {
    				   
    				Log.info("Stopping the Appium Server");
   					//StartAndStopAppium.stopAppiumServer();
   					
   					Log.info("Starting the Appium Server");
   					//StartAndStopAppium.startAppiumServer();
   					
    			    DesiredCapabilities capabilities = new DesiredCapabilities();
    			    capabilities.setCapability("deviceName", sDeviceName);
    				capabilities.setCapability("platformName", sPlatformName);
    				capabilities.setCapability("platformVersion", sPlatformVersion);
    				capabilities.setCapability(CapabilityType.BROWSER_NAME, sBrowserName);
    				capabilities.setCapability("appPackage", "");
					capabilities.setCapability("appActivity", "");
    				File f = new File(sAppPath);
    				capabilities.setCapability("app", f.getAbsolutePath());
    				
    				 IOSDriver driver = new IOSDriver(new URL("http://"+sIpAddress+":4723/wd/hub"),capabilities);
    				
    			   }
    			   catch(Exception e)
   	    		   {  	    			
    				 Log.info("Not able to open iOS Mobile Application "+e.getMessage());
   	    			 ActionsMobile.bResult=false;

   	    		   }
    			   
    			}
    		}
    		else if (sPlatformEmulatorRunMode.equalsIgnoreCase("No"))
    		{
    			if(sPlatformName.equalsIgnoreCase("Android"))
    			{
    				try
    				{
    					Log.info("Stopping the Appium Server");
    					StartAndStopAppium.stopAppiumServer();
    					
    					Log.info("Starting the Appium Server");
    					StartAndStopAppium.startAppiumServer();

    					if(sPlatformVersion.equals("2.3") || sPlatformVersion.equals("2.3.2") || sPlatformVersion.equals("2.3.3") || sPlatformVersion.equals("2.3.7") || sPlatformVersion.equals("3.1") || sPlatformVersion.equals("3.2") || sPlatformVersion.equals("3.2.6") || sPlatformVersion.equals("4.0") || sPlatformVersion.equals("4.0.2") || sPlatformVersion.equals("4.0.3") || sPlatformVersion.equals("4.0.4") || sPlatformVersion.equals("4.1") || sPlatformVersion.equals("4.1.2"))
    					{
    					
    						DesiredCapabilities capabilities = new DesiredCapabilities();
    				    	capabilities.setCapability("automationName", "Selendroid"); 
    						capabilities.setCapability("deviceName", sDeviceName);
    						capabilities.setCapability("platformName", sPlatformName);
    						capabilities.setCapability("platformVersion", sPlatformVersion);
    						capabilities.setCapability("appiumVersion","1.5.3");
    						capabilities.setCapability("maxDuration", "10800");
    						capabilities.setCapability("appPackage", "");
    						capabilities.setCapability("appActivity", "");
    						//capabilities.setCapability(CapabilityType.BROWSER_NAME, sBrowserName);
    						capabilities.setCapability("app", "sauce-storage:"+sAppName);
    		
    						System.out.println(sSauceUserName);
    						driver = new AndroidDriver(new URL("http://"+sSauceUserName+":"+sSauceAccessKey+"@ondemand.saucelabs.com:80/wd/hub"),capabilities);
    			
      					}
    					else
    					{
    				    		
    						DesiredCapabilities capabilities = new DesiredCapabilities();
    						capabilities.setCapability("deviceName", sDeviceName);
    						capabilities.setCapability("platformName", sPlatformName);
    						capabilities.setCapability("platformVersion", sPlatformVersion);
    						capabilities.setCapability("appiumVersion","1.4.7");
    						capabilities.setCapability("maxDuration", "10800");
    						capabilities.setCapability("app", "sauce-storage:"+sAppName);
    		
    						System.out.println(sSauceUserName);
    						driver = new AndroidDriver(new URL("http://"+sSauceUserName+":"+sSauceAccessKey+"@ondemand.saucelabs.com:80/wd/hub"),capabilities);

    					}
    				}
    				catch(Exception e)
    	    		{
    	    			Log.info("Not able to open Android Mobile Application on Cloud "+e.getMessage());
    	    			ActionsMobile.bResult=false;

    	    		}
     				
    	   }
    			
    		   else if(sPlatformName.equalsIgnoreCase("iOS"))
    			{
    			   try
    			   {
    				   
    				Log.info("Stopping the Appium Server");
   					StartAndStopAppium.stopAppiumServer();
   					
   					Log.info("Starting the Appium Server");
   					StartAndStopAppium.startAppiumServer();
   					

   					DesiredCapabilities capabilities = DesiredCapabilities.ipad();
   					capabilities.setCapability("browserName", "");
   					capabilities.setCapability("deviceName", sDeviceName);
   					capabilities.setCapability("platformName", sPlatformName);
   					capabilities.setCapability("platformVersion",sPlatformVersion);
   					capabilities.setCapability("appiumVersion", "1.4.7");
					capabilities.setCapability("maxDuration", "10800");
   					capabilities.setCapability("app", "sauce-storage:"+sAppName);
    				
    				  driver = new IOSDriver(new URL("http://"+sSauceUserName+":"+sSauceAccessKey+"@ondemand.saucelabs.com:80/wd/hub"),capabilities);
    				
    			   }
    			   catch(Exception e)
   	    		   {
   	    			
    				 Log.info("Not able to open iOS Mobile Application on Cloud "+e.getMessage());
   	    			 ActionsMobile.bResult=false;

   	    		   }
     			
    		}
    	}
    		else
    		{
    			
    			if(sPlatformName.equalsIgnoreCase("Android"))
    			{
    				try
    				{
    					Log.info("Stopping the Appium Server");
    					StartAndStopAppium.stopAppiumServer();
    					
    					Log.info("Starting the Appium Server");
    					StartAndStopAppium.startAppiumServer();
    					
    					DefaultExecutor executor = new DefaultExecutor();
    			        DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();

    			        CommandLine launchEmul = new CommandLine(sEmulatorPath);
    			        launchEmul.addArgument("--vm-name");
    			        launchEmul.addArgument("\""+sDeviceName+"\"");
    			        executor.setExitValue(1);
    			        executor.execute(launchEmul, resultHandler);
    			        
    			        
                        Thread.sleep(75000);
    					if(sPlatformVersion.equals("2.3") || sPlatformVersion.equals("2.3.2") || sPlatformVersion.equals("2.3.3") || sPlatformVersion.equals("2.3.7") || sPlatformVersion.equals("3.1") || sPlatformVersion.equals("3.2") || sPlatformVersion.equals("3.2.6") || sPlatformVersion.equals("4.0") || sPlatformVersion.equals("4.0.2") || sPlatformVersion.equals("4.0.3") || sPlatformVersion.equals("4.0.4") || sPlatformVersion.equals("4.1") || sPlatformVersion.equals("4.1.2"))
    					{
    					
    						DesiredCapabilities emul= new DesiredCapabilities ();
    						  emul.setCapability ("deviceName",sDeviceName );
      						  emul.setCapability("browsername",sBrowserName);
    						  emul.setCapability ("platformName", sPlatformName);
    						  emul.setCapability ("platformVersion", sPlatformVersion);
    						  emul.setCapability ("appPackage","com.android.chrome");
      						  emul.setCapability ("appActivity","com.google.android.apps.chrome.Main" );
    						  emul.setCapability ("udid",sIpAddress );	
    						  emul.setCapability ("appActivity","com.google.android.apps.chrome.Main" );
    						  emul.setCapability ("udid","192.168.56.101:5555" );
    						  driver = new AndroidDriver <WebElement> (new URL ("http://127.0.0.1:4723/wd/hub"),emul);

    						 			
      					}
    					else
    					{
    						System.out.println(sBrowserName);
    						DesiredCapabilities emul= new DesiredCapabilities ();
    						emul.setCapability ("deviceName",sDeviceName );
    						emul.setCapability("browsername",sBrowserName);
    						emul.setCapability ("platformName", sPlatformName);
    						emul.setCapability ("platformVersion", sPlatformVersion);
    						emul.setCapability ("appPackage","com.android.chrome");
    						emul.setCapability ("appActivity","com.google.android.apps.chrome.Main" );
  						    emul.setCapability ("udid",sIpAddress );
  						    emul.setCapability ("udid","192.168.56.101:5555" );
                            driver = new AndroidDriver <WebElement> (new URL ("http://127.0.0.1:4723/wd/hub"),
                             emul);

    					}
    				}
    				catch(Exception e)
    	    		{
    	    			Log.info("Not able to open Android Mobile Application on Emulator "+e.getMessage());
    	    			ActionsMobile.bResult=false;


    	    		}
    				
    	   }
    			
    		}
    	}
    		
    	   catch(Exception e)
    		{
    			Log.info("Not able to open Mobile Application "+e.getMessage());
	    	    ActionsMobile.bResult=false;

    		}
    	
    	
    }
    
   

	public static void navigate(String sLocators, String sValue,String sBrowserName){	
		try
		{
			Log.info("Saving the Url Name");
			URL name = new URL(sValue);
			UrlName=name.getHost();			
			Log.info("Url Name Saved");
	
			Log.info("Navigating to URL: "+sValue);
			driver.get(sValue);
		}
		catch(Exception e)
		{
			Log.info("Failed to nagivate to "+ sValue + e.getMessage() );
			ActionsWeb.bResult=false;
  			ActionsMobile.bResult=false;



		}
	}
	
	 public static void openEyes(String BrowserSize)
	    {
		 
		 int width;
		 int height;
		 try
		 {
	    	Log.info("Creating Object of Eyes");
	    	eyes=new Eyes();
	    	
	    	if(VerifyingExcel.excelFilePath.contains("Web"))
			{
			Log.info("Setting the Api Key of Eyes for Web");
			eyes.setApiKey(WebApplicationTest.sAppliToolApiKey);
			
			
			}
	    	else
	    	{
			Log.info("Setting the Api Key of Eyes for Mobile");
			eyes.setApiKey(MobileApplicationTest.sPlatformAppliToolApiKey);
	    	}
	    	
			
					
			if(VerifyingExcel.excelFilePath.contains("Web"))
			{
				
				String resolution[];
				resolution=BrowserSize.split(",",2);
				
				width=Integer.parseInt(resolution[0]);
				height=Integer.parseInt(resolution[1]);
				
				Log.info("Opening eyes for Web");
				eyes.open(driver, UrlName, WebApplicationTest.sBrowserName+" "+WebApplicationTest.sBrowserVersion+" "+WebApplicationTest.sOperatingSystem, new RectangleSize(width,height));
				ActionsWeb.bResult=true;
				ActionsMobile.bResult=true;
			}
				
			else
			{
				Log.info("Opening eyes for Mobile");
				eyes.open(driver, MobileApplicationTest.sPlatformAppName ,MobileApplicationTest.sPlatformDeviceName+" "+MobileApplicationTest.sPlatformVersion);
				ActionsWeb.bResult=true;
				ActionsMobile.bResult=true;
			}
		 }
		 catch(Exception e)
		 {
			 Log.info("Failed to open the eyes"+e.getMessage());
			 ActionsWeb.bResult=false;
			 ActionsMobile.bResult=false;
		 }
	    }
	    
	

	public static void click(String sLocators)
	{
		try
		{
			Log.info("Waiting for few Seconds");
			WebDriverWait wait = new WebDriverWait(driver, 30);
			
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sLocators)));
			 
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sLocators)));
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(sLocators)));
			
			
			Log.info("Click action performed");
			driver.findElement(By.xpath(sLocators)).click();
			ActionsWeb.bResult=true;
  			ActionsMobile.bResult=true;



		}
		catch(Exception e)
		{
			Log.info("Failed to click "+e.getMessage());
			ActionsWeb.bResult=false;
  			ActionsMobile.bResult=false;


		}
	}

	public static void doubleClick(String sLocators)
	{
		try
		{
			Log.info("Waiting for few Seconds");
			WebDriverWait wait = new WebDriverWait(driver, 30);
			
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sLocators)));
			 
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sLocators)));
			
			Log.info("Double Click action performed");
			Actions action = new Actions(driver);
			
			WebElement element = driver.findElement(By.xpath(sLocators));
			action.doubleClick(element).build().perform();
			ActionsWeb.bResult=true;
  			ActionsMobile.bResult=true;



		}
		catch(Exception e)
		{
			Log.info("Failed to Double Click "+e.getMessage());
			ActionsWeb.bResult=false;
  			ActionsMobile.bResult=false;


		}
	}
	public static void input(String sLocators, String sValue,String sBrowserName)
	{
		try
		{
			Log.info("Waiting for few Seconds");
			WebDriverWait wait = new WebDriverWait(driver, 30);
			
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sLocators)));
			 
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sLocators)));
			
			Log.info("Value entered "+sValue);
			driver.findElement(By.xpath(sLocators)).sendKeys(sValue); 
			ActionsWeb.bResult=true;
  			ActionsMobile.bResult=true;


		}
		catch(Exception e)
		{
			Log.info("Failed to input value "+sValue + e.getMessage());
			ActionsWeb.bResult=false;
  			ActionsMobile.bResult=false;


		}
	}
	
	

	public static void waitFor(String sLocators) throws Exception
	{
		try
		{
			Log.info("Waiting for few Seconds");
			WebDriverWait wait = new WebDriverWait(driver, 30);
			
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sLocators)));
			 
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sLocators)));
			ActionsWeb.bResult=true;
  			ActionsMobile.bResult=true;


		}
		catch(Exception e)
		{
			Log.info("Failed to wait for few seconds "+e.getMessage());
			ActionsWeb.bResult=false;
  			ActionsMobile.bResult=false;


		}

	}
	
	public static void wait(String sLocators, String sValue)
	{
		try
		{
			Log.info("Waiting for "+sValue+ " Seconds");
		    int sleep = Integer.parseInt(sValue);
		    Thread.sleep(sleep);
			ActionsWeb.bResult=true;
  		    ActionsMobile.bResult=true;


		}
		catch(Exception e)
		{
			Log.info("Failed to wait for " +sValue+ " Seconds "+e.getMessage());
			ActionsWeb.bResult=false;
  		    ActionsMobile.bResult=false;


		}
	}
	
	
	public static void assert_table(String sLocators,String sAssert)
	{
		
		Log.info("Waiting for few Seconds");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sLocators)));
		 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sLocators)));
		
		WebElement element=driver.findElement(By.xpath(sLocators));
		

		if((element.getAttribute("value")).equals(sAssert))
		{
			Log.info("Assertion Passed");
			ActionsWeb.bResult=true;
  			ActionsMobile.bResult=true;


		}
		else
		{
			Log.info("Assertion Failed");
			ActionsWeb.bResult=false;
  			ActionsMobile.bResult=false;

			
			}
		
		

		
	}
	
	public static void assert_upload(String sLocators, String sAssert)
	{
		
		Log.info("Waiting for few Seconds");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sLocators)));
		 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sLocators)));
		
		
		WebElement element=driver.findElement(By.xpath(sLocators));
		
		if((element.getText().equals(sAssert)))
		{
			Log.info("Upload File Assertion Passed");
			ActionsWeb.bResult=true;
  			ActionsMobile.bResult=true;

		}
		else
		{
			Log.info("Upload File Assertion Failed");
			ActionsWeb.bResult=false;
  		    ActionsMobile.bResult=false;

			
		}
		

	}
	
	public static void assert_tooltip(String sLocators, String sAssert)
	{
		
		Log.info("Waiting for few Seconds");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sLocators)));
		 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sLocators)));
		
		WebElement element=driver.findElement(By.xpath(sLocators));
		
		if((element.getAttribute("data-original-title").equals(sAssert)))
		{
			Log.info("Tool tip Assertion Passed");
			ActionsWeb.bResult=true;
  		    ActionsMobile.bResult=true;


		}
		else
		{
			Log.info("Tool tip Assertion Failed");
			ActionsWeb.bResult=false;
  		    ActionsMobile.bResult=false;

	
		}
	}
	
	public static void assert_WaterMarkText(String sLocators, String sAssert)
	{
		
		Log.info("Waiting for few Seconds");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sLocators)));
		 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sLocators)));
		
		WebElement element=driver.findElement(By.xpath(sLocators));
		
		
		if((element.getAttribute("placeholder").equals(sAssert)))
		{
			Log.info("Watermark Text Assertion Passed");
			ActionsWeb.bResult=true;
  		    ActionsMobile.bResult=true;


		}
		else
		{
			Log.info("Watermark Text Assertion Failed");
			ActionsWeb.bResult=false;
  		    ActionsMobile.bResult=false;

			
		}
		
	}
	
	public static void assert_PageTitleText(String sAssert)
	{
		
		Log.info("Waiting for few Seconds");
		
		
		String  title =driver.getTitle();
		
		if(title.equals(sAssert))
		{
			Log.info("Page Title Text Assertion Passed");
			ActionsWeb.bResult=true;
  		    ActionsMobile.bResult=true;

			

		}
		else
		{
			Log.info("Page Title Text Assertion Failed");
			ActionsWeb.bResult=false;
  		    ActionsMobile.bResult=false;

			
		}
		
	}
	
	public static void assert_Text(String sLocators, String sAssert) throws InterruptedException
	{
		try
		{
		
		Log.info("Waiting for few Seconds");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		 
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sLocators)));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sLocators)));
        
		
		WebElement element=driver.findElement(By.xpath(sLocators));
		Log.info(element.getText());
		if((element.getText().equals(sAssert)))
		{
			Log.info("Text Assertion Passed");
			ActionsWeb.bResult=true;
  		    ActionsMobile.bResult=true;


		}
	
		}
		catch(Exception e)
		{
			Log.info("Text Assertion Failed"+e.getMessage());
			ActionsWeb.bResult=false;
  		    ActionsMobile.bResult=false;


		}
		
		
	
	}
	public static void assert_IsEnabled(String sLocators)
	{
		
			try
			{
					
			Log.info("Waiting for few Seconds");
			WebDriverWait wait = new WebDriverWait(driver, 30);
			
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sLocators)));
			 
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sLocators)));		
			
			Log.info("Checking whether an element is enabled");
			WebElement element = driver.findElement(By.xpath(sLocators));
			if(element.isEnabled())
			{
				Log.info("IsEnabled Assertion Passed");
				ActionsWeb.bResult=true;
	  		    ActionsMobile.bResult=true;

			}
			else
			{
				Log.info("IsEnabled Assertion Failed");
				ActionsWeb.bResult=false;
	  		    ActionsMobile.bResult=false;
				
			}
			}
			catch(Exception e)
			{
				Log.info("IsEnabled Assertion Failed"+e.getMessage());
				ActionsWeb.bResult=false;
	  		    ActionsMobile.bResult=false;

			}
			
	}
	
	public static void assert_IsDisabled(String sLocators)
	{
		
			try
			{
			Log.info("Waiting for few Seconds");
			WebDriverWait wait = new WebDriverWait(driver, 30);
			
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sLocators)));
			 
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sLocators)));
			
			
			Log.info("Checking whether an element is disabled");
			String element = driver.findElement(By.xpath(sLocators)).getAttribute("class");
			if(element.contains("p-state-disabled"))
			{
				Log.info("IsDisabled Assertion Passed");

				ActionsWeb.bResult=true;
	  		    ActionsMobile.bResult=true;

			}
			else
			{
				Log.info("IsDisabled Assertion Failed");
				ActionsWeb.bResult=false;
	  		    ActionsMobile.bResult=false;
				
			}
			}
			catch(Exception e)
			{
				Log.info("IsDisabled Assertion Failed"+e.getMessage());
				ActionsWeb.bResult=false;
	  		    ActionsMobile.bResult=false;

			}
			
	}
	
	public static void assert_IsDisabled_Mobile(String sLocators)
	{
		
			try
			{
			Log.info("Waiting for few Seconds");
			WebDriverWait wait = new WebDriverWait(driver, 30);
			
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sLocators)));
			 
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sLocators)));
					
			Log.info("Checking whether an element is disabled on Mobile");
			WebElement element = driver.findElement(By.xpath(sLocators));
			if(element.isEnabled())
			{
				Log.info("IsDisabled Assertion Failed");
				ActionsWeb.bResult=false;
	  		    ActionsMobile.bResult=false;

			}
			else
			{
				Log.info("IsDisabled Assertion Passed");
				ActionsWeb.bResult=true;
	  		    ActionsMobile.bResult=true;

				
			}
			}
			catch(Exception e)
			{

				Log.info("IsDisabled_Mobile Assertion Failed");
				ActionsWeb.bResult=false;
	  		    ActionsMobile.bResult=false;

			}			

	}
	
	public static void assert_Name(String sLocators, String sAssert)
	{
		
			Log.info("Waiting for few Seconds");
			WebDriverWait wait = new WebDriverWait(driver, 30);
			
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sLocators)));
			 
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sLocators)));
			
			
			Log.info("Checking whether the text is present");
			WebElement element = driver.findElement(By.xpath(sLocators));
			
			if((element.getAttribute("Name").equals(sAssert)))
			{
				Log.info("Text_Name Assertion Passed");
				ActionsWeb.bResult=true;
	  		    ActionsMobile.bResult=true;


			}
			else
			{
				Log.info("Text_Name Assertion Failed");
				ActionsWeb.bResult=false;
	  		    ActionsMobile.bResult=false;

				
			}
	
	}
	
	public static void assert_TextHighlight(String sLocators)
	{
		Log.info("Waiting for few Seconds");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sLocators)));
		 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sLocators)));
		
		String color =driver.findElement(By.xpath(sLocators)).getCssValue("color");
		String backgroundcolor=driver.findElement(By.xpath(sLocators)).getCssValue("background-color");
		
		if(!color.equals(backgroundcolor))
		{
			Log.info("Text Highlight Assertion Passed");
			ActionsWeb.bResult=true;
  		    ActionsMobile.bResult=true;

		}
		else
		{
			Log.info("Text Highlight Assertion Failed");
			ActionsWeb.bResult=false;
  		    ActionsMobile.bResult=false;

		}
	}
	

	
	public static void eyeScanner(String pageName)
	{
		try
		{
		Thread.sleep(8000);
		Log.info("Checking the Screen");
		eyes.checkWindow(pageName);
		ActionsWeb.bResult=true;
    	ActionsMobile.bResult=true;
		}
		
		catch(Exception e)
		{
			Log.info("Failed to check the screen"+ e.getMessage());
			ActionsWeb.bResult=false;
        	ActionsMobile.bResult=false;			
		}
	}
	

	public static void uploadFile(String sLocators, String sValue, String sBrowserName)
	{
		
	try
	{
		Log.info("Waiting for few Seconds");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sLocators)));
		 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sLocators)));
		
		
		Log.info("Uploading the File");
		driver.findElement(By.xpath(sLocators)).sendKeys(sValue);
		ActionsWeb.bResult=true;
		ActionsMobile.bResult=true;

	}
	
	catch(Exception e)
	{
		Log.info("Failed to upload the file "+e.getMessage());
		ActionsWeb.bResult=false;
		ActionsMobile.bResult=false;


	}
	
	}
	
	public static void mouseHover(String sLocators, String sValue, String sBrowserName)
	{
		try
		{
			Log.info("Waiting for few Seconds");
			WebDriverWait wait = new WebDriverWait(driver, 30);
			
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sLocators)));
			 
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sLocators)));
			
			
			Log.info("Hovering over an element");
			Actions actions = new Actions(driver);
			WebElement element = driver.findElement(By.xpath(sLocators));
			actions.moveToElement(element).build().perform();
			ActionsWeb.bResult=true;
  		    ActionsMobile.bResult=true;


		}
		
		catch(Exception e)
		{
			Log.info("Failed to hover over an element "+e.getMessage());
			ActionsWeb.bResult=false;
  		    ActionsMobile.bResult=false;

		}
	}
	
	public static void refreshPage()
	{
		try
		{
			Log.info("Refreshing the page");
			driver.navigate().refresh();
			ActionsWeb.bResult=true;
  		    ActionsMobile.bResult=true;


		}
		
		catch(Exception e)
		{
			Log.info("Failed to refresh the page "+e.getMessage());
			ActionsWeb.bResult=false;
  		    ActionsMobile.bResult=false;

		}
	}
	
	public static void forwardPage()
	{
		try
		{
			Log.info("Navigation forward");
			driver.navigate().forward();
			ActionsWeb.bResult=true;
  		    ActionsMobile.bResult=true;


		}
		
		catch(Exception e)
		{
			Log.info("Failed to navigate forward "+e.getMessage());
			ActionsWeb.bResult=false;
  		    ActionsMobile.bResult=false;

		}
	}
	
	public static void backwardPage()
	{
		try
		{
			Log.info("Navigation backward");
			driver.navigate().back();
			ActionsWeb.bResult=true;
  		    ActionsMobile.bResult=true;
  		    


		}
		
		catch(Exception e)
		{
			Log.info("Failed to navigate back "+e.getMessage());
			ActionsWeb.bResult=false;
  		    ActionsMobile.bResult=false;

			
		}
	}
	
	public static void dragAndDrop(String sLocators, String sValue, String sBrowserName)
	{
		try
		{
			Log.info("Waiting for few Seconds");
			WebDriverWait wait = new WebDriverWait(driver, 30);
			
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sLocators)));
			 
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sLocators)));
			
			
			int value=Integer.parseInt(sValue);
			Log.info("Drag and Drop of element started");
			WebElement element = driver.findElement(By.xpath(sLocators));
			Actions actions = new Actions(driver);
            actions.dragAndDropBy(element, value, 0).perform();
			ActionsWeb.bResult=true;
  		    ActionsMobile.bResult=true;


			
		}
		
		catch(Exception e)
		{
			Log.info("Drag and Drop of element failed"+e.getMessage());
			ActionsWeb.bResult=false;
  		    ActionsMobile.bResult=false;

		}
	}
	
	public static void rightClick(String sLocators)
	{
		try
		{
			
			Log.info("Waiting for few Seconds");
			WebDriverWait wait = new WebDriverWait(driver, 30);
			
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sLocators)));
			 
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sLocators)));
			
			
			Log.info("Performing right click action");
			WebElement element = driver.findElement(By.xpath(sLocators));
			Actions actions = new Actions(driver);
            actions.moveToElement(element).perform();
            actions.contextClick().perform();
			ActionsWeb.bResult=true;
  		    ActionsMobile.bResult=true;


			
		}
		
		catch(Exception e)
		{
			Log.info("Performing right click action failed"+e.getMessage());
			ActionsWeb.bResult=false;
  		    ActionsMobile.bResult=false;

		}
	}
	
	public static void scrollDown(String sLocators)
	{
		try
		{
			
			Log.info("Waiting for few Seconds");
			WebDriverWait wait = new WebDriverWait(driver, 30);
			
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sLocators)));
			 
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sLocators)));
			
			Log.info("Scrolling down till it finds an Element");
			
			WebElement element = driver.findElement(By.xpath(sLocators));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			
			ActionsWeb.bResult=true;
  		    ActionsMobile.bResult=true;


			
		}
		
		catch(Exception e)
		{
			Log.info("Performing Scroll down action failed"+e.getMessage());
			ActionsWeb.bResult=false;
  		    ActionsMobile.bResult=false;

		}
		
	}
	
	public static void scrollUp(String sValue)
	{
		try
		{
						
			Log.info("Scrolling up");
			JavascriptExecutor jsx = ( JavascriptExecutor)driver;
			int i=Integer.parseInt(sValue);
			jsx.executeScript("window.scrollBy("+i+",0)", "");
			ActionsWeb.bResult=true;
  		    ActionsMobile.bResult=true;

		
		}
		
		catch(Exception e)
		{
			Log.info("Scrolling Up action failed"+e.getMessage());
			ActionsWeb.bResult=false;
  		    ActionsMobile.bResult=false;

		}
	}
	
	public static void switchToFrame(String sValue)
	{
		try
		{
		Log.info("Switching to Frame");
		driver.switchTo().frame(sValue);
		ActionsWeb.bResult=true;
		ActionsMobile.bResult=true;


		}
		
		catch(Exception e)
		{
			Log.info("Switching to frame failed"+e.getMessage());
			ActionsWeb.bResult=false;
  		    ActionsMobile.bResult=false;

		}
	}

	public static void switchOutsideFrame()
	{
		try
		{
		Log.info("Switching Outside Frame");
		driver.switchTo().defaultContent();
		ActionsWeb.bResult=true;
		ActionsMobile.bResult=true;


		}
		
		catch(Exception e)
		{
			Log.info("Switching outside frame failed"+e.getMessage());
			ActionsWeb.bResult=false;
  		    ActionsMobile.bResult=false;

		}
	}
	
	public static void selectText(String sLocators)
	{
		try
		{
			Log.info("Selecting the Text");
            driver.findElement(By.xpath(sLocators)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
    		ActionsWeb.bResult=true;
  		    ActionsMobile.bResult=true;


		}
		
		catch(Exception e)
		{
			Log.info("Selection Text failed"+e.getMessage());
			ActionsWeb.bResult=false;
  		    ActionsMobile.bResult=false;

		}
	}
	
	public static void clearText(String sLocators)
	{
		try
		{      
			Log.info("Waiting for few Seconds");
			WebDriverWait wait = new WebDriverWait(driver, 30);
		
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sLocators)));
		 
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sLocators)));
		
			Log.info("Clearing the Text");
            driver.findElement(By.xpath(sLocators)).clear();
    		ActionsWeb.bResult=true;
  		    ActionsMobile.bResult=true;
		}
		
		catch(Exception e)
		{
			Log.info("Clearing of Text failed"+e.getMessage());
			ActionsWeb.bResult=false;
  		    ActionsMobile.bResult=false;
		}
	}
	
	
	
	public static void keyboardEnter(String sLocators)
	{
		try
		{
			Log.info("Pressing Enter button on Keyboard");
            driver.findElement(By.xpath(sLocators)).sendKeys(Keys.RETURN);
    		ActionsWeb.bResult=true;
  		    ActionsMobile.bResult=true;
		}
		
		catch(Exception e)
		{
			Log.info("Falied to press Enter button"+e.getMessage());
			ActionsWeb.bResult=false;
  		    ActionsMobile.bResult=false;

		}							
	}

	public static void keyboardTab(String sLocators)
	{
		try
		{
			Log.info("Pressing Tab button on Keyboard");
            driver.findElement(By.xpath(sLocators)).sendKeys(Keys.TAB);
    		ActionsWeb.bResult=true;
  		    ActionsMobile.bResult=true;


		}
		
		catch(Exception e)
		{
			Log.info("Falied to press Tab button"+e.getMessage());
			ActionsWeb.bResult=false;
  		    ActionsMobile.bResult=false;

		}							
	}

	public static void keyboardPageUp(String sLocators)
	{
		try
		{
			Log.info("Pressing PageUp button on Keyboard");
            driver.findElement(By.xpath(sLocators)).sendKeys(Keys.PAGE_UP);
    		ActionsWeb.bResult=true;
  		    ActionsMobile.bResult=true;


		}
		
		catch(Exception e)
		{
			Log.info("Falied to press PageUp button"+e.getMessage());
			ActionsWeb.bResult=false;
  		    ActionsMobile.bResult=false;

		}							
	}
	
	public static void keyboardPageDown(String sLocators)
	{
		try
		{
			Log.info("Pressing PageDown button on Keyboard");
            driver.findElement(By.xpath(sLocators)).sendKeys(Keys.PAGE_DOWN);
    		ActionsWeb.bResult=true;
  		    ActionsMobile.bResult=true;


		}
		
		catch(Exception e)
		{
			Log.info("Falied to press PageDown button"+e.getMessage());
			ActionsWeb.bResult=false;
  		    ActionsMobile.bResult=false;

		}							
	}
	
	
	
	//Mobile Specific Actions
	public static void tap(String sLocators, String sValue)
	{
		try
		{
			
			String sValue1[];
			
			Log.info("Spliting the sValue into number of fingers and seconds");
			sValue1=sValue.split(",",2);
			
			Log.info("Finding an element to be tapped");
			WebElement element = driver.findElement(By.xpath(sLocators));
			
			Log.info("Converting the number of fingers from string to integer");
			int numberOfFingers=Integer.parseInt(sValue1[0]);
			
			Log.info("Converting the seconds from string to integer");
			int seconds=Integer.parseInt(sValue1[1]);
			
			Log.info("Tapping on an Element");

			((AppiumDriver) driver).tap(numberOfFingers, element,seconds);
			
  		    ActionsMobile.bResult=true;

							
		}
		
		catch(Exception e)
		{
			Log.info("Falied to tap on an element on Mobile"+e.getMessage());
  		    ActionsMobile.bResult=false;
		}
	}
	
	public static void longPress(String sLocators)
	{
		try
		{
			Log.info("Creating an Object of Touch Action");
			TouchAction action = new TouchAction((MobileDriver)driver);
			
			Log.info("Finding an element to Long Press");
			WebElement element = driver.findElement(By.xpath(sLocators));
			
			Log.info("Long pressing on an Element");
			action.longPress(element);
			
  		    ActionsMobile.bResult=true;
			
		}
		
		catch(Exception e)
		{
			Log.info("Falied to Long press on an element on Mobile"+e.getMessage());
  		    ActionsMobile.bResult=false;
		}
	}
	
	public static void press(String sLocators)
	{
		try
		{
			Log.info("Creating an Object of Touch Action");
			TouchAction action = new TouchAction((MobileDriver)driver);
			
			Log.info("Finding an element to  Press");
			WebElement element = driver.findElement(By.xpath(sLocators));
			
			Log.info("Pressing on an Element");
			action.press(element);
			
  		    ActionsMobile.bResult=true;

			
		}
		
		catch(Exception e)
		{
			Log.info("Falied to  press on an element on Mobile"+e.getMessage());
  		    ActionsMobile.bResult=false;
		}
	}

	public static void swipeRight()
	{
		try
		{
			
			
			int screenWidth = driver.manage().window().getSize().getWidth();
			int screenHeight =driver.manage().window().getSize().getHeight();
			//Swipe Right
			int startx = screenWidth*8/9;
			int endx = screenWidth/9;
			int starty = screenHeight/2;
			int endy = screenHeight/2;
			((AppiumDriver) driver).swipe(startx, starty, endx, endy, 5000);

  		    ActionsMobile.bResult=true;

		}
		
		catch(Exception e)
		{
			Log.info("Falied to  swipe on Mobile"+e.getMessage());
  		    ActionsMobile.bResult=false;
		}
	}
	
	public static void swipeLeft()
	{
		try
		{			
			
			int screenWidth = driver.manage().window().getSize().getWidth();
			int screenHeight =
			driver.manage().window().getSize().getHeight();
			//Swipe Left
			int startx = screenWidth/9;
			int endx = screenWidth*8/9;
			int starty = screenHeight/2;
			int endy = screenHeight/2;
			((AppiumDriver) driver).swipe(startx, starty, endx, endy, 5000);


  		    ActionsMobile.bResult=true;

		}
		
		catch(Exception e)
		{
			Log.info("Falied to  swipe on Mobile"+e.getMessage());
  		    ActionsMobile.bResult=false;
		}
	}
	
	public static void scrollTo(String sValue)
	{
		try
		{
			Log.info("Scroll to a particular text");
			///((AppiumDriver) driver).scrollTo(sValue);
  		    ActionsMobile.bResult=true;

		}
		
		catch(Exception e)
		{
			Log.info("Falied to  scrollTo a particular text on Mobile"+e.getMessage());
  		    ActionsMobile.bResult=false;
		}
	}
	

	
	public static void loginCode(String sLocators, String sValue)
	{
		try
	{
	    int i=0;
		String sValue1[];

		Log.info("Getting the elements of login code");
		List<WebElement> codes = driver.findElements(By.xpath(sLocators));
		
		Log.info("Spliting the sValue");
		sValue1=sValue.split(",",4);
		
		List<Integer> codevalues =new ArrayList<Integer>();
		
		
		for(int j=0;j<=3;j++)
		{
		
			codevalues.add(Integer.parseInt(sValue1[j]));
		}
		
		for(WebElement code: codes)
		{

		    code.sendKeys(Integer.toString(codevalues.get(i)));
			i++;
			
		}
		
		
	}
	catch(Exception e)
	{
		Log.info("Falied getting the elements of login code"+e.getMessage());
		    ActionsMobile.bResult=false;
	}
		
	}
	
	public static void passCode(String sLocators, String sValue)
	{
		try
	{
	    int k=0;
		String sValue2[];

		Log.info("Getting the elements of pass code");
		List<WebElement> codes1 = driver.findElements(By.xpath(sLocators));
		
		Log.info("Spliting the sValue of passcode");
		sValue2=sValue.split(",",5);
		
		List<Integer> codevalues1 =new ArrayList<Integer>();
		
		
		for(int l=0;l<=4;l++)
		{
		
			Log.info("Adding the values in codevalues1");
			codevalues1.add(Integer.parseInt(sValue2[l]));
		}
		
		for(WebElement code1: codes1)
		{

			
		
			Log.info("Sending the keys to the text field");
		    code1.sendKeys(Integer.toString(codevalues1.get(k)));
			k++;
			
		}
		
		codevalues1.clear();
		
	}
	catch(Exception e)
	{
		Log.info("Failsed Getting the elements of pass code"+e.getMessage());
		    ActionsMobile.bResult=false;
	}
		
	}
	
	
	public static void dynamicMethodQm(String sLocators, String sValue) throws Exception
	{
		try
		{
		
		String sLocator1[];
		sLocator1=sLocators.split(",",2);

		String sValue1[];
		sValue1=sValue.split(",",2);
		
		WebDriverWait wait = new WebDriverWait(driver,60);
		try
		{

	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.LinearLayout[@text='']")));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.LinearLayout[@text='']")));

		List<WebElement> linearlayouts =driver.findElements(By.xpath("//android.widget.LinearLayout[@text='']"));
		int linearSize=linearlayouts.size();
		
		
		for(int i=1;i<=linearSize;i++)
		{
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ListView[@index=0]//android.widget.LinearLayout[@index="+i+"]//android.view.View[@index=0]//android.view.View[@index=0]//android.view.View[@index=1]//android.view.View[@index=0]//android.widget.TextView[@index=0]")));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ListView[@index=0]//android.widget.LinearLayout[@index="+i+"]//android.view.View[@index=0]//android.view.View[@index=0]//android.view.View[@index=1]//android.view.View[@index=0]//android.widget.TextView[@index=0]")));
			WebElement view4=driver.findElement(By.xpath("//android.widget.ListView[@index=0]//android.widget.LinearLayout[@index="+i+"]//android.view.View[@index=0]//android.view.View[@index=0]//android.view.View[@index=1]//android.view.View[@index=0]//android.widget.TextView[@index=0]"));
            System.out.println(view4.getText());
			if(view4.getText().equals(sValue1[1]))
			{
				assert_Text("//android.widget.ListView[@index=0]//android.widget.LinearLayout[@index="+i+"]//android.view.View[@index=0]//android.view.View[@index=0]//android.view.View[@index=2]"+sLocator1[0], sValue1[0]);
				assert_Text("//android.widget.ListView[@index=0]//android.widget.LinearLayout[@index="+i+"]//android.view.View[@index=0]//android.view.View[@index=0]//android.view.View[@index=1]//android.view.View[@index=0]"+sLocator1[1], sValue1[1]);
				click("//android.widget.ListView[@index=0]//android.widget.LinearLayout[@index="+i+"]//android.view.View[@index=0]//android.view.View[@index=0]//android.view.View[@index=2]"+sLocator1[0]);
				ActionsWeb.bResult=true;
	  		    ActionsMobile.bResult=true;
				break;		
			}
			
			
			
		}	
		}
		catch(Exception e)
		{
			Log.info("Failed to find the dynamic element without swiping "+e.getMessage());
			
		}
		
		try
		{
		int screenHeight = driver.manage().window().getSize().getHeight();
		
		int screenWidth = driver.manage().window().getSize().getWidth();
		
		int startX=screenWidth/2;
		int startY=screenHeight*6/7;
		int endX=screenWidth/2;
		int endY=screenHeight/7;
		
		((AppiumDriver) driver).swipe(startX,startY,endX,endY,5000);
		
		List<WebElement> linearlayout =driver.findElements(By.xpath("//android.widget.LinearLayout[@text='']"));
		int linearSize1=linearlayout.size();
		
		
		for(int i=1;i<=linearSize1;i++)
		{
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ListView[@index=0]//android.widget.LinearLayout[@index="+i+"]//android.view.View[@index=0]//android.view.View[@index=0]//android.view.View[@index=1]//android.view.View[@index=0]//android.widget.TextView[@index=0]")));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ListView[@index=0]//android.widget.LinearLayout[@index="+i+"]//android.view.View[@index=0]//android.view.View[@index=0]//android.view.View[@index=1]//android.view.View[@index=0]//android.widget.TextView[@index=0]")));	
				
			WebElement view4=driver.findElement(By.xpath("//android.widget.ListView[@index=0]//android.widget.LinearLayout[@index="+i+"]//android.view.View[@index=0]//android.view.View[@index=0]//android.view.View[@index=1]//android.view.View[@index=0]//android.widget.TextView[@index=0]"));

            System.out.println(view4.getText());

			if(view4.getText().equals(sValue1[1]))
			{
				assert_Text("//android.widget.ListView[@index=0]//android.widget.LinearLayout[@index="+i+"]//android.view.View[@index=0]//android.view.View[@index=0]//android.view.View[@index=2]"+sLocator1[0], sValue1[0]);
				assert_Text("//android.widget.ListView[@index=0]//android.widget.LinearLayout[@index="+i+"]//android.view.View[@index=0]//android.view.View[@index=0]//android.view.View[@index=1]//android.view.View[@index=0]"+sLocator1[1], sValue1[1]);
				click("//android.widget.ListView[@index=0]//android.widget.LinearLayout[@index="+i+"]//android.view.View[@index=0]//android.view.View[@index=0]//android.view.View[@index=2]"+sLocator1[0]);
				ActionsWeb.bResult=true;
	  		    ActionsMobile.bResult=true;
				break;		
			}
		}
		}
		
		catch(Exception e)
		{
			Log.info("Failed to find the dynamic element with swiping too "+e.getMessage());
			
		}
		
		
		}
		catch(Exception e)
		{
			Log.info("Failed to find the dynamic element "+e.getMessage());
			ActionsWeb.bResult=false;
  		    ActionsMobile.bResult=false;
		}
	
	
		}
	
	public static void BackMenuButtonClickQm(String sLocators)
	{
		WebDriverWait wait=new WebDriverWait(driver,250);
		try
		{
		try
		{
			Log.info("Click on Back or Menu Button");
			if(sLocators.equals("//android.widget.ImageButton[@index=0]"))
			{
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageButton[@index=0]")));			
				driver.findElement(By.xpath(sLocators)).click();
				Log.info("Successfully clicked on Menu or Back button");
				ActionsWeb.bResult=true;
	  		    ActionsMobile.bResult=true;
			}
			
				

			
		}
		catch(Exception e)
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index=0]")));
			Log.info("Click on Back or Menu Button");
			driver.findElement(By.xpath("//android.widget.ImageView[@index=0]")).click();
			Log.info("Successfully clicked on Menu or Back button");
			ActionsWeb.bResult=true;
  		    ActionsMobile.bResult=true;
			
		}
		}
		catch(Exception e)
		{
			Log.info("Failed to click on Menu or Back button "+e.getMessage());
			
			ActionsWeb.bResult=false;
  		    ActionsMobile.bResult=false;
			
		}
	}
	
	public static void mobileBackButton()
	{
		
		try
		{
			Log.info("Click on Back or Menu Button");
			
			((AndroidDriver) driver).pressKeyCode(4);
			
  		    ActionsMobile.bResult=true;

		}
		catch(Exception e)
		{
			Log.info("Failed to Click on Back  Button");
			
  		    ActionsMobile.bResult=false;
			
		}
		}
	

	
	
	public static void hideKeyboard()
	{
		try
		{
			Log.info("Hiding the keyboard");
			((AppiumDriver) driver).hideKeyboard();
			ActionsWeb.bResult=true;
  		    ActionsMobile.bResult=true;


		
		}
		catch(Exception e)
		{
			Log.info("Failed to hide the Application "+e.getMessage());
			ActionsWeb.bResult=false;
  		    ActionsMobile.bResult=false;
		}
	}
	
	
	
	

	public static void closeApplication(String sLocators, String sValue, String sBrowserName)
	{
		try
		{
			Log.info("Closing the Application");
			driver.quit();
			StartAndStopAppium.stopAppiumServer();
			ActionsWeb.bResult=true;
  		    ActionsMobile.bResult=true;


		
		}
		catch(Exception e)
		{
			Log.info("Failed to close the Application "+e.getMessage());
			ActionsWeb.bResult=false;
  		    ActionsMobile.bResult=false;
		}

	}
	
	public static void closeEmulator()
	{
		try
		{
			Log.info("Closing the Emulator");
			Runtime rt = Runtime.getRuntime();
			rt.exec("taskkill.exe /F /IM player.exe");
			ActionsWeb.bResult=true;
  		    ActionsMobile.bResult=true;


		
		}
		catch(Exception e)
		{
			Log.info("Failed to close the Emulator "+e.getMessage());
			ActionsWeb.bResult=false;
  		    ActionsMobile.bResult=false;
		}

	}
	
	public static void closeEyes()
	{
		try
		{
			Log.info("Closing the eyes");
			eyes.close();
			ActionsWeb.bResult=true;
			ActionsMobile.bResult=true;
		}
		catch(Exception e)
		{
			Log.info("Failed to close the eyes"+e.getMessage());
			ActionsWeb.bResult=false;
			ActionsMobile.bResult=false;
		}
		finally
		{
			
			try 
			{
				Log.info("Aborting the eyes");
				eyes.abortIfNotClosed();
			} 
			catch (Exception e) 
			{
				Log.info("Failed to abort the eyes"+e.getMessage());
			}
		}
	}
	// *******************************************EXPERIMENT*******************************************
//	public static void StoreInVariableX()
//	{
//		try
//		{
//			Log.info("Storing value in variable");
//			//eyes.close();
//			
//			float value;
//			
//			
//			value = Element.getProperty(a, "text");
//			
//					
//			ActionsWeb.bResult=true;
//			ActionsMobile.bResult=true;
//		}
//		catch(Exception e)
//		{
//			Log.info("Failed to close the eyes"+e.getMessage());
//			ActionsWeb.bResult=false;
//			ActionsMobile.bResult=false;
//		}
//		finally
//		{
//			
//			try 
//			{
//				Log.info("Aborting the eyes");
//				eyes.abortIfNotClosed();
//			} 
//			catch (Exception e) 
//			{
//				Log.info("Failed to abort the eyes"+e.getMessage());
//			}
//		}
//	}
	// *******************************************EXPERIMENT*******************************************
	
	public static void execute_WaitPopup()
	{
		
		frame1.setUndecorated(true);
		frame1.setForeground(Color.BLACK);
		frame1.setBackground(Color.BLACK);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setBounds(0, 0, 240, 120);
		frame1.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setOpaque(false);
		contentPane.setLayout(null);
		frame1.setContentPane(contentPane);
		
		Label lblPleaseWaitTill = new Label("    Please wait till browser is up..");
		lblPleaseWaitTill.setForeground(Color.WHITE);
		lblPleaseWaitTill.setBackground(Color.BLACK);
		lblPleaseWaitTill.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPleaseWaitTill.setBounds(0, 0, 240, 120);
		contentPane.add(lblPleaseWaitTill);
		frame1.setVisible(true);
	}

}
