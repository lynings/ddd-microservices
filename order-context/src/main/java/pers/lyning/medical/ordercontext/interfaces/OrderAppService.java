package pers.lyning.medical.ordercontext.interfaces;

import pers.lyning.medical.ordercontext.gateways.ohs.data.PlaceOrderCommand;

/**
 * @author lyning
 */
public interface OrderAppService {

    /**
     * 完成订单
     *
     * @param orderId 订单id
     */
    void complete(Long orderId);

    /**
     * 下单
     *
     * @param orderCommand
     * @return
     */
    Long placeOrder(PlaceOrderCommand orderCommand);
}
