package com.think.ui.components;

import net.serenitybdd.screenplay.targets.Target;

public class ResponsePage {

    public static final Target MESSAGE = Target
            .the("message save success").locatedBy("//div[@id='actionResponseTitle']/span");

    public static final Target BUTTON = Target
            .the("button {0}").locatedBy("//div[@id='actionResponseBtns']/button[contains(text(),'{0}')]");


}
