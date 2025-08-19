package api.tests;

import api.config.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

public class BaseTest {
    public static final ApiConfig apiConfig = ApiProvider.getApiConfig();

    @BeforeAll
    static void setupConfiguration() {
        BaseApiConfig baseConfig = new BaseApiConfig(apiConfig);
        baseConfig.setConfig();
    }

    @BeforeEach
    public void setupAllureListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
}
