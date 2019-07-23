package pers.lyning.medical.notificationcontext.application;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author lyning
 */
public interface OrderSink {

    /**
     * 订单已确认
     * 表示已经支付完成
     */
    String ORDER_CONFIRMED = "order-confirmed";

    /**
     * 接收 订单已确认请求
     *
     * @return
     */
    @Input(ORDER_CONFIRMED)
    SubscribableChannel receiveOrderConfirmed();
}
