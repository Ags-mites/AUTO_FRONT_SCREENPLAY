package com.frontendpom.questions;

import com.frontendpom.ui.KudosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class SuccessMessage implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return KudosPage.TOAST_SUCCESS.resolveFor(actor).getText();
    }

    public static SuccessMessage successMessage() {
        return new SuccessMessage();
    }
}
