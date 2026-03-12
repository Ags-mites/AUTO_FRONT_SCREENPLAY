package com.frontendpom.questions;

import com.frontendpom.ui.KudosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class FormCleaned implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        String message = KudosPage.TEXTAREA_MENSAJE.resolveFor(actor).getAttribute("value");
        return message == null || message.isEmpty();
    }

    public static FormCleaned formCleaned() {
        return new FormCleaned();
    }
}
