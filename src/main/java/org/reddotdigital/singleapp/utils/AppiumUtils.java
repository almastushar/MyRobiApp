package org.reddotdigital.singleapp.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.reddotdigital.singleapp.pageObjects.android.HomePage;
import org.reddotdigital.singleapp.pageObjects.android.LoginPage;
import org.reddotdigital.singleapp.pageObjects.ios.IOS_HomePage;
import org.reddotdigital.singleapp.pageObjects.ios.IOS_LoginPage;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public abstract class AppiumUtils {
	//public AndroidDriver driver;
	public LoginPage loginPage;
	public HomePage homePage;
	
	public IOS_LoginPage ios_loginPage;
	public IOS_HomePage ios_homePage;

	public AppiumDriverLocalService service;
	public Properties prop;
	public FileInputStream fs;

	public Double getFormattedAmount(String amount) {
		Double price = Double.parseDouble(amount.substring(1));
		return price;

	}

	public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {
		String jsonContent = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);

		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});

		return data;

	}

	public AppiumDriverLocalService startAppiumServer(String ipAddress, int port) throws IOException {
		prop = new Properties();
		//fs = new FileInputStream(System.getProperty("user.dir")
				//+ "//src//main//java//org//reddotdigital//singleapp//resources//data.properties");
		fs = new FileInputStream(System.getProperty("user.dir")
				+ "//src//main//java//org//reddotdigital//singleapp//resources//data.properties");
		prop.load(fs);
		service = new AppiumServiceBuilder().withAppiumJS(new File(prop.getProperty("AppiumNodeJsPath")))
				.withIPAddress(ipAddress).usingPort(port).build();
		service.start();
		return service;
	}

	public void waitForElementToAppear(WebElement ele, AppiumDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains((ele), "text", "Cart"));
	}

	public String getScreenshotPath(String testCaseName, AppiumDriver driver) throws IOException {
		File source = driver.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "//screenshots//reports" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;

	}

	public void Login(HashMap<String, String> input) throws InterruptedException {
		loginPage.setMobileNumber(input.get("mobileNumber"));
		homePage = loginPage.setOTP(input.get("otp"));

		homePage.selectionOffer(input.get("offerPopup"));
		homePage.selectionUpdate(input.get("updatePopup"));
		homePage.getProfileNameText();

	}
	
	public void IOS_Login(HashMap<String, String> input) throws InterruptedException {
		ios_loginPage.setMobileNumber(input.get("mobileNumber"));
		ios_homePage = ios_loginPage.setOTP(input.get("otp"));

		ios_homePage.getMobileNumText();

	}

}
