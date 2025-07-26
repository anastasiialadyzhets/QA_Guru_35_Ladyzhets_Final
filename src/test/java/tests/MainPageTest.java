package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.MainPage;
import pages.components.CartPageComponent;
import pages.components.MainPageComponent;

import static io.qameta.allure.Allure.step;

public class MainPageTest extends BaseTest{

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
