package kmstest.domain;

import java.time.LocalDate;
import java.util.*;
import kmstest.domain.*;
import kmstest.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class CookinfoAdded extends AbstractEvent {

    private Long id;
    private String orderid;
    private String address;
    private String status;
    private String customerid;

    public CookinfoAdded(Rider aggregate) {
        super(aggregate);
    }

    public CookinfoAdded() {
        super();
    }
}
//>>> DDD / Domain Event
