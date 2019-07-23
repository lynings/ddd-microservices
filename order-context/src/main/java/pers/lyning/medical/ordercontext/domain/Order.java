package pers.lyning.medical.ordercontext.domain;

import lombok.*;
import pers.lyning.medical.corestandard.ddd.annotation.domain.AggregateRoot;
import pers.lyning.medical.corestandard.ddd.support.domain.AggregateId;
import pers.lyning.medical.corestandard.model.AbstractEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 订单
 *
 * @author lyning
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@AggregateRoot
@Entity
@javax.persistence.Table(name = "orders")
@org.hibernate.annotations.Table(appliesTo = "orders", comment = "订单信息")
public class Order extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 2112926549903164468L;

    @EmbeddedId
    private AggregateId aggregateId;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    @Column(length = 25, columnDefinition = "comment '状态'")
    private State state;

    public boolean isCancelled() {
        return this.state == State.CANCELLED;
    }

    public boolean isExpired() {
        return this.state == State.EXPIRED;
    }

    public boolean isPaid() {
        return this.state == State.PAID;
    }


    /**
     * 订单状态
     *
     * @author lyning
     */
    enum State {
        /**
         * 已过期
         */
        EXPIRED,
        /**
         * 已取消
         */
        CANCELLED,

        /**
         * 已支付
         */
        PAID,
    }
}
