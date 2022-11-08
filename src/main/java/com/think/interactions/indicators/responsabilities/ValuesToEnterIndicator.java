package com.think.interactions.indicators.responsabilities;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static com.think.ui.indicators.responsabilities.ValuesToEnterPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;


public class ValuesToEnterIndicator {

    public static Performable searchVariableWithName(String name) {
        return Task.where("{0} search variable #name",
                        WaitUntil.the(SEARCH_BY_NAME, isClickable())
                                .then(Enter.theValue(name).into(SEARCH_BY_NAME))
                                .then(SendKeys.of(Keys.ENTER).into(SEARCH_BY_NAME)))
                .with("name").of(name);
    }

    public static Performable clickOnVariableWithName(String name) {
        return Task.where("{0} click on variable #name",
                        WaitUntil.the(OPTION_NAME.of(name), isClickable()),
                        Click.on(OPTION_NAME.of(name)))
                .with("name").of(name);
    }

    public static Performable clickVariousButton(String name) {
        return Task.where("{0} click on button various",
                Click.on(VARIOUS_BUTTON.of(name)));
    }

    public static Performable clickSaveButton() {
        return Task.where("{0} click on button save",
                WaitUntil.the(SAVE, isClickable())
                        .then(Click.on(SAVE)));
    }
}
