package base;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BaseApi {
    public Response getRequest(String endpoint) {
        return RestAssured
                .given()
                .when()
                .get(endpoint);
    }

    public Response postRequest(String endpoint, Object body) {
        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post(endpoint);
    }

    public Response putRequest(String endpoint, Object body) {
        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .put(endpoint);
    }

    protected Response deleteRequest(String endpoint) {
        return RestAssured
                .given()
                .when()
                .delete(endpoint);
    }

}
