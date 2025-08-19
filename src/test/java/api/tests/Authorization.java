package api.tests;

import api.model.response.AuthResponseModel;
import io.restassured.RestAssured;

import static api.specification.AuthSpec.*;
import static api.specification.BaseSpec.build;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class Authorization {

    static void setupConfiguration() {
        RestAssured.baseURI = "https://web-agr.chitai-gorod.ru/web/api/v1/auth/anonymous";
    }

    public static String Auth() {
        AuthResponseModel authToken = step("Получить анонимный сессионный токен ", () ->
                given(authRequestSpec)

                        .when()
                        .post()

                        .then()
                        .spec(build(201))
                        .extract().body().as(AuthResponseModel.class)
        );
        return authToken.getToken().getAccessToken();
    }
}
