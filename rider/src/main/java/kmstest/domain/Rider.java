package kmstest.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import kmstest.RiderApplication;
import kmstest.domain.CookinfoAdded;
import lombok.Data;

@Entity
@Table(name = "Rider_table")
@Data
//<<< DDD / Aggregate Root
public class Rider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String orderid;

    private String address;

    private String status;

    private String customerid;

    @PostPersist
    public void onPostPersist() {
        CookinfoAdded cookinfoAdded = new CookinfoAdded(this);
        cookinfoAdded.publishAfterCommit();
    }

    public static RiderRepository repository() {
        RiderRepository riderRepository = RiderApplication.applicationContext.getBean(
            RiderRepository.class
        );
        return riderRepository;
    }

    //<<< Clean Arch / Port Method
    public void accept(AcceptCommand acceptCommand) {
        //implement business logic here:

        Dellveryaccepted dellveryaccepted = new Dellveryaccepted(this);
        dellveryaccepted.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void dellveryStrat(DellveryStratCommand dellveryStratCommand) {
        //implement business logic here:

        Dellverystrated dellverystrated = new Dellverystrated(this);
        dellverystrated.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void dellverycomplete(
        DellverycompleteCommand dellverycompleteCommand
    ) {
        //implement business logic here:

        Dellverycompleted dellverycompleted = new Dellverycompleted(this);
        dellverycompleted.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method

    //<<< Clean Arch / Port Method
    public static void addCookInfo(Cookfinished cookfinished) {
        //implement business logic here:

        /** Example 1:  new item 
        Rider rider = new Rider();
        repository().save(rider);

        CookinfoAdded cookinfoAdded = new CookinfoAdded(rider);
        cookinfoAdded.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(cookfinished.get???()).ifPresent(rider->{
            
            rider // do something
            repository().save(rider);

            CookinfoAdded cookinfoAdded = new CookinfoAdded(rider);
            cookinfoAdded.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
