package com.epam.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class APIHook {
    private Response response;
    @Before
    void authenticate(){
        response=given().auth().basic("admin","admin").when().post("http://localhost:9000/api/authenticate");
    }
    public String getToken(){
        return response.jsonPath().getString("id_token");
    }
    @After
    void destroy(){
        response=null;
    }
}
