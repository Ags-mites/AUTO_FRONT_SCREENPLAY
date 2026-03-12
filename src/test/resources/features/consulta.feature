Feature: Envio de reconocimientos entre compañeros
  Como empleado de Sofka
  Quiero enviar un reconocimiento (Kudo) a un compañero
  Para fortalecer la cultura de equipo

  Scenario Outline: Envio exitoso de Kudo
    Given el usuario se encuentra en la pagina de envio de Kudos
    When el usuario selecciona un remitente
    And el usuario selecciona un destinatario diferente
    And el usuario selecciona una categoría
    And el usuario escribe el "<Kudo>"
    And el usuario arrastra el slider de confirmacion
    Then el sistema muestra un mensaje de exito
    And el formulario se limpia automaticamente

    Examples:
      | Kudo                                                                                                                                                      |
      | Quiero reconocer tu gran trabajo y la actitud positiva que siempre aportas al equipo. Tu compromiso y disposición para ayudar marcan una gran diferencia. |
