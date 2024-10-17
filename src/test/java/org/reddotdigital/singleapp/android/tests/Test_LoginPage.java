package org.reddotdigital.singleapp.android.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.reddotdigital.singleapp.testUtils.AndroidBaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test_LoginPage extends AndroidBaseTest {

	@Test(dataProvider = "getData", groups = { "Regression" })
	public void LoginTest(HashMap<String, String> input) throws InterruptedException {
		loginPage.setMobileNumber(input.get("mobileNumber"));
		homePage = loginPage.setOTP(input.get("otp"));

		homePage.selectionOffer(input.get("offerPopup"));
		homePage.selectionUpdate(input.get("updatePopup"));
		String profileName = homePage.getProfileNameText();
		Assert.assertEquals(profileName, input.get("assertProfileName"));

	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")
				+ "//src//test//java//org//reddotdigital//singleapp//testData//dataSingleApp.json");

		return new Object[][] { { data.get(0) } };
	}

}
