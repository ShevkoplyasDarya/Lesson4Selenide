package github;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;


public class MoveSquaresTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @AfterEach
    void afterAll() {
        Selenide.closeWebDriver();
    }

    @Test
    void MoveSquares() {
        // open page internet.herokuapp
        open("https://the-internet.herokuapp.com/drag_and_drop");
        //find squares A & B
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        //move square A
        $("#column-a").dragAndDropTo($("#column-b"));
        //check if squares moved
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));

    }


}
