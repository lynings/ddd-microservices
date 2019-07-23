package pers.lyning.medical.ordercontext.gateways.mq.messages;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author lyning
 */
@Setter
@Getter
public class PaymentProcessed implements Serializable {

    private static final long serialVersionUID = 150555997160942524L;

    /**
     * 订单id
     */
    private Long orderId;
}
