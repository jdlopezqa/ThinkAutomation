package com.think.features.auth;

import com.think.conf.BaseConf;
import com.think.factories.ThinkActorFactory;
import com.think.models.ThinkActor;
import com.think.tasks.NavigateTo;
import com.think.tasks.login.LoginSystem;
import lombok.SneakyThrows;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.SingleBrowser;
import net.thucydides.core.annotations.WithTagValuesOf;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.think.ui.HomePage.IMG_USER_ICON;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

@ExtendWith(SerenityJUnit5Extension.class)
@SingleBrowser
public class Login extends BaseConf {

    ThinkActor admin;

    @Test
    @WithTagValuesOf({"login", "smoke"})
    public void should_UserLoginSuccessfully_When_HeSendsValidCredentials() {

        admin = ThinkActorFactory.getActorByUsername("Administrador");

        thinkActor.describedAs("login with valid credential");
        thinkActor.attemptsTo(
                LoginSystem.withUser(admin)
        );
        thinkActor.should(
                seeThat(
                        the(IMG_USER_ICON), isVisible())
        );
    }

}
