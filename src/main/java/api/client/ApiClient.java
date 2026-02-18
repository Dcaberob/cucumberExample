package api.client;

import org.openqa.selenium.devtools.v123.network.model.Request;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

public abstract class ApiClient {
    HttpClient client = HttpClient.newHttpClient();
    HttpResponse<String> response;

    public abstract HttpResponse<String> send(RequestApi request) throws IOException, InterruptedException;

    public HttpClient getClient() {
        return client;
    }

}
