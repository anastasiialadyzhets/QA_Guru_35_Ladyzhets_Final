package web.pages;

import com.codeborne.selenide.SelenideElement;
import web.pages.components.MainPageComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;


public class MainPage {
    public MainPageComponent mainPageComponent = new MainPageComponent();
    private final SelenideElement chgAppBtn = $("[class='chg-app-button__content']");

    public MainPage openPage(String page) throws InterruptedException {
        open(page);
        chgAppBtn.shouldBe(visible);
        chgAppBtn.click();

        return this;
    }

    public MainPage clickBottomMenuElement(String itemName){
        $(byText(itemName)).click();

        return this;
    }

    public MainPage openCatalog( ) {
        chgAppBtn.shouldBe(visible);
        chgAppBtn.click();

        return this;
    }
}
