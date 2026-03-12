package com.frontendpom.ui;

import net.serenitybdd.screenplay.targets.Target;

public class KudosPage {

    public static final Target SLIDER_HOMEPAGE = Target.the("Slider homepage")
            .locatedBy("(//span[contains(normalize-space(.),'Desliza para conectar')]/ancestor::div[contains(@class,'cursor-pointer')][1]//*[contains(@class,'w-16') and contains(@class,'rounded-full') and contains(@class,'bg-brand')])[1]");

    public static final Target SELECT_REMITENTE = Target.the("Select remitente")
            .locatedBy("(//label[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZÁÉÍÓÚ','abcdefghijklmnopqrstuvwxyzáéíóú'),'remitente')]/following::select[1] | //select[contains(translate(@id,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'remit') or contains(translate(@name,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'remit') or contains(translate(@id,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'sender') or contains(translate(@name,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'sender')])[1]");

    public static final Target SELECT_DESTINATARIO = Target.the("Select destinatario")
            .locatedBy("(//label[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZÁÉÍÓÚ','abcdefghijklmnopqrstuvwxyzáéíóú'),'destinatario') or contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZÁÉÍÓÚ','abcdefghijklmnopqrstuvwxyzáéíóú'),'destino')]/following::select[1] | //select[@name='to' or contains(translate(@id,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'destinat') or contains(translate(@name,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'destinat') or contains(translate(@id,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'receiver') or contains(translate(@name,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'receiver')])[1]");

    public static final Target SELECT_CATEGORIA = Target.the("Select categoría")
            .locatedBy("(//label[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZÁÉÍÓÚ','abcdefghijklmnopqrstuvwxyzáéíóú'),'categor')]/following::select[1] | //select[contains(translate(@id,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'categor') or contains(translate(@name,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'categor')])[1]");

    public static final Target TEXTAREA_MENSAJE = Target.the("Textarea mensaje")
            .locatedBy("(//label[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZÁÉÍÓÚ','abcdefghijklmnopqrstuvwxyzáéíóú'),'mensaje')]/following::textarea[1] | //textarea[contains(translate(@id,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'mensaje') or contains(translate(@name,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'mensaje') or contains(translate(@id,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'message') or contains(translate(@name,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'message')])[1]");

    public static final Target SLIDER_ENVIO = Target.the("Slider de envío")
            .locatedBy("(//span[contains(normalize-space(.),'Desliza para enviar')]/ancestor::div[contains(@class,'cursor-pointer')][1]//*[contains(@class,'w-16') and contains(@class,'rounded-full') and contains(@class,'bg-brand')])[1]");

    public static final Target TOAST_SUCCESS = Target.the("Toast éxito")
            .locatedBy("(//li[@data-sonner-toast and @data-type='success']//div[@data-title] | //*[contains(normalize-space(.),'Kudo enviado')])[1]");
}
