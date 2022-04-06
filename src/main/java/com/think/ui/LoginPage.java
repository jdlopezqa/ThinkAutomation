package com.think.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public static final Target INPUT_LOGIN = Target
            .the("Input login").located(By.id("user"));

    public static final Target INPUT_PASSWORD = Target
            .the("Input password").located(By.id("password"));

    public static final Target BTN_LOGIN = Target
            .the("Button login").located(By.id("signInButton"));

}
