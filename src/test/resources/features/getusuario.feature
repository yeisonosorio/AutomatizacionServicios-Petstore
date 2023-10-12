Feature: Obtener un usuario
  Como usuario de la api
  quiero  obtener un usuario
  Para poder usar los servicios del sistema


  @GetUsuario
  Scenario Outline: Obtener un usuario
    Given que el usuario se encuentra en el servicio
    When el usuario envia una solicitud con el <nombre> del usuario deseado
    Then el usuario  recibe un estatus <code> con usuario encontrado
    Examples:
      | nombre   | code |
      | "yeison" | 200  |
      | "juan"   | 200  |

