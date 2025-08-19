package api.specification;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;

public class CartSpec extends BaseSpec {
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
    public static ResponseSpecification getCartResponse200Spec = build(200);

    public static RequestSpecification putCartRequestSpec (String accessToken) {
        return with()
                .header("authorization", accessToken)
                .contentType(JSON)

                .log().uri()
                .log().body()
                .log().headers()
                .basePath("/web/api/v1/cart");
    }

    public static ResponseSpecification putCartResponse200Spec = build(200);
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
    public static ResponseSpecification deleteAllCartResponse204Spec = build(204);
}
