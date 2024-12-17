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

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Orderinfoadded'"
    )
    public void wheneverOrderinfoadded_SendKakaoMessageToManager(
        @Payload Orderinfoadded orderinfoadded
    ) {
        Orderinfoadded event = orderinfoadded;
        System.out.println(
            "\n\n##### listener SendKakaoMessageToManager : " +
            orderinfoadded +
            "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Statusupdataed'"
    )
    public void wheneverStatusupdataed_SendKakaoMessageToManager(
        @Payload Statusupdataed statusupdataed
    ) {
        Statusupdataed event = statusupdataed;
        System.out.println(
            "\n\n##### listener SendKakaoMessageToManager : " +
            statusupdataed +
            "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookinfoAdded'"
    )
    public void wheneverCookinfoAdded_SendKakaoMessageToManager(
        @Payload CookinfoAdded cookinfoAdded
    ) {
        CookinfoAdded event = cookinfoAdded;
        System.out.println(
            "\n\n##### listener SendKakaoMessageToManager : " +
            cookinfoAdded +
            "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Dellverystrated'"
    )
    public void wheneverDellverystrated_SendKakaoMessageToCustomer(
        @Payload Dellverystrated dellverystrated
    ) {
        Dellverystrated event = dellverystrated;
        System.out.println(
            "\n\n##### listener SendKakaoMessageToCustomer : " +
            dellverystrated +
            "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Orderplaced'"
    )
    public void wheneverOrderplaced_SendKakaoMessageToCustomer(
        @Payload Orderplaced orderplaced
    ) {
        Orderplaced event = orderplaced;
        System.out.println(
            "\n\n##### listener SendKakaoMessageToCustomer : " +
            orderplaced +
            "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Accepted'"
    )
    public void wheneverAccepted_SendKakaoMessageToCustomer(
        @Payload Accepted accepted
    ) {
        Accepted event = accepted;
        System.out.println(
            "\n\n##### listener SendKakaoMessageToCustomer : " +
            accepted +
            "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Rejected'"
    )
    public void wheneverRejected_SendKakaoMessageToCustomer(
        @Payload Rejected rejected
    ) {
        Rejected event = rejected;
        System.out.println(
            "\n\n##### listener SendKakaoMessageToCustomer : " +
            rejected +
            "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Cookstarted'"
    )
    public void wheneverCookstarted_SendKakaoMessageToCustomer(
        @Payload Cookstarted cookstarted
    ) {
        Cookstarted event = cookstarted;
        System.out.println(
            "\n\n##### listener SendKakaoMessageToCustomer : " +
            cookstarted +
            "\n\n"
        );
        // Sample Logic //

    }
}
//>>> Clean Arch / Inbound Adaptor
