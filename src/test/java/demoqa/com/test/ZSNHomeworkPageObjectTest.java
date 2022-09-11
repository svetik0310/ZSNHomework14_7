package demoqa.com.test;

import demoqa.com.data.ZSNPageObjectData;
import demoqa.com.pages.RegistrationPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class ZSNHomeworkPageObjectTest extends BaseTest {
    @Feature("Registration form test")
    @DisplayName("Fill out the registration form")
    @Test
    void fillAutomationPracticeForm() {
        ZSNPageObjectData testPerson = new ZSNPageObjectData();
        RegistrationPage registrationPage = new RegistrationPage();
        step("Open page, fill the form, submit", () -> registrationPage
                .openPage()
                .setDataToForm(testPerson)
                .clickSubmitButton());
        step("Assert data in registration form", () -> registrationPage.assertData(testPerson));
    }
}