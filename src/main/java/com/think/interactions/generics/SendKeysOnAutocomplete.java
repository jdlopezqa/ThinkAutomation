package com.think.interactions.generics;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SendKeysOnAutocomplete implements Interaction {
    private static final String REMOVE_ICON = "./following-sibling::*[@class='icon_clear']";

    private final CharSequence[] theText;
    private Target target;

    public SendKeysOnAutocomplete(CharSequence... text) {
        theText = text;
    }

    public static SendKeysOnAutocomplete theValue(CharSequence... text) {
        return new SendKeysOnAutocomplete(text);
    }

    public SendKeysOnAutocomplete into(Target target) {
        this.target = target;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (target.resolveFor(actor)
                .findElement(By.xpath(REMOVE_ICON)).isDisplayed()) {

            target.resolveFor(actor)
                    .findElement(By.xpath(REMOVE_ICON)).click();
        }

        actor.attemptsTo(
                Click.on(target),
                SendKeys.of(theText).into(target)
        );
    }
}
