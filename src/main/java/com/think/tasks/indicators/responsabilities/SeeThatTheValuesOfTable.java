package com.think.tasks.indicators.responsabilities;

import com.think.models.indicators.variables.Values;
import com.think.questions.TextFound;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.think.ui.indicators.responsabilities.ExploreVariablePage.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.equalTo;

public class SeeThatTheValuesOfTable implements Task {

    private final Values value;
    private String goalValue;
    private String month;

    public SeeThatTheValuesOfTable(Values value) {
        this.value = value;
        month = value.getMonth();
    }

    public static SeeThatTheValuesOfTable areExpected(Values value) {
        return instrumented(SeeThatTheValuesOfTable.class, value);
    }

    public SeeThatTheValuesOfTable andGoalValue(String goalValue) {
        this.goalValue = goalValue;
        return this;
    }

    @Override
    @Step("{0} see that the values in the table for #month are expected ")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(ITEM_GOAL_TABLE.of(value.getMonth()), isVisible()),
                Scroll.to(ITEM_GOAL_TABLE.of(value.getMonth()))
        );

        actor.should(
                seeThat(String.format("item goal to %s", value.getMonth()),
                        TextFound.formatIn(ITEM_GOAL_TABLE.of(value.getMonth())),
                        equalTo(goalValue)),
                seeThat(String.format("item value to %s", value.getMonth()),
                        TextFound.formatIn(ITEM_VALUE_TABLE.of(value.getMonth())),
                        equalTo(value.getValue())),
                seeThat(String.format("item compliance to %s", value.getMonth()),
                        TextFound.withoutSpacesIn(ITEM_COMPLIANCE_TABLE.of(value.getMonth())),
                        equalTo(value.getCompliance()))
        );

    }
}
