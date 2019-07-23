package pers.lyning.medical.ordercontext.gateways.mq.messages;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author lyning
 */
@Setter
@Getter
public class OrderConfirmed implements Serializable {

    private static final long serialVersionUID = 164509205612029099L;
    /**
     * 订单 id
     */
    private Long orderId;
}
