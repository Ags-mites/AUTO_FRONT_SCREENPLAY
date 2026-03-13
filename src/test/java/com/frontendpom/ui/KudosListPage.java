package com.frontendpom.ui;

import net.serenitybdd.screenplay.targets.Target;

public class KudosListPage {
    
    public static final Target LINK_EXPLORADOR = Target.the("Link Explorador Kudos")
            .locatedBy("//button[contains(normalize-space(.), 'Explorar Kudos')]");

    public static final Target SELECT_FILTRO_CATEGORIA = Target.the("Filtro Categoría")
             .locatedBy("//select[@aria-label='Filtrar por categoría']");

    public static final Target INPUT_BUSQUEDA = Target.the("Input Búsqueda por correo")
             .locatedBy("//input[@aria-label='Buscar kudos']");

    public static final Target BTN_APLICAR_FILTROS = Target.the("Botón Aplicar Filtros")
             .locatedBy("//button[contains(., 'Aplicar Filtros')]");

    public static final Target DATA_ROW = Target.the("Fila del Kudo encontrado")
             .locatedBy("//tbody/tr[1]");

    public static final Target LABEL_MENSAJE_KUDO = Target.the("Mensaje del Kudo")
             .locatedBy("//tbody/tr[1]/td[4]");

    public static final Target LABEL_REMITENTE_KUDO = Target.the("Remitente del Kudo")
             .locatedBy("//tbody/tr[1]/td[1]");

    public static final Target LABEL_FECHA_KUDO = Target.the("Fecha del Kudo")
             .locatedBy("//tbody/tr[1]/td[5]");
}
