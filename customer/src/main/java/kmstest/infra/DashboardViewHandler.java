package kmstest.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import kmstest.config.kafka.KafkaProcessor;
import kmstest.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class DashboardViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private DashboardRepository dashboardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderplaced_then_CREATE_1(
        @Payload Orderplaced orderplaced
    ) {
        try {
            if (!orderplaced.validate()) return;

            // view 객체 생성
            Dashboard dashboard = new Dashboard();
            // view 객체에 이벤트의 Value 를 set 함
            dashboard.setFoodid(orderplaced.getFoodid());
            dashboard.setOptions(orderplaced.getOptions());
            dashboard.setPrice(orderplaced.getPrice());
            dashboard.setCustomerid(orderplaced.getCustomerid());
            dashboard.setStoreid(orderplaced.getStoried());
            dashboard.setOrderid(String.valueOf(orderplaced.getId()));
            dashboard.setStatus(주문);
            // view 레파지 토리에 save
            dashboardRepository.save(dashboard);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaid_then_UPDATE_1(@Payload Paid paid) {
        try {
            if (!paid.validate()) return;
            // view 객체 조회

            List<Dashboard> dashboardList = dashboardRepository.findByOrderid(
                paid.getOrdereid()
            );
            for (Dashboard dashboard : dashboardList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setStatus(결제완료);
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenAccepted_then_UPDATE_2(@Payload Accepted accepted) {
        try {
            if (!accepted.validate()) return;
            // view 객체 조회

            List<Dashboard> dashboardList = dashboardRepository.findByOrderid(
                accepted.getOrderid()
            );
            for (Dashboard dashboard : dashboardList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setStatus(주문수락);
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
