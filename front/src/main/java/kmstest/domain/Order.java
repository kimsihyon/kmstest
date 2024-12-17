package kmstest.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import kmstest.FrontApplication;
import kmstest.domain.Ordercanclled;
import kmstest.domain.Orderplaced;
import lombok.Data;

@Entity
@Table(name = "Order_table")
@Data
//<<< DDD / Aggregate Root
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String foodid;

    private String options;

    private String price;

    private String status;

    private String address;

    private String customerid;

    @PostPersist
    public void onPostPersist() {
        Orderplaced orderplaced = new Orderplaced(this);
        orderplaced.publishAfterCommit();

        Ordercanclled ordercanclled = new Ordercanclled(this);
        ordercanclled.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {}

    public static OrderRepository repository() {
        OrderRepository orderRepository = FrontApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    //<<< Clean Arch / Port Method
    public static void updataStatus(Accepted accepted) {
        //implement business logic here:

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        Paid paid = new Paid(order);
        paid.publishAfterCommit();
        Dellveryaccepted dellveryaccepted = new Dellveryaccepted(order);
        dellveryaccepted.publishAfterCommit();
        Dellverystrated dellverystrated = new Dellverystrated(order);
        dellverystrated.publishAfterCommit();
        Dellverycompleted dellverycompleted = new Dellverycompleted(order);
        dellverycompleted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(accepted.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            Paid paid = new Paid(order);
            paid.publishAfterCommit();
            Dellveryaccepted dellveryaccepted = new Dellveryaccepted(order);
            dellveryaccepted.publishAfterCommit();
            Dellverystrated dellverystrated = new Dellverystrated(order);
            dellverystrated.publishAfterCommit();
            Dellverycompleted dellverycompleted = new Dellverycompleted(order);
            dellverycompleted.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void updataStatus(Cookstarted cookstarted) {
        //implement business logic here:

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        Paid paid = new Paid(order);
        paid.publishAfterCommit();
        Dellveryaccepted dellveryaccepted = new Dellveryaccepted(order);
        dellveryaccepted.publishAfterCommit();
        Dellverystrated dellverystrated = new Dellverystrated(order);
        dellverystrated.publishAfterCommit();
        Dellverycompleted dellverycompleted = new Dellverycompleted(order);
        dellverycompleted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(cookstarted.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            Paid paid = new Paid(order);
            paid.publishAfterCommit();
            Dellveryaccepted dellveryaccepted = new Dellveryaccepted(order);
            dellveryaccepted.publishAfterCommit();
            Dellverystrated dellverystrated = new Dellverystrated(order);
            dellverystrated.publishAfterCommit();
            Dellverycompleted dellverycompleted = new Dellverycompleted(order);
            dellverycompleted.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void updataStatus(Cookfinished cookfinished) {
        //implement business logic here:

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        Paid paid = new Paid(order);
        paid.publishAfterCommit();
        Dellveryaccepted dellveryaccepted = new Dellveryaccepted(order);
        dellveryaccepted.publishAfterCommit();
        Dellverystrated dellverystrated = new Dellverystrated(order);
        dellverystrated.publishAfterCommit();
        Dellverycompleted dellverycompleted = new Dellverycompleted(order);
        dellverycompleted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(cookfinished.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            Paid paid = new Paid(order);
            paid.publishAfterCommit();
            Dellveryaccepted dellveryaccepted = new Dellveryaccepted(order);
            dellveryaccepted.publishAfterCommit();
            Dellverystrated dellverystrated = new Dellverystrated(order);
            dellverystrated.publishAfterCommit();
            Dellverycompleted dellverycompleted = new Dellverycompleted(order);
            dellverycompleted.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
