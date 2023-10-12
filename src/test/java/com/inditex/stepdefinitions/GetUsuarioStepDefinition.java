package com.inditex.stepdefinitions;

import com.inditex.setup.ApiSetUp;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static com.inditex.tasks.DoGetSimpleUsuario.doGetSimpleUsuario;
import static com.inditex.utils.ReqresResources.REQRES_BASE_URL;
import static com.inditex.utils.ReqresResources.RESOURCES;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;


public class GetUsuarioStepDefinition extends ApiSetUp {


    public static Logger LOGGER = Logger.getLogger(GetUsuarioStepDefinition.class);

    @Given("que el usuario se encuentra en el servicio")
    public void queElUsuarioSeEncuentraEnElServicio() {
        try {
            setUp(REQRES_BASE_URL.getValue());
            LOGGER.info("INICIA LA AUTOMATIZACION");
        } catch (Exception e) {
            LOGGER.info(" fallo la configuracion inicial");
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }


    }

    @When("el usuario envia una solicitud con el {string} del usuario deseado")
    public void elUsuarioEnviaUnaSolicitudConElDelUsuarioDeseado(String nombre) {
        try {
            actor.attemptsTo(
                    doGetSimpleUsuario()
                            .withTheResource(RESOURCES.getValue() + nombre)
            );
            LOGGER.info("Realiza la peticion");
            System.out.println(SerenityRest.lastResponse().body().asString());
        } catch (Exception e) {
            LOGGER.info(" fallo al momento de realizar la peticion");
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }
    }

    @Then("el usuario  recibe un estatus {int} con usuario encontrado")
    public void elUsuarioRecibeUnEstatusConUsuarioEncontrado(Integer code) {
        try {
            actor.should(
                    seeThatResponse("El codigo de respuesta es: " + code,
                            response -> response.statusCode(code))
            );
            LOGGER.info("CUMPLE");
        } catch (
                Exception e) {
            LOGGER.info("Error al realizar la comparacion");
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }
    }


}
