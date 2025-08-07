package web.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class SalesPage extends MainPage{
    public SalesPage addItemToBasket(){
        $("[class='product-card app-products-list__item']").scrollIntoView(true);
        //$(byText("Купить")).scrollIntoView(true);
        $("[class='chg-app-button chg-app-button--primary chg-app-button--s chg-app-button--brand-blue product-buttons__main-action product-buttons__main-action']").click();

        return this;
    }
    public SalesPage chekoutAfterAddItemToBasket(){//openPage(String page){
       sleep(2000);
        $("[class='chg-app-button chg-app-button--primary chg-app-button--s chg-app-button--green product-buttons__main-action product-buttons__main-action']").click();

        return this;
    }
}
