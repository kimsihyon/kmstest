package kmstest.domain;

import java.time.LocalDate;
import java.util.*;
import kmstest.domain.*;
import kmstest.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Dellverycompleted extends AbstractEvent {

    private Long id;
    private String orderid;
    private String address;
    private String status;
    private String customerid;

    public Dellverycompleted(Rider aggregate) {
        super(aggregate);
    }

    public Dellverycompleted() {
        super();
    }
}
//>>> DDD / Domain Event
