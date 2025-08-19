package web.pages;

import com.codeborne.selenide.SelenideElement;
import web.pages.components.PromotionsPageComponent;

import static com.codeborne.selenide.Selenide.$;

public class PromotionsPage extends MainPage{
    public PromotionsPageComponent promotionsPageComponent = new PromotionsPageComponent();
    private final SelenideElement fPromotionCard = $("[class='block-promotion-card']");

    public PromotionsPage openFirstPromotionCard(){
        fPromotionCard.click();

        return this;
    }
}
