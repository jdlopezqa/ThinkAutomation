package com.think.ui.components;

import net.serenitybdd.screenplay.targets.Target;

public class MessagesPage {

    public static final Target MESSAGE = Target
            .the("message save success").locatedBy("//div[@id='actionResponseTitle']/span");
}
