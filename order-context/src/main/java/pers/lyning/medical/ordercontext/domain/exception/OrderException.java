package pers.lyning.medical.ordercontext.domain.exception;

/**
 * 订单 异常
 *
 * @author lyning
 */
public class OrderException extends RuntimeException {

    public OrderException(final String message) {
        super(message);
    }
}
