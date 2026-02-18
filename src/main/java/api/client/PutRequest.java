package api.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PutRequest extends ApiClient {
    @Override
    public HttpResponse<String> send(RequestApi request) throws IOException, InterruptedException {
        System.out.println("PUT" + request.getUrl());
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(request.getUrl()))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(request.getBody()))
                .build();

        return client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
    }
}
