package doc.dobedkina.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private final String URL = "https://demoqa.com/";

    //Действия
    @Step("Открываем страницу {URL}")
    public MainPage openPage() {
        open(URL);
        return this;
    }

    @Step("Переходим на страницу {pageName}")
    public MainPage goToPage(String pageName) {
        $(".category-cards").$(byText(pageName)).click();
        return this;
    }

    //Проверки
    @Step("Проверяем наличие на странице текста {text}")
    public void checkTextOnPage(String text) {
        $("html").shouldHave(Condition.text("Please select an item from left to start practice."));
    }


}

