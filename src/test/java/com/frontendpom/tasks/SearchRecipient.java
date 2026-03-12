package com.frontendpom.tasks;

import com.frontendpom.ui.KudosListPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SearchRecipient implements Task {
    private final String recipient;

    public SearchRecipient(String recipient) {
        this.recipient = recipient;
    }

    public static SearchRecipient byEmail(String recipient) {
        return instrumented(SearchRecipient.class, recipient);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(KudosListPage.INPUT_BUSQUEDA, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(recipient).into(KudosListPage.INPUT_BUSQUEDA).thenHit(Keys.TAB),
                net.serenitybdd.screenplay.actions.Click.on(KudosListPage.BTN_APLICAR_FILTROS)
        );
    }
}
