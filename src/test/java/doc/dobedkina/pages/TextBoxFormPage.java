package doc.dobedkina.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxFormPage {
    private final String URL = "https://demoqa.com/text-box";

    @Step("Открываем страницу + {URL}")
    public void openPage() {
        open(URL);
    }

    //Заполнение формы
    @Step("Вводим в форму ФИО")
    public void enterUserName(String userName) {
        $("#userName").setValue(userName);
    }

    @Step("Вводим в форму email")
    public void enterUserEmail(String email) {
        $("#userEmail").setValue(email);
    }

    @Step("Вводим в форму адрес текущего места жительства")
    public void enterCurrentAddress(String currentAddress) {
        $("#currentAddress").setValue(currentAddress);
    }

    @Step("Вводим в форму постоянный адрес")
    public void enterPermanentAddress(String permanentAddress) {
        $("#permanentAddress").setValue(permanentAddress);
    }

    @Step("Нажимаем кнопку Submit")
    public void submitForm() {
        $("#submit").click();
    }

    //Проверки
    @Step("Проверяем отображение ФИО")
    public void checkThatUserNameIsDisplayed(String userName) {
        $("#output #name").shouldHave(Condition.text(userName));
    }

    @Step("Проверяем отображение email")
    public void checkThatEmailIsDisplayed(String email) {
        $("#output #email").shouldHave(Condition.text(email));
    }

    @Step("Проверяем отображение адреса текущего места жительства")
    public void checkThatCurrentAddressIsDisplayed(String currentAddress) {
        $("#output #currentAddress").shouldHave(Condition.text(currentAddress));
    }

    @Step("Проверяем отображение постоянного адреса")
    public void checkThatPermanentAddressIsDisplayed(String permanentAddress) {
        $("#output #permanentAddress").shouldHave(Condition.text(permanentAddress));
    }

}
