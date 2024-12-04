package demoqa;

import org.junit.jupiter.api.Test;
import pages.RegistrationPages;

import static com.codeborne.selenide.Selenide.$;


public class TestPracticePageObjectForm extends TestBase {


    @Test
    void practiceForm() {


        registrationPages.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setPhoneUserNumber(testData.mobile)
                .setBirthDate(testData.birthDay, testData.birthMonth, testData.birthYear)
                .setSubject(testData.subject)
                .setHobbies(testData.hobby)
                .setPicture(testData.img)
                .setCurrentAddress(testData.currentAddress)
                .setStateState(testData.state)
                .setStateCity(testData.city)
                .submit();
        registrationPages.verifyResultsModalAppears()
                .verifyResult("Student Name", testData.fullName)
                .verifyResult("Student Email", testData.email)
                .verifyResult("Gender", testData.gender)
                .verifyResult("Mobile", testData.mobile)
                .verifyResult("Date of Birth", testData.fullBirthDay)
                .verifyResult("Subjects", testData.subject)
                .verifyResult("Hobbies", testData.hobby)
                .verifyResult("Picture", testData.img)
                .verifyResult("Address", testData.currentAddress)
                .verifyResult("State and City", testData.fullStateAndCity);


    }
}
