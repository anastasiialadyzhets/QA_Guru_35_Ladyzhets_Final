package api.specification;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;

public class BaseSpec {
    public static ResponseSpecification build (int statusCode){
        return new ResponseSpecBuilder()
                .expectStatusCode(statusCode)
                .log(STATUS)
                .log(BODY)
                .build();
    }
}