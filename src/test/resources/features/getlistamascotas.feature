Feature: Obtener una lista de mascotas
  Como usuario de la api de mascotas
  quiero obtener una lista de mascotas
  Para poder usar los servicios del sistema


  @GetListaMascotas
  Scenario Outline: Obtener una lista de mascotas
    Given que el usuario se encuentra en el servicio de lista de mascotas
    When el usuario envia una solicitud con el <nombre> de la lista que desea
    Then el usuario  recibe un estatus <status> con la lista de mascotas
    Examples:
      | nombre | status   |
      | "sold" | "sold" |


