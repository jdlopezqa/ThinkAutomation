package com.think.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public static final Target USER = Target
            .the("input login").located(By.id("user"));

    public static final Target PASSWORD = Target
            .the("input password").located(By.id("password"));

    public static final Target LOGIN = Target
            .the("button login").located(By.id("signInButton"));

}
