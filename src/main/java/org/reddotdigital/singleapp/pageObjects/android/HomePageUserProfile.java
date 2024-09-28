package org.reddotdigital.singleapp.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HomePageUserProfile {
    AndroidDriver driver;

    public HomePageUserProfile(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "net.omobio.robisc:id/tv_profile_name")
    WebElement userName;

    @AndroidFindBy(id = "net.omobio.robisc:id/tv_mobile_number")
    WebElement userNumber;

    @AndroidFindBy(id = "net.omobio.robisc:id/ivProfileImage")
    WebElement profileImage;

    @AndroidFindBy(id = "net.omobio.robisc:id/button_edit_name")
    WebElement editName;

    @AndroidFindBy(id = "net.omobio.robisc:id/edit_text")
    WebElement giveUserName;

    @AndroidFindBy(id = "net.omobio.robisc:id/buttonPositive")
    WebElement saveUserName;

    @AndroidFindBy(id = "net.omobio.robisc:id/tv_email")
    WebElement giveEmail;

    @AndroidFindBy(id = "net.omobio.robisc:id/btnSaveChanges")
    WebElement saveChanges;

    public void homeScreenTest() throws InterruptedException {
        try {
            String UserName = userName.getText();
            String UserNumber = userNumber.getText();

            String[] variableNames = {
                    "UserName", "UserNumber"
            };

            Object[] values = {
                    UserName, UserNumber
            };

            for (int i = 0; i < variableNames.length; i++) {
                System.out.println(variableNames[i] + ": " + values[i]);
            }
            editUser();
        } catch (Exception e) {
            editUser();
        }
    }

    public void editUser() {
        profileImage.click();
        editName.click();

        giveUserName.sendKeys("QATest");
        saveUserName.click();

        giveEmail.sendKeys("qatestmail@gmail.com");
        saveChanges.click();
    }
}
