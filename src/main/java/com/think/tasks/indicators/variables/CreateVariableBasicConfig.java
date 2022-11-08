package com.think.tasks.indicators.variables;

import com.think.interactions.SelectGeneralOptions;
import com.think.interactions.indicators.variables.AddBasicConfigurationToVariable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateVariableBasicConfig implements Task {

    private final List<Performable> itemsVariable;

    public CreateVariableBasicConfig() {
        itemsVariable = new ArrayList<>();
    }

    public static CreateVariableBasicConfig with() {
        return instrumented(CreateVariableBasicConfig.class);
    }

    public CreateVariableBasicConfig name(String name) {
        this.itemsVariable.add(SelectGeneralOptions.create());
        this.itemsVariable.add(AddBasicConfigurationToVariable.name(name));
        return this;
    }

    public CreateVariableBasicConfig unitMeasurement(String unitMeasurement) {
        this.itemsVariable.add(AddBasicConfigurationToVariable.unitMeasurement(unitMeasurement));
        return this;
    }

    public CreateVariableBasicConfig measurementFrequency(String measurementFrequency) {
        this.itemsVariable.add(AddBasicConfigurationToVariable.measurementFrequency(measurementFrequency));
        return this;
    }

    public CreateVariableBasicConfig initialDate(String initialDate) {
        this.itemsVariable.add(AddBasicConfigurationToVariable.initialDate(initialDate));
        return this;
    }

    public CreateVariableBasicConfig isIndicator(boolean isIndicator) {
        this.itemsVariable.add(AddBasicConfigurationToVariable.isIndicator(isIndicator));
        return this;
    }

    public CreateVariableBasicConfig goal(String goal) {
        this.itemsVariable.add(AddBasicConfigurationToVariable.goal(goal));
        return this;
    }

    public CreateVariableBasicConfig goalValue(String goalValue) {
        this.itemsVariable.add(AddBasicConfigurationToVariable.goalValue(goalValue));
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                variableActions()
        );
    }

    private Performable[] variableActions() {
        this.itemsVariable.add(SelectGeneralOptions.save());
        return this.itemsVariable.toArray(new Performable[this.itemsVariable.size()]);
    }
}
