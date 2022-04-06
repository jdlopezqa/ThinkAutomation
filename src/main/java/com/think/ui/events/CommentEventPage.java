package com.think.ui.events;

import net.serenitybdd.screenplay.targets.Target;

public class CommentEventPage {

    public static final Target LINK_COMMENT = Target
            .the("link add new comment")
            .locatedBy("//a[starts-with(@id,'commentEvent')]");

    public static final Target ADD_COMMENT = Target
            .the("button save comment").locatedBy("//input[@value='Comentar']");

    public static final Target BTN_EXPANDS_COMMENTS = Target
            .the("expand comments").locatedBy("//span[contains(text(),'Comentarios')]");

    public static final Target COMMENT = Target
            .the("comment in grid")
            .locatedBy("//div[contains(@id,'commentDiscussion')]//table//table/tbody/tr//span[contains(text(),'{0}')]");
    
}
