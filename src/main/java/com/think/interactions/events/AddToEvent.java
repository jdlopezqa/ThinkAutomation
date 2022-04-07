package com.think.interactions.events;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static com.think.ui.events.CreateEventPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddToEvent {

    public static Performable subject(String subject) {
        return Task.where("{0} add a subject #subject",
                Enter.theValue(subject).into(SUBJECT))
                .with("subject").of(subject);
    }

    public static Performable description(String description) {
        return Task.where("{0} add a description #description",
                Enter.theValue(description).into(DESCRIPTION))
                .with("description").of(description);
    }

    public static Performable process(String process) {
        return Task.where("{0} add a process #process",
                Enter.theValue(process).into(PROCESS)
                        .then(Click.on(OPTION_AUTOCOMPLETE.of(process))))
                .with("process").of(process);
    }

    public static Performable area(String area) {
        return Task.where("{0} add a area #area",
                Enter.theValue(area).into(AREA)
                        .then(Click.on(OPTION_AUTOCOMPLETE.of(area))))
                .with("area").of(area);
    }

    public static Performable addUser() {
        return Task.where("{0} clicks on add user option",
                Click.on(ADD_USER)
        );
    }

    public static Performable decider(String user) {
        return Task.where("{0} clicks on decider for user #user",
                Click.on(DECIDER.of(user))
        ).with("user").of(user);
    }

    public static Performable goToDiscussion() {
        return Task.where("{0} clicks on go to discussion",
                WaitUntil.the(GO_TO_DISCUSSION, isVisible()).forNoMoreThan(Duration.ofSeconds(10)),
                Click.on(GO_TO_DISCUSSION)
        );
    }

}
