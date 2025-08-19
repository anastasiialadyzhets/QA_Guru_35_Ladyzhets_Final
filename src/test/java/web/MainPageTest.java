package web;

import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import web.pages.MainPage;

import static io.qameta.allure.Allure.step;

public class MainPageTest extends BaseTest {
    MainPage mainPage = new MainPage();

    @Tag("web_test")
    @Severity(SeverityLevel.CRITICAL)
    @AllureId("39337")
    @Owner("Ladyzhets")
    @ValueSource(strings = {
            "", "/promotions", "/skorovprodage", "/about"
    })
    @ParameterizedTest(name = "Проверка что страница {0} содержит стандартное меню")
    void topMenuTest(String page) {
        step("Перейти на сайт на страницу " + page, () -> {
            mainPage.openPage(page);
        });
        step("Проверить что страница " + page + "содержит стандартное меню", () -> {
            mainPage.mainPageComponent.checkTopMenu();
        });
    }

    @Tag("web_test")
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @AllureId("39338")
    @Owner("Ladyzhets")
    @DisplayName("Проверка наполения каталога")
    void checkCatalogTest() {
        step("Перейти на сайт", () -> {
            mainPage.openPage("");
        });
        step("Раскрыть каталог", () -> {
            mainPage.openCatalog();
        });
        step("Проверить содержимое каталога", () -> {
            mainPage.mainPageComponent.checkCatalog();
        });
    }

    @Tag("web_test")
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @AllureId("39336")
    @Owner("Ladyzhets")
    @DisplayName("Проверка списка страниц в верхнем меню")
    void checkPagesTest() {
        step("Перейти на сайт", () -> {
            mainPage.openPage("");
        });
        step("Проверить доступные страницы в верхнем меню", () -> {
            mainPage.mainPageComponent.checkBottomLinkMenu();
        });
    }
}
