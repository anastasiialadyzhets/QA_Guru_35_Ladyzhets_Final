package web.pages;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;


public class MainPage {
    public MainPage openPage(String page){
        open(page);
        sleep(3000);
        $("[class='chg-app-button__content']").click();

        return this;
    }

    public MainPage clickBottomMenuElement(String itemName){
        $(byText(itemName)).click();

        return this;
    }

    public MainPage openCatalog( ) {
        $("[class='chg-app-button__content']").click();

        return this;
    }
}
