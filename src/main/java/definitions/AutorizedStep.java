package definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import models.newRequest;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.Tasks;
import questions.BodyQuestion;
import tasks.AutorizationTask;
import tasks.DeleteTask;
import tasks.ObtenerTokenTask;

import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class AutorizedStep {



    @Given("el usuario carga la informacion de la url")
    public void elUsuarioCargaLaInformacionDeLaUrlHttpsDemoqaComAccountV1Authorized(newRequest request) {
        theActorInTheSpotlight().remember("request",request);
    }
    @When("el ingresa los datos")
    public void elIngresaLosDatosPruebaServicioYPrueba123() {
        theActorInTheSpotlight().attemptsTo(AutorizationTask.autorizationTask());


    }
    @Then("el obtiene una respuesta exitosa")
    public void elObtieneUnaRespuestaExitosa() {
        newRequest requestAut = theActorInTheSpotlight().recall("request");
        theActorInTheSpotlight().should(seeThatResponse("mensaje", response -> response.statusCode(Integer.parseInt(requestAut.getCode()))));
    }

    @When("el ingresa los datos para Obtener Token")
    public void elIngresaLosDatosParaObtenerToken() {
        theActorInTheSpotlight().attemptsTo(ObtenerTokenTask.autorizationTask());

    }

    @Then("el obtiene una respuesta de generacion de token exitosa")
    public void elObtieneUnaRespuestaDeGeneracionDeTokenExitosa() {

        Response response = SerenityRest.lastResponse();

        theActorInTheSpotlight().should(GivenWhenThen.seeThat("validacion de respuestas", BodyQuestion.bodyQuestion(),sameBeanAs("{\n" +
                "    \"token\": \"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6IlBydWViYVNlcnZpY2lvIiwicGFzc3dvcmQiOiJQcnVlYmExMjMqIiwiaWF0IjoxNjI4MTY3MDExfQ.xw14PxUsM5h3jDMsuDMerWnkbgJR99NBkdAcUJQqFtA\",\n" +
                "    \"expires\": \"2021-08-12T12:36:51.824Z\",\n" +
                "    \"status\": \"Success\",\n" +
                "    \"result\": \"User authorized successfully.\"\n" +
                "}")));
    }

    @Given("el usuario carga la informacion para la eliminacion")
    public void elUsuarioCargaLaInformacionParaLaEliminacion() {

    }

    @When("se realiza la elimnacion")
    public void seRealizaLaElimnacion() {
        theActorInTheSpotlight().attemptsTo(Tasks.instrumented(DeleteTask.class));
    }
}
