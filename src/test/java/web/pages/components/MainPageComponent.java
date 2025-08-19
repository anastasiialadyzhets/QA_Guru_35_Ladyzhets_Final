package web.pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPageComponent {
    private final SelenideElement headerRow = $("[class='header__row']"),
            headerLogo = $("[class='header__logo-wrapper']"),
            catalogElem = $("[class='chg-app-button__content']"),
            searchInputElem = $("[class='app-search__form']"),
            headerControls = $("[class='header-controls header__controls']"),
            headerBottom = $("[class='header-bottom__container']"),
            signMenuElem = $("[class='ui-modal__slot-wrapper']"),
            catalogMenu = $("[class='categories-menu']");
    private final ElementsCollection headerControlsText = $$("[class='header-controls__text']"),
            headerControlsIcon = $$("[class='header-controls__icon']"),
            headerBottomLink = $$("[class='header-bottom__link-item']"),
            catalogMenuCategories = $$("[class='categories-level-menu__item-title']");


    private final String[] bottomMenuContent = new String[]{"Акции", "Распродажа", "Читай-школа", "Растем вместе"
            , "Что ещё почитать?", "Читай-журнал", "Подарочные сертификаты"};
    private final String[] topMenuContent = new String[]{"Войти", "Заказы", "Закладки", "Корзина"};
    private final String[] catalogLvl1Items = new String[]{"Книги", "Канцтовары", "Подарки и сувениры", "Игры и игрушки"
            , "Творчество и хобби", "Товары для художников"};

    public MainPageComponent checkTopMenu() {
        headerRow.shouldBe(visible);
        headerLogo.shouldBe(visible);
        catalogElem.shouldHave(text("Каталог"));
        searchInputElem.shouldBe(visible);

        headerControls.shouldBe(visible);
        Assertions.assertEquals(topMenuContent.length, headerControlsText.size());
        for (int i = 0; i < topMenuContent.length; i++) {
            headerControlsText.get(i).shouldHave(text(topMenuContent[i]));
            headerControlsIcon.get(i).shouldBe(visible);
        }

        return this;
    }

    public MainPageComponent checkBottomLinkMenu() {
        headerBottom.shouldBe(visible);

        Assertions.assertEquals(bottomMenuContent.length, headerBottomLink.size());
        for (int i = 0; i < bottomMenuContent.length; i++) {
            headerBottomLink.get(i).shouldHave(text(bottomMenuContent[i]));
        }

        return this;
    }

    public MainPageComponent checkCatalog() {
        catalogMenu.shouldBe(visible);
        for (int i = 0; i < catalogLvl1Items.length; i++) {
            catalogMenuCategories.get(i).shouldHave(text(catalogLvl1Items[i]));
        }

        return this;
    }

    public MainPageComponent checkSignInSignUpPopUpOccured() {
        signMenuElem.shouldBe(visible);
        signMenuElem.shouldHave(text("Вход и регистрация"));

        return this;
    }
}
