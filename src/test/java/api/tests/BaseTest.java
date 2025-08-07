package api.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.*;

public class BaseTest {
    @BeforeAll
    static void setupConfiguration(){
        RestAssured.baseURI ="https://web-agr.chitai-gorod.ru";
    }
    @BeforeEach
    public void setupAllureListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
}
