package doc.dobedkina.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxFormPage {
    private final String URL = "https://demoqa.com/text-box";

    @Step("Открываем страницу + {URL}")
    public TextBoxFormPage openPage() {
        open(URL);
        return this;
    }

    //Заполнение формы
    @Step("Вводим в форму ФИО")
    public TextBoxFormPage enterUserName(String userName) {
        $("#userName").setValue(userName);
        return this;
    }

    @Step("Вводим в форму email")
    public TextBoxFormPage enterUserEmail(String email) {
        $("#userEmail").setValue(email);
        return this;
    }

    @Step("Вводим в форму адрес текущего места жительства")
    public TextBoxFormPage enterCurrentAddress(String currentAddress) {
        $("#currentAddress").setValue(currentAddress);
        return this;
    }

    @Step("Вводим в форму постоянный адрес")
    public TextBoxFormPage enterPermanentAddress(String permanentAddress) {
        $("#permanentAddress").setValue(permanentAddress);
        return this;
    }

    @Step("Нажимаем кнопку Submit")
    public void submitForm() {
        $("#submit").click();
    }

    //Проверки
    @Step("Проверяем отображение ФИО")
    public TextBoxFormPage checkThatUserNameIsDisplayed(String userName) {
        $("#output #name").shouldHave(Condition.text(userName));
        return this;
    }

    @Step("Проверяем отображение email")
    public TextBoxFormPage checkThatEmailIsDisplayed(String email) {
        $("#output #email").shouldHave(Condition.text(email));
        return this;
    }

    @Step("Проверяем отображение адреса текущего места жительства")
    public TextBoxFormPage checkThatCurrentAddressIsDisplayed(String currentAddress) {
        $("#output #currentAddress").shouldHave(Condition.text(currentAddress));
        return this;
    }

    @Step("Проверяем отображение постоянного адреса")
    public void checkThatPermanentAddressIsDisplayed(String permanentAddress) {
        $("#output #permanentAddress").shouldHave(Condition.text(permanentAddress));
    }

}
