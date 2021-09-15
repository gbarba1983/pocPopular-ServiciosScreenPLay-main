package tasks;

import interactions.DeleteInteraction;
import interactions.PostInteraction;
import models.newRequest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DeleteTask  implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        newRequest requestAut = theActorInTheSpotlight().recall("request");
        actor.attemptsTo(
                PostInteraction.postInteraction());
        requestAut.setUrl("/Account/v1/Login");
        actor.attemptsTo(
                PostInteraction.postInteraction(),
                Tasks.instrumented(DeleteInteraction.class)
        );
    }
}
