package com.makers.qa.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
    //Task
    public static final Target USERNAME_INPUT = Target.the("campo de usuario").located(By.id("user-name"));
    public static final Target PASSWORD_INPUT = Target.the("campo de contraseña").located(By.id("password"));
    public static final Target LOGIN_BUTTON = Target.the("botón de login").located(By.id("login-button"));

    //Question
    public static final Target ERROR_MESSAGE = Target.the("mensaje de error").located(By.cssSelector("[data-test='error']"));
    public static final Target PRODUCTS_TITLE = Target.the("título de productos").located(By.cssSelector(".title"));

    private LoginPage() {}
}
