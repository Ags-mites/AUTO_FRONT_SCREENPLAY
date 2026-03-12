package com.frontendpom.questions;

import com.frontendpom.ui.KudosListPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class KudoAuthorVisible implements Question<String> {

    public static Question<String> value() {
        return new KudoAuthorVisible();
    }

    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(KudosListPage.LABEL_REMITENTE_KUDO, isVisible()).forNoMoreThan(10).seconds()
        );
        return Text.of(KudosListPage.LABEL_REMITENTE_KUDO).answeredBy(actor);
    }
}
