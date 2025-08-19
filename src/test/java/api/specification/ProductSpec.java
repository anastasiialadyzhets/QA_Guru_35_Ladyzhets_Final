package api.specification;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;

public class ProductSpec extends BaseSpec {
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

    public static ResponseSpecification postProductResponse200Spec = build(200);

    public static ResponseSpecification postProductResponse500Spec = build(500);
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
    public static ResponseSpecification deleteProductResponse204Spec = build(204);

    public static ResponseSpecification deleteProductResponse404Spec = build(404);

}
