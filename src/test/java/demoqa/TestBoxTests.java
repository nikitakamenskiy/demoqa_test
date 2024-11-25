package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {

        String userName = "Nikita Kamenskiy";
        String emailAdress = "erqwe@gmail.com";

        open("/text-box");
        $(".text-center").shouldHave(text("Text Box"));

        $("#userName").setValue(userName);
        $("#userEmail").setValue(emailAdress);
        $("#currentAddress").setValue("dfdfsdfsdsd");
        $("#permanentAddress").setValue("ewrwrewrwrew");
        $("#submit").click();
        $("#output").shouldBe(visible);
        $("#output").$("#name").shouldHave(text(userName));
        $("#output #email").shouldHave(text(emailAdress));
// todo check adresses
    }
}
