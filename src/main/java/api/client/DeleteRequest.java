package api.client;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteRequest implements ApiClient {

    @Override
    public Response send(ApiRequest request, String url) {
        return given()
                .contentType("application/x-www-form-urlencoded")
                .formParams(request.getParams())
                .when()
                .delete(url)
                .then()
                .extract()
                .response();
    }
}
