package org.reddotdigital.singleapp.android.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.reddotdigital.singleapp.pageObjects.android.EasyPlanPage;
import org.reddotdigital.singleapp.pageObjects.android.QuickLinksPage;
import org.reddotdigital.singleapp.testUtils.AndroidBaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test_EasyPlan extends AndroidBaseTest {

	@Test(dataProvider = "getData", groups = { "Regression" })
	public void EasyPlanTest(HashMap<String, String> input) throws InterruptedException {
		Login(input);
		QuickLinksPage quickLinksPage = homePage.expandViewMoreQuickLinks();
		quickLinksPage.clickQuickLinksItems("EasyPlan");
		
		EasyPlanPage easyPlanPage = new EasyPlanPage(driver);
		easyPlanPage.clickCustomizeEasyPlan();
		easyPlanPage.swipeValidity();
		easyPlanPage.swipeInternet();
		easyPlanPage.swipeMinutes();
		
		String validityAmountText = easyPlanPage.getValidityAmountText();
		String internetAmountText = easyPlanPage.getInternetAmountText();
		String minutesAmountText = easyPlanPage.getMinutesAmountText();
		String totalPlanPriceText = easyPlanPage.getTotalPlanPriceText();
		easyPlanPage.clickBtnBuyPlan();
		
		String confirmValidityAmountText = easyPlanPage.getConfirmValidityAmountText();
		String confirmInternetAmountText = easyPlanPage.getConfirmInternetAmountText();
		String confirmMinutesAmountText = easyPlanPage.getConfirmMinutesAmountText();
		String purchasingNumberText = easyPlanPage.getPurchasingNumberText();
		String totalPayableAmountText = easyPlanPage.getTotalPayableAmountText();
		
		Assert.assertEquals(purchasingNumberText, input.get("mobileNumber"));
		Assert.assertEquals(validityAmountText, confirmValidityAmountText);
		Assert.assertEquals(internetAmountText, confirmInternetAmountText);
		Assert.assertEquals(minutesAmountText, confirmMinutesAmountText);
		Assert.assertEquals(totalPlanPriceText, totalPayableAmountText);
		Assert.assertTrue(easyPlanPage.getVerifyRemainingBalance());
		Assert.assertTrue(easyPlanPage.btnVerifyPurchase("Recharge & Purchase", "Confirm Purchase"));

	}
	
	@Test(dataProvider = "getData", groups = { "Regression" })
	public void EasyPlanTestLowBalance(HashMap<String, String> input) throws InterruptedException {
		Login(input);
		QuickLinksPage quickLinksPage = homePage.expandViewMoreQuickLinks();
		quickLinksPage.clickQuickLinksItems("EasyPlan");
		
		EasyPlanPage easyPlanPage = new EasyPlanPage(driver);
		easyPlanPage.clickCustomizeEasyPlan();
		easyPlanPage.swipeValidityLow();
		easyPlanPage.swipeInternetLow();
		easyPlanPage.swipeMinutesLow();
		
		String validityAmountText = easyPlanPage.getValidityAmountText();
		String internetAmountText = easyPlanPage.getInternetAmountText();
		String minutesAmountText = easyPlanPage.getMinutesAmountText();
		String totalPlanPriceText = easyPlanPage.getTotalPlanPriceText();
		Double totalPlanPrice = easyPlanPage.getTotalPlanPrice();
		easyPlanPage.clickBtnBuyPlan();
		
		String confirmValidityAmountText = easyPlanPage.getConfirmValidityAmountText();
		String confirmInternetAmountText = easyPlanPage.getConfirmInternetAmountText();
		String confirmMinutesAmountText = easyPlanPage.getConfirmMinutesAmountText();
		String purchasingNumberText = easyPlanPage.getPurchasingNumberText();
		String totalPayableAmountText = easyPlanPage.getTotalPayableAmountText();
		
		Assert.assertEquals(purchasingNumberText, input.get("mobileNumber"));
		Assert.assertEquals(validityAmountText, confirmValidityAmountText);
		Assert.assertEquals(internetAmountText, confirmInternetAmountText);
		Assert.assertEquals(minutesAmountText, confirmMinutesAmountText);
		Assert.assertEquals(totalPlanPriceText, totalPayableAmountText);
		Assert.assertTrue(easyPlanPage.getVerifyRemainingBalance());
		Assert.assertTrue(easyPlanPage.btnVerifyPurchase("Recharge & Purchase", "Confirm Purchase"));
		
		Double totalPayableAmount = easyPlanPage.getTotalPayableAmount();
		String titleText = easyPlanPage.getPageTitleText();
		String btnRechargeText = easyPlanPage.getbtnRechargeText();
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
