package com.think.ui.indicators.responsabilities;

import net.serenitybdd.screenplay.targets.Target;

public class ExploreVariablePage {

    public static final Target TITLE = Target
            .the("tittle form").locatedBy("//div[@class='titleA']/div");

    public static final Target DATE = Target
            .the("label date")
            .locatedBy("//div[@class='nrt-boxData']/div[contains(text(),'Fecha')]/following-sibling::div[1]");

    public static final Target GOAL = Target
            .the("label goal")
            .locatedBy("//div[@class='nrt-boxData']/div[contains(text(),'Meta')]/following-sibling::div[1]/div");

    public static final Target VALUE = Target
            .the("label value")
            .locatedBy("//div[@class='nrt-boxData']/div[contains(text(),'Valor')]/following-sibling::div[1]/div");

    public static final Target COMPLIANCE = Target
            .the("label compliance")
            .locatedBy("//div[@class='nrt-boxData']/div[contains(text(),'Cumplimiento')]/following-sibling::div[1]");

    public static final Target ITEM_GOAL_TABLE = Target
            .the("item goal to table of {0}")
            .locatedBy("//table[contains(@class,'row-table')]//div[contains(text(),'{0}')]/parent::td/following-sibling::td[2]/div");

    public static final Target ITEM_VALUE_TABLE = Target
            .the("item value to table of {0}")
            .locatedBy("//table[contains(@class,'row-table')]//div[contains(text(),'{0}')]/parent::td/following-sibling::td[3]/div/div[@class='containerValue']");

    public static final Target ITEM_COMPLIANCE_TABLE = Target
            .the("item compliance to table of {0}")
            .locatedBy("//table[contains(@class,'row-table')]//div[contains(text(),'{0}')]/parent::td/following-sibling::td[4]/div/div");


}
