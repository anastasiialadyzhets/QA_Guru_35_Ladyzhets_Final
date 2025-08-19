package api.specification;

import io.restassured.specification.RequestSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;

public class CartSpec {
    public static RequestSpecification getCartRequestSpec (String accessToken) {
        return with()
                .filter(withCustomTemplates())
                .header("authorization", accessToken)
                .contentType(JSON)

                .log().uri()
                .log().body()
                .log().headers()
                .basePath("/web/api/v1/cart");
    }
    public static RequestSpecification putCartRequestSpec (String accessToken) {
        return with()
                .header("authorization", accessToken)
                .contentType(JSON)

                .log().uri()
                .log().body()
                .log().headers()
                .basePath("/web/api/v1/cart");
    }

    public static RequestSpecification deleteAllCartRequestSpec (String accessToken) {
        return with()
                .filter(withCustomTemplates())
                .header("authorization", accessToken)
                .contentType(JSON)

                .log().uri()
                .log().body()
                .log().headers()
                .basePath("/web/api/v1/cart");
    }
}
