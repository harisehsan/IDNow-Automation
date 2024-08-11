package stepdefinitions;

import base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.openqa.selenium.MutableCapabilities;

import java.net.URL;


public class Hooks extends BaseUtil {

    private String scenarioName;
    private BaseUtil base;


    public Hooks(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest(Scenario scenario) throws Exception {
        scenarioName = scenario.getName();
        if (scenarioName.contains("iOS")) {
            MutableCapabilities caps = new MutableCapabilities();
            caps.setCapability("platformName", "iOS");
            caps.setCapability("appium:app", "storage:filename=AutoIdent.ipa");
            caps.setCapability("appium:deviceName", "iPhone.*");
            caps.setCapability("appium:platformVersion", "17");
            caps.setCapability("appium:automationName", "XCUITest");
            MutableCapabilities sauceOptions = new MutableCapabilities();
            sauceOptions.setCapability("appiumVersion", "latest");
            sauceOptions.setCapability("username", "oauth-harisehsan213-879b4");
            sauceOptions.setCapability("accessKey", "e4720f14-0068-41bf-8e73-83b10a44cc17");
            sauceOptions.setCapability("build", "1");
            sauceOptions.setCapability("name", "IDnow iOS Test");
            caps.setCapability("sauce:options", sauceOptions);
            URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
            iosDriver = new IOSDriver(url, caps);
        }
       else if (scenarioName.contains("Android")) {
            MutableCapabilities caps = new MutableCapabilities();
            caps.setCapability("platformName", "Android");
            caps.setCapability("appium:app", "storage:filename=AutoIdent.apk");
            caps.setCapability("appium:deviceName", "Samsung.*");
            caps.setCapability("appium:automationName", "UiAutomator2");
            MutableCapabilities sauceOptions = new MutableCapabilities();
            sauceOptions.setCapability("appiumVersion", "latest");
            sauceOptions.setCapability("username", "oauth-harisehsan213-879b4");
            sauceOptions.setCapability("accessKey", "e4720f14-0068-41bf-8e73-83b10a44cc17");
            sauceOptions.setCapability("build", "1");
            sauceOptions.setCapability("name", "IDNow Android  Test");
            caps.setCapability("sauce:options", sauceOptions);
            URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
            androidDriver = new AndroidDriver(url, caps);
        }

       else if (scenarioName.contains("API")) {
            RestAssured.requestSpecification = new RequestSpecBuilder()
                    .setBaseUri("https://api.test.idnow.de/api/")
                    .addFilter(new RequestLoggingFilter())
                    .addFilter(new ResponseLoggingFilter())
                    .setContentType(ContentType.JSON)
                    .build();
        }
    }

    @After
    public void TearDownTest(Scenario scenario) throws Exception {
        if (scenarioName.contains("iOS"))
            iosDriver.quit();
        else if (scenarioName.contains("Android"))
                androidDriver.quit();
    }
}