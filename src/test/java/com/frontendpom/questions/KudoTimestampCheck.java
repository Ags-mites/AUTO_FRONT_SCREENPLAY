package com.frontendpom.questions;

import com.frontendpom.ui.KudosListPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class KudoTimestampCheck implements Question<String> {

    public static Question<String> value() {
        return new KudoTimestampCheck();
    }

    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(KudosListPage.LABEL_FECHA_KUDO, isVisible()).forNoMoreThan(10).seconds()
        );
        return Text.of(KudosListPage.LABEL_FECHA_KUDO).answeredBy(actor);
    }
}
