package com.makers.qa.stepdefinitions;

import com.makers.qa.questions.LoginQuestion;
import com.makers.qa.tasks.LoginNoExitosoTask;
import com.makers.qa.tasks.LoginTask;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LoginStepDefinition {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que el usuario navega a la pagina de inicio")
    public void queElUsuarioNavegaALaPaginaDeInicio() {
        theActorCalled("Cliente").wasAbleTo(Open.url("https://www.saucedemo.com/"));
    }

    @Cuando("el usuario intenta iniciar sesion con el usuario {string}")
    public void elUsuarioIntentaIniciarSesionConElUsuario(String usuario) {
        theActorInTheSpotlight().attemptsTo(
                LoginTask.withusuario(usuario)
        );
    }

    @Cuando("el usuario intenta iniciar sesion con el usuario {string} y contraseña {string}")
    public void elUsuarioIntentaIniciarSesionConElUsuarioYContraseña(String usuario, String contrasenia) {
        theActorInTheSpotlight().attemptsTo(
                LoginNoExitosoTask.withusuario(usuario,contrasenia)
        );
    }

    @Entonces("el cliente deberia visualizar el mensaje {string}")
    public void elClienteDeberiaVisualizarElMensaje(String mensaje) {
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(LoginQuestion.validarMensaje(mensaje))
        );
    }
}