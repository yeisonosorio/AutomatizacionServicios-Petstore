Feature: Crear usuario
  Como usuario de la tienda de mascotas
  quiero crear un usuario
  Para poder usar los servicios del sistema

  @CrearUsuario
  Scenario Outline: Crear un nuevo usuario
    Given que el usuario se encuentra en servicio para crear usuario
    When el usuario envia la peticion de crea un nuevo usuario con <id>, <username>, <firstName>, <lastName>, <email>, <password>, <phone>, <userStatus>
    Then el usuario debria ver un mensaje con informacion del nuevo usuario creado con un estatus <code>
    Examples:
      | id | username | firstName | lastName | email             | password | phone      | userStatus | code |
      | 10 | "yeison" | "oso"     | "bui"    | "yei@gmail.com"   | "1234"   | "31385487" | 1          | 200  |
      | 20 | "juan"   | "perez"   | "rodri"  | "rodri@gmail.com" | "1234"   | "3158151d" | 0          | 200  |

