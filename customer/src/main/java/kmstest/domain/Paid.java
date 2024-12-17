package kmstest.domain;

import java.time.LocalDate;
import java.util.*;
import kmstest.infra.AbstractEvent;
import lombok.Data;

@Data
public class Paid extends AbstractEvent {

    private Long id;
    private String price;
    private String ordereid;
    private String status;
}
