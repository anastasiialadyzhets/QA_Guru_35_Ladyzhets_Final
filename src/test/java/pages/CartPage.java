package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    public CartPage checkOut() {
        $("[class='chg-app-button chg-app-button--primary chg-app-button--xl chg-app-button--brand-blue chg-app-button--block cart-sidebar__order-button cart-sidebar__order-button']").click();
        return this;
    }
}
