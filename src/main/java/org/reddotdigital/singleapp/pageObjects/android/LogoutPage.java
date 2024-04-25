package org.reddotdigital.singleapp.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.reddotdigital.singleapp.utils.AndroidActions;

import java.util.concurrent.TimeUnit;

public class LogoutPage extends AndroidActions {
    AndroidDriver driver;

    public LogoutPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='More']")
    WebElement moreButton;

    @AndroidFindBy(id = "net.omobio.robisc:id/buttonSignOut")
    WebElement SignOut;

    @AndroidFindBy(id = "net.omobio.robisc:id/buttonPositive")
    WebElement positiveSubmit;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.RelativeLayout[4]/android.widget.ImageView[2]")
    WebElement giveRating;

    @AndroidFindBy(id = "net.omobio.robisc:id/tieFeedback")
    WebElement giveFeedback;

    public void clickNavBtn(String navName) {
        driver.findElement(By.xpath("//android.widget.TextView[@text='" + navName + "']")).click();
    }

    public void clickSignOut() {
        scrollToText("Sign Out");
        SignOut.click();
    }

    public void giveRating() {
        try {
            if (giveRating.isDisplayed()) {
                giveRating.click();
                giveFeedback.sendKeys("Test Feedback");
                positiveSubmit.click();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
