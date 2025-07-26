package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;


public class MainPage {
    public MainPage openPage(String page){//openPage(String page){
        open(page);
       // executeJavaScript("$('tippy').remove()");
        sleep(3000);
        $("[class='chg-app-button__content']").click();

        return this;
    }

    public MainPage clickBottomMenuElement(String itemName){
        $(byText(itemName)).click();

        return this;
    }

    public MainPage openCatalog( ) {//openPage(String page){
        $("[class='chg-app-button__content']").click();
        return this;
    }
}
