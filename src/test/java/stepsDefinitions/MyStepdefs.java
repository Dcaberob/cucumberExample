package stepsDefinitions;

import api.client.ApiClient;
import api.client.FactoryRequest;
import api.client.RequestApi;
import api.client.ResponseApi;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jakarta.validation.constraints.AssertTrue;
import org.glassfish.jersey.client.ClientRequest;
import org.testng.Assert;

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
    @When("^I (GET|POST|PUT|DELETE) request '(.*)' and send data$")
    public void iGetRequestWithEmail(String method, String service,
                                     Map<String, String> data ) throws IOException, InterruptedException {
        requestApi.setUrl(HOST + service);
        requestApi.setParams(data);
        ApiClient clientRequest = FactoryRequest.make(method);

        System.out.println(requestApi.getParams());
        response = clientRequest.send(requestApi);
    }

    @Then("The status code is {int}")
    public void theStatusCodeIs(int statusCode) {
        Assert.assertEquals(response.statusCode(),statusCode);
        System.out.println(response.body());
        System.out.println(response.statusCode());
    }
}
