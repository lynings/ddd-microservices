package pers.lyning.medical.inframq.publsher;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author lyning
 */
public interface OrderResource {

    String PLACE_ORDER_OUTPUT = "place-order";

    /**
     * 下单
     *
     * @return
     */
    @Output(PLACE_ORDER_OUTPUT)
    MessageChannel placeOrder();
}
