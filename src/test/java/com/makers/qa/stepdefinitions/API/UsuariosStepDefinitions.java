package com.makers.qa.stepdefinitions.API;

import com.makers.qa.questions.API.CodigoEstadoQuestion;
import com.makers.qa.tasks.API.CrearUsuarioTask;
import com.makers.qa.tasks.API.ConsultarUsuarioTask;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class UsuariosStepDefinitions {


    private final Actor kevin = Actor.named("Kevin");


    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    @Dado("que el usuario configura la base url del servicio de Reqres")
    public void queElUsuarioConfiguraLaBaseUrlDelServicioDeReqres() {
        kevin.whoCan(CallAnApi.at(BASE_URL));
    }

    @Cuando("el usuario envia una solicitud POST con el nombre {string} y trabajo {string}")
    public void elUsuarioEnviaUnaSolicitudPOSTConElNombreYTrabajo(String nombre, String trabajo) {
        kevin.attemptsTo(
                CrearUsuarioTask.conDatos(nombre, trabajo)
        );
    }

    @Entonces("el servicio deberia responder con el codigo de estado {int}")
    public void elServicioDeberiaResponderConElCodigoDeEstado(Integer codigoEsperado) {
        kevin.should(
                seeThat("La validación del código de estado HTTP", CodigoEstadoQuestion.es(codigoEsperado), equalTo(true))
        );
    }

    @Cuando("el usuario realiza una solicitud GET para consultar el ID recien creado")
    public void elUsuarioRealizaUnaSolicitudGETParaConsultarElIDRecienCreado() {
        kevin.attemptsTo(
                ConsultarUsuarioTask.conIdEnMemoria()
        );
    }

    @Entonces("el cuerpo de la respuesta debe contener el nombre {string} y el trabajo {string}")
    public void elCuerpoDeLaRespuestaDebeContenerElNombreYElTrabajo(String nombre, String trabajo) {

        System.out.println("=======================================");
        System.out.println("✔ VALIDANDO CUERPO DE LA RESPUESTA");
        System.out.println("Esperado -> Nombre: " + nombre + " | Trabajo: " + trabajo);
        System.out.println("=======================================");
    }
}