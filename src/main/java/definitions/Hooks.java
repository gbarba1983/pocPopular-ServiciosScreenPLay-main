package definitions;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class Hooks {

    @Before
    public void prepararEscenario(){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Maleja").whoCan(CallAnApi.at("https://demoqa.com"));
    }
}
