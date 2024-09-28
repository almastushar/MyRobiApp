package org.reddotdigital.singleapp.testUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.reddotdigital.singleapp.pageObjects.ios.IOS_LoginPage;
import org.reddotdigital.singleapp.utils.AppiumUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class IOSBaseTest extends AppiumUtils{

	public IOSDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass
	public void ConfigureAppium() throws IOException
	{

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+"/src/main/java/org/reddotdigital/singleapp/resources/data.properties");

		prop.load(fis);
		String ipAddress = prop.getProperty("ipAddress");
		String port = prop.getProperty("port");

		//service = startAppiumServer(ipAddress,Integer.parseInt(port));

		XCUITestOptions	options = new XCUITestOptions();	
		options.setDeviceName("iPhone 14 Pro");
		options.setApp(System.getProperty("user.dir")
				+ "/src/test/java/org/reddotdigital/singleapp/testResources/My Robi.app");
		options.setPlatformVersion("16.0");

		options.setCapability("autoAcceptAlerts", true);
		options.setWdaLaunchTimeout(Duration.ofSeconds(20));

		//driver = new IOSDriver(service.getUrl(), options);
		driver = new IOSDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ios_loginPage = new IOS_LoginPage(driver);

	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
		service.stop();
	}

}
