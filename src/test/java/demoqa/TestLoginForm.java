package demoqa;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TestLoginForm {
    @CsvFileSource(resources = "/testData.csv")

    @ParameterizedTest

    @Tags({@Tag("BLOCKER"), @Tag("UI_TEST")})
    void testLoginForm(
            String userName,
            String password) {
        open("https://demoqa.com/login");
        $("#userName").setValue(userName);
        $("#password").setValue(password);

    }

}
