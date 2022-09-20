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
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browserPosition = "0x0";
        Configuration.browser = System.getProperty("browser_name", "chrome");
        Configuration.browserVersion = System.getProperty("browser_version", "105.0");
        Configuration.browserSize = System.getProperty("browser_size", "760x840");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = "https://demoqa.com";
     /*   Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";*/
        if (System.getProperty("remote") != null) {
            Configuration.remote = System.getProperty("remote");
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
        }
    }

    @AfterEach
    void addAttachments() {
        Attach.attachLog("Browser console log");
        Attach.pageSource();
        Attach.takeScreenshot();
        if (System.getProperty("remote") != null) {Attach.addVideo();}
        Selenide.closeWebDriver();
    }
}
