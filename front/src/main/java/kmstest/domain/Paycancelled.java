package kmstest.domain;

import java.time.LocalDate;
import java.util.*;
import kmstest.domain.*;
import kmstest.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Paycancelled extends AbstractEvent {

    private Long id;
    private String price;
    private String ordereid;
    private String status;

    public Paycancelled(Payment aggregate) {
        super(aggregate);
    }

    public Paycancelled() {
        super();
    }
}
//>>> DDD / Domain Event
