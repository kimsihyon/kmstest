package kmstest.domain;

import java.util.*;
import kmstest.domain.*;
import kmstest.infra.AbstractEvent;
import lombok.*;

@Data
@ToString
public class Paid extends AbstractEvent {

    private Long id;
    private String price;
    private String ordereid;
    private String status;
}
