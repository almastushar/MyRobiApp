package org.reddotdigital.singleapp.android.tests;

import org.reddotdigital.singleapp.pageObjects.android.HomePageUserProfile;
import org.reddotdigital.singleapp.testUtils.AndroidBaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Test_UserProfile extends AndroidBaseTest {
    @Test(dataProvider = "getData", groups = {"Regression"})
    public void homeScreenTest(HashMap<String, String> input) throws InterruptedException {
        Login(input);
        HomePageUserProfile homeScreen = new HomePageUserProfile(driver);
        homeScreen.homeScreenTest();
    }


    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")
                + "//src//test//java//org//reddotdigital//singleapp//testData//dataSingleApp.json");

        return new Object[][]{{data.get(0)}};
    }
}
