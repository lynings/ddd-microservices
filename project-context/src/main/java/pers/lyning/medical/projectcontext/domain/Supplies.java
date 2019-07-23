package pers.lyning.medical.projectcontext.domain;

import lombok.Getter;
import lombok.Setter;
import pers.lyning.medical.corestandard.model.AbstractEntity;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author lyning
 */
@Setter
@Getter
@Embeddable
@Entity
@Table(name = "supplies")
@org.hibernate.annotations.Table(appliesTo = "supplies", comment = "护理耗材")
public class Supplies extends AbstractEntity {

    private static final long serialVersionUID = 2671481491255831193L;

    private String name;

    @Embedded
    private Price price;

    @Embedded
    private SuppliesDetail detail;
}
