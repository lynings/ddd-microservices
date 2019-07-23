package pers.lyning.medical.projectcontext.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pers.lyning.medical.corestandard.ddd.annotation.domain.AggregateRoot;
import pers.lyning.medical.corestandard.ddd.support.domain.AggregateId;
import pers.lyning.medical.corestandard.model.AbstractEntity;
import pers.lyning.medical.corestandard.model.support.LocalDateTimeConverter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author lyning
 */
@Setter
@Getter
@NoArgsConstructor
@AggregateRoot
@Entity
@Table(name = "projects")
@org.hibernate.annotations.Table(appliesTo = "projects", comment = "医疗项目")
public class Project extends AbstractEntity {

    @EmbeddedId
    private AggregateId id;

    /**
     * 医疗项目名称
     */
    private String name;

    /**
     * 医疗项目价格
     */
    @Embedded
    private Price price;

    /**
     * 套餐
     */
    private List<Package> packages;

    /**
     * 服务时间
     */
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime serviceTime;

    /**
     * 耗材
     */
    @OneToMany(fetch = FetchType.LAZY)
    private Supplies supplies;

    /**
     * 详情
     */
    @Embedded
    private ProjectDetail projectDetail;

    @Enumerated(EnumType.STRING)
    @Column(length = 25, columnDefinition = "comment '状态'")
    private State state;

    enum State {
        /**
         * 上架
         */
        ON,
        /**
         * 下架
         */
        OFF,
        /**
         * 隐藏
         */
        HIDDEN
    }
}
