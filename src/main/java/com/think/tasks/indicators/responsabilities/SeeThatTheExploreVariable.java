package com.think.tasks.indicators.responsabilities;

import com.think.interactions.generics.SwitchTo;
import com.think.interactions.indicators.responsabilities.ValuesToEnterIndicator;
import com.think.models.indicators.variables.Variable;
import com.think.questions.TextFound;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.think.ui.indicators.responsabilities.ExploreVariablePage.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static org.hamcrest.Matchers.equalTo;

public class SeeThatTheExploreVariable implements Task {

    private final Variable variable;

    public SeeThatTheExploreVariable(Variable variable) {
        this.variable = variable;
    }

    public static SeeThatTheExploreVariable areExpected(Variable variable) {
        return instrumented(SeeThatTheExploreVariable.class, variable);
    }

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {

        Thread.sleep(1000);

        actor.attemptsTo(
                ValuesToEnterIndicator.clickOnVariableWithName(variable.getName())
        );

        actor.attemptsTo(SwitchTo.iFrame(By.id("commentary-modal1")));

        actor.attemptsTo(WaitUntil.the(TITLE, isVisible()).forNoMoreThan(Duration.ofSeconds(10)));

        actor.should(
                seeThat(the(TITLE), isVisible())
        );

        int size = variable.getValues().size() - 1;

        actor.should(
                seeThat("Date", TextFound.firstLowerIn(DATE),
                        equalTo(variable.getValues().get(size).getMonth())
                ),
                seeThat("Goal", TextFound.formatIn(GOAL),
                        equalTo(variable.getGoalValue())
                ),
                seeThat("Value", TextFound.formatIn(VALUE),
                        equalTo(variable.getValues().get(size).getValue())
                ),
                seeThat("Compliance", TextFound.in(COMPLIANCE),
                        equalTo(variable.getValues().get(size).getCompliance())
                )
        );

        actor.attemptsTo(SwitchTo.iFrame(By.id("stats_frame")));

        variable.getValues().forEach(
                values ->
                        actor.attemptsTo(
                                SeeThatTheValuesOfTable
                                        .areExpected(values)
                                        .andGoalValue(variable.getGoalValue())
                        )
        );

        actor.attemptsTo(Switch.toDefaultContext());

    }
}
