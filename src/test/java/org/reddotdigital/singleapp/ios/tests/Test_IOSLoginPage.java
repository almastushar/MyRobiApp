package org.reddotdigital.singleapp.ios.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.reddotdigital.singleapp.testUtils.IOSBaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test_IOSLoginPage extends IOSBaseTest {

	@Test(dataProvider = "getData", groups = { "Regression" })
	public void LoginTest(HashMap<String, String> input) throws InterruptedException {
		ios_loginPage.selectLanguage(input.get("EngLang"));
		ios_loginPage.setMobileNumber(input.get("mobileNumber"));
		ios_homePage = ios_loginPage.setOTP(input.get("otp"));

		String mobileNumber = ios_homePage.getMobileNumText();
		Assert.assertEquals(mobileNumber, input.get("assertMobileNum"));

	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")
				+ "//src//test//java//org//reddotdigital//singleapp//testData//dataSingleApp.json");

		return new Object[][] { { data.get(0) } };
	}

}
