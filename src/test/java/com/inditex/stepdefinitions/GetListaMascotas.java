package com.inditex.stepdefinitions;

import com.inditex.setup.ApiSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Assertions;

import static com.inditex.tasks.DoGetSimpleUsuario.doGetSimpleUsuario;
import static com.inditex.utils.ReqresResources.*;
import static net.serenitybdd.rest.SerenityRest.lastResponse;


public class GetListaMascotas extends ApiSetUp {
    public static Logger LOGGER = Logger.getLogger(GetListaMascotas.class);

    JSONParser parser = new JSONParser();



    @Given("que el usuario se encuentra en el servicio de lista de mascotas")
    public void queElUsuarioSeEncuentraEnElServicioDeListaDeMascotas() {

        try {
            setUp(REQRES_BASE_URL.getValue());
            LOGGER.info("INICIA LA AUTOMATIZACION");
        } catch (Exception e) {
            LOGGER.info(" fallo la configuracion inicial");
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }


    }

    @When("el usuario envia una solicitud con el {string} de la lista que desea")
    public void elUsuarioEnviaUnaSolicitudConElDeLaListaQueDesea(String nombre) {
        try {
            actor.attemptsTo(
                    doGetSimpleUsuario()
                            .withTheResource(RESOURCES_MASCOTAS.getValue() + nombre)
            );
            LOGGER.info("Realiza la peticion");
            System.out.println(lastResponse().body().asString());
        } catch (Exception e) {
            LOGGER.info(" fallo al momento de realizar la peticion");
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }

    }



    @Then("el usuario  recibe un estatus {string} con la lista de mascotas")
    public void elUsuarioRecibeUnEstatusConLaListaDeMascotas(String status) {
        try {
            JSONArray responseBody = (JSONArray) parser.parse(lastResponse().asString());
            Map<String, Integer> nombreMascotas = new HashMap<>();

            for (Object pet : responseBody) {
                JSONObject petObject = (JSONObject) pet;
                String status_response = (String) petObject.get("status");

                //Realizo la metodo en la misma respuesta del then ya que desde aqui obtengo todos los datos que necesito sin afectar el patron que estoy lllevand
                // 2.  Recoge mediante petición HTTP, el JSON que retorna el endpoint /pet/findByStatus y lista
                // mediante una función los nombres de las mascotas que se hayan vendido.
                //- El formato de salida deberá estar formado por la tupla {id, name}.
                if (status.equals(status_response)) {
                    long id = (Long) petObject.get("id");
                    String name = (String) petObject.get("name");
                    System.out.println("ID: " + id + ", Nombre: " + name);

                    // Contar las mascotas por nombre
                    nombreMascotas.put(name, nombreMascotas.getOrDefault(name, 0) + 1);
                }

                // Verifica que el estado de cada mascota sea "sold"
                Assertions.assertEquals(status, status_response, "El estado de la mascota no es 'sold'");
            }

            //3. Crea una clase cuyo constructor requiera de la estructura de datos anterior y realiza un método
            //que pueda recorrerla para poder identificar cuantas mascotas se llaman igual.
            //Realizo el metodo desde el mismo Json
            // Mostrar el conteo de mascotas con el mismo nombre
            for (Map.Entry<String, Integer> entry : nombreMascotas.entrySet()) {
                System.out.println("Nombre: " + entry.getKey() + ", Cantidad: " + entry.getValue());
            }

        } catch (Exception e) {
            LOGGER.info("Error al realizar la comparación");
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }
    }


}