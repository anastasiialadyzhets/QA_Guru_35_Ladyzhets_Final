package web;

import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import web.pages.PromotionsPage;
import static io.qameta.allure.Allure.step;

public class PromotionsPageTest extends BaseTest {
    PromotionsPage promotionsPage = new PromotionsPage();

    @Tag("web_test")
    @Test
    @Severity(SeverityLevel.NORMAL)
    @AllureId("39348")
    @Owner("Ladyzhets")
    @DisplayName("Проверка, что отображаются акции и скидки")
    void CheckAvailablePromotionsTest() {
        step("Перейти на сайт на страницу ", () -> {
            promotionsPage.openPage("/promotions");
        });
        step("Проверить заголовок страницы", () -> {
            promotionsPage.promotionsPageComponent.checkPageName("Скидки и акции");
        });
        step("Проверить список доступных акций", () -> {
            promotionsPage.promotionsPageComponent.checkPromotionsListNotEmpty();
        });
    }

    @Tag("web_test")
    @Test
    @Severity(SeverityLevel.NORMAL)
    @AllureId("39346")
    @Owner("Ladyzhets")
    @DisplayName("Проверка, что доступны быстрые фильтры по акциям и скидкам")
    void CheckPromotionsQuickFilterTest() {
        step("Перейти на сайт на страницу ", () -> {
            promotionsPage.openPage("/promotions");
        });
        step("Проверить быстрые фильтры", () -> {
            promotionsPage.promotionsPageComponent.checkPromotionsQuickFilterList();
        });
    }

    @Tag("web_test")
    @Test
    @Severity(SeverityLevel.NORMAL)
    @AllureId("39347")
    @Owner("Ladyzhets")
    @DisplayName("Проверка перехода в карточку акции")
    void CheckPromotionsDetailedTest() {
        step("Перейти на сайт на страницу ", () -> {
            promotionsPage.openPage("/promotions");
        });
        step("Открыть карточку акции", () -> {
            promotionsPage.openFirstPromotionCard();
        });

        step("Проверить отображение карточки акции", () -> {
            promotionsPage.promotionsPageComponent.checkPromotionCardVisability();
        });
    }
}
