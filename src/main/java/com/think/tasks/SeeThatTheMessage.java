package com.think.tasks;

import com.think.enums.ButtonOption;
import com.think.enums.Messages;
import com.think.questions.TextFound;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.think.ui.components.ResponsePage.BUTTON;
import static com.think.ui.components.ResponsePage.MESSAGE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.hamcrest.core.IsEqual.equalTo;

public class SeeThatTheMessage implements Task {

    private final Messages messages;
    private ButtonOption buttonOption;
    private boolean option = false;

    public SeeThatTheMessage(Messages messages) {
        this.messages = messages;
    }

    public static SeeThatTheMessage areExpected(Messages messages) {
        return instrumented(SeeThatTheMessage.class, messages);
    }

    public SeeThatTheMessage andSelectOption(ButtonOption buttonOption) {
        this.buttonOption = buttonOption;
        option = true;
        return this;
    }


    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.should(
                seeThat("the display message", TextFound.in(MESSAGE),
                        equalTo(messages.getText()))
        );

        if (option) {
            actor.attemptsTo(
                    Click.on(BUTTON.of(buttonOption.getText()))
            );
        }

        Thread.sleep(1000);
    }
}
