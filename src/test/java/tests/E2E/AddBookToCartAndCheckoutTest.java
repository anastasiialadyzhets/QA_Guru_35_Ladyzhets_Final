package tests.E2E;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.MainPage;
import pages.SalesPage;
import pages.components.CartPageComponent;
import pages.components.MainPageComponent;
import tests.BaseTest;

import static io.qameta.allure.Allure.step;

public class AddBookToCartAndCheckoutTest extends BaseTest {
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
