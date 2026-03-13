package com.frontendpom.questions;

import com.frontendpom.ui.KudosCreatePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.TimeoutException;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SuccessMessage implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        try {
            actor.attemptsTo(WaitUntil.the(KudosCreatePage.TOAST_SUCCESS, isVisible()).forNoMoreThan(15).seconds());
            return KudosCreatePage.TOAST_SUCCESS.resolveFor(actor).getText();
        } catch (TimeoutException e) {
            throw new RuntimeException("El mensaje de éxito no fue encontrado en el tiempo esperado", e);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener el mensaje de éxito: " + e.getMessage(), e);
        }
    }

    public static SuccessMessage successMessage() {
        return new SuccessMessage();
    }
}
