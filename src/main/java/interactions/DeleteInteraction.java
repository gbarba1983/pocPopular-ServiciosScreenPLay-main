package interactions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Delete;

public class DeleteInteraction implements Interaction {
    private Object token;
    private Object uuid;

    @Override
    public <T extends Actor> void performAs(T actor) {
        token = SerenityRest.lastResponse().getBody().path("token");
        uuid = SerenityRest.lastResponse().getBody().path("userId");
        actor.attemptsTo(Delete.from("/Account/v1/User/{UUID}").with(request -> request
                .pathParam("UUID",uuid)
                .header("Authorization","Bearer "+ token)));
    }


}
