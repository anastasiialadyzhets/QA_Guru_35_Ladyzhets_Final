package api.tests.cart;

import api.model.request.ProductRequestModel;
import api.tests.Authorization;
import api.tests.BaseTest;
import io.qameta.allure.Step;
import jdk.jfr.Description;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static api.specification.CartSpec.*;
import static api.specification.ProductSpec.postProductRequestSpec;
import static api.specification.ProductSpec.postProductResponse200Spec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.is;

public class GetCartTest extends BaseTest {
    private final String getCartSchema = "getCartResponse-schema.json";

    @Tag("api_tests")
    @Test
    @Description("Проверка пустой корзины")
    void emptyCartTest() {
        //get token
        //add token to variables
        String accessToken=Authorization.Auth();

        step("Проверить наполнение корзины", () -> {
            given(getCartRequestSpec(accessToken))
                    .when()
                    .get()

                    .then()
                    .spec(getCartResponse200Spec)
                    .body(matchesJsonSchemaInClasspath(getCartSchema));
        });
    }
    @Tag("api_tests")
    @Test
    @Description("Проверка наполненой корзины")
    void notEmptyCartTest() {
        ProductRequestModel request = new ProductRequestModel();
        request.setId(3072819);
        String accessToken=Authorization.Auth();

        step("Добавить книгу в корзину", () -> {
            given(postProductRequestSpec(accessToken))
                    .body(request)
                    .when()
                    .post()

                    .then()
                    .spec(postProductResponse200Spec);
        });
        step("Проверить наполнение корзины", () -> {
            given(getCartRequestSpec(accessToken))
                    .when()
                    .get()

                    .then()
                    .spec(getCartResponse200Spec)
                    .body(matchesJsonSchemaInClasspath(getCartSchema))
                    .body("products[0].goodsId", is(3072819));///////
        });
    }
}
