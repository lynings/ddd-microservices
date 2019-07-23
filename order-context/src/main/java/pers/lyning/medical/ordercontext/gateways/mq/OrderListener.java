package pers.lyning.medical.ordercontext.gateways.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import pers.lyning.medical.ordercontext.gateways.mq.binding.OrderBinding;
import pers.lyning.medical.ordercontext.gateways.mq.messages.OrderRequested;
import pers.lyning.medical.ordercontext.gateways.mq.messages.PaymentProcessed;
import pers.lyning.medical.ordercontext.interfaces.OrderAppService;

/**
 * @author lyning
 */
@EnableBinding(OrderBinding.class)
public class OrderListener {

    private final OrderAppService orderAppService;

    @Autowired
    public OrderListener(OrderAppService orderAppService) {
        this.orderAppService = orderAppService;
    }

    /**
     * 接收 支付已处理 通知
     *
     * @param paymentProcessed
     */
    @StreamListener(target = OrderBinding.PAYMENT_PROCESSED)
    public void receivePaymentProcessed(PaymentProcessed paymentProcessed) {
        this.orderAppService.complete(paymentProcessed.getOrderId());
    }

    /**
     * 接收 订单生成 通知
     *
     * @param orderRequested
     */
    @StreamListener(target = OrderBinding.ORDER_REQUESTED)
    public void receiveOrderRequested(OrderRequested orderRequested) {
//        this.orderAppService.placeOrder()
    }
}
