package com.makers.qa.questions;

import com.makers.qa.userinterfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class LoginQuestion implements Question<Boolean> {

    private final String mensajeEsperado;


    public LoginQuestion(String mensajeEsperado) {
        this.mensajeEsperado = mensajeEsperado;
    }

    public static LoginQuestion validarMensaje(String mensajeEsperado) {
        return new LoginQuestion(mensajeEsperado);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String mensajeObtenido;

        if (LoginPage.ERROR_MESSAGE.resolveFor(actor).isVisible()) {
            mensajeObtenido = LoginPage.ERROR_MESSAGE.resolveFor(actor).getText().trim();
        } else {
            mensajeObtenido = LoginPage.PRODUCTS_TITLE.resolveFor(actor).getText().trim();
        }


        System.out.println("=======================================");
        System.out.println("✔ VALIDACIÓN DE LA PANTALLA");
        System.out.println("Mensaje a probar (Esperado): " + mensajeEsperado);
        System.out.println("Mensaje obtenido (Actual): " + mensajeObtenido);
        System.out.println("=======================================");

        return mensajeObtenido.contains(mensajeEsperado);
    }
}