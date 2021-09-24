package doc.dobedkina.tests;

import doc.dobedkina.enumClasses.ToolsQaItems;
import doc.dobedkina.pages.MainPage;
import doc.dobedkina.pages.TextBoxFormPage;
import doc.dobedkina.testData.TextBoxFormData;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Configuration.startMaximized;

@Feature("Parametrized Tests")
@Owner("Daria Obedkina")
public class ParametrizedTests {
    private static TextBoxFormData textBoxFormData1 = new TextBoxFormData();
    private static TextBoxFormData textBoxFormData2 = new TextBoxFormData();
    private TextBoxFormPage textBoxFormPage = new TextBoxFormPage();
    private MainPage mainPage = new MainPage();

    static Stream<Arguments> textBoxFormFields() {
        return Stream.of(
                Arguments.of(textBoxFormData1),
                Arguments.of(textBoxFormData2)
        );

    }

    @BeforeEach
    void setUp() {
        startMaximized = true;
    }

    @CsvSource({
            "Ivan Ivanov,someemail@qqq.ert,Moscow Test str. 12, Moscow Test str. 25, Форма TextBox; имя и адреса на английском",
            "Мария Иванова,maria123@gmail.com, Tver Test str. 123, Moscow Test. str. 43, Форма TextBox; имя на русском + адреса на английском",
            "Петр Петров,qwerty@yandex.ru, Москва Тестовая ул. 89, Париж Тестовый пер. 87, Форма TextBox; имя и адреса на русском"
    })

    @ParameterizedTest(name = "{4}")
    void checkTextBoxFormFilling(String userName, String email, String currentAddress, String permanentAddress, String testName) {
        textBoxFormPage.openPage();

        textBoxFormPage.enterUserName(userName);
        textBoxFormPage.enterUserEmail(email);
        textBoxFormPage.enterCurrentAddress(currentAddress);
        textBoxFormPage.enterPermanentAddress(permanentAddress);
        textBoxFormPage.submitForm();

        textBoxFormPage.checkThatUserNameIsDisplayed(userName);
        textBoxFormPage.checkThatEmailIsDisplayed(email);
        textBoxFormPage.checkThatCurrentAddressIsDisplayed(currentAddress);
        textBoxFormPage.checkThatPermanentAddressIsDisplayed(permanentAddress);

    }

    @EnumSource(value = ToolsQaItems.class, names = {"BOOKS"}, mode = EnumSource.Mode.EXCLUDE)
    @ParameterizedTest(name = "Проверка текста \"Please select an item from left to start practice.\" на странице " + "{0}")
    void checkTextForSeveralPages(ToolsQaItems toolsQaItem) {
        mainPage.openPage();
        mainPage.goToPage(toolsQaItem.getDescription());

        mainPage.checkTextOnPage("Please select an item from left to start practice.");

    }

    @MethodSource("textBoxFormFields")
    @ParameterizedTest(name = "Заполнение формы TextBox случайными данными")
    void testWithMethodSource(TextBoxFormData textBoxFormData) {
        textBoxFormPage.openPage();

        textBoxFormPage.enterUserName(textBoxFormData.getUserName());
        textBoxFormPage.enterUserEmail(textBoxFormData.getUserEmail());
        textBoxFormPage.enterCurrentAddress(textBoxFormData.getCurrentAddress());
        textBoxFormPage.enterPermanentAddress(textBoxFormData.getPermanentAddress());
        textBoxFormPage.submitForm();

        textBoxFormPage.checkThatUserNameIsDisplayed(textBoxFormData.getUserName());
        textBoxFormPage.checkThatEmailIsDisplayed(textBoxFormData.getUserEmail());
        textBoxFormPage.checkThatCurrentAddressIsDisplayed(textBoxFormData.getCurrentAddress());
        textBoxFormPage.checkThatPermanentAddressIsDisplayed(textBoxFormData.getPermanentAddress());

    }
}
