package com.think.interactions.generics;

import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import org.openqa.selenium.interactions.Actions;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class SendKeysTo implements Interaction {

    private final String text;

    public SendKeysTo(String text) {
        this.text = text;
    }

    public static Performable currentFocusWith(String text) {
        return instrumented(SendKeysTo.class, text);
    }

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {
        Actions actions = new Actions(getDriver());
        Thread.sleep(1000);
        actions.sendKeys(text).build().perform();
        Thread.sleep(1000);
    }
}
