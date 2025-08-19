package api.specification;

import io.restassured.specification.RequestSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;

public class ProductSpec {
    public static RequestSpecification postProductRequestSpec(String accessToken) {
        return with()
                .filter(withCustomTemplates())
                .header("authorization", accessToken)
                .contentType(JSON)

                .log().uri()
                .log().body()
                .log().headers()
                .basePath("/web/api/v1/cart/product");
    }

    public static RequestSpecification deleteProductRequestSpec(String accessToken) {
        return with()
                .filter(withCustomTemplates())
                .header("authorization", accessToken)
                .contentType(JSON)

                .log().uri()
                .log().body()
                .log().headers()
                .basePath("/web/api/v1/cart/product");
    }
}