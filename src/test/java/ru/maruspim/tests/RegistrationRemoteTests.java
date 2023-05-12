package ru.maruspim.tests;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class RegistrationRemoteTests extends TestBase {

    @Feature("Checking DemoQA registration form fulfilling")
    @Owner("Mary Pimenova")
    @Test
    @Tag("remote")
    @DisplayName("DemoQA registration form fulfilling test with annotated steps")
    void successfulFillFormTest() {

        String
                pageUrl = "/automation-practice-form",
                firstName = randomUtils.createRandomFirstName(),
                lastName = randomUtils.createRandomLastName(),
                userEmail = randomUtils.createRandomEmail(),
                gender = randomUtils.createRandomGender(),
                mobileNumber = randomUtils.createRandomMobileNumber(),
                year = randomUtils.createRandomYear(),
                month = randomUtils.createRandomMonth(),
                day = randomUtils.createRandomDay(),
                subject = randomUtils.createRandomSubject(),
                hobby = randomUtils.createRandomHobby(),
                uploadedPicture = "images/batty.jpg",
                currentAddress = randomUtils.createRandomCurrentAddress(),
                state = randomUtils.createRandomState(),
                city = randomUtils.createRandomCity(state);

        step("Open DemoQA registration form: ", () -> {
            registrationPageComponent.openPage(pageUrl)
                    .footerRemoving();
        });
        step("Set first name value: ", () -> {
            registrationPageComponent.setFirstName(firstName);
        });
        step("Set last name value: ", () -> {
            registrationPageComponent.setLastName(lastName);
        });
        step("Set user e-mail value: ", () -> {
            registrationPageComponent.setUserEmail(userEmail);
        });
        step("Select gender value: ", () -> {
            registrationPageComponent.setGenderWrapper(gender);
        });
        step("Set mobile number: ", () -> {
            registrationPageComponent.setMobileNumber(mobileNumber);
        });
        step("Set date (day, month, year): ", () -> {
            registrationPageComponent.setDate(day,month,year);
        });
        step("Set subject: ", () -> {
            registrationPageComponent.setSubjects(subject);
        });
        step("Select hobby: ", () -> {
            registrationPageComponent.setHobby(hobby);
        });
        step("Upload picture: " + uploadedPicture, () -> {
            registrationPageComponent.uploadPicture(uploadedPicture);
        });
        step("Set current address: ", () -> {
            registrationPageComponent.setCurrentAddress(currentAddress);
        });
        step("Select state of living: ", () -> {
            registrationPageComponent.setState(state);
        });
        step("Select city of living: ", () -> {
            registrationPageComponent.setCity(city);
        });
        step("Click submit button: ", () -> {
            registrationPageComponent.clickSubmit();;
        });

        registrationPageComponent.verifyRegistrationResultsModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", mobileNumber)
                .verifyResult("Date of Birth", day + " " + month + "," + year)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobby)
                .verifyResult("Picture", "batty.jpg")
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", state + " " + city);


    }

}
