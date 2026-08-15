package com.makers.qa.tasks;

import com.makers.qa.userinterfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;


public class LoginTask implements Task {
    private final String usuario;

    public LoginTask(String usuario) {
        this.usuario = usuario;
    }

    public static LoginTask withusuario(String usuario) {
        return Tasks.instrumented(LoginTask.class, usuario);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        String safePassword = variables.getProperty("vault.saucedemo.password", "secret_sauce");

        System.out.println("=======================================");
        System.out.println("▶ ACTOR INTENTANDO INICIAR SESIÓN");
        System.out.println("Usuario ingresado: " + usuario);
        System.out.println("Contraseña ingresada: ********");
        System.out.println("=======================================");

        actor.attemptsTo(
                Enter.theValue(usuario).into(LoginPage.USERNAME_INPUT),
                Enter.theValue(safePassword).into(LoginPage.PASSWORD_INPUT),
                Click.on(LoginPage.LOGIN_BUTTON)
        );
    }
}
