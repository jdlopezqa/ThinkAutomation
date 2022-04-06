package com.think.interactions;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.think.ui.components.GeneralOptionsPage.*;

public class SelectGeneralOptions {

    public static Performable search() {
        return Task.where("{0} click on search option",
                Click.on(SEARCH));
    }

    public static Performable create() {
        return Task.where("{0} click on create option",
                Click.on(CREATE));
    }

    public static Performable save() {
        return Task.where("{0} click on save option",
                Click.on(SAVE));
    }

    public static Performable add() {
        return Task.where("{0} click on add option",
                Click.on(ADD));
    }

    public static Performable addAndClose() {
        return Task.where("{0} click on add and close option",
                Click.on(ADD_CLOSE));
    }

    public static Performable close() {
        return Task.where("{0} click on close option",
                Click.on(CLOSE));
    }


}
