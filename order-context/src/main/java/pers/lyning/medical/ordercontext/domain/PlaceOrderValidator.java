package pers.lyning.medical.ordercontext.domain;

import pers.lyning.medical.corestandard.ddd.annotation.domain.DomainService;
import pers.lyning.medical.ordercontext.domain.exception.OrderException;

/**
 * @author lyning
 */
@DomainService
public class PlaceOrderValidator {

    public boolean validate(final Order order) {
        if (order.isExpired()) {
            throw new OrderException("order.expired");
        }
        if (order.isCancelled()) {
            throw new OrderException("order.cancelled");
        }
        if (order.isPaid()) {
            throw new OrderException("order.paid");
        }
        return true;
    }
}
