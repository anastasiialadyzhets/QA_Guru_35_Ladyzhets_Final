package api.tests.cart;

import api.model.request.ProductRequestModel;
import api.model.response.CartResponseModel;
import api.tests.Authorization;
import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
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

public class DeleteFromCartTest extends BaseCartTest {
    @Tag("api_test")
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @AllureId("39332")
    @Owner("Ladyzhets")
    @DisplayName("Проверка удаления из корзины")
    void deleteFromCartTest() {
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

        CartResponseModel responseCart= step("Получить инфо о книгах из корзины", () ->
                given(getCartRequestSpec(accessToken))
                        .when()
                        .get()

                        .then()
                        .spec(getCartResponse200Spec)
                        .body(matchesJsonSchemaInClasspath(getCartSchema))
                        .extract().body().as(CartResponseModel.class));

        step("Удалить книгу из корзины", () -> {
            given(deleteProductRequestSpec(accessToken))
                    .when()
                    .delete("/"+responseCart.getProducts()[0].getId())

                    .then()
                    .spec(deleteProductResponse204Spec);
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

    @Tag("api_test")
    @Test
    @Severity(SeverityLevel.NORMAL)
    @AllureId("39333")
    @Owner("Ladyzhets")
    @DisplayName("Проверка очистки корзины")
    void deleteAllFromCartTest() {
       String accessToken=Authorization.Auth();

        step("Очистить корзину", () -> {
            given(deleteAllCartRequestSpec(accessToken))
                    .when()
                    .delete()

                    .then()
                    .spec(deleteAllCartResponse204Spec);
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

    @Tag("api_test")
    @Test
    @Severity(SeverityLevel.NORMAL)
    @AllureId("39334")
    @Owner("Ladyzhets")
    @DisplayName("Проверка удаления из корзины товара которого нет в корзине")
    void deleteFromCartNotAddedItemTest() {
        ProductRequestModel request = new ProductRequestModel();
        Random random = new Random();
        int productItem=random.nextInt(productList.length-1);
        request.setId(productList[productItem]);

        String accessToken=Authorization.Auth();

        step("Удалить книгу из корзины", () -> {
            given(deleteProductRequestSpec(accessToken))
                    .when()
                    .delete("/"+request.getId())

                    .then()
                    .spec(deleteProductResponse404Spec)
                    .body("message",is(messageProductDFindInCart));
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

    @Tag("api_test")
    @Test
    @Severity(SeverityLevel.NORMAL)
    @AllureId("39335")
    @Owner("Ladyzhets")
    @DisplayName("Проверка удаления из корзины товара которого не существует")
    void deleteFromCartNotExistItemTest() {
        ProductRequestModel request = new ProductRequestModel();
        Random random = new Random();
        int productItem=random.nextInt(productList.length-1);
        request.setId(productList[productItem]);

        String accessToken=Authorization.Auth();

        step("Удалить книгу из корзины", () -> {
            given(deleteProductRequestSpec(accessToken))
                    .when()
                    .delete("/"+request.getId())

                    .then()
                    .spec(deleteProductResponse404Spec)
                    .body("message",is(messageProductDFindInCart));
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
