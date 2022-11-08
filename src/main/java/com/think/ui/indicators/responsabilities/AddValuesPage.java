package com.think.ui.indicators.responsabilities;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.shadow.ByShadow;
import org.openqa.selenium.By;

public class AddValuesPage {

    public static Target INPUT_VALUE_2(String month) {
        return Target.the("input value")
                .located(ByShadow.cssSelector(
                        By.xpath(String.format("//div[@class='var-value-box__date' and contains(.,'%s')]//following-sibling::div/sve-textfield", month)),
                        "input"));
    }

    public static final Target ITEMS_GRID = Target.the("button accept")
            .located(By.cssSelector("div[class=\"table-grid-sve__body\"]>div:nth-of-type(n)>div.var-value-box__value>sve-textfield"));

    public static Target INPUT_VALUE(String month) {
        return Target.the("input value")
                .located(ByShadow.cssSelector(
                        "input",
                        String.format("div[class=\"table-grid-sve__body\"]>div:nth-of-type(%s)>div.var-value-box__value>sve-textfield", month)));
    }

    public static final Target BUTTON_ACCEPT = Target.the("button accept")
            .located(By.id("btnValuesAccept"));

}
