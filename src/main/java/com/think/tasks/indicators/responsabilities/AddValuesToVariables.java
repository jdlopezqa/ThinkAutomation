package com.think.tasks.indicators.responsabilities;

import com.think.interactions.indicators.responsabilities.ValuesToEnterIndicator;
import com.think.models.indicators.variables.Variable;
import com.think.tasks.SeeThatTheMessage;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static com.think.enums.Memory.NUMBER;
import static com.think.enums.Memory.VALUES_TO_VARIABLE;
import static com.think.enums.Messages.SUCCESSFULLY_SAVED;
import static com.think.ui.indicators.responsabilities.ValuesToEnterPage.COUNT_VALUES;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class AddValuesToVariables implements Task {

    private final Variable variable;

    public AddValuesToVariables(Variable variable) {
        this.variable = variable;
    }

    public static AddValuesToVariables withInfo(Variable variable) {
        return instrumented(AddValuesToVariables.class, variable);
    }

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {
        Thread.sleep(1000);
        actor.attemptsTo(
                ValuesToEnterIndicator.searchVariableWithName(variable.getName()),
                ValuesToEnterIndicator.clickVariousButton(variable.getName()),
                AddValuesToVariable.withInfo(variable)
        );

        variable.setValues(actor.recall(VALUES_TO_VARIABLE.name()));

        int sizeActual = actor.recall(NUMBER.name());

        actor.should(
                seeThat(
                        the(COUNT_VALUES.of(variable.getName(),
                                String.valueOf(variable.getValues().size()),
                                String.valueOf(sizeActual))), isVisible())
        );

        actor.attemptsTo(
                ValuesToEnterIndicator.clickSaveButton(),
                SeeThatTheMessage.areExpected(SUCCESSFULLY_SAVED)
        );
    }
}
