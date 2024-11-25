package demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestPracticeForm {

    @BeforeAll
    static void beforAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void practiceForm() {

        open("/automation-practice-form");
        $(".text-center").shouldHave(text("Practice Form"));

        String FirstName = "Nikita";
        String LastName = "Kamenskiy";
        String Email = "nikitakamenskiy@gmail.com";
        String Mobile = "2313121113";
        String currentAddress = "Nfwefwfewf fewfewfwef";
        String Subjects = "Computer Science";
        String nameFile = "Img.jpg";

        $("#firstName").setValue(FirstName);
        $("#lastName").setValue(LastName);
        $("#userEmail").setValue(Email);
        $(".custom-control-label").click();
        $("#userNumber").setValue(Mobile);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-container").shouldBe(visible);
        $(".react-datepicker__day--017").click();
        $(".subjects-auto-complete__control").click();
        $("#subjectsInput").setValue(Subjects).pressEnter();
        $("label[for='hobbies-checkbox-1']").click();
        $("label[for='hobbies-checkbox-2']").click();
        $("#uploadPicture").uploadFile(new File("src/test/java/demoqa/resources/" +nameFile));
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-0").click();
        $("#submit").click();
        //result check
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table").$(new ByText("Student Name")).sibling(0).shouldHave(text(FirstName + " " + LastName));
        $(".table").$(new ByText("Student Email")).sibling(0).shouldHave(text(Email));
        // Gender доделать
        $(".table").$(new ByText("Mobile")).sibling(0).shouldHave(text(Mobile));
        // Date of Birth
        $(".table").$(new ByText("Subjects")).sibling(0).shouldHave(text(Subjects));
       // доделать Hobbies
        $(".table").$(new ByText("Picture")).sibling(0).shouldHave(text(nameFile));
        $(".table").$(new ByText("Address")).sibling(0).shouldHave(text(currentAddress));




















    }
}
