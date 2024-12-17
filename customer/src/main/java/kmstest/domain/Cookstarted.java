package kmstest.domain;

import java.util.*;
import kmstest.domain.*;
import kmstest.infra.AbstractEvent;
import lombok.*;

@Data
@ToString
public class Cookstarted extends AbstractEvent {

    private Long id;
    private String foodid;
    private String options;
    private String status;
    private String orderid;
    private String address;
    private String customerid;
}