package pers.lyning.medical.corestandard.ddd.support.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pers.lyning.medical.corestandard.ddd.annotation.domain.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

/**
 * @author lyning
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ValueObject
@Embeddable
public class AggregateId implements Serializable {

    private static final long serialVersionUID = -9135851751899830923L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint")
    private Long id;
}
