package api.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DeleteRequest extends ApiClient {
    @Override
    public HttpResponse<String> send(RequestApi request) throws IOException, InterruptedException {
        System.out.println("DELETE" + request.getUrl());
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(request.getUrl())).DELETE()
                .build();


        return client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
    }
}
