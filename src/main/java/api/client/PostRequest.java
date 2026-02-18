package api.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PostRequest extends ApiClient {
    @Override
    public HttpResponse<String> send(RequestApi request) throws IOException, InterruptedException {
        System.out.println("POST" + request.getUrl());
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(request.getUrl()))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(request.getBody()))
                .build();

        return client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
    }
}
