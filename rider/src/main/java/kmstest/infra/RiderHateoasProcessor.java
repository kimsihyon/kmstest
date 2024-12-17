package kmstest.infra;

import kmstest.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class RiderHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Rider>> {

    @Override
    public EntityModel<Rider> process(EntityModel<Rider> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/accept")
                .withRel("accept")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/dellverystrat")
                .withRel("dellverystrat")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/dellverycomplete"
                )
                .withRel("dellverycomplete")
        );

        return model;
    }
}
