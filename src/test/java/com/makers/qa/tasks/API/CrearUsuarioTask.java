package com.makers.qa.tasks.API;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.HashMap;
import java.util.Map;

public class CrearUsuarioTask implements Task {

    private final String nombre;
    private final String trabajo;

    public CrearUsuarioTask(String nombre, String trabajo) {
        this.nombre = nombre;
        this.trabajo = trabajo;
    }

    public static CrearUsuarioTask conDatos(String nombre, String trabajo) {
        return Tasks.instrumented(CrearUsuarioTask.class, nombre, trabajo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Map<String, String> bodyRequest = new HashMap<>();
        bodyRequest.put("name", nombre);
        bodyRequest.put("job", trabajo);

        System.out.println("▶ Ejecutando POST al endpoint: /users con nombre: " + nombre);

        actor.attemptsTo(
                Post.to("/users").with(request -> request
                        .header("Content-Type", "application/json")
                        .header("Accept", "*/*")
                        .header("User-Agent", "PostmanRuntime/7.32.3")
                        .body(bodyRequest)
                )
        );

        try {
            String idGenerado = SerenityRest.lastResponse().jsonPath().getString("id");
            if (idGenerado != null) {
                System.setProperty("id_usuario_global", idGenerado);
                System.out.println("✔ ID capturado y guardado globalmente: " + idGenerado);
            }
        } catch (Exception e) {
            System.out.println("⚠ No se pudo extraer el ID del JSON.");
        }
    }
}