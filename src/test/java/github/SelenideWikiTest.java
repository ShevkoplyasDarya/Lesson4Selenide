package github;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;


public class SelenideWikiTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @AfterEach
    void afterAll() {
        Selenide.closeWebDriver();
    }

    @Test
    void shouldFindSelenideWikiOnGithub() {
        //open selenide page
        open("https://github.com/selenide/selenide");
        //open Wiki
        $("#wiki-tab").click();
        // check if page Soft assertions is present
        $("#wiki-body").shouldHave(text("Soft assertions"));
        //open page SoftAssertions
        $("#wiki-body").$(byText("Soft assertions")).click();
        //find code for JUnit5
        $("#wiki-body").shouldHave(text("JUnit5"), text("@ExtendWith({SoftAssertsExtension.class})"));
    }

}
