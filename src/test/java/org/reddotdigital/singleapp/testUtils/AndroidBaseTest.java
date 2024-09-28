package org.reddotdigital.singleapp.testUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.reddotdigital.singleapp.pageObjects.android.LoginPage;
import org.reddotdigital.singleapp.utils.AppiumUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AndroidBaseTest extends AppiumUtils {
	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	@BeforeMethod
	public void ConfigureAppium() throws IOException {

		prop = new Properties();
		//fs = new FileInputStream(System.getProperty("user.dir")
				//+ "//src//main//java//org//reddotdigital//singleapp//resources//data.properties");
		fs = new FileInputStream(System.getProperty("user.dir")
				+ "/src/main/java/org/reddotdigital/singleapp/resources/data.properties");
		String ipAddress = System.getProperty("ipAddress") != null ? System.getProperty("ipAddress")
				: prop.getProperty("ipAddress");
		prop.load(fs);
		String port = prop.getProperty("port");

		service = startAppiumServer(ipAddress, Integer.parseInt(port));

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(prop.getProperty("AndroidDeviceName"));
		options.setAppPackage(prop.getProperty("appPackage"));
		options.setAppActivity(prop.getProperty("appActivity"));
		options.setCapability("autoGrantPermissions", true);
		options.setCapability("isHeadless", true);

		//options.setApp(System.getProperty("user.dir")
				//+ "\\src\\test\\java\\org\\reddotdigital\\singleapp\\testResources\\my-robi-6.1.5_rc1.apk");
		options.setApp(System.getProperty("user.dir")
				+ "/src/test/java/org/reddotdigital/singleapp/testResources/my-robi.apk");

		driver = new AndroidDriver(service.getUrl(), options);
		driver = new AndroidDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		loginPage = new LoginPage(driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		service.stop();
	}

}
