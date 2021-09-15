package tasks;

import interactions.PostInteraction;
import models.newRequest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ObtenerTokenTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                PostInteraction.postInteraction()
        );
    }

    public static ObtenerTokenTask autorizationTask(){
        return Tasks.instrumented(ObtenerTokenTask.class);
    }
}
