package kmstest.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class PayCompleteCommand {

    private String orderid;
}
