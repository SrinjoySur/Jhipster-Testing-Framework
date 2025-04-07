package com.epam.api.requestspecs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {
    RequestSpecBuilder requestSpecBuilder=new RequestSpecBuilder();
    protected RequestSpecification get(String BaseUri,String token){
        return requestSpecBuilder.setBaseUri(BaseUri).addHeader("accept","*/*").addHeader("Authorization","Bearer "+token).build();
    }
    protected RequestSpecification post(String BaseUri){
        return requestSpecBuilder.setBaseUri(BaseUri).setContentType(ContentType.JSON).addHeader("accept","*/*").build();
    }
    protected RequestSpecification post(String BaseUri, String token){
        return requestSpecBuilder.setBaseUri(BaseUri).addHeader("accept","*/*").addHeader("Authorization","Bearer "+token).build();
    }
    protected RequestSpecification put(String BaseUri,String token){
        return requestSpecBuilder.setBaseUri(BaseUri).addHeader("accept","*/*").addHeader("Authorization","Bearer "+token).build();
    }
    protected RequestSpecification patch(String BaseUri,String token){
        return requestSpecBuilder.setBaseUri(BaseUri).addHeader("accept","*/*").addHeader("Authorization","Bearer "+token).build();
    }
    protected RequestSpecification delete(String BaseUri,String token){
        return requestSpecBuilder.setBaseUri(BaseUri).addHeader("accept","*/*").addHeader("Authorization","Bearer "+token).build();
    }
}
