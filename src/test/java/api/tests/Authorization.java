package api.tests;

import api.model.response.AuthResponseModel;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import static api.specification.AuthSpec.*;
import static api.specification.ProductSpec.postProductRequestSpec;
import static api.specification.ProductSpec.postProductResponse200Spec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.http.ContentType.JSON;

public class Authorization {

    static void setupConfiguration() {
        RestAssured.baseURI = "https://web-agr.chitai-gorod.ru/web/api/v1/auth/anonymous";
    }

    public static String Auth() {
        AuthResponseModel authToken= step("Получить анонимный сессионный токен ", () ->
                given(authRequestSpec)

                .when()
                .post()

                .then()
                .spec(authResponse201Spec)
                .extract().body().as(AuthResponseModel.class)
        );
        return authToken.getToken().getAccessToken();
    }
}
