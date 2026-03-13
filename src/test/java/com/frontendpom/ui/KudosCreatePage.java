package com.frontendpom.ui;

import net.serenitybdd.screenplay.targets.Target;

public class KudosCreatePage {

    public static final Target SLIDER_HOMEPAGE = Target.the("Slider homepage")
            .locatedBy("//span[contains(normalize-space(.),'Desliza para conectar')]/ancestor::div[contains(@class,'cursor-pointer')]//div[contains(@class,'bg-brand')]");

    public static final Target SELECT_REMITENTE = Target.the("Select remitente")
            .locatedBy("//select[@name='from']");

    public static final Target SELECT_DESTINATARIO = Target.the("Select destinatario")
            .locatedBy("//select[@name='to']");

    public static final Target SELECT_CATEGORIA = Target.the("Select categoría")
            .locatedBy("//select[@name='category']");

    public static final Target TEXTAREA_MENSAJE = Target.the("Textarea mensaje")
            .locatedBy("//textarea[@name='message']");

    public static final Target SLIDER_ENVIO = Target.the("Slider de envío")
            .locatedBy("//span[contains(normalize-space(.),'Desliza para enviar')]/ancestor::div[contains(@class,'cursor-pointer')]//div[contains(@class,'bg-brand')]");

    public static final Target TOAST_SUCCESS = Target.the("Toast éxito")
            .locatedBy("//li[@data-sonner-toast and @data-type='success']");

}
