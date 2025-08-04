package web.E2E;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import web.pages.CartPage;
import web.pages.MainPage;
import web.pages.SalesPage;
import web.pages.components.CartPageComponent;
import web.pages.components.MainPageComponent;
import web.BaseTest;

import static io.qameta.allure.Allure.step;

public class AddBookToCartAndCheckoutTest extends BaseTest {
    @Tag("web_tests")
    @Tag("web_e2e_tests")
    @Test
    @DisplayName("Положить книгу из распродажи в корзину и перейти к оплате без логина")
    void checkCatalogTest() {//переименовать
        //перейти в раздел распродажа
        //поллжить книгу в корзину
        //перейти в корзину
        //перейти в оформлению
        MainPage mainPage= new MainPage();
        CartPage cartPage = new CartPage();
        SalesPage salesPage = new SalesPage();

        MainPageComponent mainPageComponent = new MainPageComponent();
        CartPageComponent cartPageComponent = new CartPageComponent();

        step("Перейти на сайт", () -> {
            mainPage.openPage("");
        });
        step("Перейти в раздел Распродажа", () -> {
            mainPage.clickBottomMenuElement("Распродажа");//("Растем вместе")//(" Распродажа")
        });
        step("Добавить книгу в корзину", () -> {
            salesPage.addItemToBasket();
        });
        //тут можно проверить что книга отобразилась в корзине
        step("Перейти к оформлению покупки", () -> {
            salesPage.chekoutAfterAddItemToBasket();
            cartPageComponent.checkPageNameAfterRedirect("Корзина");
        });
        step("Перейти к оплате", () -> {
            cartPage.checkOut();
            cartPageComponent.checkSignInSignUpPopUpOccured();
        });
    }
}
