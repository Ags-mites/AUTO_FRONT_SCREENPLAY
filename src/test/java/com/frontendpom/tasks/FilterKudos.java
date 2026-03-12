package com.frontendpom.tasks;

import com.frontendpom.ui.KudosListPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FilterKudos implements Task {
    private final String category;

    public FilterKudos(String category) {
        this.category = category;
    }

    public static FilterKudos byCategory(String category) {
        return instrumented(FilterKudos.class, category);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(KudosListPage.SELECT_FILTRO_CATEGORIA, isVisible()).forNoMoreThan(10).seconds(),
                SelectFromOptions.byVisibleText(category).from(KudosListPage.SELECT_FILTRO_CATEGORIA),
                net.serenitybdd.screenplay.actions.Click.on(KudosListPage.BTN_APLICAR_FILTROS)
        );
    }
}
