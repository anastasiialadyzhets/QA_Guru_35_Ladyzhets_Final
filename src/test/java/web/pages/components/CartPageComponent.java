package web.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CartPageComponent extends MainPageComponent {
    private final SelenideElement cartPageTitle = $("[class='cart-page__title']");

    public CartPageComponent checkPageNameAfterRedirect(String expectedName) {
        cartPageTitle.shouldHave(text(expectedName));

        return this;
    }
}
