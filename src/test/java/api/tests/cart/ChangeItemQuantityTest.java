package api.tests.cart;

import api.model.request.ItemRequestModel;
import api.model.request.ProductRequestModel;
import api.model.response.CartResponseModel;
import api.tests.Authorization;
import jdk.jfr.Description;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static api.specification.CartSpec.*;
import static api.specification.ProductSpec.*;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.is;

public class ChangeItemQuantityTest extends BaseCartTest {
    @Tag("api_tests")
    @Test
    @Description("Проверка изменения количесства товаров в корзине")
    void changeCountOfItemTest() {
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

        List<ItemRequestModel> item_request = new ArrayList<ItemRequestModel>();


        CartResponseModel responseCart= step("Получить инфо о книгах из корзины", () ->
                given(getCartRequestSpec(accessToken))
                        .when()
                        .get()

                        .then()
                        .spec(getCartResponse200Spec)
                        .body(matchesJsonSchemaInClasspath(getCartSchema))
                        .extract().body().as(CartResponseModel.class));
        int stock_count=responseCart.getProducts()[0].getStock();
        int setted_count=stock_count/2+1;
        item_request.add(new ItemRequestModel(responseCart.getProducts()[0].getId(),setted_count));

        step("Изменить кол-во товаров", () -> {
            given(putCartRequestSpec(accessToken))
                    .body(item_request.toArray())
                    .when()
                    .put()

                    .then()
                    .spec(putCartResponse200Spec)
                    .body("products[0].quantity", is(setted_count));
        });
    }
}
