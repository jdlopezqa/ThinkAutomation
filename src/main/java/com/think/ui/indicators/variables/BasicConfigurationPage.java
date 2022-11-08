package com.think.ui.indicators.variables;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BasicConfigurationPage {

    public static final Target NAME = Target
            .the("input name").located(By.id("defName"));

    public static final Target UNIT_MEASUREMENT = Target
            .the("input unit measurement").located(By.id("defUomStore_lab"));

    public static final Target OPTION_UNIT_MEASUREMENT = Target
            .the("option unit measurement {0}").locatedBy("//div[@class='ac_results']//li[contains(.,'{0}')]/strong");

    public static final Target MEASUREMENT_FREQUENCY = Target
            .the("input measurement frequency").located(By.id("obtTimer_lab"));

    public static final Target OPTION_MEASUREMENT_FREQUENCY = Target
            .the("option measurement frequency").locatedBy("//div[@class='ac_results']//li/strong[text()='{0}']");

    public static final Target BTN_REMOVE_FREQUENCY = Target
            .the("button remove measurement frequency").located(By.id("obtTimer_lab_clear"));

    public static final Target INITIAL_DATE = Target
            .the("input initial date").located(By.id("lab_defInitDate"));

    public static final Target IS_INDICATOR = Target
            .the("check this variable is a indicator").located(By.id("checkThisVarIsInd"));

    public static final Target GOAL = Target
            .the("goal option {0}")
            .locatedBy("//div[@id='thisVarIsIndContainer']//tr//label[text()='Meta']//following::label[text()='{0}']//preceding-sibling::input");

    public static final Target GOAL_VALUE = Target
            .the("input goal value").located(By.id("defTargetValue"));
}
