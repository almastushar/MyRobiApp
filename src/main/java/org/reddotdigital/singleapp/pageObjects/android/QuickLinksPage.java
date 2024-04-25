package org.reddotdigital.singleapp.pageObjects.android;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.reddotdigital.singleapp.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class QuickLinksPage extends AndroidActions {

    AndroidDriver driver;

	public QuickLinksPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "net.omobio.robisc:id/search_src_text")
	WebElement searchQuickLinks;
	
	@AndroidFindBy(id = "net.omobio.robisc:id/tvPageName")
	List<WebElement> searchQuickLinksResult;
	

	public void setSearchQuickLinks(String search) throws InterruptedException {
		searchQuickLinks.click();
		searchQuickLinks.sendKeys(search);
		Thread.sleep(2000);
	}
	
	public void clickSearchQuickLinksResult(int index, String resultText) {
		try {
			if(searchQuickLinksResult.get(index).getText().equals(resultText))
			{
				searchQuickLinksResult.get(index).click();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

    public void clickQuickLinksItems(String item) {
        driver.findElement(By.xpath("//android.widget.TextView[@text='" + item + "']")).click();
    }
}
