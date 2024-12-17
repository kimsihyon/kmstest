package kmstest.domain;

import java.time.LocalDate;
import java.util.*;
import kmstest.domain.*;
import kmstest.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Dellverystrated extends AbstractEvent {

    private Long id;
    private String orderid;
    private String address;
    private String status;
    private String customerid;

    public Dellverystrated(Rider aggregate) {
        super(aggregate);
    }

    public Dellverystrated() {
        super();
    }
}
//>>> DDD / Domain Event
