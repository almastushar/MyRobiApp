package org.reddotdigital.singleapp.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.reddotdigital.singleapp.pageObjects.android.GiftPlanPage;
import org.reddotdigital.singleapp.pageObjects.android.QuickLinksPage;
import org.reddotdigital.singleapp.testUtils.AndroidBaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test_GiftPlan extends AndroidBaseTest {

	@Test(dataProvider = "getData", groups = { "Regression" })
	public void GiftPlanTest(HashMap<String, String> input) throws InterruptedException {
		Login(input);
		QuickLinksPage quickLinksPage = homePage.expandViewMoreQuickLinks();
		quickLinksPage.setSearchQuickLinks("gift");
		quickLinksPage.clickSearchQuickLinksResult(0, "gift plan");
		
		GiftPlanPage giftPlanPage = new GiftPlanPage(driver);
		giftPlanPage.clickBtnProceedToGift();
		giftPlanPage.swipeValidity();
		giftPlanPage.swipeInternet();
		giftPlanPage.swipeMinutes();
		
		String validityAmountText = giftPlanPage.getValidityAmountText();
		String internetAmountText = giftPlanPage.getInternetAmountText();
		String minutesAmountText = giftPlanPage.getMinutesAmountText();
		String totalPlanPriceText = giftPlanPage.getTotalPlanPriceText();
		Double totalPlanPrice = giftPlanPage.getTotalPlanPrice();
		giftPlanPage.clickBtnGiftPlan();
		
		String confirmValidityAmountText = giftPlanPage.getConfirmValidityAmountText();
		String confirmInternetAmountText = giftPlanPage.getConfirmInternetAmountText();
		String confirmMinutesAmountText = giftPlanPage.getConfirmMinutesAmountText();
		String totalPayableAmountText = giftPlanPage.getTotalPayableAmountText();
		Assert.assertEquals(validityAmountText, confirmValidityAmountText);
		Assert.assertEquals(internetAmountText, confirmInternetAmountText);
		Assert.assertEquals(minutesAmountText, confirmMinutesAmountText);
		Assert.assertEquals(totalPlanPriceText, totalPayableAmountText);
		Assert.assertTrue(giftPlanPage.getVerifyRemainingBalance());
		
		giftPlanPage.enterValidGiftNumber(input.get("mobileNumber"));
		giftPlanPage.clickBtnSendGift();
		
		String purchasingNumberText = giftPlanPage.getPurchasingNumberText();
		String titleText = giftPlanPage.getPageTitleText();
		String btnRechargeText = giftPlanPage.getbtnRechargeText();
		Double totalPayableAmount = giftPlanPage.getTotalPayableAmount();
		Assert.assertEquals(purchasingNumberText, input.get("mobileNumber"));
		Assert.assertEquals(totalPlanPrice, totalPayableAmount);
		Assert.assertEquals(titleText, "Make Payment");
		Assert.assertEquals(btnRechargeText, "Recharge");

	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")
				+ "//src//test//java//org//reddotdigital//singleapp//testData//dataSingleApp.json");

		return new Object[][] { { data.get(0) } };
	}

}
