package com.think.tasks.events;

import com.think.interactions.generics.SendKeysTo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.think.ui.events.CommentEventPage.ADD_COMMENT;
import static com.think.ui.events.CommentEventPage.LINK_COMMENT;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddComment implements Task {

    private final String description;

    public AddComment(String description) {
        this.description = description;
    }

    public static Performable withDescription(String description) {
        return instrumented(AddComment.class, description);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LINK_COMMENT),
                SendKeysTo.currentFocusWith(description),
                Click.on(ADD_COMMENT)
        );
    }
}
