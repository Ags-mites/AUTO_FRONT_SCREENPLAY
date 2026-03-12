package com.frontendpom.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SlideRight implements Task {

    private final Target target;
    private final int offset;

    public SlideRight(Target target, int offset) {
        this.target = target;
        this.offset = offset;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebElement draggable = target.resolveFor(actor);
        WebElement track = draggable.findElement(By.xpath("ancestor::div[contains(@class,'cursor-pointer')][1]"));

        int dynamicDistance = Math.max(0, track.getSize().getWidth() - draggable.getSize().getWidth() - 4);
        int distanceToMove = Math.max(offset, dynamicDistance);

        new Actions(BrowseTheWeb.as(actor).getDriver())
                .clickAndHold(draggable)
            .moveByOffset(distanceToMove, 0)
                .release()
                .perform();
    }

    public static Task on(Target target, int offset) {
        return Tasks.instrumented(SlideRight.class, target, offset);
    }
}
