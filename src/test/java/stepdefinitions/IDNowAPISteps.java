package stepdefinitions;

import Pages.IDNowAPIPage;

import base.BaseApi;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
public class IDNowAPISteps {

    BaseApi baseApi;
    IDNowAPIPage idNowAPIPage;

    private Response response;

    public IDNowAPISteps()  {
        baseApi = new BaseApi();
        idNowAPIPage = new IDNowAPIPage();
    }

    @Given("I send a GET request to {string}")
    public void iSendAGETRequestTo(String url) {
        response = baseApi.getRequest(url);
    }

    @And("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int statusCode) {
        response.then().statusCode(statusCode);
    }


    @And("I ensure that the autoident has the browserSupportMatrix")
    public void iEnsureThatTheAutoidentHasTheBrowserSupportMatrix() {
        idNowAPIPage.isBrowserMatrixSupportPresent(response);
    }

    @And("I verify web considering the minimum version supported for Desktop")
    public void iVerifyWebConsideringTheMinimumVersionSupportedInEachOfThePlatforms() {
        idNowAPIPage.verifyTheMinimumSupportedVersionForDesktop();
    }

    @Then("I verify web considering the minimum version supported for Mobile")
    public void iVerifyWebConsideringTheMinimumVersionSupportedForMobile() {
        idNowAPIPage.verifyTheMinimumSupportedVersionForMobile();
    }
}
