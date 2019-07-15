package pers.lyning.medical.ordercontext.interfaces;

import pers.lyning.medical.ordercontext.gateways.ohs.data.OrderCommand;

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
