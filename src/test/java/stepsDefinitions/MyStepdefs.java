package stepsDefinitions;

import api.client.*;
import api.utils.Utils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Map;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class MyStepdefs {

    private Response response;
    private ApiRequest request;

    @When("^I (GET|POST|PUT|DELETE) request '(.*)'$")
    public void iGetRequest(String method, String service) throws IOException, InterruptedException {
        request = new BasicRequest();
        String url = request.getUrl() + service;
        ApiClient client = FactoryRequest.make(method);
        response = client.send(request, url);
    }

    @When("^I (GET|POST|PUT|DELETE) request '(.*)' and send data$")
    public void iSendRequestWithData(String method,
                                     String endpoint,
                                     DataTable dataTable) {

        Map<String, String> params =
                dataTable.asMap(String.class, String.class);

        request = new BasicRequest();
        request.setUrl(request.getUrl() + endpoint);
        request.setParams(params);

        ApiClient client = FactoryRequest.make(method);

        response = client.send(request, request.getUrl() + endpoint);
    }

    @Then("The status code is {int}")
    public void theStatusCodeIs(int statusCode) {
        assertEquals(response.statusCode(), statusCode);
    }

    @When("I POST request {string} and send body")
    public void iPOSTRequestSearchProductAndSendBody(String service, DataTable dataTable) {
        Map<String, String> params =
                dataTable.asMap(String.class, String.class);

        request = new BasicRequest();
        request.setParams(params);
        request.setBody(params.toString());
        ApiClient client = FactoryRequest.make("Post");

        response = client.send(request, request.getUrl() + service);
    }

    @Then("The body contain")
    public void theBodyContain(DataTable dataTable) {
        Map<String, String> responseBody =
                dataTable.asMap(String.class, String.class);
        String res = Utils.htmlToJson(response.getBody().prettyPrint());

        for (Map.Entry<String, String> entry : responseBody.entrySet()) {
            assertTrue(res.contains(entry.getKey()));
            assertTrue(res.contains(entry.getValue()));
        }
    }
}
