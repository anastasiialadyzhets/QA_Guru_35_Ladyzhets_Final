package web.pages.components;

import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPageComponent {
    private final String[] bottomMenuContent= new String[]{"Акции","Распродажа","Читай-школа","Растем вместе"
            ,"Что ещё почитать?","Читай-журнал","Подарочные сертификаты"};
    private final String[] topMenuContent= new String[]{"Войти","Заказы","Закладки","Корзина"};
    private final String[] catalogLvl1Items= new String[]{"Книги","Канцтовары","Подарки и сувениры","Игры и игрушки"
            ,"Творчество и хобби","Товары для художников"};

    //тут можно переопределить на разные локали ру и другие
    public MainPageComponent checkTopMenu() {
        $("[class='header__row']").shouldBe(visible);
        $("[class='header__logo-wrapper']").shouldBe(visible);
        $("[class='chg-app-button__content']").shouldHave(text("Каталог"));
        $("[class='app-search__form']").shouldBe(visible);
        //й тут можно добаить на плейсхолдер "я иду ююю

        $("[class='header-controls header__controls']").shouldBe(visible);
        Assertions.assertEquals(topMenuContent.length, $$("[class='header-controls__text']").size());
        for (int i=0;i<topMenuContent.length;i++){
            $$("[class='header-controls__text']").get(i).shouldHave(text(topMenuContent[i]));
            $$("[class='header-controls__icon']").get(i).shouldBe(visible);

        }

        return this;
    }

    public MainPageComponent checkBottomLinkMenu() {
        $("[class='header-bottom__container']").shouldBe(visible);

        Assertions.assertEquals(bottomMenuContent.length, $$("[class='header-bottom__link-item']").size());
        for (int i=0;i<bottomMenuContent.length;i++){
            $$("[class='header-bottom__link-item']").get(i).shouldHave(text(bottomMenuContent[i]));
        }

        return this;
    }
    public MainPageComponent checkCatalog() {
        $("[class='categories-menu']").shouldBe(visible);
       // Assertions.assertEquals(catalogLvl1Items.length, $$("[class='categories-level-menu__item-title']").size());
        for (int i=0;i<catalogLvl1Items.length;i++){
            $$("[class='categories-level-menu__item-title']").get(i).shouldHave(text(catalogLvl1Items[i]));
        }

        return this;
    }

    public MainPageComponent checkCheckoutAvailable() {
        $("[class='button action-button blue']").shouldHave(text("Оформить"));

        return this;
    }

    public MainPageComponent checkPageName(String expectedName) {
        $("[class='cart-page__title']").shouldHave(text("Корзина"));

        return this;
    }

    public MainPageComponent checkSignInSignUpPopUpOccured() {
        $("[class='ui-modal__slot-wrapper']").shouldBe(visible);
        $("[class='ui-modal__slot-wrapper']").shouldHave(text("Вход и регистрация"));

        return this;
    }

}
