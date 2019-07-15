package pers.lyning.springcloud.corestandard.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * 普通 entity id
 *
 * @author lyning
 */
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class EntityId {

    /**
     * 主键自增id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint")
    @Getter
    @Setter
    protected Long id;
}
