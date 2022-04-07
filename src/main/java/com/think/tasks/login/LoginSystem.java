package com.think.tasks.login;

import com.think.models.ThinkActor;
import com.think.tasks.NavigateTo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.think.ui.LoginPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginSystem implements Task {

    private final ThinkActor user;

    public LoginSystem(ThinkActor user) {
        this.user = user;
    }

    public static LoginSystem withUser(ThinkActor user) {
        return instrumented(LoginSystem.class, user);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                NavigateTo.loginPage(),
                Enter.theValue(user.getUser()).into(USER),
                Enter.theValue(user.getPassword()).into(PASSWORD),
                Click.on(LOGIN));
    }
}
