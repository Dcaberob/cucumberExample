package stepsDefinitions;

import api.client.ApiClient;
import api.client.FactoryRequest;
import api.client.RequestApi;
import api.client.ResponseApi;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.glassfish.jersey.client.ClientRequest;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

import static api.config.Configuration.HOST;

public class MyStepdefs {

    ResponseApi response1 = new ResponseApi();

    RequestApi requestApi = new RequestApi();
    Map<String, String> variables = new HashMap<>();
    private HttpResponse<String> response;

    @When("^I (GET|POST|PUT|DELETE) request '(.*)'$")
    public void iGetRequest(String method, String service ) throws IOException, InterruptedException {
        requestApi.setUrl(HOST + service);

        ApiClient clientRequest = FactoryRequest.make(method);


        System.out.println(requestApi.getUrl());

        response = clientRequest.send(requestApi);


    }

    @Then("The status code is {int}")
    public void theStatusCodeIs(int statusCode) {
        System.out.println(response.statusCode());
    }
}
