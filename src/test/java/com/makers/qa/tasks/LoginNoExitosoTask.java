package com.makers.qa.tasks;

import com.makers.qa.userinterfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;


public class LoginNoExitosoTask implements Task {
    private final String usuario;
    private final String contrasenia;

    public LoginNoExitosoTask(String usuario, String contrasenia) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public static LoginNoExitosoTask withusuario(String usuario, String contrasenia) {
        return Tasks.instrumented(LoginNoExitosoTask.class, usuario, contrasenia);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        System.out.println("=======================================");
        System.out.println("▶ ACTOR INTENTANDO INICIAR SESIÓN");
        System.out.println("Usuario ingresado: " + usuario);
        System.out.println("Contraseña ingresada: ********");
        System.out.println("=======================================");

        actor.attemptsTo(
                Enter.theValue(usuario).into(LoginPage.USERNAME_INPUT),
                Enter.theValue(contrasenia).into(LoginPage.PASSWORD_INPUT),
                Click.on(LoginPage.LOGIN_BUTTON)
        );
    }
}
