package web.pages.components;

//-tests.pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CartPageComponent extends MainPageComponent {
    // тут можно переопределить на разные локали ру и другие
    //проверить наименование страницы cart-page__title
    public CartPageComponent checkPageNameAfterRedirect(String expectedName) {
        $("[class='cart-page__title']").shouldHave(text("Корзина"));

        return this;
    }
}
