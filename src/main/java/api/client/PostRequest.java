package api.client;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostRequest implements ApiClient {

    @Override
    public Response send(ApiRequest request, String url) {
        return given()
                .contentType("application/x-www-form-urlencoded")
                .formParams(request.getParams())
                .when()
                .post(url)
                .then()
                .extract()
                .response();
    }
}
