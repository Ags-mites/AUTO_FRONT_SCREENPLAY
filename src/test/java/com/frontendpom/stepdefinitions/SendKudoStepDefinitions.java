package com.frontendpom.stepdefinitions;

import com.frontendpom.hooks.OpenBrowser;
import com.frontendpom.questions.SuccessMessage;
import com.frontendpom.questions.FormCleaned;
import com.frontendpom.tasks.SlideRight;
import com.frontendpom.ui.KudosPage;
import com.frontendpom.util.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class SendKudoStepDefinitions {

    @Given("el usuario se encuentra en la pagina de envio de Kudos")
    public void theUserIsOnKudoSendPage() {
        OnStage.theActorCalled(Config.ACTOR_NAME).attemptsTo(
            OpenBrowser.openUrl(Config.BASE_URL),
            SlideRight.on(KudosPage.SLIDER_HOMEPAGE, 600),
            WaitUntil.the(KudosPage.SELECT_REMITENTE, isVisible()).forNoMoreThan(20).seconds()
        );
        OnStage.theActorInTheSpotlight();
    }

    @When("el usuario selecciona un remitente")
    public void theUserSelectsSender() {
        OnStage.theActorInTheSpotlight().attemptsTo(
            SelectFromOptions.byVisibleText(Config.SENDER).from(KudosPage.SELECT_REMITENTE)
        );
    }

    @When("el usuario selecciona un destinatario diferente")
    public void theUserSelectsDifferentReceiver() {
        OnStage.theActorInTheSpotlight().attemptsTo(
            SelectFromOptions.byVisibleText(Config.RECEIVER).from(KudosPage.SELECT_DESTINATARIO)
        );
    }

    @When("el usuario selecciona una categoría")
    public void theUserSelectsCategory() {
        OnStage.theActorInTheSpotlight().attemptsTo(
            SelectFromOptions.byVisibleText(Config.CATEGORY).from(KudosPage.SELECT_CATEGORIA)
        );
    }

    @When("el usuario escribe el {string}")
    public void theUserWritesTheKudo(String kudo) {
        OnStage.theActorInTheSpotlight().attemptsTo(
            Enter.theValue(kudo).into(KudosPage.TEXTAREA_MENSAJE),
            Hit.the(Keys.TAB).into(KudosPage.TEXTAREA_MENSAJE)
        );
        setTextareaValue(kudo);
    }

    @When("el usuario arrastra el slider de confirmacion")
    public void theUserDragsConfirmationSlider() {
        OnStage.theActorInTheSpotlight().attemptsTo(
            SlideRight.on(KudosPage.SLIDER_ENVIO, 420)
        );
    }

    @Then("el sistema muestra un mensaje de exito")
    public void theSystemShowsSuccessMessage() {
        OnStage.theActorInTheSpotlight().attemptsTo(
            WaitUntil.the(KudosPage.TOAST_SUCCESS, isVisible()).forNoMoreThan(15).seconds()
        );
        OnStage.theActorInTheSpotlight().should(
            seeThat(SuccessMessage.successMessage(), containsString("Kudo enviado"))
        );
    }

    @And("el formulario se limpia automaticamente")
    public void theFormIsCleanedAutomatically() {
        OnStage.theActorInTheSpotlight().should(
            seeThat(FormCleaned.formCleaned(), is(true))
        );
    }

    private void setTextareaValue(String value) {
        WebElement textarea = KudosPage.TEXTAREA_MENSAJE.resolveFor(OnStage.theActorInTheSpotlight());
        JavascriptExecutor js = (JavascriptExecutor) BrowseTheWeb.as(OnStage.theActorInTheSpotlight()).getDriver();
        js.executeScript(
            "const textarea = arguments[0];" +
            "const value = arguments[1];" +
            "const setter = Object.getOwnPropertyDescriptor(window.HTMLTextAreaElement.prototype, 'value').set;" +
            "setter.call(textarea, value);" +
            "textarea.dispatchEvent(new Event('input', { bubbles: true }));" +
            "textarea.dispatchEvent(new Event('change', { bubbles: true }));",
                textarea,
                value
        );
    }

}
