package com.think.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class TextFound implements Question<String> {

    private final Target object;

    public TextFound(Target object) {
        this.object = object;
    }

    public static Question<String> in(Target object) {
        return new TextFound(object);
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(object).answeredBy(actor).trim();
    }
}
