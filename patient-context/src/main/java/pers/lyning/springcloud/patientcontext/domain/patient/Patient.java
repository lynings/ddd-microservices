package pers.lyning.springcloud.patientcontext.domain.user;

import lombok.Getter;
import lombok.Setter;
import pers.lyning.springcloud.corestandard.ddd.support.domain.AggregateId;
import pers.lyning.springcloud.corestandard.model.AbstractEntity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * @author lyning
 */
@Getter
@Setter
@Entity
@javax.persistence.Table(name = "users")
@org.hibernate.annotations.Table(appliesTo = "users", comment = "用户信息")
public class User extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1547402469349165908L;

    /**
     * 聚合根id
     */
    @Embedded
    private final AggregateId aggregateId;

    /**
     * 用户名
     */
    private final String username;

    public User(final AggregateId aggregateId, final String username) {
        this.aggregateId = aggregateId;
        this.username = username;
    }
}
