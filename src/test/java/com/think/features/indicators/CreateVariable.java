package com.think.features.indicators;

import com.think.conf.BaseConf;
import com.think.factories.indicators.VariablesFactory;
import com.think.models.ThinkActor;
import com.think.models.indicators.variables.Variable;
import com.think.tasks.AccessTo;
import com.think.tasks.SeeThatTheMessage;
import com.think.tasks.indicators.responsabilities.AddValuesToVariables;
import com.think.tasks.indicators.responsabilities.SeeThatTheExploreVariable;
import com.think.tasks.indicators.variables.CreateVariableBasicConfig;
import com.think.tasks.login.LoginSystem;
import lombok.SneakyThrows;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.SingleBrowser;
import net.thucydides.core.annotations.WithTagValuesOf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.think.enums.Actors.ADMIN;
import static com.think.enums.ButtonOption.CLOSE;
import static com.think.enums.MenuOption.INDICATORS;
import static com.think.enums.Messages.SUCCESSFULLY_SAVED;
import static com.think.enums.SubMenuOption.MY_RESPONSABILITIES;
import static com.think.enums.SubMenuOption.VARIABLES;
import static com.think.enums.SubSubMenuOption.MANAGE;
import static com.think.factories.ThinkActorFactory.getActorByUsername;

@ExtendWith(SerenityJUnit5Extension.class)
@SingleBrowser
@WithTagValuesOf({"variables"})
public class CreateVariable extends BaseConf {

    ThinkActor admin;

    @BeforeEach
    public void setUp() {
        admin = getActorByUsername(ADMIN.getActorName());
        thinkActor.wasAbleTo(
                LoginSystem.withUser(admin),
                AccessTo
                        .menu(INDICATORS)
                        .andSubMenu(VARIABLES)
                        .andSubSubMenu(MANAGE)
        );
    }

    @Test
    @SneakyThrows
    @WithTagValuesOf({"smoke"})
    public void should_SeeHisIndicators_When_HeCreateAVariableIndicatorWithConstantGoal() {
        Variable variable = VariablesFactory.getVariableByKey("indicator-with-constant-goal");

        thinkActor.describedAs("has a variable type indicator with constant goal");

        thinkActor.attemptsTo(
                CreateVariableBasicConfig
                        .with()
                        .name(variable.getName())
                        .unitMeasurement(variable.getUnitMeasurement())
                        .measurementFrequency(variable.getMeasurementFrequency())
                        .initialDate(variable.getInitialDate())
                        .isIndicator(variable.getIsIndicator())
                        .goal(variable.getGoal())
                        .goalValue(variable.getGoalValue()),
                SeeThatTheMessage
                        .areExpected(SUCCESSFULLY_SAVED)
                        .andSelectOption(CLOSE)
        );

        thinkActor.attemptsTo(
                AccessTo.menu(INDICATORS)
                        .andSubMenu(MY_RESPONSABILITIES),
                AddValuesToVariables
                        .withInfo(variable),
                SeeThatTheExploreVariable
                        .areExpected(variable)
        );

    }

}
