package web.pages.components;

//-tests.pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CartPageComponent extends MainPageComponent {
    public CartPageComponent checkPageNameAfterRedirect(String expectedName) {
        $("[class='cart-page__title']").shouldHave(text(expectedName));

        return this;
    }
}
