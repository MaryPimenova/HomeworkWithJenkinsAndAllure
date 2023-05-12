package ru.maruspim.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.maruspim.pages.RegistrationPageComponent;
import ru.maruspim.utils.RandomUtils;

public class TestBase {
    RegistrationPageComponent registrationPageComponent = new RegistrationPageComponent();
    RandomUtils randomUtils = new RandomUtils();
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy="eager";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true); // активировать потоковое видео при запуске браузера
        capabilities.setCapability("enableVideo", true); // активировать запись видео
        Configuration.browserCapabilities = capabilities;
    }
    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
}