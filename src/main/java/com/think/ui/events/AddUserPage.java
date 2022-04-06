package com.think.ui.events;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AddUserPage {

    public static final Target NAME = Target
            .the("input name user").located(By.id("name"));

    public static final Target DOMAIN = Target
            .the("input domain user").located(By.id("domain"));

    public static final Target LOGIN = Target
            .the("input login user").located(By.id("login"));

    public static final Target ITEM_USER_GRID = Target
            .the("check for user")
            .locatedBy("//table[@id='_results']//tr[contains(.,'{0}') and contains(.,'{1}')]");
    
}
