package com.think.ui.components;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class GeneralOptionsPage {

    public static final Target SEARCH = Target
            .the("button search")
            .locatedBy("//input[@type='button' and @value='Buscar' and contains(@id,'btn') and contains(@class,'Search')]");

    public static final Target CREATE = Target
            .the("button create")
            .locatedBy("//div[@id='floating-button']/p[contains(text(),'Crear')]");

    public static final Target SAVE = Target
            .the("button save")
            .locatedBy("//input[@id='save']");

    public static final Target ADD = Target
            .the("button add").located(By.id("searcher_add"));

    public static final Target ADD_CLOSE = Target
            .the("button add and close")
            .located(By.id("searcher_add_close"));

    public static final Target CLOSE = Target
            .the("button close").located(By.id("searcher_close"));
}