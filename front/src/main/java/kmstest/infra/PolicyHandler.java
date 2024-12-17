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
    OrderRepository orderRepository;

    @Autowired
    PaymentRepository paymentRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Orderplaced'"
    )
    public void wheneverOrderplaced_Pay(@Payload Orderplaced orderplaced) {
        Orderplaced event = orderplaced;
        System.out.println("\n\n##### listener Pay : " + orderplaced + "\n\n");

        // Sample Logic //
        Payment.pay(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Ordercanclled'"
    )
    public void wheneverOrdercanclled_PayReject(
        @Payload Ordercanclled ordercanclled
    ) {
        Ordercanclled event = ordercanclled;
        System.out.println(
            "\n\n##### listener PayReject : " + ordercanclled + "\n\n"
        );

        // Sample Logic //
        Payment.payReject(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Accepted'"
    )
    public void wheneverAccepted_UpdataStatus(@Payload Accepted accepted) {
        Accepted event = accepted;
        System.out.println(
            "\n\n##### listener UpdataStatus : " + accepted + "\n\n"
        );

        // Sample Logic //
        Order.updataStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Cookstarted'"
    )
    public void wheneverCookstarted_UpdataStatus(
        @Payload Cookstarted cookstarted
    ) {
        Cookstarted event = cookstarted;
        System.out.println(
            "\n\n##### listener UpdataStatus : " + cookstarted + "\n\n"
        );

        // Sample Logic //
        Order.updataStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Cookfinished'"
    )
    public void wheneverCookfinished_UpdataStatus(
        @Payload Cookfinished cookfinished
    ) {
        Cookfinished event = cookfinished;
        System.out.println(
            "\n\n##### listener UpdataStatus : " + cookfinished + "\n\n"
        );

        // Sample Logic //
        Order.updataStatus(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
