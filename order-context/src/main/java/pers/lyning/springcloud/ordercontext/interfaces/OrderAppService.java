package pers.lyning.springcloud.ordercontext.interfaces;

import pers.lyning.springcloud.ordercontext.gateways.ohs.data.OrderCommand;

/**
 * @author lyning
 */
public interface OrderAppService {

    /**
     * 下单
     *
     * @param orderCommand
     * @return
     */
    Long placeOrder(OrderCommand orderCommand);
}
