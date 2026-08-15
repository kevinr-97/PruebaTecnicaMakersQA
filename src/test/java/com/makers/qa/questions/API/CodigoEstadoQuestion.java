package com.makers.qa.questions.API;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CodigoEstadoQuestion implements Question<Boolean> {

    private final int codigoEsperado;

    public CodigoEstadoQuestion(int codigoEsperado) {
        this.codigoEsperado = codigoEsperado;
    }

    public static CodigoEstadoQuestion es(int codigoEsperado) {
        return new CodigoEstadoQuestion(codigoEsperado);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        int codigoObtenido = SerenityRest.lastResponse().statusCode();

        System.out.println("=======================================");
        System.out.println("✔ VALIDACIÓN DE CÓDIGO DE ESTADO HTTP");
        System.out.println("Código Esperado: " + codigoEsperado);
        System.out.println("Código Obtenido: " + codigoObtenido);
        System.out.println("=======================================");

        return codigoObtenido == codigoEsperado;
    }
}
