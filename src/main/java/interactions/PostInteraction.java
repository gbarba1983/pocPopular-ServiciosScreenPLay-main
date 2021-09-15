package interactions;

import models.newRequest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PostInteraction implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        newRequest requestAut = theActorInTheSpotlight().recall("request");
        theActorInTheSpotlight().attemptsTo(Post.to(requestAut.getUrl()).with(request -> request
                .contentType("application/json; charset=utf-8")
                .body(requestAut.getAuthorizationBody())
                .relaxedHTTPSValidation()));
    }

    public static PostInteraction postInteraction(){
        return Tasks.instrumented(PostInteraction.class);
    }
}
