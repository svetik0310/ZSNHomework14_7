package demoqa.com.pages;

import com.codeborne.selenide.selector.ByText;
import demoqa.com.data.ZSNPageObjectData;
import demoqa.com.pages.component.ResultModal;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;

public class RegistrationPage {

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        attachment("Source", webdriver().driver().source());
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    void setFirstName(String value) {
        $("#firstName").setValue(value);
    }

    void setLastName(String value) {
        $("#lastName").setValue(value);
    }

    void setUserEmail(String value) {
        $("#userEmail").setValue(value);
    }

    void setGenterWrapper(String value) {
        $("#genterWrapper").find(new ByText(value)).click();
    }

    void setUserNumber(String value) {
        $("#userNumber").setValue(value);
    }

    void setDateOfBirthInput(String value) {
        $("#dateOfBirthInput").sendKeys(Keys.CONTROL + "a");
        $("#dateOfBirthInput").sendKeys(value + Keys.ENTER);
    }

    void setHobbiesWrapper(String value) {
        $("#hobbiesWrapper").find(new ByText(value)).click();
    }

    void setUploadPicture(String value) {
        $("#uploadPicture").uploadFile(new File("src/test/resources/" + value));
    }

    void setCurrentAddress(String value) {
        $("#currentAddress").setValue(value);
    }

    void setState(String value) {
        $("#state").click();
        $(byText(String.valueOf(value))).click();
    }

    void setCity(String value) {
        $("#city").click();
        $(byText(String.valueOf(value))).click();
    }

    void setSubjects(String[] value) {
        for (String s : value) {
            $("#subjectsInput").setValue(s).pressEnter();
        }
    }

    public RegistrationPage setDataToForm(ZSNPageObjectData data) {
        setFirstName(data.getFirstName());
        setLastName(data.getLastName());
        setUserEmail(data.getEmail());
        setGenterWrapper(data.getGender());
        setUserNumber(data.getMobile());
        setDateOfBirthInput(data.getDateOfBirth());
        setHobbiesWrapper(data.getHobbies());
        setUploadPicture(data.getPicture());
        setCurrentAddress(data.getCurrentAddress());
        setState(data.getState());
        setCity(data.getCity());
        setSubjects(data.getSubjects());
        return this;
    }

    public RegistrationPage clickSubmitButton() {
        $("#submit").click();
        return this;
    }

    public RegistrationPage assertData(ZSNPageObjectData data) {
        ResultModal result = new ResultModal().checkVisiable();
        result.checkData("Student Name", data.getFirstName() + " " + data.getLastName());
        result.checkData("Student Email", data.getEmail());
        result.checkData("Gender", data.getGender());
        result.checkData("Mobile", data.getMobile());
        result.checkData("Hobbies", data.getHobbies());
        result.checkData("Address", data.getCurrentAddress());
        result.checkData("State and City", data.getState() + " " + data.getCity());
        result.checkData("Picture", data.getPicture());
        result.checkData("Subjects", "Maths, Computer Science");
        result.checkData("Date of Birth", data.getDateOfBirth());
        result.checkData("Mobile", data.getMobile());
        return this;
    }
}