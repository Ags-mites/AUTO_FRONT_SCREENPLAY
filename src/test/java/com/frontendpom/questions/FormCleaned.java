package com.frontendpom.questions;

import com.frontendpom.ui.KudosCreatePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.TimeoutException;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FormCleaned implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            actor.attemptsTo(WaitUntil.the(KudosCreatePage.TEXTAREA_MENSAJE, isVisible()).forNoMoreThan(10).seconds());
            String message = KudosCreatePage.TEXTAREA_MENSAJE.resolveFor(actor).getAttribute("value");
            return message == null || message.isEmpty();
        } catch (TimeoutException e) {
            throw new RuntimeException("El formulario no fue encontrado en el tiempo esperado", e);
        } catch (Exception e) {
            throw new RuntimeException("Error al verificar el formulario: " + e.getMessage(), e);
        }
    }

    public static FormCleaned formCleaned() {
        return new FormCleaned();
    }
}
