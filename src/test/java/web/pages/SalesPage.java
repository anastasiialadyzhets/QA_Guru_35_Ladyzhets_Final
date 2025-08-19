package web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SalesPage extends MainPage{
    private final SelenideElement addToCartBtn = $("[class='chg-app-button chg-app-button--primary chg-app-button--s chg-app-button--brand-blue product-buttons__main-action product-buttons__main-action']"),
            productCardItem = $("[class='product-card app-products-list__item']"),
            chekoutBtn = $("[class='chg-app-button chg-app-button--primary chg-app-button--s chg-app-button--green product-buttons__main-action product-buttons__main-action']");

    public SalesPage addItemToBasket(){
        productCardItem.scrollIntoView(true);
        addToCartBtn.click();

        return this;
    }
    public SalesPage chekoutAfterAddItemToBasket(){
        chekoutBtn.shouldBe(Condition.visible);
        chekoutBtn.click();

        return this;
    }
}
