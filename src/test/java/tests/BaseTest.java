package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {
    @BeforeAll
    static void setupConfiguration(){
        Configuration.pageLoadStrategy= "eager";
        Configuration.baseUrl="https://www.chitai-gorod.ru";
        Configuration.browserSize="1920x1080";

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }
    @BeforeEach
    void setupConfigurationForEach(){
        //SelenideLogger.addListener("allure", new AllureSelenide());
    }
    @AfterEach
    void addAttachments() {
        String sessionId = Selenide.sessionId().toString();
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        closeWebDriver();

        //Attach.addVideo(sessionId);
    }

}
