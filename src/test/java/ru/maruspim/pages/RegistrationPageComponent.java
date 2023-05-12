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
    public RegistrationPageComponent openPage(String pageUrl) {
        open(pageUrl);
        formHeaderText.shouldHave(text("Student Registration Form"));

        return this;
    }
    public RegistrationPageComponent footerRemoving () {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }
    public RegistrationPageComponent setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }
    public RegistrationPageComponent setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }
    public RegistrationPageComponent setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }
    public RegistrationPageComponent setGenderWrapper(String value) {
        gendersWrapper.$(byText(value)).click();

        return this;
    }
    @Step("Opening the tab Issues")
    public RegistrationPageComponent setMobileNumber(String value) {
        mobileNumberInput.setValue(value);

        return this;
    }
    public RegistrationPageComponent setDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }
    public RegistrationPageComponent setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }
    public RegistrationPageComponent setHobby(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }
    public RegistrationPageComponent uploadPicture(String value) {
        pictureUpload.uploadFromClasspath(value);

        return this;
    }
    public RegistrationPageComponent setCurrentAddress(String value) {
       currentAddressInput.setValue(value);

        return this;
    }
    public RegistrationPageComponent setState(String value) {
        state.click();
        stateAndCityChoice.$(byText(value)).click();

        return this;
    }
    public RegistrationPageComponent setCity(String value) {
        city.click();
        stateAndCityChoice.$(byText(value)).click();

        return this;
    }
    public void clickSubmit() {
        submitButton.click();
    }

    public RegistrationPageComponent verifyRegistrationResultsModalAppears() {
        resultsModal.verifyModalAppears();

        return this;
    }

    public RegistrationPageComponent verifyResult(String key, String value) {
        resultsModal.verifyResult(key, value);
        return this;

    }
}
