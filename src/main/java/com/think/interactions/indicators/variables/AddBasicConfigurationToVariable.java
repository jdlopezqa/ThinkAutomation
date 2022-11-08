package com.think.interactions.indicators.variables;

import com.think.interactions.generics.SendKeysOnAutocomplete;
import com.think.interactions.generics.SendKeysOnCalendar;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static com.think.ui.indicators.variables.BasicConfigurationPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddBasicConfigurationToVariable {

    public static Performable name(String name) {
        return Task.where("{0} add a name #name",
                        Enter.theValue(name).into(NAME))
                .with("name").of(name);
    }

    public static Performable unitMeasurement(String unitMeasurement) {
        return Task.where("{0} add a unit measurement #unitMeasurement",
                        Enter.theValue(unitMeasurement).into(UNIT_MEASUREMENT)
                                .then(WaitUntil.the(OPTION_UNIT_MEASUREMENT.of(unitMeasurement), isVisible()).forNoMoreThan(Duration.ofSeconds(10)))
                                .then(Click.on(OPTION_UNIT_MEASUREMENT.of(unitMeasurement))))
                .with("unitMeasurement").of(unitMeasurement);
    }

    public static Performable measurementFrequency(String measurementFrequency) {
        return Task.where("{0} add a measurement frequency #measurementFrequency",
                        SendKeysOnAutocomplete.theValue(measurementFrequency)
                                .into(MEASUREMENT_FREQUENCY)
                                .then(WaitUntil.the(OPTION_MEASUREMENT_FREQUENCY.of(measurementFrequency), isVisible()).forNoMoreThan(Duration.ofSeconds(10)))
                                .then(Click.on(OPTION_MEASUREMENT_FREQUENCY.of(measurementFrequency))))
                .with("measurementFrequency").of(measurementFrequency);
    }

    public static Performable initialDate(String initialDate) {
        return Task.where("{0} add a initial date #initialDate",
                        SendKeysOnCalendar.theValue(initialDate)
                                .into(INITIAL_DATE))
                .with("initialDate").of(initialDate);
    }

    public static Performable isIndicator(boolean process) {

        if (process) {
            return Task.where("{0} check this variable is indicator",
                    Click.on(IS_INDICATOR));
        } else {
            return Task.where("{0} not check this variable is indicator");
        }

    }

    public static Performable goal(String goal) {
        return Task.where("{0} check #goal this goal",
                        Click.on(GOAL.of(goal)))
                .with("goal").of(goal);
    }

    public static Performable goalValue(String goalValue) {
        return Task.where("{0} add a goalValue #goalValue",
                        Enter.theValue(goalValue).into(GOAL_VALUE))
                .with("goalValue").of(goalValue);
    }
}
