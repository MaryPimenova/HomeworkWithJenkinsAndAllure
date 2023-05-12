package ru.maruspim.tests;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class RegistrationRemoteTests extends TestBase {

    @Test
    @Tag("remote")
    void successfulFillFormTest() {

        String
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
                currentAddress = randomUtils.createRandomCurrentAddress(),
                state = randomUtils.createRandomState(),
                city = randomUtils.createRandomCity(state);

        registrationPageComponent.openPage("/automation-practice-form")
                .footerRemoving()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGenderWrapper(gender)
                .setMobileNumber(mobileNumber)
                .setDate(day,month,year)
                .setSubjects(subject)
                .setHobby(hobby)
                .uploadPicture("images/batty.jpg")
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .clickSubmit();

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
