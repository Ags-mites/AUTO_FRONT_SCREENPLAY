package com.frontendpom.stepdefinitions;

import com.frontendpom.hooks.OpenBrowser;
import com.frontendpom.questions.SuccessMessage;
import com.frontendpom.questions.FormCleaned;
import com.frontendpom.tasks.SlideRight;
import com.frontendpom.ui.KudosCreatePage;
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

    @Given("que el empleado se encuentra en la pantalla de \"Envío de Kudos\"")
    public void theUserIsOnKudoSendPage() {
        OnStage.theActorCalled(Config.ACTOR_NAME).attemptsTo(
            OpenBrowser.openUrl(Config.BASE_URL),
            SlideRight.on(KudosCreatePage.SLIDER_HOMEPAGE, 600),
            WaitUntil.the(KudosCreatePage.SELECT_REMITENTE, isVisible()).forNoMoreThan(20).seconds()
        );
        OnStage.theActorInTheSpotlight();
    }

    @When("el empleado selecciona como remitente a {string}")
    public void theUserSelectsSender(String sender) {
        OnStage.theActorInTheSpotlight().attemptsTo(
            SelectFromOptions.byVisibleText(sender).from(KudosCreatePage.SELECT_REMITENTE)
        );
    }

    @When("busca y selecciona al destinatario {string}")
    public void theUserSelectsDifferentReceiver(String receiver) {
        OnStage.theActorInTheSpotlight().attemptsTo(
            SelectFromOptions.byVisibleText(receiver).from(KudosCreatePage.SELECT_DESTINATARIO)
        );
    }

    @When("elige la categoría de reconocimiento {string}")
    public void theUserSelectsCategory(String category) {
        OnStage.theActorInTheSpotlight().attemptsTo(
            SelectFromOptions.byVisibleText(category).from(KudosCreatePage.SELECT_CATEGORIA)
        );
    }

    @When("escribe un mensaje de agradecimiento: {string}")
    public void theUserWritesTheKudo(String kudo) {
        OnStage.theActorInTheSpotlight().attemptsTo(
            Enter.theValue(kudo).into(KudosCreatePage.TEXTAREA_MENSAJE),
            Hit.the(Keys.TAB).into(KudosCreatePage.TEXTAREA_MENSAJE)
        );
        setTextareaValue(kudo);
    }

    @When("desliza el control de confirmación hasta el final")
    public void theUserDragsConfirmationSlider() {
        OnStage.theActorInTheSpotlight().attemptsTo(
            SlideRight.on(KudosCreatePage.SLIDER_ENVIO, 420)
        );
    }

    @Then("el sistema debe mostrar una notificación de envío exitoso")
    public void theSystemShowsSuccessMessage() {
        OnStage.theActorInTheSpotlight().attemptsTo(
            WaitUntil.the(KudosCreatePage.TOAST_SUCCESS, isVisible()).forNoMoreThan(15).seconds()
        );
        OnStage.theActorInTheSpotlight().should(
            seeThat(SuccessMessage.successMessage(), containsString("Kudo enviado"))
        );
    }

    @And("los campos del formulario deben quedar vacíos para un nuevo registro")
    public void theFormIsCleanedAutomatically() {
        OnStage.theActorInTheSpotlight().should(
            seeThat(FormCleaned.formCleaned(), is(true))
        );
    }

    private void setTextareaValue(String value) {
        WebElement textarea = KudosCreatePage.TEXTAREA_MENSAJE.resolveFor(OnStage.theActorInTheSpotlight());
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
