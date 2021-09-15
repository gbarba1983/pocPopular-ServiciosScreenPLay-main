package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class BodyQuestion implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return SerenityRest.lastResponse().getBody().toString();
    }

    public static BodyQuestion bodyQuestion(){
        return new BodyQuestion();
    }
}
