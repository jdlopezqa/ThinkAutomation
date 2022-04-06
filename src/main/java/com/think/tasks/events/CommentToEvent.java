package com.think.tasks.events;

import com.think.interactions.events.AddToEvent;
import com.think.interactions.generics.SendKeysTo;
import com.think.models.events.Comment;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;

import static com.think.ui.events.CommentEventPage.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class CommentToEvent implements Task {

    private final List<Comment> comments;

    public CommentToEvent(List<Comment> comments) {
        this.comments = comments;
    }

    public static CommentToEvent withData(List<Comment> coments) {
        return instrumented(CommentToEvent.class, coments);
    }

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                AddToEvent.goToDiscussion(),
                Click.on(BTN_EXPANDS_COMMENTS)
        );

        for (Comment comment : comments) {
            actor.attemptsTo(
                   AddComment.withDescription(comment.getDescription())
            );
            actor.should(
                    seeThat("the comment is displayed",
                            the(COMMENT.of(comment.getDescription())), isVisible())
            );
        }

    }
}
