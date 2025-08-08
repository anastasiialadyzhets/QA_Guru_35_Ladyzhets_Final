package web;

import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import web.pages.PromotionsPage;
import web.pages.components.PromotionsPageComponent;

import static io.qameta.allure.Allure.step;

public class PromotionsPageTest extends BaseTest {
    @Tag("web_test")
    @Test
    @Severity(SeverityLevel.NORMAL)
    @AllureId("39348")
    @Owner("Ladyzhets")
    @DisplayName("Проверка, что отображаются акции и скидки")
    void CheckAvailablePromotionsTest() {
        PromotionsPage promotionsPage= new PromotionsPage();
        PromotionsPageComponent promotionsPageComponent = new PromotionsPageComponent();

        step("Перейти на сайт на страницу ", () -> {
            promotionsPage.openPage("/promotions");
        });
        step("Проверить заголовок страницы", () -> {
            promotionsPageComponent.checkPageName("Скидки и акции");
        });
        step("Проверить список доступных акций", () -> {
            promotionsPageComponent.checkPromotionsListNotEmpty();
        });
    }

    @Tag("web_test")
    @Test
    @Severity(SeverityLevel.NORMAL)
    @AllureId("39346")
    @Owner("Ladyzhets")
    @DisplayName("Проверка, что доступны быстрые фильтры по акциям и скидкам")
    void CheckPromotionsQuickFilterTest() {
        PromotionsPage promotionsPage= new PromotionsPage();
        PromotionsPageComponent promotionsPageComponent = new PromotionsPageComponent();

        step("Перейти на сайт на страницу ", () -> {
            promotionsPage.openPage("/promotions");
        });
        step("Проверить быстрые фильтры", () -> {
            promotionsPageComponent.checkPromotionsQuickFilterList();
        });
    }

    @Tag("web_test")
    @Test
    @Severity(SeverityLevel.NORMAL)
    @AllureId("39347")
    @Owner("Ladyzhets")
    @DisplayName("Проверка перехода в карточку акции")
    void CheckPromotionsDetailedTest() {
        PromotionsPage promotionsPage= new PromotionsPage();
        PromotionsPageComponent promotionsPageComponent = new PromotionsPageComponent();

        step("Перейти на сайт на страницу ", () -> {
            promotionsPage.openPage("/promotions");
        });
        step("Открыть карточку акции", () -> {
            promotionsPage.openFirstPromotionCard();
        });

        step("Проверить отображение карточки акции", () -> {
            promotionsPageComponent.checkPromotionCardVisability();
        });
    }
}
