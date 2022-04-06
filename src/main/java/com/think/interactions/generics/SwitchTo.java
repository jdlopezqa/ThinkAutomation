package com.think.interactions.generics;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.core.Serenity.getDriver;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SwitchTo implements Interaction {

    private final By iFrame;

    public SwitchTo(By iFrame) {
        this.iFrame = iFrame;
    }

    public static Performable iFrame(By iFrame) {
        return new SwitchTo(iFrame);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebElement frame = getDriver().findElement(iFrame);

        actor.attemptsTo(
                WaitUntil.the(iFrame, isVisible()),
                Switch.toFrame(frame)
        );
    }
}
