package com.epam.api.stepdefinitions;

import com.epam.api.requestspecs.RequestSpec;
import com.epam.hooks.APIHook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class OperationsApiTests {
    private RequestSpecification requestSpecification;
    private Response response;
    RequestSpec requestSpec=new RequestSpec();
    APIHook apiHook=new APIHook();
    private String token;
    @Given("User logs in to the app through authenticate api and gets a token in response")
    public void userLogsInToTheAppThroughAuthenticateApiAndGetsATokenInResponse() {
    }

    @When("User is at {string} endpoint with query params as {string} being {int},{string} being {int},{string} being {string} and {string} being {string}")
    public void userIsAtEndpointWithQueryParamsAsBeingBeingBeingAndBeing(String endpoint, String param1, int value1, String param2, int value2, String param3, String value3, String param4, String value4) {

    }

    @Then("User response of Status Code {int} with a body containing all operations objects")
    public void userResponseOfStatusCodeWithABodyContainingAllOperationsObjects(int arg0) {
    }
}
