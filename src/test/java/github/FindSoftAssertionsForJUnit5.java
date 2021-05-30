package github;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class FindSoftAssertionsForJUnit5 {

    static Logger log = LoggerFactory.getLogger(FindSoftAssertionsForJUnit5.class);

    @Test
    void shouldFindSoftAssertionsForJUnit5() {

        open("https://github.com");
        $("[name=q]").setValue("Selenide").pressEnter();
        $$("ul.repo-list li a").findBy(href("/selenide/selenide")).click();
        $(byText("Wiki")).click();
        $(".wiki-more-pages-link button").click();
        $$(".Box-row").find(text("SoftAssertions")).click();
        log.info("SoftAssertions page is present in the wiki right bar");

        $$(".markdown-body ol li").findBy(text("Using JUnit5")).shouldBe(visible);
        log.info("SoftAssertions example code for JUnit5 is present on the SoftAssertion wiki page");
    }

}