package com.think.tasks.events;

import com.think.interactions.SelectGeneralOptions;
import com.think.interactions.events.AddToEvent;
import com.think.models.events.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateAEvent implements Task {

    private final List<Performable> itemsEvent;

    public CreateAEvent() {
        itemsEvent = new ArrayList<>();
    }

    public static CreateAEvent with() {
        return instrumented(CreateAEvent.class);
    }

    public CreateAEvent subject(String subject) {
        this.itemsEvent.add(SelectGeneralOptions.create());
        this.itemsEvent.add(AddToEvent.subject(subject));
        return this;
    }

    public CreateAEvent andDescription(String description) {
        this.itemsEvent.add(AddToEvent.description(description));
        return this;
    }

    public CreateAEvent andProcess(String process) {
        this.itemsEvent.add(AddToEvent.process(process));
        return this;
    }

    public CreateAEvent andArea(String area) {
        this.itemsEvent.add(AddToEvent.area(area));
        return this;
    }

    public CreateAEvent andUsers(List<User> users) {
        this.itemsEvent.add(AddToEvent.addUser());
        this.itemsEvent.add(AddUsers.withInfo(users));
        return this;
    }

    public CreateAEvent andDecider(String decider) {
        this.itemsEvent.add(AddToEvent.decider(decider));
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                eventActions()
        );
    }

    private Performable[] eventActions() {
        this.itemsEvent.add(SelectGeneralOptions.save());
        return this.itemsEvent.toArray(new Performable[this.itemsEvent.size()]);
    }
}
