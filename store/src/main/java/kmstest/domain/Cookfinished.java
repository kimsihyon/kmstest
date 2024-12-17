package kmstest.domain;

import java.time.LocalDate;
import java.util.*;
import kmstest.domain.*;
import kmstest.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Cookfinished extends AbstractEvent {

    private Long id;
    private String foodid;
    private String options;
    private String status;
    private String orderid;
    private String address;
    private String customerid;

    public Cookfinished(Cooking aggregate) {
        super(aggregate);
    }

    public Cookfinished() {
        super();
    }
}
//>>> DDD / Domain Event
