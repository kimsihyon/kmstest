package kmstest.domain;

import kmstest.domain.Orderinfoadded;
import kmstest.domain.Statusupdataed;
import kmstest.domain.Cookcanclled;
import kmstest.StoreApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;
import java.time.LocalDate;


@Entity
@Table(name="Cooking_table")
@Data

//<<< DDD / Aggregate Root
public class Cooking  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    private Long id;
    
    
    
    
    private String foodid;
    
    
    
    
    private String options;
    
    
    
    
    private String status;
    
    
    
    
    private String orderid;
    
    
    
    
    private String address;
    
    
    
    
    private String customerid;

    @PostPersist
    public void onPostPersist(){


        Orderinfoadded orderinfoadded = new Orderinfoadded(this);
        orderinfoadded.publishAfterCommit();



        Statusupdataed statusupdataed = new Statusupdataed(this);
        statusupdataed.publishAfterCommit();



        Cookcanclled cookcanclled = new Cookcanclled(this);
        cookcanclled.publishAfterCommit();

    
    }

    public static CookingRepository repository(){
        CookingRepository cookingRepository = StoreApplication.applicationContext.getBean(CookingRepository.class);
        return cookingRepository;
    }



//<<< Clean Arch / Port Method
    public void accept(AcceptCommand acceptCommand){
        
        //implement business logic here:
        


        Accepted accepted = new Accepted(this);
        accepted.publishAfterCommit();
    }
//>>> Clean Arch / Port Method
//<<< Clean Arch / Port Method
    public void reject(RejectCommand rejectCommand){
        
        //implement business logic here:
        


        Rejected rejected = new Rejected(this);
        rejected.publishAfterCommit();
    }
//>>> Clean Arch / Port Method
//<<< Clean Arch / Port Method
    public void cookStart(CookStartCommand cookStartCommand){
        
        //implement business logic here:
        

        kmstest.external.CookingQuery cookingQuery = new kmstest.external.CookingQuery();
        // cookingQuery.set??()        
          = CookingApplication.applicationContext
            .getBean(kmstest.external.Service.class)
            .cooking(cookingQuery);

        Cookstarted cookstarted = new Cookstarted(this);
        cookstarted.publishAfterCommit();
    }
//>>> Clean Arch / Port Method
//<<< Clean Arch / Port Method
    public void cookfinish(CookfinishCommand cookfinishCommand){
        
        //implement business logic here:
        


        Cookfinished cookfinished = new Cookfinished(this);
        cookfinished.publishAfterCommit();
    }
//>>> Clean Arch / Port Method

//<<< Clean Arch / Port Method
    public static void addOrderInfo(Orderplaced orderplaced){
        
        //implement business logic here:

        
        /** Example 1:  new item 
        Cooking cooking = new Cooking();
        repository().save(cooking);

        Orderinfoadded orderinfoadded = new Orderinfoadded(cooking);
        orderinfoadded.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderplaced.get???()).ifPresent(cooking->{
            
            cooking // do something
            repository().save(cooking);

            Orderinfoadded orderinfoadded = new Orderinfoadded(cooking);
            orderinfoadded.publishAfterCommit();

         });
        */

        
    }
//>>> Clean Arch / Port Method
//<<< Clean Arch / Port Method
    public static void updataPayStatus(Paid paid){
        
        //implement business logic here:

        // if aggregate reference class exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<, Object> paymentMap = mapper.convertValue(paid.getPaymentId(), Map.class);
        
        /** Example 1:  new item 
        Cooking cooking = new Cooking();
        repository().save(cooking);

        Statusupdataed statusupdataed = new Statusupdataed(cooking);
        statusupdataed.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(paid.get???()).ifPresent(cooking->{
            
            cooking // do something
            repository().save(cooking);

            Statusupdataed statusupdataed = new Statusupdataed(cooking);
            statusupdataed.publishAfterCommit();

         });
        */

        
    }
//>>> Clean Arch / Port Method
//<<< Clean Arch / Port Method
    public static void cancleOrder(Ordercanclled ordercanclled){
        
        //implement business logic here:

        
        /** Example 1:  new item 
        Cooking cooking = new Cooking();
        repository().save(cooking);

        Cookcanclled cookcanclled = new Cookcanclled(cooking);
        cookcanclled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(ordercanclled.get???()).ifPresent(cooking->{
            
            cooking // do something
            repository().save(cooking);

            Cookcanclled cookcanclled = new Cookcanclled(cooking);
            cookcanclled.publishAfterCommit();

         });
        */

        
    }
//>>> Clean Arch / Port Method


}
//>>> DDD / Aggregate Root
