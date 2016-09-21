package utility;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.io.IOException;

import executionEngine.MobileApplicationTest;
public class StartAndStopAppium 
{

	static AppiumDriverLocalService service; 
	private static String APPIUMSERVERSTART = MobileApplicationTest.sPlatformAppiumServerPath;
	static String path[] = APPIUMSERVERSTART.split(",", 3);
	private static String NODEJSPATH = path[0];
	private static String APPIUMJSPATH = path[1];
	private static String APPIUMLOGFILEPATH = path[2];

	

	public static void startAppiumServer() throws IOException, InterruptedException {

	service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File(NODEJSPATH)).withAppiumJS(new File(APPIUMJSPATH)).withLogFile(new File(APPIUMLOGFILEPATH)));
	
	service.start();
		

	System.out.println("Appium server started");

	}



	public static void stopAppiumServer() throws IOException {

	service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File(NODEJSPATH)).withAppiumJS(new File(APPIUMJSPATH)).withLogFile(new File(APPIUMLOGFILEPATH)));
		
	service.stop();

	System.out.println("Appium server stopped");

	}

}
