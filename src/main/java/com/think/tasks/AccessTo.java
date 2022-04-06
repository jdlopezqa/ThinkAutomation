package com.think.tasks;

import com.think.enums.MenuOption;
import com.think.enums.SubMenuOption;
import com.think.enums.SubSubMenuOption;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.util.Objects;

import static com.think.ui.HomePage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AccessTo implements Task {

    private final MenuOption menu;
    private SubMenuOption subMenu = null;
    private SubSubMenuOption subSubMenu = null;

    public AccessTo(MenuOption menu) {
        this.menu = menu;
    }

    public static AccessTo menu(MenuOption menu) {
        return instrumented(AccessTo.class, menu);
    }

    public AccessTo andSubMenu(SubMenuOption subMenu) {
        this.subMenu = subMenu;
        return this;
    }

    public AccessTo andSubSubMenu(SubSubMenuOption subSubMenu) {
        this.subSubMenu = subSubMenu;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(OPTION_MENU.of(menu.asString()))
        );

        if (Objects.nonNull(subMenu)) {
            actor.attemptsTo(
                    Click.on(OPTION_SUBMENU.of(subMenu.asString()))
            );
            if (Objects.nonNull(subSubMenu))
                actor.attemptsTo(
                        Click.on(OPTION_SUB_SUBMENU.of(subMenu.asString(), subSubMenu.asString()))
                );
        }
    }

}
