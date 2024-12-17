package kmstest.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import kmstest.config.kafka.KafkaProcessor;
import kmstest.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    CookingRepository cookingRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Orderplaced'"
    )
    public void wheneverOrderplaced_AddOrderInfo(
        @Payload Orderplaced orderplaced
    ) {
        Orderplaced event = orderplaced;
        System.out.println(
            "\n\n##### listener AddOrderInfo : " + orderplaced + "\n\n"
        );

        // Sample Logic //
        Cooking.addOrderInfo(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Paid'"
    )
    public void wheneverPaid_UpdataPayStatus(@Payload Paid paid) {
        Paid event = paid;
        System.out.println(
            "\n\n##### listener UpdataPayStatus : " + paid + "\n\n"
        );

        // Sample Logic //
        Cooking.updataPayStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Ordercanclled'"
    )
    public void wheneverOrdercanclled_CancleOrder(
        @Payload Ordercanclled ordercanclled
    ) {
        Ordercanclled event = ordercanclled;
        System.out.println(
            "\n\n##### listener CancleOrder : " + ordercanclled + "\n\n"
        );

        // Sample Logic //
        Cooking.cancleOrder(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
