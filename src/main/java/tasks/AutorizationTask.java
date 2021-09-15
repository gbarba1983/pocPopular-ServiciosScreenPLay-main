package tasks;

import interactions.PostInteraction;
import models.newRequest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AutorizationTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        newRequest requestAut = theActorInTheSpotlight().recall("request");
        requestAut.setUrl("/Account/v1/GenerateToken");
        theActorInTheSpotlight().remember("request",requestAut);
        actor.attemptsTo(
                PostInteraction.postInteraction()
        );
        requestAut.setUrl("/Account/v1/Authorized");
        theActorInTheSpotlight().remember("request",requestAut);
        actor.attemptsTo(
                PostInteraction.postInteraction()
        );
    }

    public static AutorizationTask autorizationTask(){
        return Tasks.instrumented(AutorizationTask.class);
    }
}
