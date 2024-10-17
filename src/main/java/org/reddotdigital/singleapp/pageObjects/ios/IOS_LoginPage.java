package org.reddotdigital.singleapp.pageObjects.ios;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.reddotdigital.singleapp.utils.IOSActions;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class IOS_LoginPage extends IOSActions {

	IOSDriver driver;

	public IOS_LoginPage(IOSDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == '   English'`]")
	WebElement LangEng;

	@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField'")
	WebElement mobInputField;

	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == 'Send OTP'`]")
	WebElement btnOTPRequest;

	@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND index == 0")
	WebElement otpInputField1;

	@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND index == 1")
	WebElement otpInputField2;

	@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND index == 2")
	WebElement otpInputField3;

	@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND index == 3")
	WebElement otpInputField4;

	@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND index == 4")
	WebElement otpInputField5;

	@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND index == 5")
	WebElement otpInputField6;

	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == 'Verify number'`]")
	WebElement btnContinueLogin;
	
	public void selectLanguage(String lang) {
		if(lang.equals("English"))
		{
			LangEng.click();
		}
		else
		{
			LangEng.click();
		}
	}

	public void setMobileNumber(String mobileNumber) {
		mobInputField.click();
		mobInputField.sendKeys(mobileNumber);
		btnOTPRequest.click();
	}

	public IOS_HomePage setOTP(String otp) throws InterruptedException {
		char[] arrOTP = new char[otp.length()];
		for (int i = 0; i < otp.length(); i++) {
			arrOTP[i] = otp.charAt(i);
		}

		otpInputField1.sendKeys(String.valueOf(arrOTP[0]));
		otpInputField2.sendKeys(String.valueOf(arrOTP[1]));
		otpInputField3.sendKeys(String.valueOf(arrOTP[2]));
		otpInputField4.sendKeys(String.valueOf(arrOTP[3]));
		otpInputField5.sendKeys(String.valueOf(arrOTP[4]));
		otpInputField6.sendKeys(String.valueOf(arrOTP[5]));
		btnContinueLogin.click();
		Thread.sleep(2000);
		return new IOS_HomePage(driver);
	}

}
