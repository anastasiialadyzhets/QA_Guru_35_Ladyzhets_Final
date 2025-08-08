package web;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import web.config.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {
    public static final WebConfig webConfig = WebProvider.getWebConfig();
    @BeforeAll
    static void setupConfiguration(){
        BaseConfig baseConfig = new BaseConfig(webConfig);
        baseConfig.setConfig();
    }
    @BeforeEach
    void setupConfigurationForEach(){
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Screenshot");
        Attach.pageSource();
        if (webConfig.isRemote()) {
            Attach.addVideo();
        }
        closeWebDriver();
    }
}
