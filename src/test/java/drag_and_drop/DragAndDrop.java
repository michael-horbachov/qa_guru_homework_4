package drag_and_drop;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDrop {

    static Logger log = LoggerFactory.getLogger(DragAndDrop.class);

    @Test
    void shouldDragAndDrop() {

        open("https://the-internet.herokuapp.com/drag_and_drop");
        $$(".column").first().shouldHave(text("A"));
        log.info("The first rectangle is A");
        $("#column-a").dragAndDropTo($("#column-b"));
        $$(".column").first().shouldHave(text("B"));
        log.info("The first rectangle is B");
    }

}