package com.makers.qa.tasks.API;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class ConsultarUsuarioTask implements Task {

    public static ConsultarUsuarioTask conIdEnMemoria() {
        return Tasks.instrumented(ConsultarUsuarioTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String idUsuario = System.getProperty("id_usuario_global", "1");

        System.out.println("▶ Ejecutando GET al endpoint: /users/" + idUsuario);

        actor.attemptsTo(
                Get.resource("/users/" + idUsuario)
        );
    }
}