package pers.lyning.medical.projectcontext.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import pers.lyning.medical.corestandard.ddd.support.domain.AggregateId;
import pers.lyning.medical.corestandard.model.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author lyning
 */
@Setter
@Getter
@Embeddable
@Entity
@Table(name = "packages")
@org.hibernate.annotations.Table(appliesTo = "packages", comment = "项目可选套餐")
public class Package extends AbstractEntity {

    private static final long serialVersionUID = -5528002907919122560L;

    private AggregateId id;

    private Long projectId;

    /**
     * 价格
     */
    private Price price;

    @Column(nullable = false, columnDefinition = "comment '项目数量 或 服务次数'")
    private Integer amount;

    private String name;

    @Column(nullable = false, length = 1, columnDefinition = "comment '是否选中: 0 否；1 是'")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean checked;
}
