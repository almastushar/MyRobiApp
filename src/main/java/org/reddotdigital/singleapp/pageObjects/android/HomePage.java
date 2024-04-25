package org.reddotdigital.singleapp.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.reddotdigital.singleapp.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends AndroidActions {

    AndroidDriver driver;

    public HomePage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    WebElement btnDenyLocation;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    WebElement btnDenyContact;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    WebElement btnDenyNotification;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    WebElement btnDenyPhoneNumber;

    @AndroidFindBy(id = "net.omobio.robisc:id/buttonClose")
    WebElement btnCancelOffer;

    @AndroidFindBy(id = "net.omobio.robisc:id/buttonAction")
    WebElement btnGetOffer;

    @AndroidFindBy(id = "net.omobio.robisc:id/buttonNegative")
    WebElement btnCancelUpdate;

    @AndroidFindBy(id = "net.omobio.robisc:id/buttonPositive")
    WebElement btnUpdateNow;

    @AndroidFindBy(id = "net.omobio.robisc:id/tv_profile_name")
    WebElement profileNameText;

    @AndroidFindBy(id = "net.omobio.robisc:id/btn_view_more")
    WebElement btnViewMore;

    @AndroidFindBy(id = "net.omobio.robisc:id/tvMainBalanceAmount")
    WebElement mainBalanceText;


    public void selectionOffer(String selection) {
        try {
            if (btnCancelOffer.isDisplayed()) {
                if (selection.equals("Cancel")) {
                    btnCancelOffer.click();
                } else if (selection.equals("Get Offer")) {
                    btnGetOffer.click();
                }
            }

        } catch (Exception e) {
            // TODO: handle exception

        }

    }

    public void selectionUpdate(String selection) {
        try {
            if (btnCancelUpdate.isDisplayed()) {
                if (selection.equals("Later")) {
                    btnCancelUpdate.click();
                } else if (selection.equals("Update Now")) {
                    btnUpdateNow.click();
                }
            }

        } catch (Exception e) {
            // TODO: handle exception

        }

    }

    public String getProfileNameText() {
        return profileNameText.getText();

    }

    public QuickLinksPage expandViewMoreQuickLinks() {
        btnViewMore.click();
        return new QuickLinksPage(driver);
    }

    public String getMainBalanceText() {
        return mainBalanceText.getText();

    }
}
