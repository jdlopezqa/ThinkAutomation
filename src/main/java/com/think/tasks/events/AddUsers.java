package com.think.tasks.events;

import com.think.interactions.SelectGeneralOptions;
import com.think.interactions.generics.SwitchTo;
import com.think.models.events.User;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Switch;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.List;

import static com.think.ui.events.AddUserPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddUsers implements Task {

    private final List<User> users;
    
    public AddUsers(List<User> users){
        this.users = users;
    }

    public static Performable withInfo(List<User> users) {
        return instrumented(AddUsers.class, users);
    }

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(SwitchTo.iFrame(By.id("createFrameModal")));

        users.forEach(
                user -> actor.attemptsTo(
                            Enter.theValue(user.getName()).into(NAME).thenHit(Keys.ENTER),
                            Click.on(ITEM_USER_GRID.of(user.getName(), user.getLogin())),
                            SelectGeneralOptions.add()
                )
        );

        actor.attemptsTo(
            SelectGeneralOptions.close(),
            Switch.toDefaultContext()
        );        
    }
    
}
