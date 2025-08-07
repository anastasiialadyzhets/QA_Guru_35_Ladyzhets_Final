package api.tests.cart;

import api.model.request.ProductRequestModel;
import api.tests.Authorization;
import jdk.jfr.Description;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import java.util.Random;

import static api.specification.CartSpec.*;
import static api.specification.ProductSpec.*;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class CheckCartTest extends BaseCartTest {
    @Tag("api_tests")
    @Test
    @Description("Проверка пустой корзины")
    void emptyCartTest() {
        String accessToken=Authorization.Auth();

        step("Проверить наполнение корзины", () -> {
            given(getCartRequestSpec(accessToken))
                    .when()
                    .get()

                    .then()
                    .spec(getCartResponse200Spec)
                    .body(matchesJsonSchemaInClasspath(getCartSchema))
                    .body("products", hasSize(0));
        });
    }
    @Tag("api_tests")
    @Test
    @Description("Проверка наполненой корзины")
    void notEmptyCartTest() {
        ProductRequestModel request = new ProductRequestModel();
        Random random = new Random();
        int productItem=random.nextInt(productList.length-1);
        request.setId(productList[productItem]);

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
                    .body("products[0].goodsId", is(productList[productItem]))
                    .body("products", hasSize(1));
        });
    }
}
