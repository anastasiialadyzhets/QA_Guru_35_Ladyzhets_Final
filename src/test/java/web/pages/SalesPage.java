package web.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class SalesPage extends MainPage{
    public SalesPage addItemToBasket(){
        $("[class='product-card product-card product']").scrollIntoView(true);
        //$(byText("Купить")).scrollIntoView(true);
        $("[class='product-buttons buttons product-card__controls']").click();

        return this;
    }
    public SalesPage chekoutAfterAddItemToBasket(){//openPage(String page){
       sleep(2000);
        $("[class='product-buttons buttons product-card__controls']").click();

        return this;
    }
}
