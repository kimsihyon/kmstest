package kmstest.domain;

import java.time.LocalDate;
import java.util.*;
import kmstest.domain.*;
import kmstest.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Ordercanclled extends AbstractEvent {

    private Long id;
    private String foodid;
    private String options;
    private String price;
    private String status;
    private String address;
    private String customerid;

    public Ordercanclled(Order aggregate) {
        super(aggregate);
    }

    public Ordercanclled() {
        super();
    }
}
//>>> DDD / Domain Event
