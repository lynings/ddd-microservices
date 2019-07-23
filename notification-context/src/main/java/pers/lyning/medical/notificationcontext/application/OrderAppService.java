package pers.lyning.medical.notificationcontext.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import pers.lyning.medical.corestandard.ddd.annotation.application.ApplicationService;

/**
 * @author lyning
 */
@ApplicationService
@EnableBinding(OrderSink.class)
@Slf4j
public class OrderAppService {

    @StreamListener(target = OrderSink.ORDER_CONFIRMED)
    public void orderConfirmed(OrderConfirmed orderConfirmed) {
        log.info("订单确认", orderConfirmed.toString());
    }
}
