package com.epam.api.requestspecs;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class AuthenticateSpec extends RequestSpec{
    @Override
    protected RequestSpecification post(String BaseUri){
        return requestSpecBuilder.setBaseUri(BaseUri).setContentType(ContentType.JSON).build();
    }
}
