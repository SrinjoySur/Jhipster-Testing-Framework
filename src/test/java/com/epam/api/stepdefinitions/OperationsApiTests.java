package com.epam.api.stepdefinitions;

import com.epam.api.requestspecs.RequestSpec;
import com.epam.hooks.APIHook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import static io.restassured.RestAssured.given;

public class OperationsApiTests {
    private RequestSpecification requestSpecification;
    private Response response;
    RequestSpec requestSpec=new RequestSpec();
    APIHook apiHook=new APIHook();
    @Given("User logs in to the app through authenticate api and gets a token in response")
    public void userLogsInToTheAppThroughAuthenticateApiAndGetsATokenInResponse() {
        requestSpecification=requestSpec.get(apiHook.getBaseUri(), apiHook.getToken());
    }

    @When("User is at {string} endpoint with query params as {string} being {int},{string} being {int},{string} being {string} and {string} being {string}")
    public void userIsAtEndpointWithQueryParamsAsBeingBeingBeingAndBeing(String endpoint, String param1, int value1, String param2, int value2, String param3, String value3, String param4, String value4) {
        response=given().spec(requestSpecification).queryParam(param1,value1).queryParam(param2,value2).queryParam(param3,value3).queryParam(param4,Boolean.valueOf(value4)).when().get(endpoint);
    }

    @Then("User response of Status Code {int}")
    public void userResponseOfStatusCodeWithABodyContainingAllOperationsObjects(int statusCode) {
        response.then().assertThat().statusCode(statusCode).and().body(Matchers.notNullValue());
    }
}
