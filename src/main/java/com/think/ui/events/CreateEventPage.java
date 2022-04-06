package com.think.ui.events;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CreateEventPage {

    public static final Target SUBJECT = Target
            .the("input subject").located(By.id("name"));

    public static final Target DESCRIPTION = Target
            .the("input description").located(By.id("description"));

    public static final Target PROCESS = Target
            .the("input process").located(By.id("process_lab"));

    public static final Target OPTION_AUTOCOMPLETE = Target
            .the("option {0}").locatedBy("//div[@class='ac_results']//li[contains(.,'{0}')]/strong");

    public static final Target AREA = Target
            .the("input area").located(By.id("groupunitve_lab"));

    public static final Target ADD_USER = Target
            .the("button add user").located(By.id("span_user_link2Add"));

    public static final Target DECIDER = Target
            .the("radio button decider for {0}")
            .locatedBy("//table[@id='user_results']/tbody/tr[contains(.,'{0}')]/td[3]/input");

    public static final Target GO_TO_DISCUSSION = Target
            .the("link go to discussion")
            .locatedBy("//span[contains(text(),'Ir a la discusi\u00F3n')]");

}
