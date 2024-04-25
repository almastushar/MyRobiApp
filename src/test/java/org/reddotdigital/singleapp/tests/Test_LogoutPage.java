package org.reddotdigital.singleapp.tests;

import org.reddotdigital.singleapp.pageObjects.android.LogoutPage;
import org.reddotdigital.singleapp.testUtils.AndroidBaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Test_LogoutPage extends AndroidBaseTest {

    @Test(dataProvider = "getData", groups = {"Regression"})
    public void logoutTest(HashMap<String, String> input) throws InterruptedException {
        Login(input);
        LogoutPage logout = new LogoutPage(driver);
        Thread.sleep(2000);
        logout.clickNavBtn("More");
        logout.clickSignOut();
        logout.giveRating();
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")
                + "//src//test//java//org//reddotdigital//singleapp//testData//dataSingleApp.json");

        return new Object[][]{{data.get(0)}};
    }
}
