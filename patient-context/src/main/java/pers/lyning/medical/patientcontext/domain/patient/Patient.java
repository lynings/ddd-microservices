package pers.lyning.medical.patientcontext.domain.patient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pers.lyning.medical.corestandard.ddd.support.domain.AggregateId;
import pers.lyning.medical.corestandard.model.AbstractEntity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * @author lyning
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@javax.persistence.Table(name = "patients")
@org.hibernate.annotations.Table(appliesTo = "patients", comment = "患者信息")
public class Patient extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1547402469349165908L;

    /**
     * 聚合根id
     */
    @EmbeddedId
    private AggregateId aggregateId;

    /**
     * 用户名
     */
    private String username;

    public Patient(final AggregateId aggregateId, final String username) {
        this.aggregateId = aggregateId;
        this.username = username;
    }
}
