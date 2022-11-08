package com.think.interactions.generics;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.Keys;

public class SendKeysOnCalendar implements Interaction {
    private final String theText;
    private Target target;

    public SendKeysOnCalendar(String text) {
        theText = text;
    }

    public static SendKeysOnCalendar theValue(String text) {
        return new SendKeysOnCalendar(text);
    }

    public SendKeysOnCalendar into(Target target) {
        this.target = target;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String[] dateSplit = theText.split("/");
        actor.attemptsTo(
                Clear.field(target),
                SendKeys.of(dateSplit[0]).into(target).thenHit(Keys.DIVIDE)
                        .then(SendKeys.of(dateSplit[1]).into(target).thenHit(Keys.DIVIDE)
                                .then(SendKeys.of(dateSplit[2]).into(target)
                                        .thenHit(Keys.TAB))
                        )
        );
    }
}