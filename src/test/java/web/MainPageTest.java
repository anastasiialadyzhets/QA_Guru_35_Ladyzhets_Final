package web;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import web.BaseTest;
import web.pages.MainPage;
import web.pages.components.MainPageComponent;

import static io.qameta.allure.Allure.step;

public class MainPageTest extends BaseTest {

    @Tag("web_tests")
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
    @Tag("web_tests")
    @Test
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
    @Tag("web_tests")
    @Test
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
