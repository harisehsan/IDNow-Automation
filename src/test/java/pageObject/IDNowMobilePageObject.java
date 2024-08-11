package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IDNowMobilePageObject {

    @FindBy(xpath = "//XCUIElementTypeTextField[@value='Ident-ID']") public WebElement identID_txtBox_iOS;
    @FindBy(xpath = "<Replace with Android Element>") public WebElement identID_txtBox_android;

    @FindBy(name = "Start") public WebElement start_btn_iOS;

    @FindBy(name = "Terms & Conditions") public WebElement terms_and_condition_lbl_iOS;

    @FindBy(name = "Close") public WebElement term_and_condition_close_btn_iOS;

    @FindBy(name = "Quit session") public WebElement quit_session_btn_iOS;

    @FindBy(name = "Identification not completed") public WebElement identification_not_completed_lbl_iOS;


}
