package com.think.tasks.indicators.responsabilities;

import com.github.javafaker.Faker;
import com.think.enums.Months;
import com.think.models.indicators.variables.Values;
import com.think.models.indicators.variables.Variable;
import com.think.utils.ConvertValues;
import com.think.utils.GetMonth;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static com.think.enums.Memory.NUMBER;
import static com.think.enums.Memory.VALUES_TO_VARIABLE;
import static com.think.ui.indicators.responsabilities.AddValuesPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class AddValuesToVariable implements Task {

    private final Variable variable;

    public AddValuesToVariable(Variable variable) {
        this.variable = variable;
    }

    public static AddValuesToVariable withInfo(Variable variable) {
        return instrumented(AddValuesToVariable.class, variable);
    }

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {

        int sizeActual = ITEMS_GRID.resolveAllFor(actor).size();

        variable.setValues(getValues(variable, sizeActual));

        variable.getValues().forEach(
                value -> {
                    actor.attemptsTo(
                            Scroll.to(INPUT_VALUE(value.getIndex())),
                            WaitUntil.the(INPUT_VALUE(value.getIndex()), isClickable()),
                            Click.on(INPUT_VALUE(value.getIndex())),
                            Enter.theValue(value.getValue()).into(INPUT_VALUE(value.getIndex()))
                    );
                }
        );

        actor.remember(NUMBER.name(), sizeActual);
        actor.remember(VALUES_TO_VARIABLE.name(), variable.getValues());
        actor.attemptsTo(Click.on(BUTTON_ACCEPT));
        Thread.sleep(1000);

    }

    private static List<Values> getValues(Variable variable, int size) {
        int goal = Integer.parseInt(variable.getGoalValue());
        int goalMinim = (int) (goal * 0.5);
        int goalMax = (int) ((goal * 0.2) + goal); //TODO revisar calculo de cumplimiento
        int month = GetMonth.fromNumber(variable.getInitialDate().split("/")[1]);
        ;

        for (int i = size; i > 0; i -= 2) {
            Values value = new Values();
            int valueMonth = Faker.instance().random().nextInt(goalMinim, goal);
            float compliance = (float) valueMonth / goal * 100;
            value.setIndex(String.valueOf(i));
            if (month == 13)
                month = Months.JANUARY.getIndex();
            if (month == 14)
                month = Months.FEBRUARY.getIndex();
            value.setMonth(GetMonth.fromNumber(month));
            value.setValue(String.valueOf(valueMonth));
            value.setCompliance(ConvertValues.formatString(compliance).concat("%"));
            variable.getValues().add(value);
            month += 2;
        }
        return variable.getValues();
    }
}
