package stepdefinitions;

import Pages.IDNowMobilePage;
import base.BaseUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IDNowMobileSteps {

    private BaseUtil base;

    IDNowMobilePage idNowMobilePage;

    public IDNowMobileSteps(BaseUtil base)  {
        this.base = base;
        idNowMobilePage = new IDNowMobilePage(BaseUtil.iosDriver,BaseUtil.androidDriver);
    }

    @Given("I Validate that the home screen is displayed with ident edit box and start button")
    public void iValidateThatTheHomeScreenIsDisplayedEditBoxAndStartButton() {
        idNowMobilePage.verifyTheHomeScreenIsDisplayed();
    }

    @Given("I enter the ID {string} and select the start button")
    public void iEnterTheID(String id) {
        idNowMobilePage.enterIDAndSelectStartButton(id);
    }


    @And("I validate the terms and conditions screen is displayed")
    public void iValidateTheTermsAndConditionsScreenIsDisplayed() {
        idNowMobilePage.validateTheTermsAndConditionScreen();
    }

    @And("I click on close icon on top left corner")
    public void iClickOnCloseIconOnTopLeftCorner() {
        idNowMobilePage.clickOnCloseButton();
    }

    @And("I validate the options with the reasons are displayed")
    public void iValidateTheOptionsWithTheReasonsAreDisplayed() {
        idNowMobilePage.verifyAllQuitReasonsAreDisplayed();
    }

    @When("I select one quit reason and select quit session")
    public void iSelectOneQuitReasonAndSelectQuitSession() {
        idNowMobilePage.selectOneQuitReason();
    }

    @Then("I validate the intermediate screen displayed before the app redirects to the home screen")
    public void iValidateTheIntermediateScreenDisplayedBeforeTheAppRedirectsToTheHomeScreen() {
        idNowMobilePage.verifyIntermediateScreenIsDisplayed();
    }
}
