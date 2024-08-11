package Pages;

import base.BaseMobile;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObject.IDNowMobilePageObject;

import java.time.Duration;


public class IDNowMobilePage extends BaseMobile {
    IOSDriver iOSdriver;
    AndroidDriver androidDriver;
    IDNowMobilePageObject idNowMobilePageObject = new IDNowMobilePageObject();
    String[] quitReasons = {"I don’t have my document with me", "I have privacy concerns","The app is not responding and I cannot go further", "Not interested in the service for which this identification is required", "I will complete the identification later"};


    public IDNowMobilePage(IOSDriver iosDriver, AndroidDriver androidDriver) {
        if (iosDriver!=null) {
            this.iOSdriver = iosDriver;
            PageFactory.initElements(iosDriver, idNowMobilePageObject);
            iosDriver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        }
        else {
            this.androidDriver = androidDriver;
            PageFactory.initElements(androidDriver, idNowMobilePageObject);
            androidDriver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        }

    }

    public void verifyTheHomeScreenIsDisplayed()
    {
        Assert.assertTrue(idNowMobilePageObject.identID_txtBox_iOS.isDisplayed() && idNowMobilePageObject.start_btn_iOS.isDisplayed(),"The home screen is not displayed with an edit box for ident id and button labelled start ident");
    }

    public void enterIDAndSelectStartButton(String id)
    {
        idNowMobilePageObject.identID_txtBox_iOS.sendKeys(id);
        idNowMobilePageObject.start_btn_iOS.click();
    }

    public void validateTheTermsAndConditionScreen()
    {
        Assert.assertTrue(idNowMobilePageObject.terms_and_condition_lbl_iOS.isDisplayed(),"The terms and conditions screen is not displayed!");
    }

    public void clickOnCloseButton()
    {
        idNowMobilePageObject.term_and_condition_close_btn_iOS.click();
    }

    public void verifyAllQuitReasonsAreDisplayed()
    {
        String reasons = verifyAllNameElementsAreDisplayed(quitReasons);
        Assert.assertEquals(reasons, "" ,reasons+ " : This/These quit reason(s) is/are not displayed!");
    }

    public void selectOneQuitReason()
    {
        selectRandomNameElement(quitReasons).click();
        idNowMobilePageObject.quit_session_btn_iOS.click();
    }

    public void verifyIntermediateScreenIsDisplayed()
    {
        Assert.assertTrue(idNowMobilePageObject.identification_not_completed_lbl_iOS.isDisplayed(), "The Intermediate screen is not displayed!");
    }
}