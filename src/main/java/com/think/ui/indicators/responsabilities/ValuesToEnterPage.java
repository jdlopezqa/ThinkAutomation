package com.think.ui.indicators.responsabilities;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.shadow.ByShadow;
import org.openqa.selenium.By;

public class ValuesToEnterPage {

    public static final Target SEARCH_BY_NAME = Target
            .the("input search by name").located(By.id("variableNameSearcher"));

    public static final Target SEARCH_BUTTON = Target
            .the("button search").located(By.id("variableNameSearcherBtn"));

    public static final Target OPTION_NAME = Target
            .the("option name {0}").locatedBy("//div[@class='variable__box-name' and contains(.,'{0}')]/a");

    public static final Target COUNT_VALUES = Target
            .the("label count values fill ({1}/{2})")
            .locatedBy("//div[@class='variable__box-name' and contains(.,'{0}')]/a/following-sibling::span[text()='({1}/{2})']");

    public static final Target DATE = Target
            .the("drop down date")
            .locatedBy("//div[@class='variable__box-name']/a[text()='{0}']/parent::div/following-sibling::div[@class='variable__box-date']/select");

    public static final Target INPUT_VALUE = Target
            .the("input value")
            .located(ByShadow.cssSelector(
                    By.xpath("//div[@class='variable__box-name' and contains(.,'{0}')]//following-sibling::div[contains(@class,'variable__box-value')]/sve-textfield"),
                    "input"));

    public static Target INPUT_VALUE_(String name) {
        return Target.the("input value")
                .located(ByShadow.cssSelector(
                        By.xpath(String.format("//div[@class='variable__box-name' and contains(.,'%s')]//following-sibling::div[contains(@class,'variable__box-value')]/sve-textfield", name)),
                        "input"));
    }

    public static final Target VARIOUS_BUTTON = Target
            .the("various button for {0}")
            .locatedBy("//div[@class='variable__box-name']/a[text()='{0}']//parent::div/following-sibling::div[contains(.,'Varios')]/button");

    public static final Target SAVE = Target
            .the("button save").located(By.id("btnSave"));

}
