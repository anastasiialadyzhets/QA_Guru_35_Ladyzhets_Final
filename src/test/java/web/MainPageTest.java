package web;

import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import web.pages.MainPage;
import web.pages.components.MainPageComponent;

import static io.qameta.allure.Allure.step;

public class MainPageTest extends BaseTest {

    @Tag("web_test")
    @Severity(SeverityLevel.CRITICAL)
    @AllureId("39337")
    @Owner("Ladyzhets")
    @ValueSource(strings = {
            "", "/promotions","/skorovprodage","/about"
    })
    @ParameterizedTest(name = "Проверка что страница {0} содержит стандартное меню")
    void topMenuTest(String page) {
        MainPage mainPage= new MainPage();
        MainPageComponent mainPageComponent = new MainPageComponent();

        step("Перейти на сайт на страницу "+page, () -> {
            mainPage.openPage(page);
        });
        step("Проверить что страница "+page + "содержит стандартное меню", () -> {
            mainPageComponent.checkTopMenu();
        });
    }
    @Tag("web_test")
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @AllureId("39338")
    @Owner("Ladyzhets")
    @DisplayName("Проверка наполения каталога")
    void checkCatalogTest() {
        MainPage mainPage= new MainPage();
        MainPageComponent mainPageComponent = new MainPageComponent();

        step("Перейти на сайт", () -> {
            mainPage.openPage("");
        });
        step("Раскрыть каталог", () -> {
            mainPage.openCatalog();
        });
        step("Проверить содержимое каталога", () -> {
            mainPageComponent.checkCatalog();
        });
    }
    @Tag("web_test")
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @AllureId("39336")
    @Owner("Ladyzhets")
    @DisplayName("Проверка списка страниц в верхнем меню")
    void checkPagesTest() {
        MainPage mainPage= new MainPage();
        MainPageComponent mainPageComponent = new MainPageComponent();

        step("Перейти на сайт", () -> {
            mainPage.openPage("");
        });
        step("Проверить доступные страницы в верхнем меню", () -> {
            mainPageComponent.checkBottomLinkMenu();
        });
    }
}
