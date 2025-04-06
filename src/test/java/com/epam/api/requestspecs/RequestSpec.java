package com.epam.api.requestspecs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public abstract class RequestSpec {
    RequestSpecBuilder requestSpecBuilder=new RequestSpecBuilder();
    protected RequestSpecification get(String BaseUri){
        return requestSpecBuilder.setBaseUri(BaseUri).addHeader("accept","*/*").addHeader("Authorization","Bearer ").build();
    }
    protected RequestSpecification post(String BaseUri){
        return requestSpecBuilder.setBaseUri(BaseUri).setContentType(ContentType.JSON).addHeader("accept","*/*").addHeader("Authorization","Bearer ").build();
    }
    protected RequestSpecification put(String BaseUri){
        return requestSpecBuilder.setBaseUri(BaseUri).addHeader("accept","*/*").addHeader("Authorization","Bearer ").build();
    }
    protected RequestSpecification patch(String BaseUri){
        return requestSpecBuilder.setBaseUri(BaseUri).addHeader("accept","*/*").addHeader("Authorization","Bearer ").build();
    }
    protected RequestSpecification delete(String BaseUri){
        return requestSpecBuilder.setBaseUri(BaseUri).addHeader("accept","*/*").addHeader("Authorization","Bearer ").build();
    }
}
