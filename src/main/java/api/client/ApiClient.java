package api.client;


import io.restassured.response.Response;

public interface ApiClient {
    Response send(ApiRequest request, String url);
}