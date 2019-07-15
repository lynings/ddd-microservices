package pers.lyning.springcloud.corestandard.ddd.support.domain;

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
    private String aggregateId;

    public String getId() {
        return this.aggregateId;
    }
}
