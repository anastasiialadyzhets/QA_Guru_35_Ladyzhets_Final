package web.pages.components;

//-tests.pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PromotionsPageComponent extends MainPageComponent {
    private final SelenideElement pageName = $("[class='constructor-promotions-page__title']"),
            promoCardTitle = $("[class='constructor-page__promo-title']");

    private final ElementsCollection promotionsTabMenu = $$("[class='chg-app-tabs__tab-item chg-app-tabs__tab-item--underline']"),
            promotionsBlockCard = $$("[class='block-promotion-card']");

    private final String[] QuickFilterList= new String[]{"Все акции","В интернет-магазине","В розничных магазинах"};

    public PromotionsPageComponent checkPageName(String expectedName) {
        pageName.shouldHave(text(expectedName));

        return this;
    }

    public PromotionsPageComponent checkPromotionsListNotEmpty() {
        Assertions.assertFalse(promotionsBlockCard.isEmpty());

        return this;
    }

    public PromotionsPageComponent checkPromotionsQuickFilterList() {
        Assertions.assertFalse(promotionsTabMenu.isEmpty());
        Assertions.assertEquals(QuickFilterList.length, promotionsTabMenu.size());

        for (int i = 0; i < QuickFilterList.length; i++) {
            promotionsTabMenu.get(i).shouldHave(text(QuickFilterList[i]));
        }
        return this;
    }

    public PromotionsPageComponent checkPromotionCardVisability() {
        promoCardTitle.shouldNot(empty);

        return this;
    }
}
