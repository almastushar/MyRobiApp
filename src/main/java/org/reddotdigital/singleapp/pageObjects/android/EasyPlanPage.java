package org.reddotdigital.singleapp.pageObjects.android;

import java.text.DecimalFormat;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.reddotdigital.singleapp.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EasyPlanPage extends AndroidActions {

	AndroidDriver driver;

	public EasyPlanPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "net.omobio.robisc:id/btnCustomizePlan")
	WebElement btnCustomizeEasyPlan;
	
	@AndroidFindBy(xpath = "//android.widget.SeekBar[@text='300.0']")
	WebElement btnSwipeValidity;
	
	@AndroidFindBy(xpath = "//android.widget.SeekBar[@text='600.0']")
	WebElement btnSwipeInternet;
	
	@AndroidFindBy(xpath = "//android.widget.SeekBar[@text='800.0']")
	WebElement btnSwipeInternetLow;
	
	@AndroidFindBy(xpath = "//android.widget.SeekBar[@text='700.0']")
	WebElement btnSwipeMinutes;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='net.omobio.robisc:id/tv_item_value']")
	List<WebElement> validityText;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='net.omobio.robisc:id/tv_item_value']")
	List<WebElement> internetText;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='net.omobio.robisc:id/tv_item_value']")
	List<WebElement> minutesText;
	
	@AndroidFindBy(id = "net.omobio.robisc:id/tvPlanPriceAmount")
	WebElement totalPlanPriceText;
	
	@AndroidFindBy(id = "net.omobio.robisc:id/btnBuyNow")
	WebElement btnBuyPlan;
	
	@AndroidFindBy(id = "net.omobio.robisc:id/tv_phone_number")
	WebElement purchasingNumberText;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='net.omobio.robisc:id/tvItemValue']")
	List<WebElement> confirmValidityText;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='net.omobio.robisc:id/tvItemValue']")
	List<WebElement> confirmInternetText;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='net.omobio.robisc:id/tvItemValue']")
	List<WebElement> confirmMinutesText;
	
	@AndroidFindBy(id = "net.omobio.robisc:id/tv_total_payable_amount")
	WebElement totalPayableAmountText;
	
	@AndroidFindBy(id = "net.omobio.robisc:id/tv_available_balance_amount")
	WebElement availableBalanceText;
	
	@AndroidFindBy(id = "net.omobio.robisc:id/tv_remaining_balance_amount")
	WebElement remainingBalanceText;
	
	@AndroidFindBy(id = "net.omobio.robisc:id/btn_purchase")
	WebElement btnPurchase;
	
	@AndroidFindBy(id = "net.omobio.robisc:id/tv_congratulations")
	WebElement congratulationsText;
	
	@AndroidFindBy(id = "net.omobio.robisc:id/btn_check_balance")
	WebElement btnCheckBalance;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='net.omobio.robisc:id/tv_start_value']")
	List<WebElement> validitySwipeElement;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Internet']")
	WebElement internetSwipeElement;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Minutes']")
	WebElement minutesSwipeElement;
	
	@AndroidFindBy(id = "net.omobio.robisc:id/tv_title")
	WebElement pageTitleText;
	
	@AndroidFindBy(id = "net.omobio.robisc:id/buttonRecharge")
	WebElement btnRecharge;
	
	@AndroidFindBy(id = "net.omobio.robisc:id/btnCustomizePlan")
	WebElement btnProceedToGift;

	public void clickCustomizeEasyPlan() {
		btnCustomizeEasyPlan.click();
	}
	
	public void swipeValidity() throws InterruptedException {
		swipe(btnSwipeValidity, 100, 910);
		Thread.sleep(2000);
	}
	
	public void swipeInternet() throws InterruptedException {
		swipe(btnSwipeInternet, 160, 1200);
		Thread.sleep(2000);
	}
	
	public void swipeMinutes() throws InterruptedException {
		swipe(btnSwipeMinutes, 185, 1480);
		Thread.sleep(2000);
	}
	
	public void swipeValidityLow() throws InterruptedException {
		swipe(btnSwipeValidity, 970, 910);
		Thread.sleep(2000);
	}
	
	public void swipeInternetLow() throws InterruptedException {
		swipe(btnSwipeInternetLow, 980, 1200);
		Thread.sleep(2000);
	}
	
	public void swipeMinutesLow() throws InterruptedException {
		swipe(btnSwipeMinutes, 980, 1480);
		Thread.sleep(2000);
	}
	
	public String getValidityAmountText(){
		return validityText.get(0).getText();
	}
	
	public String getInternetAmountText() {
		return internetText.get(1).getText();
	}
	
	public String getMinutesAmountText() {
		return minutesText.get(2).getText();
	}
	
	public String getConfirmValidityAmountText(){
		return confirmValidityText.get(0).getText();
	}
	
	public String getConfirmInternetAmountText() {
		return confirmInternetText.get(1).getText();
	}
	
	public String getConfirmMinutesAmountText() {
		return confirmMinutesText.get(2).getText();
	}
	
	public String getTotalPlanPriceText() {
		return totalPlanPriceText.getText();
	}
	
	public Double getTotalPlanPrice() {
		Double planPriceAmount = Double.parseDouble(totalPlanPriceText.getText().substring(1));
		int temp = (int) Math.round(planPriceAmount);
		if(temp % 10 != 0)
		{
			int reminder = temp % 10;
			int needToAdd = 10-reminder;
			int planPrice = temp + needToAdd;
			return Double.valueOf(planPrice);
		}
		else {
			Double planPrice = Double.valueOf(temp);
			return planPrice;
		}
		
	}
	
	public void clickBtnBuyPlan() {
		btnBuyPlan.click();
	}
	
	public String getPurchasingNumberText() {
		return purchasingNumberText.getText();
	}
	
	public String getTotalPayableAmountText() {
		return totalPayableAmountText.getText();
	}
	
	public Double getTotalPayableAmount() {
		Double payableAmount = Double.parseDouble(totalPayableAmountText.getText().substring(1));
		return payableAmount;
	}
	
	public String getRemainingBalanceText() {
		return remainingBalanceText.getText();
	}
	
	public boolean getVerifyRemainingBalance() {
		DecimalFormat decfor = new DecimalFormat("0.00"); 
		Double payableAmount = Double.parseDouble(totalPayableAmountText.getText().substring(1));
		Double avaiableAmount = Double.parseDouble(availableBalanceText.getText().substring(1));
		Double remainingAmount = Double.parseDouble(remainingBalanceText.getText().substring(1));
		Double subtractionAmount = Double.parseDouble(decfor.format(avaiableAmount - payableAmount));
		if(Double.compare(subtractionAmount, remainingAmount) == 0)
		{
			return true;
		}else
		{
			return false;
		}
		
	}
	
	public boolean btnVerifyPurchase(String RePur, String ConPur) {
		Double payableAmount = Double.parseDouble(totalPayableAmountText.getText().substring(1));
		Double avaiableAmount = Double.parseDouble(availableBalanceText.getText().substring(1));
		if(payableAmount > avaiableAmount)
		{
			boolean RechargePur = btnPurchase.getText().equals(RePur);
			btnPurchase.click();
			return RechargePur;
		}
		else
		{
			return btnPurchase.getText().equals(ConPur);
		}
	}
	
	public String getPageTitleText() {
		return pageTitleText.getText();
	}
	
	public String getbtnRechargeText() {
		return btnRecharge.getText();
	}
	
	public void clickBtnProceedToGift() {
		btnProceedToGift.click();
	}

}
