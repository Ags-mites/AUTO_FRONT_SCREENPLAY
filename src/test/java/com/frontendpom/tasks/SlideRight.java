package com.frontendpom.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.TimeoutException;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SlideRight implements Task {

    private final Target target;
    private final int offset;

    public SlideRight(Target target, int offset) {
        this.target = target;
        this.offset = offset;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(WaitUntil.the(target, isVisible()).forNoMoreThan(10).seconds());
            
            WebElement draggable = target.resolveFor(actor);
            String sliderText = draggable.getText();
            WebElement track = draggable.findElement(By.xpath("ancestor::div[.//span[contains(normalize-space(.),'Desliza')]][1]"));

            int dynamicDistance = Math.max(0, track.getSize().getWidth() - draggable.getSize().getWidth() - 4);
            int distanceToMove = Math.max(offset, dynamicDistance);

            new Actions(BrowseTheWeb.as(actor).getDriver())
                    .clickAndHold(draggable)
                .moveByOffset(distanceToMove, 0)
                    .release()
                    .perform();
        } catch (TimeoutException e) {
            throw new RuntimeException("El elemento deslizable no fue encontrado en el tiempo esperado: " + target, e);
        } catch (Exception e) {
            throw new RuntimeException("Error al realizar el deslizamiento: " + e.getMessage(), e);
        }
    }

    public static Task on(Target target, int offset) {
        return Tasks.instrumented(SlideRight.class, target, offset);
    }
}
