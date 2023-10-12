# AutomatizacionServicios-Petstore

Este proyecto es un reto de implementación de un servicio de mascotas https://petstore.swagger.io/ utilizando el patrón de diseño Screenplay en Java.

## Descripción

El objetivo de este proyecto es demostrar la implementación de un servicio de mascotas en el que se pueden realizar operaciones como consultar una lista de mascotas, identificar cuántas mascotas comparten el mismo nombre y otras operaciones relacionadas con el servicio.

Este proyecto demuestra la implementación del patrón Screenplay en un servicio de mascotas, aprovechando Gherkin como lenguaje de definición de pruebas BDD. Los escenarios de prueba describen cómo los actores interactúan con el servicio, desde la creación de usuarios hasta la llamada al servicio y la modelación de respuestas. Este enfoque mejora la organización, legibilidad y mantenibilidad de las pruebas, permitiendo una estructura clara y concisa en cada escenario

1. Crea tu usuario mediante petición HTTP y posteriormente recupera sus datos llamando al
servicio correspondiente.

Creo el usuario desde un escenario Outline donde envio los parametros de los usuarios que deseo crear y posterior, desde la peticion GetUsuario obtengo esos usuarios que acabe de crear 

3. Recoge mediante petición HTTP, el JSON que retorna el endpoint /pet/findByStatus y lista
mediante una función los nombres de las mascotas que se hayan vendido.
- El formato de salida deberá estar formado por la tupla {id, name}.
- Puedes utilizar la estructura de datos que prefieras.

En este punto en la respuesta que recibo de la peticion modelo el Json con los datos que necesito gracias al uso del JSONParser que permite convertir al Json en un objeto y manejarlo de la forma que lo necesite
  
3. Crea una clase cuyo constructor requiera de la estructura de datos anterior y realiza un método
que pueda recorrerla para poder identificar cuantas mascotas se llaman igual.
- Ejemplo de salida: {“William”: 11, “ Floyd”: 2} Como output, te pediremos el código (puedes
separarlo en archivos como quieras) y los resultados de salida de los puntos anteriores.
- Recuerda que puedes utilizar el lenguaje que prefieras y cualquier mejora adicional será bien
considerada

En este punto reutilizo la misma respuesta y la formateo de la manera que la necesito sin la necesidad de crear otras clases u objetos, como ya estoy obteniendo la respuesta lo que hago es recorrecta y contar las coincidencias que tengan los nombre y sumar las cantidades
## Patrón Screenplay

El patrón de diseño Screenplay es un enfoque de automatización de pruebas que se centra en la colaboración entre actores y la composición de tareas de manera modular y legible. En este proyecto, hemos utilizado el patrón Screenplay para definir actores, tareas y preguntas que representan las acciones y consultas del servicio de mascotas.

## Tecnologías Utilizadas

- Java: 11.
- Gradle: Sistema de construcción.
- Cucumber: Framework de pruebas BDD.
- Serenity BDD: Biblioteca para la implementación del patrón Screenplay.
- Git: Sistema de control de versiones.
- RestAssured

## Configuración

Asegúrate de tener Java y Gradle instalados en tu entorno de desarrollo. Luego, puedes clonar este repositorio:

## Estructura del proyecto

<pre>
src
│-main
├── java
│   ├── com
│   │   ├── inditex
│   │   │   ├── interactions
│   │   │   │   ├── OurGet
│   │   │   │   ├── OurPost
│   │   │   ├── models
│   │   │   │   ├── Category
│   │   │   │   ├── ModelCrearUsuario
│   │   │   │   ├── ResponsePet
│   │   │   │   ├── Tag
│   │   │   ├── questions
│   │   │   │   ├── ReturnQuestionGetListaMascotas
│   │   │   ├── tasks
│   │   │   │   ├── DoGetSimpleUsuario
│   │   │   │   ├── DoPostCrearUsuario
│   │   │   ├── utils
│   │   │   │   ├── Log4jValues
│   │   │   │   ├── ReqresResources
│   │   ├── test
│   │   │   ├── java
│   │   │   │   ├── com
│   │   │   │   │   ├── inditex
│   │   │   │   │   │   ├── runners
│   │   │   │   │   │   │   ├── GetListaMascotas
│   │   │   │   │   │   │   ├── GetUsuarioRunnerResponse
│   │   │   │   │   │   │   ├── PostUsuarioRunnerResponse
│   │   │   │   │   │   │   ├── RunnerGeneral
│   │   │   │   │   ├── setup
│   │   │   │   │   │   ├── ApiSetUp
│   │   │   │   │   ├── stepdefinitions
│   │   │   │   │   │   ├── CrearUsuarioPost
│   │   │   │   │   │   ├── GetListaMascotas
│   │   │   │   │   │   ├── GetUsuarioStepDefinition
│   │   │   │   ├── resources
│   │   │   │   │   ├── features
│   │   │   │   │   │   ├── crearusuario.feature
│   │   │   │   │   │   ├── getlistamascotas.feature
│   │   │   │   │   │   ├── getusuario.feature
│   │   │   │   │   ├── log4j.properties
</pre>

## Ejecución de Pruebas
Puedes ejecutar las pruebas utilizando Gradle. Abre una terminal en el directorio raíz del proyecto y ejecuta el siguiente comando:


 `gradle clean test`
