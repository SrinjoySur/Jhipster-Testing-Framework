package com.epam.hooks;

import com.epam.utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class APIHook {
    private Response response;
    private ConfigReader configReader=ConfigReader.getInstance();
    @Before
    void authenticate(){
        String url= configReader.getProperty("url");
        response=given().auth().basic("admin","admin").when().post(url+"/api/authenticate");
    }
    public String getToken(){
        return response.jsonPath().getString("id_token");
    }
    @After
    void destroy(){
        response=null;
    }
}
