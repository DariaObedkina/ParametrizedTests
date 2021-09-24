package doc.dobedkina.testData;

import com.github.javafaker.Faker;

public class TextBoxFormData {
    private static Faker faker = new Faker();

    private String userName;
    private String userEmail;
    private String currentAddress;
    private String permanentAddress;


    public TextBoxFormData() {
        this.userName = faker.name().fullName();
        this.userEmail = faker.internet().emailAddress();
        this.currentAddress = faker.address().fullAddress();
        this.permanentAddress = faker.address().fullAddress();
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }
}
