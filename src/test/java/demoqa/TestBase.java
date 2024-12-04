package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPages;

public class TestBase {
    RegistrationPages registrationPages = new RegistrationPages();
    TestData testData = new TestData();
    @BeforeAll
    static void beforAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }
}
