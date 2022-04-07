package com.think.features.events;

import com.think.conf.BaseConf;
import com.think.enums.Messages;
import com.think.factories.EventsFactory;
import com.think.models.ThinkActor;
import com.think.models.events.Event;
import com.think.questions.TextFound;
import com.think.tasks.AccessTo;
import com.think.tasks.login.LoginSystem;
import com.think.tasks.events.CommentToEvent;
import com.think.tasks.events.CreateAEvent;
import lombok.SneakyThrows;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.SingleBrowser;
import net.thucydides.core.annotations.WithTagValuesOf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.think.enums.MenuOption.EVENTS_DECISIONS;
import static com.think.enums.Messages.SUCCESSFULLY_SAVED;
import static com.think.enums.SubMenuOption.EVENTS;
import static com.think.enums.SubSubMenuOption.MANAGE;
import static com.think.factories.ThinkActorFactory.getActorByUsername;
import static com.think.ui.components.MessagesPage.MESSAGE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.IsEqual.equalTo;

@ExtendWith(SerenityJUnit5Extension.class)
@SingleBrowser
public class CreateEvents extends BaseConf {

    ThinkActor admin;

    @BeforeEach
    public void setUp() {
        admin = getActorByUsername("Administrador");
    }

    @Test
    @SneakyThrows
    @WithTagValuesOf({"events", "smoke"})
    public void should_SeeHisEventCreated_When_HeSendsBasicInformation() {
        Event event = EventsFactory.getEventByType("basic");

        thinkActor.describedAs("has a basic event");

        thinkActor.attemptsTo(
                LoginSystem.withUser(admin),
                AccessTo
                        .menu(EVENTS_DECISIONS)
                        .andSubMenu(EVENTS)
                        .andSubSubMenu(MANAGE),
                CreateAEvent
                        .with()
                        .subject(event.getSubject())
                        .andDescription(event.getDescription())
                        .andProcess(event.getProcess())
                        .andArea(event.getArea())
                        .andUsers(event.getUsers())
                        .andDecider(event.getUsers().get(0).getName())
        );
        thinkActor.should(
                seeThat(TextFound.in(MESSAGE),
                        equalTo(SUCCESSFULLY_SAVED.getText()))
        );

        thinkActor.attemptsTo(
                CommentToEvent.withData(event.getComments())
        );
    }

}
