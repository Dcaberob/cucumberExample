package api.client;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetRequest implements ApiClient {

    @Override
    public Response send(ApiRequest request, String url) {
        if (request.getParams() != null) {
            return given()
                    .queryParams(request.getParams())
                    .when()
                    .get(url)
                    .then()
                    .extract()
                    .response();
        } else {
            return given()
                    .when()
                    .get(url)
                    .then()
                    .extract()
                    .response();
        }
    }
}
