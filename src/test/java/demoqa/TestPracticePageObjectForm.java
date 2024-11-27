package demoqa;

import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.Test;
import java.io.File;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class TestPracticePageObjectForm extends TestBase {


    @Test
    void practiceForm() {

        String firstName = "Nikita";
        String lastName = "Kamenskiy";
        String email = "nikitakamenskiy@gmail.com";
        String mobile = "2313121113";
        String currentAddress = "Nfwefwfewf fewfewfwef";
        String Subjects = "Computer Science";
        String gender = "Other";
        String BirthDay = "25";
        String BirthMonth = "July";
        String BirthYear = "2000";
        String Hobbies = "Sports";
        String img = "img.jpg";
        String State = "NCR";
        String City = "Agra";

        registrationPages.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhoneUserNumber(mobile)
                .setBirthDate(BirthDay, BirthMonth, BirthYear)
                .setSubject(Subjects)
                .setHobbies(Hobbies)
                .setPicture(img)
                .setCurrentAddress(currentAddress)
                .setStateState(State)
                .setStateCity(City)
                .submit();



    }
}
