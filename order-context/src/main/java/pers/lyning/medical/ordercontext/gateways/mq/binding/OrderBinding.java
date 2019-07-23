package pers.lyning.medical.ordercontext.gateways.mq.binding;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author lyning
 */
public interface OrderBinding {

    /**
     * 订单已确认
     */
    String ORDER_CONFIRMED = "order-confirmed";

    /**
     * 订单支付完毕
     */
    String PAYMENT_PROCESSED = "payment-processed";

    /**
     * 发送订单请求
     */
    String ORDER_REQUESTED = "order-requested";

    /**
     * 发送订单支付验证
     */
    String ORDER_VALIDATED = "order-validated";

    /**
     * 创建 订单已确认的消息通道
     *
     * @return
     */
    @Input(PAYMENT_PROCESSED)
    MessageChannel receivePaymentProcessed();


    /**
     * 创建 生成订单请求
     *
     * @return
     */
    @Input(ORDER_REQUESTED)
    MessageChannel receiveOrderRequested();

    /**
     * 创建 订单已确认的消息通道
     *
     * @return
     */
    @Output(ORDER_CONFIRMED)
    MessageChannel createOrderConfirmed();

    /**
     * 创建 订单已验证的消息通道
     *
     * @return
     */
    @Output(ORDER_VALIDATED)
    MessageChannel createOrderValidated();
}
