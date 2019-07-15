package pers.lyning.springcloud.ordercontext.domain;

import lombok.Getter;

/**
 * @author lyning
 */
@Getter
public class Order {
    private final Long id;

    public Order(Long id) {
        this.id = id;
    }
}
