package doc.dobedkina;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Configuration.startMaximized;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class ParametrizedTests {

    @BeforeEach
    void setUp() {
        startMaximized = true;
    }

    @CsvSource({
            "Ivan Ivanov,someemail@qqq.ert,Moscow Test str. 12, Moscow Test str. 25, Имя и адреса на английском",
            "Мария Иванова,maria123@gmail.com, Tver Test str. 123, Moscow Test. str. 43, Имя на русском + адреса на английском",
            "Петр Петров,qwerty@yandex.ru, Москва Тестовая ул. 89, Париж Тестовый пер. 87, Имя и адреса на русском"
    })

    @ParameterizedTest(name = "{4}")
    void checkTextBoxElementFilling(String fullName, String email, String currentAddress, String permanentAddress, String testName) {
        open("https://demoqa.com/text-box");
        $("#userName").setValue(fullName);
        $("#userEmail").setValue(email);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);
        $("#submit").click();

        $("#output #name").shouldHave(Condition.text(fullName));
        $("#output #email").shouldHave(Condition.text(email));
        $("#output #currentAddress").shouldHave(Condition.text(currentAddress));
        $("#output #permanentAddress").shouldHave(Condition.text(permanentAddress));

    }


}
