package pers.lyning.medical.ordercontext.domain;

import lombok.Getter;

/**
 * @author lyning
 */
@Getter
public class Order {
    private final Long id;

    public Order(final Long id) {
        this.id = id;
    }
}
