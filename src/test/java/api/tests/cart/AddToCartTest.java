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
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

public class AddToCartTest extends BaseCartTest {
    @Tag("api_tests")
    @Test
    @Description("Проверка добавления книги в корзину")
    void AddToCartExistItemTest() {
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
                    .body("products[0].goodsId", is(productList[productItem]))///////
                    .body("products", hasSize(1));
        });
    }

    @Tag("api_tests")
    @Test
    @Description("Проверка добавления несуществующей книги в корзину")
    void AddToCartNonExistItemTest() {
        ProductRequestModel request = new ProductRequestModel();
        Random random = new Random();
        int productItem=random.nextInt(productNoEsistList.length-1);
        request.setId(productNoEsistList[productItem]);

        String accessToken=Authorization.Auth();
        step("Добавить книгу в корзину", () -> {
            given(postProductRequestSpec(accessToken))
                    .body(request)
                    .when()
                    .post()

                    .then()
                    .spec(postProductResponse500Spec)
                    .body("message",is(messageProductNotExist));
        });

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
}
