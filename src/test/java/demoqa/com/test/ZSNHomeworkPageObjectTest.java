package demoqa.com.test;

import com.codeborne.selenide.Configuration;
import demoqa.com.data.ZSNPageObjectData;
import demoqa.com.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ZSNHomeworkPageObjectTest {
    @BeforeAll
    static void setup() {
        Configuration.browserSize = "1500x840";
        Configuration.browserPosition = "0x0";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillAutomationPracticeForm() {
        ZSNPageObjectData testPerson = new ZSNPageObjectData();
        new RegistrationPage()
                .openPage()
                .setDataToForm(testPerson)
                .clickSubmitButton()
                .assertData(testPerson);
    }
}