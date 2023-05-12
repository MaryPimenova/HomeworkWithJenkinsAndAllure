package ru.maruspim.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultsModal {
    // Selenide elements / locator / etc
    SelenideElement resultsModal = $(".modal-content"),
            resultsModalHeader = $("#example-modal-sizes-title-lg"),
            resultsModalBody = $(".table-responsive");
    // Actions
    public void verifyModalAppears() {
        resultsModal.shouldBe(visible);
        resultsModalHeader.shouldHave(text("Thanks for submitting the form"));
    }

    public void verifyResult(String key, String value) {
        resultsModalBody.$(byText(key)).sibling(0).shouldHave(text(value));

    }
}


