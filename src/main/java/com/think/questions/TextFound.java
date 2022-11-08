package com.think.questions;

import com.think.utils.ConvertValues;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.targets.TargetText;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class TextFound  {
    public static Question<String> in(Target object) {
        return actor -> Text.of(object).answeredBy(actor).trim();
    }

    public static Question<String> withoutSpacesIn(Target object) {
        return actor -> Text.of(object).answeredBy(actor).trim().replace(" ", "");
    }

    public static Question<String> formatIn(Target object) {
        String text = Text.of(object).answeredBy(theActorInTheSpotlight()).trim();
        return actor -> ConvertValues.formatString(text);
    }

    public static Question<String> firstLowerIn(Target object) {
        String text = Text.of(object).answeredBy(theActorInTheSpotlight()).trim();
        return actor -> (text.toLowerCase().charAt(0) + text.substring(1,3));
    }


}
