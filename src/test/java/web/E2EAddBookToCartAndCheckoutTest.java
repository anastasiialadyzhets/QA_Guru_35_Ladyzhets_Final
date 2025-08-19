package web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import web.pages.CartPage;
import web.pages.MainPage;
import web.pages.SalesPage;

import static io.qameta.allure.Allure.step;

public class E2EAddBookToCartAndCheckoutTest extends BaseTest {
    MainPage mainPage = new MainPage();
    CartPage cartPage = new CartPage();
    SalesPage salesPage = new SalesPage();

    @Tag("web_test")
    @Tag("web_e2e_test")
    @Test
    @DisplayName("Положить книгу из распродажи в корзину и перейти к оплате без логина")
    void AddItemAndCheckoutUnregistered() {
        step("Перейти на сайт", () -> {
            mainPage.openPage("");
        });
        step("Перейти в раздел Распродажа", () -> {
            mainPage.clickBottomMenuElement("Распродажа");
        });
        step("Добавить книгу в корзину", () -> {
            salesPage.addItemToBasket();
        });
        step("Перейти к оформлению покупки", () -> {
            salesPage.chekoutAfterAddItemToBasket();
            cartPage.cartPageComponent.checkPageNameAfterRedirect("Корзина");
        });
        step("Перейти к оплате", () -> {
            cartPage.checkOut();
            cartPage.cartPageComponent.checkSignInSignUpPopUpOccured();
        });
    }
}
