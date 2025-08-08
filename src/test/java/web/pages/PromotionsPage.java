package web.pages;

import static com.codeborne.selenide.Selenide.$;

public class PromotionsPage extends MainPage{
    public PromotionsPage openFirstPromotionCard(){
        $("[class='block-promotion-card']").click();

        return this;
    }
}
