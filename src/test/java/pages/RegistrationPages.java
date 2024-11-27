package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import javax.security.auth.Subject;
import java.awt.*;
import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPages {
    private  CalendarComponent calendarComponent = new CalendarComponent();
    private final String TITLE_TEXT = "Student Registration Form";
    private final String IMG_FOLDER = "img/";
    private SelenideElement

    firtNameInput = $("#firstName"),
    lastNameInput = $("#lastName"),
    emailInput = $("#userEmail"),
    userPhoneNumberInput = $("#userNumber"),
    choiceGenderInput = $("#genterWrapper"),
    dateOfBirthInput = $("#dateOfBirthInput"),
    HobbieInput = $("#hobbiesWrapper"),
    pictureUpload = $("#uploadPicture"),
    currentAddressInput = $("#currentAddress"),
    stateDropDown = $("#state"),
    stateAndCityChoice = $("#stateCity-wrapper"),
    cityDropDown = $("#city"),
    subjectInput = $("#subjectsInput"),
    submitButton = $("#submit");


    public RegistrationPages openPage () {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;

    }

    public RegistrationPages setFirstName (String value) {
        firtNameInput.setValue(value);

        return this;
    }

    public RegistrationPages setLastName (String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPages setEmail (String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPages setPhoneUserNumber (String value) {
        userPhoneNumberInput.setValue(value);

        return this;
    }

    public RegistrationPages setGender (String value) {
        choiceGenderInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPages setBirthDate (String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPages setHobbies (String value) {
        HobbieInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPages setPicture(String value){
        pictureUpload.uploadFromClasspath(IMG_FOLDER + value);
        return this;
    }

    public RegistrationPages setCurrentAddress (String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public RegistrationPages setStateState (String value) {
        stateDropDown.click();
        stateAndCityChoice.$(byText(value)).click();

        return this;
    }
    public RegistrationPages setStateCity (String value) {
        cityDropDown.click();
        stateAndCityChoice.$(byText(value)).click();

        return this;
    }

    public RegistrationPages setSubject (String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPages submit () {
        submitButton.click();

        return this;
    }

}
