package kmstest.domain;

import java.time.LocalDate;
import java.util.*;
import kmstest.domain.*;
import kmstest.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Statusupdataed extends AbstractEvent {

    private Long id;
    private String foodid;
    private String options;
    private String status;
    private String orderid;
    private String address;
    private String customerid;

    public Statusupdataed(Cooking aggregate) {
        super(aggregate);
    }

    public Statusupdataed() {
        super();
    }
}
//>>> DDD / Domain Event
