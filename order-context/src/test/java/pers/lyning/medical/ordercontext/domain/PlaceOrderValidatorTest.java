package pers.lyning.medical.ordercontext.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import pers.lyning.medical.ordercontext.domain.exception.OrderException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * 1. 验证状态
 * 2. 验证数据完整性
 * 3.
 *
 * @author lyning
 */
class PlaceOrderValidatorTest {

    @Spy
    private PlaceOrderValidator placeOrderValidator;

    @BeforeEach
    void setUp() {
        this.placeOrderValidator = new PlaceOrderValidator();
    }

    @Test
    void should_throw_order_expired_message_when_order_expired() throws Exception {
        // given
        Order order = Order.builder()
                .state(Order.State.EXPIRED)
                .build();
        // when
        OrderException orderException = assertThrows(OrderException.class, () -> this.placeOrderValidator.validate(order));
        // then
        assertThat(orderException.getMessage()).isEqualTo("order.expired");
    }

    @Test
    void should_throw_order_cancelled_message_when_order_cancelled() throws Exception {
        // given
        Order order = Order.builder()
                .state(Order.State.CANCELLED)
                .build();
        // when
        OrderException orderException = assertThrows(OrderException.class, () -> this.placeOrderValidator.validate(order));
        // then
        assertThat(orderException.getMessage()).isEqualTo("order.cancelled");
    }

    @Test
    void should_throw_order_paid_message_when_order_paid() throws Exception {
        // given
        Order order = Order.builder()
                .state(Order.State.PAID)
                .build();
        // when
        OrderException orderException = assertThrows(OrderException.class, () -> this.placeOrderValidator.validate(order));
        // then
        assertThat(orderException.getMessage()).isEqualTo("order.paid");
    }
}
