package web.pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class SalesPage extends MainPage{
    public SalesPage addItemToBasket(){
        $("[class='product-card app-products-list__item']").scrollIntoView(true);
        $("[class='chg-app-button chg-app-button--primary chg-app-button--s chg-app-button--brand-blue product-buttons__main-action product-buttons__main-action']").click();

        return this;
    }
    public SalesPage chekoutAfterAddItemToBasket(){
        $("[class='chg-app-button chg-app-button--primary chg-app-button--s chg-app-button--green product-buttons__main-action product-buttons__main-action']").shouldBe(Condition.visible);
        $("[class='chg-app-button chg-app-button--primary chg-app-button--s chg-app-button--green product-buttons__main-action product-buttons__main-action']").click();

        return this;
    }
}
