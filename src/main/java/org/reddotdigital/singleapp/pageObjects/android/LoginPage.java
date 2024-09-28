package org.reddotdigital.singleapp.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.reddotdigital.singleapp.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends AndroidActions {

	AndroidDriver driver;

	public LoginPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "net.omobio.robisc:id/edit_text")
	WebElement mobInputField;

	@AndroidFindBy(id = "net.omobio.robisc:id/buttonSendOtp")
	WebElement btnOTPRequest;

	@AndroidFindBy(id = "net.omobio.robisc:id/code1")
	WebElement otpInputField1;

	@AndroidFindBy(id = "net.omobio.robisc:id/code2")
	WebElement otpInputField2;

	@AndroidFindBy(id = "net.omobio.robisc:id/code3")
	WebElement otpInputField3;

	@AndroidFindBy(id = "net.omobio.robisc:id/code4")
	WebElement otpInputField4;

	@AndroidFindBy(id = "net.omobio.robisc:id/code5")
	WebElement otpInputField5;

	@AndroidFindBy(id = "net.omobio.robisc:id/code6")
	WebElement otpInputField6;

	@AndroidFindBy(id = "net.omobio.robisc:id/buttonVerifyOtp")
	WebElement btnContinueLogin;

	public void setMobileNumber(String mobileNumber) {
		mobInputField.sendKeys(mobileNumber);
		btnOTPRequest.click();
	}

	public HomePage setOTP(String otp) throws InterruptedException {
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
		return new HomePage(driver);
	}

}
