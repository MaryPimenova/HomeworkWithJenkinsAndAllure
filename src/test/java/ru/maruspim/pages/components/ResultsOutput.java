package ru.maruspim.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class ResultsOutput {

    // Selenide elements / locator / etc
    SelenideElement outputBox = $("#output");
    SelenideElement name = $("#name");

    // Actions
    public void verifyOutputAppears() {
        outputBox.shouldBe(visible);
    }

    public void verifyResult(String key, String value) {
       outputBox.$(byText(key)).shouldHave(text(value));

    }
}
