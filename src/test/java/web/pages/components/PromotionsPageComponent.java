package web.pages.components;

//-tests.pages.components;

import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PromotionsPageComponent extends MainPageComponent {
    private final String[] QuickFilterList= new String[]{"Все акции","В интернет-магазине","В розничных магазинах"};

    public PromotionsPageComponent checkPageName(String expectedName) {
        $("[class='constructor-promotions-page__title']").shouldHave(text(expectedName));

        return this;
    }

    public PromotionsPageComponent checkPromotionsListNotEmpty() {
        Assertions.assertFalse($$("[class='block-promotion-card']").isEmpty());

        return this;
    }

    public PromotionsPageComponent checkPromotionsQuickFilterList() {
        Assertions.assertFalse($$("[class='chg-app-tabs__tab-item chg-app-tabs__tab-item--underline']").isEmpty());
        Assertions.assertEquals(QuickFilterList.length,$$("[class='chg-app-tabs__tab-item chg-app-tabs__tab-item--underline']").size());

        for (int i=0;i<QuickFilterList.length;i++){
            $$("[class='chg-app-tabs__tab-item chg-app-tabs__tab-item--underline']").get(i).shouldHave(text(QuickFilterList[i]));
        }
        return this;
    }

    public PromotionsPageComponent checkPromotionCardVisability() {
        $("[class='constructor-page__promo-title']").shouldNot(empty);
        $("[class='article-product-card']").shouldNot(empty);

        return this;
    }
}
