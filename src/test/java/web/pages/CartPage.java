package web.pages;

import com.codeborne.selenide.SelenideElement;
import web.pages.components.CartPageComponent;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    public CartPageComponent cartPageComponent = new CartPageComponent();
    private final SelenideElement checkOutBtn = $("[class='chg-app-button chg-app-button--primary chg-app-button--xl chg-app-button--brand-blue chg-app-button--block cart-sidebar__order-button cart-sidebar__order-button']");

    public CartPage checkOut() {
        checkOutBtn.click();
        return this;
    }
}
