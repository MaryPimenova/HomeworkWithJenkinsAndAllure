package ru.maruspim.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.maruspim.pages.components.CalendarComponent;
import ru.maruspim.pages.components.ResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPageComponent {
    // Selenide elements / locator / etc
    CalendarComponent calendarComponent = new CalendarComponent();
    ResultsModal resultsModal = new ResultsModal();
    SelenideElement formHeaderText = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            gendersWrapper = $("#genterWrapper"),
            mobileNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            pictureUpload = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateAndCityChoice = $("#stateCity-wrapper"),
            state = $("#state"),
            city = $("#city"),
            submitButton = $("#submit");


    // Actions
    @Step("Open page with url: {pageUrl}")
    public RegistrationPageComponent openPage(String pageUrl) {
        open(pageUrl);
        formHeaderText.shouldHave(text("Student Registration Form"));

        return this;
    }

    @Step("Remove fixed bans and footers")
    public RegistrationPageComponent footerRemoving() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    @Step("Set first name value")
    public RegistrationPageComponent setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    @Step("Set last name value")
    public RegistrationPageComponent setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    @Step("Set user e-mail value")
    public RegistrationPageComponent setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    @Step("Select gender value")
    public RegistrationPageComponent setGenderWrapper(String value) {
        gendersWrapper.$(byText(value)).click();

        return this;
    }

    @Step("Set mobile number")
    public RegistrationPageComponent setMobileNumber(String value) {
        mobileNumberInput.setValue(value);

        return this;
    }

    @Step("Set date (day, month, year)")
    public RegistrationPageComponent setDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    @Step("Set subject")
    public RegistrationPageComponent setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    @Step("Select hobby")
    public RegistrationPageComponent setHobby(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    @Step("Upload picture {value}")
    public RegistrationPageComponent uploadPicture(String value) {
        pictureUpload.uploadFromClasspath(value);

        return this;
    }

    @Step("Set current address")
    public RegistrationPageComponent setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    @Step("Select state of living")
    public RegistrationPageComponent setState(String value) {
        state.click();
        stateAndCityChoice.$(byText(value)).click();

        return this;
    }

    @Step("Select city of living")
    public RegistrationPageComponent setCity(String value) {
        city.click();
        stateAndCityChoice.$(byText(value)).click();

        return this;
    }

    @Step("Click submit button")
    public void clickSubmit() {
        submitButton.click();
    }

    @Step("Verify the appearance of registration results modal")
    public RegistrationPageComponent verifyRegistrationResultsModalAppears() {
        resultsModal.verifyModalAppears();

        return this;
    }

    @Step("Verify results: field {key} contains value --> {value}")
    public RegistrationPageComponent verifyResult(String key, String value) {
        resultsModal.verifyResult(key, value);
        return this;

    }
}
