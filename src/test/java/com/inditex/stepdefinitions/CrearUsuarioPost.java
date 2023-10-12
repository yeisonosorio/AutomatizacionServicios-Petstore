package com.inditex.stepdefinitions;

import com.inditex.models.ModelCrearUsuario;
import com.inditex.setup.ApiSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;

import static com.inditex.tasks.DoPostCrearUsuario.doPost;
import static com.inditex.utils.ReqresResources.REQRES_BASE_URL;
import static com.inditex.utils.ReqresResources.RESOURCES;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class CrearUsuarioPost extends ApiSetUp {

    private ModelCrearUsuario modelCrearUsuario = new ModelCrearUsuario();

    JSONParser parser = new JSONParser();
    JSONObject responseBody = null;
    public static Logger LOGGER = Logger.getLogger(CrearUsuarioPost.class);


    @Given("que el usuario se encuentra en servicio para crear usuario")
    public void queElUsuarioSeEncuentraEnServicioParaCrearUsuario() {
        try {
            setUp(REQRES_BASE_URL.getValue());
            LOGGER.info("INICIA LA AUTOMATIZACION");
        } catch (Exception e) {
            LOGGER.info(" fallo la configuracion inicial");
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }
    }

    @When("el usuario envia la peticion de crea un nuevo usuario con {int}, {string}, {string}, {string}, {string}, {string}, {string}, {int}")
    public void elUsuarioEnviaLaPeticionDeCreaUnNuevoUsuarioCon(Integer id, String username, String firstName, String lastName, String email, String password, String phone, Integer userStatus) {

        setVariables(id, username, firstName, lastName, email, password, phone, userStatus);

        try {
            actor.attemptsTo(
                    doPost()
                            .withTheResource(RESOURCES.getValue())
                            .andTheRequestBody(modelCrearUsuario)
            );
            LOGGER.info("Realiza la peticion");
            System.out.println(lastResponse().body().asString());
        } catch (Exception e) {
            LOGGER.info(" fallo al momento de realizar la peticion");
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }
    }

    @Then("el usuario debria ver un mensaje con informacion del nuevo usuario creado con un estatus {int}")
    public void elUsuarioDebriaVerUnMensajeConInformacionDelNuevoUsuarioCreadoConUnEstatus(Integer code) {
        try {

            actor.should(
                    seeThatResponse("El codigo de respuesta es: " + code,
                            response -> response.statusCode(code))
            );
            responseBody = (JSONObject) parser.parse(lastResponse().asString());

        } catch (AssertionError e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail("La validación de la respuesta del servidor ha fallado.");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


    private void setVariables(Integer id, String username, String firstName, String lastName, String email, String password, String phone, Integer userStatus) {
        modelCrearUsuario.setId(id);
        modelCrearUsuario.setUsername(username);
        modelCrearUsuario.setFirstName(firstName);
        modelCrearUsuario.setLastName(lastName);
        modelCrearUsuario.setEmail(email);
        modelCrearUsuario.setPassword(password);
        modelCrearUsuario.setPhone(phone);
        modelCrearUsuario.setUserStatus(userStatus);
    }

}
