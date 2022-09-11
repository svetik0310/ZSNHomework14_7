package demoqa.com.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import demoqa.com.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseTest {
    @BeforeAll
    static void setup() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
       // capabilities.setCapability("browserName", "chrome");
       // capabilities.setCapability("browserVersion", "105.0");
        Configuration.browserCapabilities = capabilities;
        Configuration.browserSize = "1500x840";
        Configuration.browserPosition = "0x0";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.attachLog("Browser console log");
        Attach.pageSource();
        Attach.takeScreenshot();
        Attach.addVideo();
        Selenide.closeWebDriver();
    }
}
