package kmstest.domain;

import java.time.LocalDate;
import java.util.*;
import kmstest.domain.*;
import kmstest.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Dellveryaccepted extends AbstractEvent {

    private Long id;
    private String orderid;
    private String address;
    private String status;
    private String customerid;

    public Dellveryaccepted(Rider aggregate) {
        super(aggregate);
    }

    public Dellveryaccepted() {
        super();
    }
}
//>>> DDD / Domain Event
