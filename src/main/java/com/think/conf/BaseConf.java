package com.think.conf;

import lombok.SneakyThrows;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class BaseConf {

    protected Actor thinkActor;
    private EnvironmentVariables environmentVariables;

    @Managed
    WebDriver browser;

    @BeforeEach
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());

        thinkActor = theActorCalled("Admin");

        thinkActor.can(BrowseTheWeb.with(browser));

        browser.manage().window().maximize();

        thinkActor.remember("baseUrl",
                EnvironmentSpecificConfiguration.from(environmentVariables)
                        .getProperty("webdriver.base.url"));
    }

    @SneakyThrows
    @AfterEach
    public void tearDown() {
        browser.manage().deleteAllCookies();
        browser.navigate().refresh();
    }

}
