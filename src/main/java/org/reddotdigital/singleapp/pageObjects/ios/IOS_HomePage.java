package org.reddotdigital.singleapp.pageObjects.ios;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.reddotdigital.singleapp.utils.IOSActions;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class IOS_HomePage extends IOSActions {

	IOSDriver driver;

    public IOS_HomePage(IOSDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(iOSNsPredicate = "name == '8801849010634'")
    WebElement profileNumText;

//    @AndroidFindBy(id = "net.omobio.robisc:id/btn_view_more")
//    WebElement btnViewMore;
//
//    @AndroidFindBy(id = "net.omobio.robisc:id/tvMainBalanceAmount")
//    WebElement mainBalanceText;


//    public void selectionOffer(String selection) {
//        try {
//            if (btnCancelOffer.isDisplayed()) {
//                if (selection.equals("Cancel")) {
//                    btnCancelOffer.click();
//                } else if (selection.equals("Get Offer")) {
//                    btnGetOffer.click();
//                }
//            }
//
//        } catch (Exception e) {
//            // TODO: handle exception
//
//        }
//
//    }
//
//    public void selectionUpdate(String selection) {
//        try {
//            if (btnCancelUpdate.isDisplayed()) {
//                if (selection.equals("Later")) {
//                    btnCancelUpdate.click();
//                } else if (selection.equals("Update Now")) {
//                    btnUpdateNow.click();
//                }
//            }
//
//        } catch (Exception e) {
//            // TODO: handle exception
//
//        }
//
//    }

    public String getMobileNumText() {
        return profileNumText.getText();

    }

//    public IOS_QuickLinksPage expandViewMoreQuickLinks() {
//        btnViewMore.click();
//        return new IOS_QuickLinksPage(driver);
//    }

//    public String getMainBalanceText() {
//        return mainBalanceText.getText();
//
//    }
}
