package api.specification;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.JSON;

public class ProductSpec {
    public static RequestSpecification postProductRequestSpec (String accessToken) {
        return with()
                .filter(withCustomTemplates())
                .header("authorization", accessToken)
                .contentType(JSON)

                .log().uri()
                .log().body()
                .log().headers()
                .basePath("/web/api/v1/cart/product");
    }

    public static ResponseSpecification postProductResponse200Spec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(STATUS)
            .log(BODY)
            .build();

    public static ResponseSpecification postProductResponse500Spec = new ResponseSpecBuilder()
            .expectStatusCode(500)
            .log(STATUS)
            .log(BODY)
            .build();

    public static RequestSpecification deleteProductRequestSpec (String accessToken) {
        return with()
                .filter(withCustomTemplates())
                .header("authorization", accessToken)
                .contentType(JSON)

                .log().uri()
                .log().body()
                .log().headers()
                .basePath("/web/api/v1/cart/product");
    }
    public static ResponseSpecification deleteProductResponse204Spec = new ResponseSpecBuilder()
            .expectStatusCode(204)
            .log(STATUS)
            .log(BODY)
            .build();

    public static ResponseSpecification deleteProductResponse404Spec = new ResponseSpecBuilder()
            .expectStatusCode(404)
            .log(STATUS)
            .log(BODY)
            .build();

}
