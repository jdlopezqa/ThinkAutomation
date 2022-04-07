package com.think.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {
    
    //Header Menu
    public static final Target IMG_USER_ICON = Target
            .the("User icon").located(By.id("userIcon"));

    public static final Target IMG_USER_ICON_ = Target
            .the("User icon").locatedBy("//input[@id='userIcon']");

    public static final Target IMG_EVENTS_ICON = Target
            .the("Events icon").located(By.id("sve7-events-link"));

    //Options menu
    public static final Target OPTION_MENU = Target
            .the("Option menu {0}")
            .locatedBy("//div[@id='sve8-menu']//span[contains(text(),'{0}')]/..");

    public static final Target OPTION_SUBMENU = Target
            .the("Option sub-menu {0}")
            .locatedBy("//div[@id='sve8-menu-lv2-2']//div[@fulltitle='{0}' and contains(text(),'{0}')]");

    public static final Target OPTION_SUB_SUBMENU = Target
            .the("Option sub sub-menu {1}")
            .locatedBy("//div[@fulltitle='{0}' and contains(text(),'{0}')]/..//a[contains(text(),'{1}')]");
    
}