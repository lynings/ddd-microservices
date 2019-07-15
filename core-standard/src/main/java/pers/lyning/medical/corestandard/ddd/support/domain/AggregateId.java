package pers.lyning.medical.corestandard.ddd.support.domain;

import lombok.*;

import javax.persistence.*;

/**
 * @author lyning
 */
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AggregateId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint")
    @Getter
    @Setter
    private Long aggregateId;

    public Long getId() {
        return this.aggregateId;
    }
}
