package Pages;

import io.restassured.response.Response;
import org.testng.Assert;
import org.json.JSONObject;
import java.util.Map;



public class IDNowAPIPage  {

    JSONObject autoidentWebSettings;

    public void isBrowserMatrixSupportPresent(Response response) {
        JSONObject jsonResponse = new JSONObject(response.getBody().asString());
        autoidentWebSettings = jsonResponse.getJSONObject("settings").getJSONObject("idnow").getJSONObject("autoident").getJSONObject("web");
        Assert.assertTrue(autoidentWebSettings.has("browserSupportMatrix"),"The Browser support matrix is not present for the autoident");
    }

    public void verifyTheMinimumSupportedVersionForDesktop()
    {
        Map<String, Object> browserSupportMatrix = autoidentWebSettings.getJSONObject("browserSupportMatrix").toMap();
        String[] desktopPlatforms = {"default", "linux", "macintosh", "windows"};
        StringBuilder errorMessage = new StringBuilder();
        boolean testStatus = true;
        for (String platform : desktopPlatforms) {
            Map<String, Object> platformData = (Map<String, Object>) browserSupportMatrix.get("desktop");
            Assert.assertNotNull(platformData, "Missing desktop platform: " + platform);

            if (platformData.containsKey("chrome")) {
                int chromeMin = Integer.parseInt(((Map<String, String>) platformData.get("chrome")).get("min"));
                if (chromeMin < 75) {
                    testStatus = false;
                    errorMessage.append("Chrome version under 'desktop -> " + platform + "' is less than 75." + "\n");
                }
            }

            if (platformData.containsKey("safari")) {
                int safariMin = Integer.parseInt(((Map<String, String>) platformData.get("safari")).get("min"));
                if (safariMin < 11) {
                    testStatus = false;
                    errorMessage.append("Safari version under 'desktop -> " + platform + "' is less than 11."+"\n");
                }
            }

            if (platformData.containsKey("firefox")) {
                int firefoxMin = Integer.parseInt(((Map<String, String>) platformData.get("firefox")).get("min"));
                if (firefoxMin < 78) {
                    testStatus = false;
                    errorMessage.append("Firefox version under 'desktop -> " + platform + "' is less than 78."+"\n");
                }
            }

            if (platformData.containsKey("edge")) {
                int edgeMin = Integer.parseInt(((Map<String, String>) platformData.get("edge")).get("min"));
                if (edgeMin < 78) {
                    testStatus = false;
                    errorMessage.append("Edge version under 'desktop -> " + platform + "' is less than 80." + "\n");
                }
            }
        }
        Assert.assertTrue(testStatus,errorMessage.toString());
    }

    public void verifyTheMinimumSupportedVersionForMobile()
    {
        Map<String, Object> browserSupportMatrix = autoidentWebSettings.getJSONObject("browserSupportMatrix").toMap();
        String[] desktopPlatforms = {"default", "android", "macintosh", "ios"};
        StringBuilder errorMessage = new StringBuilder();
        boolean testStatus = true;
        for (String platform : desktopPlatforms) {
            Map<String, Object> platformData = (Map<String, Object>) browserSupportMatrix.get("desktop");
            Assert.assertNotNull(platformData, "Missing mobile platform: " + platform);

            if (platformData.containsKey("chrome")) {
                int chromeMin = Integer.parseInt(((Map<String, String>) platformData.get("chrome")).get("min"));
                if (chromeMin < 75) {
                    testStatus = false;
                    errorMessage.append("Chrome version under 'mobile -> " + platform + "' is less than 75." + "\n");
                }
            }

            if (platformData.containsKey("safari")) {
                int safariMin = Integer.parseInt(((Map<String, String>) platformData.get("safari")).get("min"));
                if (safariMin < 11) {
                    testStatus = false;
                    errorMessage.append("Safari version under 'mobile -> " + platform + "' is less than 11."+"\n");
                }
            }

            if (platformData.containsKey("firefox")) {
                int firefoxMin = Integer.parseInt(((Map<String, String>) platformData.get("firefox")).get("min"));
                if (firefoxMin < 78) {
                    testStatus = false;
                    errorMessage.append("Firefox version under 'mobile -> " + platform + "' is less than 78."+"\n");
                }
            }

            if (platformData.containsKey("samsung")) {
                int samsungMin = Integer.parseInt(((Map<String, String>) platformData.get("edge")).get("min"));
                if (samsungMin != -1) {
                    testStatus = false;
                    errorMessage.append("Not all minimum versions for '" + platform + " of mobile ' versions are acceptable" + "\n");
                }
            }
        }
        Assert.assertTrue(testStatus,errorMessage.toString());
    }
}